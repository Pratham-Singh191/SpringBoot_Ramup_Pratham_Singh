package com.curd.demo.Crud.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
public class OfficialDetails {
    private String employee_code;
    @Column(name = "official_address")
    private String address;
    @Column(name = "official_city")
    private String city;
    @Column(name = "official_state")
    private String state;
    @Column(name = "official_country")
    private String country;
    private String company_contact_no;
    private String company_contact_email;
    private String company_name;

}
