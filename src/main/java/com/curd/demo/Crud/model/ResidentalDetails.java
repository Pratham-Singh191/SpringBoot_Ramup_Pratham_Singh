package com.curd.demo.Crud.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ResidentalDetails {
    private String address;
    private String city;
    private String state;
    private String country;
    private String contact_no_1;
    private String contact_no_2;
}
