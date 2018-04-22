package com.arydz.learning.analyzer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class TrafficViolationsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String dateOfStop;
    @NotNull
    private String timeOfStop;
    @NotNull
    private String agency;
    @NotNull
    private String subAgency;
    @NotNull
    private String description;
    @NotNull
    private String location;

    private String latitude;
    private String longitude;
    private String accident;
    private String belts;
    private String personalInjury;
    @NotNull
    private String propertyDamage;
    private String fatal;
    private String commercialLicense;
    private String hazmat;
    private String commercialVehicle;
    @NotNull
    private String alcohol;
    private String workZone;
    @NotNull
    private String state;
    @NotNull
    private String vehicleType;
    @NotNull
    private String year;
    @NotNull
    private String make;
    @NotNull
    private String model;
    @NotNull
    private String color;
    private String violationType;
    private String charge;
    private String article;
    private String contributedToAccident;
    private String race;
    @NotNull
    private String gender;
    private String driverCity;
    private String driverState;
    private String dlState;
    private String arrestType;
    private String geolocation;
}
