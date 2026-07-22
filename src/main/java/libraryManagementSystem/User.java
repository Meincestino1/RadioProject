package libraryManagementSystem;

import java.util.Random;
import java.util.UUID;

public class User {

    private String name;
    private String id;
    private Address address;
    private String email;

    public User(String name, Address address, String email) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.name = name;
        this.address = address;
        this.email = email;
        this.id = UUID.randomUUID().toString();  // ID als UUID
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
}
