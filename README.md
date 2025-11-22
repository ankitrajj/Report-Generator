# Report Generation (PDF & Excel) - Spring Boot + JSP
This project demonstrates how to generate PDF and Excel reports and mail these to an another email in a Spring Boot MVC application using JSP views.
It includes search functionality, mail sending, and file export using HTTP response streaming.

---

## 🚀 Overview
- Search & Filter data using a dynamic form
- Generate PDF Report (Downloadable)
- Generate Excel Report (Downloadable)
- JSP-based UI for frontend
- Spring Boot MVC + Service layer architecture
- Send email with above attached reports
---

## 🧩 Tech Stack

| Category | Technology |
|-----------|-------------|
| **Spring Boot 3.x** |  Backend & MVC|
| **MySQL** | Database |
| **Spring Data JPA** | Database handling |
| **Maven** |  Build Tool|
| **JSP** | UI rendering |
| **Apache POI** | Excel generation |
| **PDF Library (iText/PDFBox)** | Pdf generation |

---

## 🏗️ Project Structure
```
src/main/java/in/ankit
 ├── controller
 │     └── ReportController.java
 ├── entity
 │     └── Citizen.java
 ├── repository
 │     └── CitizenRepo.java
 ├── request
 │      └── SearchRequest.java
 ├── runner
 │     └── loadData.java
 ├── service
 │     └── ReportService.java
 │     └── ReportServiceImpl.java
 ├── util
 │     └── emailSender.java
 │     └── excelGenerator.java
 │     └── pdfGenerator.java
 │── Application.java

 src/main/webapp/pages
 └── index.jsp
       
```
## ⚙️ Features
- ✔ Search & Filter:  
   Users can search citizens by parameters like plan, status, gender, and date ranges.
- ✔ PDF Report Export:   
   Generates a downloadable PDF file using PdfGenerator.
- ✔ Excel Report Export:   
   Generates a downloadable Excel file using ExcelGenerator.
- ✔ Preloaded Sample Data:   
   LoadData.java pre-loads sample citizen records at startup.
- ✔ Email Sending:   
   EmailSender utility supports sending reports via email.
   
---

##  Controller Endpoints
- GET /   
     Loads the home page with search form and dropdown values.
- POST /search   
    Receives search criteria and displays filtered results on the same page.
- GET /pdf   
    Exports the filtered results as a PDF file.
- GET /excel   
     Exports the filtered results as an Excel file.
---

## 🖥️ How to Run
Clone the repository:
```
git clone https://github.com/ankitrajj/Report-Generator.git
```
Navigate into the project folder:
```
cd <project-folder>
```
Run the application:
```
mvn spring-boot:run
```
Open in browser:
```
http://localhost:8080/
```

  
