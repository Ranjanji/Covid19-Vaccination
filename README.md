<a name="readme-top"></a> 
<h1><img align="center" height="150" src="https://github.com/Ranjanji/dapper-spade-5134/blob/main/covidProof.png">Covid-19 Vaccination (CovidProof App) </h1>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#about-the-project">About The Project</a> </li>
    <li><a href="#Features">Features</a></li>
    <li><a href="#Tech">Tech Stack</a></li>
    <li><a href="#er">ER Diagram</a></li>
    <li><a href="#modules">Modules</a></li>
    <li><a href="#install">Installation</a></li>
    <li><a href="#usage">API Root Usage</a></li>
    <li><a href="#contributors">Contributors</a></li>
   
  </ol>
</details>

<a name="about-the-project"></a> 
# REST API for an Covid-19 Vaccination app having UI based functionality.

* We have developed this REST API for an Covid-19 Vaccination. This API performs all the fundamental CRUD operations to facilitate the citizen with an       option to register and schedule the vaccination session online in the Centers of their choice. 
* To develop and build a database application for a real-world domain.
* To The Citizen self-registration module will ensure fool-proof identification of deserving candidates for receiving the vaccines.
* Developed by team of 4 Back-end Developers during project week in [Masai School](www.masaischool.com).

<a name="Features"></a> 
## Features

* User and Admin authentication & validation with session uuid having.
* Login and LogOut functionality for both admin and user.
* Front-End UI platform to showcase the functionality of application.
* Admin Features:
    * Administrator Role of the entire application
    * Only registered admins with valid session token can add/update/delete vaccination module and vaccineCenter module or user from main database
    * Admin can access the details of different Users, Vaccine, Centers and Dose.
* User Features:
    * Registering themselves with application, and logging in to it.
    * Search the available Center based on name, city, pin code and booking a Appointment.
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<a name="Tech"></a>
## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* MySQL
* Postman
* Swagger
* JavaScript
* HTML5
* CSS3

[![My Skills](https://skillicons.dev/icons?i=java,spring,javascript,html,css,maven,hibernate,github,git,vscode&theme=light)](https://skillicons.dev)
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<a name="er"></a>
## ER Diagram
![App Screenshot](https://github.com/Ranjanji/dapper-spade-5134/blob/main/db_schema.png)

<a name="modules"></a>


## Modules

* Admin Module
* User Module
* Appointment Module

<a name="install"></a>
## Installation & Run

* Before running the API server, you should update the database config inside the [application.properties](https://github.com/Ranjanji/dapper-spade-5134/blob/main/CovidProofApp/src/main/resources/application.properties) file. 
* Update the port number, username and password as per your local database config.

```
    server.port=8880
    spring.datasource.url=jdbc:mysql://localhost:3306/CovidProof
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<a name="usage"></a>

## API Root Endpoint
```
https://localhost:8880/
```
```
http://localhost:8880/swagger-ui/index.html
```
### Sample API Response for applicant/user Register

`POST: http://localhost:8880/swagger-ui/index.html#/applicant-controller/registerApplicant`

* Request Body
```
{
  
  "name": "Subham Ranjan",
  "gender": "M",
  "dob": "1997-08-27",
  "age": 25,
  "address": "Badarpur, New Delhi",
  "city": "New Delhi",
  "state": "Delhi",
  "pincode": "110044",
  "mobile": "9311971746",
  "pancard": "65NL0CVX"
  
}
```
### Response Body

```
{
  "id": 1,
  "name": "Subham Ranjan",
  "gender": "M",
  "dob": [1997,8,27],
  "age": 25,
  "address": "Badarpur, New Delhi",
  "city": "New Delhi",
  "state": "Delhi",
  "pincode": "110044",
  "mobile": "9311971746",
  "pancard": {
    "panNumber": "65NL0CVX"
  },
  "aadharcard": {
    "adNo": 224246106463,
    "mobile": "9311971746"
  },
  "doses": null
}


``` 
<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Sample API Response for applicant/user Login

`POST: http://localhost:8880/swagger-ui/index.html#/applicant-controller/loginApplicant`

* Request Body

```
    {
        "Mobile": "9311971746",
        "dob": "1997-08-27"
    }
```

* Response Body

```
  {
  "id": 1,
  "name": "Subham Ranjan",
  "gender": "M",
  "dob": [
    1997,
    8,
    27
  ],
  "age": 25,
  "address": "Badarpur, New Delhi",
  "city": "New Delhi",
  "state": "Delhi",
  "pincode": "110044",
  "mobile": "9311971746",
  "pancard": {
    "panNumber": "65NL0CVX"
  },
  "aadharcard": {
    "adNo": 224246106463,
    "mobile": "9311971746"
  },
  "doses": []
}
```
<p align="right">(<a href="#readme-top">back to top</a>)</p>
<a href="contributors"></a>

## Contributors

* [Subham Ranjan](https://github.com/Ranjanji)
* [Sumit Panchal](https://github.com/sumitpanchal08)
* [Roshan Patro](https://github.com/Roshan-Patro)
* [Kapil Khurasde](https://github.com/kapil-khursade)
<p align="right">(<a href="#readme-top">back to top</a>)</p>
