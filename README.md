# 💬 Chatlet

A real-time chat application built with **Spring Boot** and **WebSocket**, designed for seamless communication and smooth performance. Chatlet is lightweight, fast, and ideal for small teams or personal projects.

---

## 🚀 Features

- 🔗 Real-time messaging with WebSocket
- 🔐 User authentication (Spring Security ready)
- 🧠 Smart message routing & chat room management
- 🗂️ MongoDB/Mysql integration (customizable)
- 📱 Responsive frontend-ready structure
- 🔧 Easy to configure and extend

---

## 🛠️ Tech Stack

| Layer        | Tech                         |
|--------------|------------------------------|
| Backend      | Spring Boot, Java            |
| WebSockets   | Spring WebSocket / STOMP     |
| Database     | MongoDB / MySQL (pluggable)  |
| Frontend     | (Plug in React, Vue, or Thymeleaf) |
| Build Tool   | Maven                        |

---

## 📁 Project Structure

```bash
chatlet/
├── src/
│   ├── main/
│   │   ├── java/com/chatlet/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── service/
│   │   │   └── ChatletApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
├── .gitignore
├── README.md
└── pom.xml

## ⚙️ Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/AyushPrakash414/Chatlet.git
cd Chatlet
