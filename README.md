# 💳 Secure Digital Payment App

A secure, full-stack digital payment application built using **Spring Boot**, **JWT Authentication**, **SQL Server**, and **JavaScript**.  
This project demonstrates secure login, payment processing, and transaction history management.

---

## 🚀 Features

- 🔐 User Registration & Login with JWT Authentication
- 💸 Secure Payment using UPI ID and Amount
- ✅ Real-time Payment Success / Failure handling
- 📜 Transaction History with Date & Time
- 🧾 Password Validation (Capital, Number, Special Character)
- 🎨 Clean UI using HTML, CSS, JavaScript 
- 🔒 Spring Security integration

---

## 🛠️ Tech Stack

**Backend**
- Java 17
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA

**Frontend**
- HTML
- CSS
- JavaScript (Fetch API)

**Database**
- Microsoft SQL Server

**Tools**
- IntelliJ IDEA
- Maven
- Git & GitHub

---

## 📂 Project Structure
src
└── main
├── java
│ └── com.payment
│ ├── config # Security configuration
│ ├── controller # REST & Web Controllers
│ ├── dto # Data Transfer Objects
│ ├── entity # JPA Entities
│ ├── exception # Custom Exceptions
│ ├── repository # JPA Repositories
│ ├── security # JWT Filter & Utility
│ └── service # Business Logic
└── resources
├── static
│ └── css
│ └── style.css
├── templates
│ ├── login.html
│ ├── register.html
│ ├── dashboard.html
│ ├── payment.html
│ └── status.html
└── application.properties



---

## 🔑 Authentication Flow (JWT)

1. User logs in with email & password
2. Server validates credentials
3. JWT token is generated
4. Token is stored in browser (localStorage)
5. Token is sent in `Authorization` header
6. Secure APIs validate JWT before processing requests

---

## 💸 Payment Flow

1. User enters UPI ID & Amount
2. Clicks **Pay Now**
3. Backend validates JWT
4. Transaction is saved in DB with timestamp
5. Success message shown instantly
6. Fields are cleared automatically
