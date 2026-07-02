package com.umair.dao;

import com.umair.model.Doctor;
import com.umair.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DoctorDAO {

    public boolean addDoctor(Doctor doctor) {

        String query =
                "INSERT INTO doctors(name, specialization, experience) VALUES (?, ?, ?)";

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(query)
        ) {

            statement.setString(1, doctor.getName());
            statement.setString(2, doctor.getSpecialization());
            statement.setInt(3, doctor.getExperience());

            int rowsAffected =
                    statement.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public void getAllDoctors() {

        String query = "SELECT * FROM doctors";

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(query);

                ResultSet resultSet =
                        statement.executeQuery()
        ) {

            System.out.println("\n===== Doctors =====");

            while (resultSet.next()) {

                System.out.println(
                        resultSet.getInt("doctor_id")
                                + " | "
                                + resultSet.getString("name")
                                + " | "
                                + resultSet.getString("specialization")
                                + " | "
                                + resultSet.getInt("experience")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public boolean updateDoctorExperience(
        int doctorId,
        int experience
) {

    String query =
            "UPDATE doctors SET experience = ? WHERE doctor_id = ?";

    try (
            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(query)
    ) {

        statement.setInt(1, experience);
        statement.setInt(2, doctorId);

        int rowsAffected =
                statement.executeUpdate();

        return rowsAffected > 0;

    } catch (Exception e) {

        e.printStackTrace();
        return false;
    }
}

public boolean deleteDoctor(int doctorId) {

    String query =
            "DELETE FROM doctors WHERE doctor_id = ?";

    try (
            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(query)
    ) {

        statement.setInt(1, doctorId);

        int rowsAffected =
                statement.executeUpdate();

        return rowsAffected > 0;

    } catch (Exception e) {

        e.printStackTrace();
        return false;
    }
}
}