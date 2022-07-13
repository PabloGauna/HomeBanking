package entities;

import entities.types.UserType;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private UserType type;

    public User(int id, String firstName, String lastName, UserType type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
