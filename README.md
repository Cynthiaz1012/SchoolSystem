# School System 

## Author
**Cynthia Zhang**

Student ID: **2557705**

## Project Description

This project is the **final project for Introduction to Programming**.  
It simulates a **school management system**.

The system allows:
- Students to register and drop courses
- Courses to manage students, assignments, and scores
- Teachers to generate, calculate, and display student scores

## Main Classes:
- Address
- Department
- Student
- Course
- Assignment
- Util

## Unit Testing
Unit tests are realized using JUnit Jupiter, methods testing:
- static boolean isPostalCodeValid(String postalCode)
- static boolean isDepartmentNameValid(String departmentName)
- boolean registerCourse(Course course)
- boolean dropCourse(Course course)
- double calcAssignmentAvg()
- boolean isAssignmentWeightValid()
- boolean registerStudent(Student student)
- int[] calcStudentsAverage()
- boolean addAssignment(String assignmentName, double weight)

