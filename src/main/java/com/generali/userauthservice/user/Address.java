package com.generali.userauthservice.user;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String city;
    private String street;
    private String streetNumber;
    private String zipCode;
}
