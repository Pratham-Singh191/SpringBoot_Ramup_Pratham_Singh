package com.curd.demo.Crud.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Embeddable
public class ResidentalDetails {
    private String address;
    private String city;
    private String state;
    private String country;
    @Pattern(regexp = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$", message = "Must be a valid phone number")
    private String contact_no_1;
    @Pattern(regexp = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$", message = "Must be a valid phone number")
    private String contact_no_2;
}
