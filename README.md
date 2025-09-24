# fon-software-design-client-server
# Phone Store Sales Tracking System

This project is a **Java-based client-server application** developed as part of the *Software Design* course at the Faculty of Organizational Sciences, University of Belgrade.  
The system supports management and tracking of phone sales in a retail store environment.

## Features
The system provides full **CRUD (Create, Read, Update, Delete)** functionality for all entities:

- **Worker**
- **Customer**
- **Phone**
- **Receipt**
- **ReceiptItem**
- **Place**
- **WorkerDegree**
- **WP** (relation table between Worker and WorkerDegree)

Additional features:
- Worker authentication (login with username and password)
- Search functionality with multiple filtering criteria
- Relational database integration (MySQL)
- User-friendly GUI (Java Swing)

## Architecture
The system is designed as a **three-tier architecture**:
1. **Client Layer** – Graphical User Interface (Java Swing forms)
2. **Application Layer** – Business logic and controllers
3. **Data Layer** – Relational database (MySQL)

Communication between the client and server is implemented via **TCP sockets**.

## Database Schema
The database schema `baza` contains the following tables:
- `worker`
- `customer`
- `phone`
- `receipt`
- `receiptitem`
- `place`
- `workerdegree`
- `wp` (relation between workers and degrees)

SQL scripts for schema creation are included in the project.

## Technologies
- **Java SE (JDK 17)**
- **Swing** (GUI)
- **TCP/IP Sockets**
- **MySQL**
- **NetBeans IDE**

## How to Run
1. Clone the repository.
2. Open the project in NetBeans.
3. Build 01_CommonSeminarski:
   - Clean and Build the project `01_CommonSeminarski`.
   - This will generate a `.jar` file (e.g., `01_CommonSeminarski.jar`) in the `dist` folder.
4. Add the 01_CommonSeminarski JAR to Client and Server:
   - In NetBeans, right-click on `01_KlijentSeminarski` → Properties → Libraries → Add JAR/Folder → select `01_CommonSeminarski/dist/01_CommonSeminarski.jar`.
   - Repeat the same for `01_ServerSeminarski`.
4. Import the database schema from baza.sql(01_ServerSeminarski/database) into MySQL.
5. Update database connection settings in config.properties (01_ServerSeminarski/config).
6. Add MySQL Connector/J:
   - Download from https://dev.mysql.com/downloads/connector/j/
   - Add the `.jar` file to the project libraries in NetBeans for module `01_ServerSeminarski`.
7. Start the server.
8. Run the client application and log in as a worker.
