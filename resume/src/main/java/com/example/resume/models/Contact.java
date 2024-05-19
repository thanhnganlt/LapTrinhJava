package com.example.resume.models;

public class Contact {
    private String address;
    private String email;
    private String phone;
    private boolean isFreelanceAvailable;

    public Contact(String address, String email, String phone, boolean isFreelanceAvailable) {
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.isFreelanceAvailable = isFreelanceAvailable;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isFreelanceAvailable() {
        return isFreelanceAvailable;
    }

    public void setFreelanceAvailable(boolean freelanceAvailable) {
        isFreelanceAvailable = freelanceAvailable;
    }
}
