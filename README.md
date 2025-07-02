# 🎧 Audiobook Tracker API

## Overview
This is a RESTful API built with Spring Boot for tracking audiobook listening sessions. It supports users, audiobooks, genres, and sessions, with endpoints for managing data and retrieving statistics.

## Features
- Full CRUD for:
  - Users
  - Audiobooks
  - Genres
  - Sessions
- Custom endpoints:
  - Total listening time by user
  - All audiobooks read by a user
  - All audiobooks by genre
  - All sessions for a specific audiobook
  - 5 most recent sessions
- MySQL database integration
- Postman-tested endpoints

## Technologies
- Java 17
- Spring Boot
- MySQL
- Maven

## Getting Started

### 1. Set up the Database
Create a MySQL database called `audiotracker_db` and update your `application.properties` with the correct connection details.

### 2. Run the App
```bash
mvn spring-boot:run
```

##
Looking for the command-line interface that connects to this API?  
Check out the [Audiobook Tracker CLI](https://github.com/todayisthorsday/audiotracker-cli)
