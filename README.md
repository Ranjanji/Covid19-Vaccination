<a name="readme-top"></a> 
# Covid-19 Vaccination (CovidProof App)
<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#about-the-project">About The Project</a> </li>
    <li><a href="#Features">Features</a></li>
    <li><a href="#Tech">Tech Stack</a></li>
    <li><a href="#modules">Modules</a></li>
    <li><a href="#installation">Installation</a></li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributors">Contributors</a></li>
   
  </ol>
</details>

## ER Diagram
![App Screenshot](https://github.com/Ranjanji/dapper-spade-5134/blob/main/db_schema.png)

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
* Hibernate
* MySQL
* JavaScript
* HTML5
* CSS3

[![My Skills](https://skillicons.dev/icons?i=java,spring,javascript,html,css,maven,hibernate,github,git,vscode&theme=light)](https://skillicons.dev)
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<a href="modules"></a>
## Modules

* Admin Module
* User Module
* Appointment Module

<a href="install"></a>
## Installation & Run

* Before running the API server, you should update the database config inside the [application.properties](CovidProof\src\main\resources\application.properties) file. 
* Update the port number, username and password as per your local database config.

```
    server.port=8880
    spring.datasource.url=jdbc:mysql://localhost:3306/CovidProof;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```

### Sample API Response for admin Login

`POST: http://covid19vaccinationapi-env-1.eba-becpxd2x.ap-south-1.elasticbeanstalk.com/swagger-ui.html#/user-controller/userLoginUsingPOST_1`

* Request Body

```
    {
        "Mobile": "8502245750",
        "password": "Pass@123"
    }
```

* Response

```
   Login Successful.
```

# API Root Endpoint
```
https://localhost:8880/
```
```
http://localhost:8880/swagger-ui/index.html
```
<!-- # API References

## Customer Requests

### Member Controller

| Request | METHOD     |  URI | Description                |
| :-------- | :------- | :----- | :------------------------- |
| `PUT` | `Update` | `http://localhost:8080/user/update` | Update existing user |
| `POST` | `register` | `http://localhost:8080/user/register` | Register new user |
| `POST` | `Login` | `http://localhost:8080/user/login` | User Login |
| `POST` | `Book Appointment` | `http://localhost:8080/user/bookappointment` | Book Appoinment |
| `POST` | `Appointment Detail` | `http://localhost:8080/user/appointmentdetails` | Appointment Detail |
| `POST` | `Get Member` | `http://localhost:8080/user/getmeber/mobile` | Get Member By Mobile Number |
| `GET` | `Center List` | `http://localhost:8080/user/allcenters` | Center List |
| `DELETE` | `Delete` | `http://localhost:8080/user/delete` | Delete existing user |
| `DELETE` | `Cancel Appointment` | `http://localhost:8080/user/cancelappointment` | Cancel Appoinment |

## Admin Requests

### Vaccine Center Admin Controller :

| Request | METHOD     |  URI | Description                |
| :-------- | :------- | :----- | :------------------------- |
| `PUT` | `Update Center` | `http://localhost:8080/admin/updatecenter` | Update Center Details |
| `DELETE` | `Delete Center` | `http://localhost:8080/admin/removecenter` | Remove Center Details |
| `GET` | `Center List` | `http://localhost:8080/admin/allcenters` | Get All center Details |
| `POST` | `Create Center` | `http://localhost:8080/admin/savecenter` | Save new center details |
| `POST` | `Center By Id` | `http://localhost:8080/admin/getcenterbyid` | Get Center details by center ID |


# Sample API response - Member Registeration

### Request Type
```
POST
```

### Request URI
```
http://localhost:8080/user/register
```

### Request Body
```
{
    "mobileno": "9953805224",
    "passWord":"ram@123",
    "adharcard": {
        "adharNo": "224319664199",
        "name": "Ramesh",
        "dob": "08/15/1995",
        "gender": "Male",
        "addressline": "Ayodhya",
        "city": "Ayodhya",
        "state": "UP",
        "pincode": "432939"
    }
}
```
### Response Body

```
{
    "memberId": 5,
    "mobileno": "9953805224",
    "passWord": "ram@123",
    "adharcard": {
        "adharNo": "224319664199",
        "name": "Ramesh",
        "dob": "08/15/1995",
        "gender": "Male",
        "addressline": "Ayodhya",
        "city": "Ayodhya",
        "state": "UP",
        "pincode": "432939"
    }
}

``` -->
<a href="contributors"></a>
## Contributors

* [Subham Ranjan](https://github.com/Ranjanji)
* [Sumit Panchal](https://github.com/sumitpanchal08)
* [Roshan Patro](https://github.com/Roshan-Patro)
* [Kapil Khurasde](https://github.com/kapil-khursade)
<p align="right">(<a href="#readme-top">back to top</a>)</p>
