package com.afs.parkinglot;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    public void testParkCarAndGetTicket() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car("ABC123");
        Ticket ticket = parkingLot.park(car);
        assertNotNull(ticket);
    }
    @Test
    public void testFetchCarWithValidTicket() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car("ABC123");
        Ticket ticket;
        ticket = parkingLot.park(car);
        Car fetchedCar = parkingLot.fetch(ticket);
        assertNotNull(fetchedCar);
        assertEquals(car, fetchedCar);
    }
    @Test
    public void testFetchTwoCarsWithTwoTickets() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car1 = new Car("CAR001");
        Car car2 = new Car("CAR002");

        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);

        Car fetchedCar1 = parkingLot.fetch(ticket1);
        Car fetchedCar2 = parkingLot.fetch(ticket2);

        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);
    }
    @Test
    public void testFetchCarWithoutTicket() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car("ABC123");
        parkingLot.park(car);
        Car fetchedCar = parkingLot.fetch(null);
        assertNull(fetchedCar);
    }
    @Test
    public void testFetchCarWithUsedTicket() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car("ABC123");
        Ticket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket); // 第一次取车
        Car fetchedCar = parkingLot.fetch(ticket); // 第二次用同一张票取车
        assertNull(fetchedCar);
    }
    //2 story
    // ParkingLotTest.java

        private ParkingLot parkingLot;
        private Car car1;
        private Car car2;

        @BeforeEach
        void setUp() {
            parkingLot = new ParkingLot(2); // 停车场有2个车位
            car1 = new Car("ABC123");
            car2 = new Car("XYZ789");
        }

        // 案例1: 停车并获取停车票
        @Test
        void givenParkingLotAndCar_whenPark_thenReturnTicket() {
            Ticket ticket = parkingLot.park(car1);
            assertNotNull(ticket);
            assertTrue(ticket.isValid());
        }

        // 案例2: 使用有效票取车
        @Test
        void givenParkingLotWithCarAndValidTicket_whenPickUp_thenReturnCar() {
            Ticket ticket = parkingLot.park(car1);
            Car retrievedCar = parkingLot.pickUp(ticket);
            assertEquals(car1, retrievedCar);
        }

        // 案例3: 多辆车停车和取车
        @Test
        void givenParkingLotWithTwoCarsAndTwoTickets_whenPickUpTwice_thenReturnCorrectCars() {
            Ticket ticket1 = parkingLot.park(car1);
            Ticket ticket2 = parkingLot.park(car2);

            Car retrievedCar1 = parkingLot.pickUp(ticket1);
            Car retrievedCar2 = parkingLot.pickUp(ticket2);

            assertEquals(car1, retrievedCar1);
            assertEquals(car2, retrievedCar2);
        }

        // 案例3变体: 没有票时取车
        @Test
        void givenParkingLotWithCarAndNoTicket_whenPickUp_thenReturnNull() {
            parkingLot.park(car1);
            Car retrievedCar = parkingLot.pickUp(null);
            assertNull(retrievedCar);
        }

        // 案例4: 使用错误票取车
        @Test
        void givenParkingLotAndWrongTicket_whenPickUp_thenReturnNull() {
            Ticket wrongTicket = new Ticket("wrong_id", false);
            Car retrievedCar = parkingLot.pickUp(wrongTicket);
            assertNull(retrievedCar);
        }

        // 案例5: 使用已使用的票取车
        @Test
        void givenParkingLotAndUsedTicket_whenPickUp_thenReturnNull() {
            Ticket ticket = parkingLot.park(car1);
            parkingLot.pickUp(ticket); // 第一次使用
            Car retrievedCar = parkingLot.pickUp(ticket); // 第二次使用
            assertNull(retrievedCar);
        }

        // 案例6: 停车场已满时停车
        @Test
        void givenFullParkingLotAndCar_whenPark_thenReturnNull() {
            parkingLot.park(car1);
            parkingLot.park(new Car("CAR456")); // 停满2辆车
            Ticket ticket = parkingLot.park(new Car("CAR789")); // 尝试停第三辆
            assertNull(ticket);
        }

        // 故事2案例1: 使用未识别的票取车，返回错误消息
        @Test
        void givenParkingLotAndUnrecognizedTicket_whenPickUp_thenReturnNullWithErrorMessage() {
            Ticket unrecognizedTicket = new Ticket("unrecognized_id", false);
            Car retrievedCar = parkingLot.pickUp(unrecognizedTicket);
            assertNull(retrievedCar);
            assertEquals("未识别的停车票", parkingLot.getLastErrorMessage());
        }

        // 故事2案例2: 使用已使用的票取车，返回错误消息
        @Test
        void givenParkingLotAndUsedTicket_whenPickUp_thenReturnNullWithErrorMessage() {
            Ticket ticket = parkingLot.park(car1);
            parkingLot.pickUp(ticket); // 第一次使用
            Car retrievedCar = parkingLot.pickUp(ticket); // 第二次使用
            assertNull(retrievedCar);
            assertEquals("未识别的停车票", parkingLot.getLastErrorMessage());
        }

        // 故事2案例3: 停车场已满时停车，返回错误消息
        @Test
        void givenFullParkingLotAndCar_whenPark_thenReturnNullWithErrorMessage() {
            parkingLot.park(car1);
            parkingLot.park(car2); // 停满2辆车
            Ticket ticket = parkingLot.park(new Car("CAR789")); // 尝试停第三辆
            assertNull(ticket);
            assertEquals("没有可用位置", parkingLot.getLastErrorMessage());
        }

}
