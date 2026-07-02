package com.umair.dao;

import com.umair.model.Patient;
import com.umair.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PatientDAO {
    public boolean updatePatientDisease(
        int patientId,
        String disease
) {

    String query =
            "UPDATE patients SET disease = ? WHERE patient_id = ?";

    try (
            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(query)
    ) {

        statement.setString(1, disease);
        statement.setInt(2, patientId);

        int rowsAffected =
                statement.executeUpdate();

        return rowsAffected > 0;

    } catch (Exception e) {

        e.printStackTrace();
        return false;
    }
}
    public boolean deletePatient(int patientId) {

    String query =
            "DELETE FROM patients WHERE patient_id = ?";

    try (
            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(query)
    ) {

        statement.setInt(1, patientId);

        int rowsAffected =
                statement.executeUpdate();

        return rowsAffected > 0;

    } catch (Exception e) {

        e.printStackTrace();
        return false;
    }
}

    public boolean addPatient(Patient patient) {

        String query =
                "INSERT INTO patients(name, age, gender, disease, phone) VALUES (?, ?, ?, ?, ?)";

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(query)
        ) {

            statement.setString(1, patient.getName());
            statement.setInt(2, patient.getAge());
            statement.setString(3, patient.getGender());
            statement.setString(4, patient.getDisease());
            statement.setString(5, patient.getPhone());

            int rowsAffected =
                    statement.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
    public void getAllPatients() {

        String query = "SELECT * FROM patients";

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(query);

                ResultSet resultSet =
                        statement.executeQuery()
        ) {

            System.out.println("\n===== Patients =====");

            while (resultSet.next()) {

                System.out.println(
                        resultSet.getInt("patient_id")
                                + " | "
                                + resultSet.getString("name")
                                + " | "
                                + resultSet.getInt("age")
                                + " | "
                                + resultSet.getString("gender")
                                + " | "
                                + resultSet.getString("disease")
                                + " | "
                                + resultSet.getString("phone")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public String getPatientNameById(int patientId) {

    String query =
            "SELECT name FROM patients WHERE patient_id = ?";

    try (
            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(query)
    ) {

        statement.setInt(1, patientId);

        ResultSet resultSet =
                statement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getString("name");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}
}