# 🏥 Hospital Management System

A console-based Hospital Management System built using **Java, JDBC, Maven, and MySQL**. The application allows hospital staff to manage patients, doctors, and appointments through an interactive menu-driven interface.

---

## ✨ Features

### 👨‍⚕️ Patient Management
- Add Patient
- View Patients
- Update Patient Disease
- Delete Patient
- Automatically cancel appointments when a patient is deleted

### 🩺 Doctor Management
- Add Doctor
- View Doctors
- Update Doctor Experience
- Delete Doctor

### 📅 Appointment Management
- Book Appointment
- View Appointments
- Cancel Appointment

---

## 🛠 Tech Stack

- Java 21
- JDBC
- Maven
- MySQL
- VS Code

---

## 📂 Project Structure

```
HospitalManagementSystem
│
├── src
│   └── main
│       └── java
│           └── com
│               └── umair
│                   ├── dao
│                   ├── model
│                   ├── util
│                   └── Main.java
│
├── database.sql
├── pom.xml
└── README.md
```

---

## 🗄 Database

The project uses MySQL with three tables:

- Patients
- Doctors
- Appointments

Foreign key relationships are maintained between appointments, patients, and doctors.

---

## ▶ How to Run

### Clone Repository

```bash
git clone https://github.com/syedumair11/HospitalManagementSystem.git
```

### Open Project

Open the project in VS Code.

### Create Database

Execute the SQL statements inside `database.sql`.

### Configure Database

Update the database credentials inside

```
DBConnection.java
```

### Build

```bash
mvn clean compile
```

### Run

```bash
mvn exec:java -Dexec.mainClass=com.umair.Main
```

---

## 🚀 Future Improvements

- Spring Boot REST API
- HTML/CSS Frontend
- Authentication
- Search Functionality
- Dashboard
- Reports

---

## 👨‍💻 Author

**Syed Umair Ali**

GitHub:
https://github.com/syedumair11

LinkedIn:
https://linkedin.com/in/syedumairali04