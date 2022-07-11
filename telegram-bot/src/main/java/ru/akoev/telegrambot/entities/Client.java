package ru.akoev.telegrambot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    @Column (nullable = false)
    private Long externalId;

    @Column (nullable = false)
    private String fullName;

    @Column (nullable = false, length = 15)
    private String phoneNumber;

    @Column (nullable = false, length = 400)
    private String address;


    public Long getId() { return id; }
    public Long getExternalId() { return externalId; }
    public String getFullName() { return fullName; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }

    public void setId(Long id) { this.id = id; }
    public void setExternalId(Long externalId) { this.externalId = externalId; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setAddress(String address) { this.address = address; }
}
