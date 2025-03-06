package com.curd.demo.Crud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Embeddable
public class OfficialDetails {
    @NotBlank
    private String employee_code;

    @NotBlank
    @Column(name = "official_address")
    private String address;

    @NotBlank
    @Column(name = "official_city")
    private String city;

    @NotBlank
    @Column(name = "official_state")
    private String state;

    @NotBlank
    @Column(name = "official_country")
    private String country;

    @Pattern(regexp = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$", message = "Must be a valid phone number")
    private String company_contact_no;

    @Email
    private String company_contact_email;

    @NotBlank
    private String company_name;

}
