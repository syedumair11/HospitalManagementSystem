CREATE DATABASE hospital_db;

USE hospital_db;

CREATE TABLE patients (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    gender VARCHAR(20),
    disease VARCHAR(100),
    phone VARCHAR(15)
);

CREATE TABLE doctors (
    doctor_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    specialization VARCHAR(100),
    experience INT
);

CREATE TABLE appointments (
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    appointment_time TIME,

    FOREIGN KEY(patient_id)
        REFERENCES patients(patient_id),

    FOREIGN KEY(doctor_id)
        REFERENCES doctors(doctor_id)
);