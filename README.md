## Mini Authentication System

A secure Java-based desktop authentication system implementing user registration, login validation, password hashing, and OTP generation using core Java concepts.

This project demonstrates practical implementation of authentication logic, hashing techniques, file handling, and GUI development using Java Swing.

---

## Project Overview

The **Mini Authentication System** simulates a real-world login system.  
It securely stores user credentials using hashing techniques and validates login attempts through a structured authentication flow.

This project focuses on:

- Security fundamentals
- Clean modular architecture
- Object-oriented programming
- File-based persistence

---

## Features

- ✅ User Registration  
- ✅ Secure Password Hashing  
- ✅ Login Authentication  
- ✅ OTP Generation  
- ✅ File-Based User Storage  
- ✅ Modular Service-Based Architecture  
- ✅ GUI using Java Swing  

---

## Project Structure

```
Mini-Authentication-System
│
├── Main.java
├── RegisterFrame.java
├── LoginFrame.java
├── UserService.java
├── HashUtil.java
├── OTPGenerator.java
├── PasswordGenerator.java
└── .gitignore
```

### File Responsibilities

- **Main.java** → Entry point of the application  
- **RegisterFrame.java** → Handles user registration UI  
- **LoginFrame.java** → Handles login UI  
- **UserService.java** → Business logic for authentication  
- **HashUtil.java** → Password hashing implementation  
- **OTPGenerator.java** → OTP generation logic  
- **PasswordGenerator.java** → Secure password generation utility  

---

## Security Implementation

- Passwords are never stored in plain text  
- Hashing algorithm is used for secure password storage  
- OTP generation for additional authentication layer  
- Separation of UI and business logic  

---

## Concepts Demonstrated

- Object-Oriented Programming (OOP)  
- Encapsulation  
- Modular Design  
- File Handling  
- Hashing Techniques  
- GUI Development (Java Swing)  
- Authentication Flow Design  

---

## How to Run

1) Clone the Repository
   
    git clone https://github.com/CHANDINI-SIRI/Mini-Authentication-System.git

2) Navigate to Project Folder
   
    cd Mini-Authentication-System

3) Compile
   
    javac *.java


4) Run

    java Main


---

## Future Improvements

- Database integration (MySQL / PostgreSQL)  
- Email-based OTP delivery  
- Password strength validation  
- Encryption-based secure storage  
- REST API version of authentication system  

---

## Author

**Chandini Siri**  
Aspiring Software Engineer | Java & DSA Enthusiast  

---

## ⭐ Contribution

This is a learning-focused project. Suggestions and improvements are welcome.