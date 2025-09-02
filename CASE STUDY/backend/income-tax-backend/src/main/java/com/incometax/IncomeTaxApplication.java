package com.incometax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IncomeTaxApplication {

    public static void main(String[] args) {
        SpringApplication.run(IncomeTaxApplication.class, args);
    }
}

/*
POST http://localhost:8080/api/auth/register
{ "username":"user1", "password":"pass", "role":"ROLE_USER" }


POST http://localhost:8080/api/auth/login
{ "username":"user1", "password":"pass" }



Testing via postman------>
url : http://localhost:8080

New user:
post : http://localhost:8080/api/auth/register
{
  "username": "siddhant",
  "password": "pass",
  "role": "Admin_USER"
}


for JWT token:
POST:http://localhost:8080/api/auth/login
{
  "username": "siddhant",
  "password": "pass"
}

here you will get the token
copy the token
and go to authorization tab and select type as Bearer Token
and paste the token


Create a Taxpayer
POST: http://localhost:8080/api/taxpayers
{
  "name": "Sahil Lokhande",
  "panNumber": "ABCDE1234F",
  "annualIncome": 500000
}



Get all Taxpayers
GET: http://localhost:8080/api/taxpayers



Get Taxpayer by ID
GET: http://localhost:8080/api/taxpayers/id

Update
PUT: http://localhost:8080/api/taxpayers/id



Delete
DELETE: http://localhost:8080/api/taxpayers/id
 */
