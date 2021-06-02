# Expense Reimbursement System(ERS) Java/MSA Full Stack

## Project Description

The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

## Technologies Used

* Java - version 8.0
* Javascript - es6
* PostgresSql - version 10.0
* Tomcat - version 8.5
* AWS Relational Database Service
* JDBC API
* HTML5,CSS3

## Features

* Manager is able to view all resolved reimbursement tickets and details
* Manger is able to view tickets based on whether they have been resolved or not
* Manager is able to resolve a pending request
* Employee is able to submit a new request to reimburse company-related expenses
* Employee is able to view their request history
* Each user is given a unique profile

To-do-list:

* implement ability for user to update their account information
* refactor javascript code to handle views gracefully
* implement more test coverage, logging
* implement sorting ability for tables
* implement password hashing
* implement ability to reset password via email
* implement search ability for manager to view history of a particular employee
* improve client-side validation, user feedback for forms
* employee to upload an image of their receipt for expense proof
* manager is able to view images uploaded in their request

## Getting Started

For windows:

1. open a terminal via gitbash
2. in your terminal, use the following commands
3. `git clone https://github.com/210419-USF-BSN-Java/Ruben-Garcia.git`
4. `cd project1/reimbusement-app`

## Usage

1. open the project in your IDE of choice
2. run the project on your local server using a extension for your favorite IDE, [vsCodeTomcatExtension](https://marketplace.visualstudio.com/items?itemName=adashen.vscode-tomcat
), ecplise also offers an extension to run tomcat
3. startup local server, go to localhost:8080 (default port)