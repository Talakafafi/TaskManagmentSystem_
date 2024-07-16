# Task Management Application

## Description
This Java application provides a system for managing tasks within a project , and adding users . It allows you to add, update, remove, list, and analyze tasks. Tasks can be managed with different functionalities, 
including sorting and filtering based on their status, priority, and due date. The application includes classes for managing tasks,and users .

## Prerequisites
- Java Development Kit (JDK) version 11 or higher

## Project Structure
- **`Task`**: Represents a task with attributes such as ID, title, description, status, priority, and due date.
- **`TaskManagement`**: An abstract class providing basic operations for managing tasks, including adding, removing, updating, and listing tasks.
- **`individualTask`**: Extends `TaskManagement` to add functionality for sorting tasks based on different criteria.
- **`Project`**: Extends `TaskManagement` to initialize tasks in a `PriorityQueue` and provides functionality for analyzing tasks based on their status and priority.

## This is a console-based application. To test and use the application run it and navigate between the menu options that appear on the console section
