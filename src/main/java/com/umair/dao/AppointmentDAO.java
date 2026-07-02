package com.umair.dao;

import com.umair.model.Appointment;
import com.umair.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AppointmentDAO {

    public boolean bookAppointment(Appointment appointment) {

        String query =
                "INSERT INTO appointments(patient_id, doctor_id, appointment_date, appointment_time) VALUES (?, ?, ?, ?)";

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(query)
        ) {

            statement.setInt(1, appointment.getPatientId());
            statement.setInt(2, appointment.getDoctorId());
            statement.setDate(3, appointment.getAppointmentDate());
            statement.setTime(4, appointment.getAppointmentTime());

            int rowsAffected =
                    statement.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public void getAllAppointments() {

        String query =
                """
                SELECT
                a.appointment_id,
                p.name AS patient_name,
                d.name AS doctor_name,
                a.appointment_date,
                a.appointment_time
                FROM appointments a
                JOIN patients p
                ON a.patient_id = p.patient_id
                JOIN doctors d
                ON a.doctor_id = d.doctor_id
                """;

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(query);

                ResultSet resultSet =
                        statement.executeQuery()
        ) {

            System.out.println("\n===== Appointments =====");

            while (resultSet.next()) {

                System.out.println(
                        resultSet.getInt("appointment_id")
                                + " | "
                                + resultSet.getString("patient_name")
                                + " | "
                                + resultSet.getString("doctor_name")
                                + " | "
                                + resultSet.getDate("appointment_date")
                                + " | "
                                + resultSet.getTime("appointment_time")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public boolean deleteAppointment(int appointmentId) {

        String query =
                "DELETE FROM appointments WHERE appointment_id = ?";

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(query)
        ) {

            statement.setInt(1, appointmentId);

            int rowsAffected =
                    statement.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public int deleteAppointmentsByPatientId(int patientId) {

    String query =
            "DELETE FROM appointments WHERE patient_id = ?";

    try (
            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(query)
    ) {

        statement.setInt(1, patientId);

        return statement.executeUpdate();

    } catch (Exception e) {

        e.printStackTrace();
        return 0;
    }
}
}