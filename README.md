# EI-Study-Assignment
## Virtual Classroom Manager Programming Exercise

### Personal info
Name: P.Venkata Sai Harsha

Email: p.venkatasaiharsha@gmail.com

### Problem Statement:
Imagine you are developing the backend for an EdTech platform that aims to host virtual classrooms. Your task is to create a terminal-based Virtual Classroom Manager that handles class scheduling, student attendance, and assignment submissions.

### overview:
The Virtual Classroom Manager is a terminal-based backend application designed to simulate the key operations of a virtual classroom within an EdTech platform. The application allows users to manage classrooms, students, and assignments via a simple command-line interface (CLI). It supports core functionalities like classroom creation, student enrollment, assignment scheduling, and submission handling.

This project is intended as a backend solution for managing virtual classrooms in an educational platform, with a focus on clean code practices, SOLID principles, and maintainable design patterns.

## Features
- Classroom Management: Create, list, and delete classrooms to organize virtual educational spaces.
- Student Enrollment: Add students to classrooms, list enrolled students in each class.
- Assignment Management: Schedule assignments for classrooms and allow students to submit their completed work.
- User Authentication: Secure the system with user authentication, ensuring only authorized personnel can manage classrooms and assignments.

### Functional Requirements
#### Classroom Management:
- Add a classroom by specifying the class name.
- List all classrooms.
- Remove an existing classroom.
#### Student Management:
- Enroll a student in a specific classroom using their student ID and class name.
- List all students enrolled in a particular classroom.
#### Assignment Management:
- Schedule an assignment for a class with relevant details.
- Submit assignments by students, including student ID, class name, and assignment details.

### Console Commands
- Add Classroom
  - Command: `add_classroom [ClassName]`
  - Example: `add_classroom Math101`
  - Output: `Classroom Math101 has been created.`

- Add Student
  Command: `add_student [StudentID] [ClassName]`
  Example: `add_student 12345 Math101`
  Output: `Student 12345 has been enrolled in Math101.`

- Schedule Assignment
  Command: `schedule_assignment [ClassName] [AssignmentDetails]`
  Example: `schedule_assignment Math101 Homework 1`
  Output: `Assignment for Math101 has been scheduled.`

- Submit Assignment
  Command: `submit_assignment [StudentID] [ClassName] [AssignmentDetails]`
  Example: `submit_assignment 12345 Math101 Homework 1`
  Output: `Assignment submitted by Student 12345 in Math101.`

