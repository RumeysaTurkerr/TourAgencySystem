package com.patikapaycore.TourAgencySystem.model;

import lombok.Data;

@Data
public class TravellerDTO {
    private String firstname;
    private String lastname;
    private String gender;
    private Integer age;
    private String phone;
    private String email;
}
