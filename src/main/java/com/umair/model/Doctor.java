package com.umair.model;

public class Doctor {

    private int doctorId;
    private String name;
    private String specialization;
    private int experience;

    public Doctor() {}

    public Doctor(
        String name,
        String specialization,
        int experience
) {
    this.name = name;
    this.specialization = specialization;
    this.experience = experience;
}

    public Doctor(int doctorId, String name,
                  String specialization, int experience) {

        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}