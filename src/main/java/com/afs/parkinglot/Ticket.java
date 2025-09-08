package com.afs.parkinglot;
import java.util.UUID;
import java.util.Objects;

public class Ticket {
    private String id;
    private boolean valid;

    public Ticket() {
        this.id = UUID.randomUUID().toString();
        this.valid = true;
    }

    public Ticket(String id, boolean valid) {
        this.id = id;
        this.valid = valid;
    }

    public String getId() {
        return id;
    }

    public boolean isValid() {
        return valid;
    }

    public void invalidate() {
        this.valid = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Ticket{" + "id='" + id + '\'' + ", valid=" + valid + '}';
    }
}