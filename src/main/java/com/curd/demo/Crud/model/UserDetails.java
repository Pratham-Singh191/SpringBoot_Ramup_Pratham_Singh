package com.curd.demo.Crud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Embeddable
public class UserDetails  {

    @NotBlank
    private String first_name;
    @NotBlank
    private String last_name;

    @Size(min = 1, message = "Age must be greater than 0")
    private int age;

    @NotBlank
    @Pattern(regexp = "^(Male | Female)$")
    private String gender;

    @Pattern(regexp = "^(Married | Single)$")
    @NotBlank
    private String marital_status;

    @Embedded
    @NotBlank
    private ResidentalDetails residential_details;

    @Embedded
    private OfficialDetails official_details;
}
