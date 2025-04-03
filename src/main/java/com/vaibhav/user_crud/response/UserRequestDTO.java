package com.vaibhav.user_crud.response;

import java.time.LocalDate;

public class UserRequestDTO {

    private String firstName;
    private String lastName;
    private String emailId;
    private LocalDate createdAt;
    private String createdBy;
    private LocalDate updatedAt;
    private String updatedBy;

    public UserRequestDTO(String firstName, String lastName,
                          String emailId,String createdBy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.createdBy = createdBy;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return "UserRequestDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
