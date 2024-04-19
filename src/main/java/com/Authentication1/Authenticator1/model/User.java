package com.Authentication1.Authenticator1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.util.Date;

@Document(collection = "users")
public class User {
    public User(String id, String firstName, String lastName, String cellPhoneNumber, String email, Boolean isUserActive, Date lastLoggedIn, Date lastUpdated, String password, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cellPhoneNumber = cellPhoneNumber;
        this.email = email;
        this.isUserActive = isUserActive;
        this.lastLoggedIn = lastLoggedIn;
        this.lastUpdated = lastUpdated;
        this.password = password;
        this.role = role;
    }

    @Id
    private String id;

    private String firstName;

    private String lastName;

    @Indexed(unique = true)
    private String cellPhoneNumber;

    @Indexed(unique = true)
    private String email;

    private Boolean isUserActive;

    @CreatedDate
    private Date lastLoggedIn;

    @LastModifiedDate
    private Date lastUpdated;

    private String password;

    private String role; // "student" or "student-tutor"

    // Constructors, Getters, and Setters

    public User() {
        // Default constructor is required for the mapping framework to instantiate the object.
    }

    // Add any additional constructors you need here

    // Standard getters and setters for all fields
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsUserActive() {
        return isUserActive;
    }

    public void setIsUserActive(Boolean isUserActive) {
        this.isUserActive = isUserActive;
    }

    public Date getLastLoggedIn() {
        return lastLoggedIn;
    }

    public void setLastLoggedIn(Date lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Add any additional methods you need here
}
