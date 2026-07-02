package com.umair;

import com.umair.dao.AppointmentDAO;
import com.umair.dao.DoctorDAO;
import com.umair.dao.PatientDAO;
import com.umair.model.Appointment;
import com.umair.model.Doctor;
import com.umair.model.Patient;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PatientDAO patientDAO = new PatientDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        while (true) {

            System.out.println("\n=================================");
            System.out.println(" HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("=================================");

            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Update Patient Disease");
            System.out.println("4. Delete Patient");

            System.out.println("5. Add Doctor");
            System.out.println("6. View Doctors");
            System.out.println("7. Update Doctor Experience");
            System.out.println("8. Delete Doctor");

            System.out.println("9. Book Appointment");
            System.out.println("10. View Appointments");
            System.out.println("11. Cancel Appointment");

            System.out.println("0. Exit");

            System.out.print("\nEnter Choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Gender: ");
                    String gender = scanner.nextLine();

                    System.out.print("Enter Disease: ");
                    String disease = scanner.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();

                    Patient patient =
                            new Patient(
                                    name,
                                    age,
                                    gender,
                                    disease,
                                    phone
                            );

                    if (patientDAO.addPatient(patient)) {
                        System.out.println("Patient Added Successfully!");
                    } else {
                        System.out.println("Failed To Add Patient!");
                    }

                    break;

                case 2:

                    patientDAO.getAllPatients();

                    break;

                case 3:
                    patientDAO.getAllPatients();
                    System.out.print("\nEnter Patient ID: ");
                    int patientId = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter New Disease: ");
                    String newDisease = scanner.nextLine();

                    if (patientDAO.updatePatientDisease(
                            patientId,
                            newDisease
                    )) {
                        System.out.println("Disease Updated Successfully!");
                    } else {
                        System.out.println("Update Failed!");
                    }

                    break;

                case 4:

                    patientDAO.getAllPatients();

                    System.out.print("\nEnter Patient ID To Delete: ");
                    patientId = scanner.nextInt();

                    String patientName =
                            patientDAO.getPatientNameById(patientId);

                    if (patientName == null) {

                        System.out.println("Patient Not Found!");
                        break;
                    }

                    int cancelledAppointments =
                            appointmentDAO.deleteAppointmentsByPatientId(
                                    patientId
                            );

                    if (patientDAO.deletePatient(patientId)) {

                        System.out.println(
                                "Patient '" +
                                patientName +
                                "' deleted successfully."
                        );

                        if (cancelledAppointments > 0) {

                            System.out.println(
                                    cancelledAppointments +
                                    " appointment(s) of " +
                                    patientName +
                                    " cancelled successfully."
                            );
                        }

                    } else {

                        System.out.println("Delete Failed!");
                    }

                    break;

                case 5:

                    scanner.nextLine();

                    System.out.print("Doctor Name: ");
                    String doctorName = scanner.nextLine();

                    System.out.print("Specialization: ");
                    String specialization = scanner.nextLine();

                    System.out.print("Experience (Years): ");
                    int experience = scanner.nextInt();

                    Doctor doctor =
                            new Doctor(
                                    doctorName,
                                    specialization,
                                    experience
                            );

                    if (doctorDAO.addDoctor(doctor)) {
                        System.out.println("Doctor Added Successfully!");
                    } else {
                        System.out.println("Failed To Add Doctor!");
                    }

                    break;

                case 6:

                    doctorDAO.getAllDoctors();

                    break;

                case 7:
                    doctorDAO.getAllDoctors();

                    System.out.print("\nEnter Doctor ID: ");
                    int doctorId = scanner.nextInt();

                    System.out.print("Enter New Experience: ");
                    experience = scanner.nextInt();

                    if (doctorDAO.updateDoctorExperience(
                            doctorId,
                            experience
                    )) {
                        System.out.println("Doctor Updated Successfully!");
                    } else {
                        System.out.println("Update Failed!");
                    }

                    break;

                case 8:
                    doctorDAO.getAllDoctors();


                    System.out.print("\nEnter Doctor ID To Delete: ");
                    doctorId = scanner.nextInt();

                    if (doctorDAO.deleteDoctor(doctorId)) {
                        System.out.println("Doctor Deleted Successfully!");
                    } else {
                        System.out.println("Delete Failed!");
                    }

                    break;

                case 9:
                    System.out.println("\nAvailable Patients:");
                    patientDAO.getAllPatients();

                    System.out.println("\nAvailable Doctors:");
                    doctorDAO.getAllDoctors();

                    System.out.print("Enter Patient ID: ");
                    patientId = scanner.nextInt();

                    System.out.print("Enter Doctor ID: ");
                    doctorId = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Date (yyyy-mm-dd): ");
                    String appointmentDate = scanner.nextLine();

                    System.out.print("Enter Time (hh:mm:ss): ");
                    String appointmentTime = scanner.nextLine();

                    Appointment appointment =
                            new Appointment(
                                    patientId,
                                    doctorId,
                                    Date.valueOf(appointmentDate),
                                    Time.valueOf(appointmentTime)
                            );

                    if (appointmentDAO.bookAppointment(
                            appointment
                    )) {
                        System.out.println("Appointment Booked Successfully!");
                    } else {
                        System.out.println("Booking Failed!");
                    }

                    break;

                case 10:

                    appointmentDAO.getAllAppointments();

                    break;

                case 11:
                    appointmentDAO.getAllAppointments();

                    System.out.print("\nEnter Appointment ID To Cancel: ");
                    int appointmentId = scanner.nextInt();

                    if (appointmentDAO.deleteAppointment(
                            appointmentId
                    )) {
                        System.out.println("Appointment Cancelled Successfully!");
                    } else {
                        System.out.println("Cancellation Failed!");
                    }

                    break;

                case 0:

                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}