package com.curd.demo.Crud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Embeddable
public class UserDetails  {
    enum MaritalStatus {
        Married,
        Single
    }
    enum Gender {
        Male,
        Female
    }

    private String first_name;
    private String last_name;
    private int age;
    private Gender gender;
    private MaritalStatus marital_status;
    @Embedded
    private ResidentalDetails residential_details;
    @Embedded
    private OfficialDetails official_details;
}
