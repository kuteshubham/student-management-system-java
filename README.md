# 🎓 Student Management System (Java)

A **console-based Student Management System** built using **Core Java**, following
**clean OOP principles**, **layered architecture**, and **industry-style coding practices**.

---

## 🚀 Features

- Add Student  
- View All Students  
- Update Student  
- Delete Student  
- Search Student by ID  
- Input validation (Name, Age, Email)

---

## 🧱 Project Structure

```
src/
│
├── dao/
│ └── StudentDAO.java
│
├── model/
│ └── Student.java
│
├── util/
│ ├── DBConnection.java
│ └── ValidationUtil.java
│
├── main/
│ └── MainApp.java
```

---

## ✅ Validations Implemented

- **Name:** Cannot be empty  
- **Age:** Must be between **5 and 100**  
- **Email:** Regex-based format validation  

Validation logic is separated into a **utility class** for better
**readability**, **reusability**, and **clean code**.

---

## 🛠 Technologies Used

- Java (Core Java)
- OOP Concepts
- JDBC
- MySQL
- Regex
- Git & GitHub

---

## 📌 Design Principles

- Separation of Concerns  
- Clean Code Practices  
- Maintainable & Scalable structure  

---

## ▶️ How to Run the Project

Follow the steps below to run this project locally:

### 1️⃣ Prerequisites
- Java JDK 8 or above
- MySQL Server
- MySQL JDBC Connector (Connector/J)

### 2️⃣ Database Setup
- Create a MySQL database (e.g. `student_db`)
- Create a `students` table with appropriate columns
- Update database credentials in `DBConnection.java`

### 3️⃣ Add JDBC Driver
- Download MySQL Connector/J
- Add the `.jar` file to your project classpath (lib folder or IDE configuration)

### 4️⃣ Run the Application
- Navigate to `MainApp.java`
- Run the `main()` method
- Use the console menu to perform CRUD operations

---

## 📈 Future Enhancements

- GUI using JavaFX / Swing  
- REST API version (Spring Boot)  
- Logging & Exception handling  
- Authentication & Role-based access  

---

## 👨‍💻 Author

**Shubham Kute**  

---

## ⭐ Notes

This project is designed to demonstrate:
- Real-world Java project structure  
- Proper use of OOP & validation  
- Clean and readable code suitable for interviews  

Feel free to fork, improve, or extend this project 🚀
