import java.util.*;

public class ClassroomManagerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Classroom> classrooms = new HashMap<>();
        Map<String, List<Student>> studentsByClass = new HashMap<>();
        List<Assignment> assignments = new ArrayList<>();
        Auth auth = new Auth(); // Auth object for authentication

        // Authentication before proceeding to the menu
        String id; 
        String pass; 
        boolean isAuthenticated = false;

        // Login prompt
        System.out.println("Welcome to the Classroom Manager App");
        while (!isAuthenticated) {
            try {
                System.out.print("Enter ID: ");
                id = scanner.nextLine();
                System.out.print("Enter Password: ");
                pass = scanner.nextLine();

                if (auth.authenticate(id, pass)) {
                    System.out.println("Login successful!");
                    isAuthenticated = true; // Exit the loop once authenticated
                } else {
                    System.out.println("Invalid credentials. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        // Main program logic starts after successful login
        while (true) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Add Classroom");
                System.out.println("2. Add Student");
                System.out.println("3. Schedule Assignment");
                System.out.println("4. Submit Assignment");
                System.out.println("5. Management services");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        // Add Classroom
                        System.out.print("Enter the class name: ");
                        String className = scanner.nextLine();
                        if (classrooms.containsKey(className)) {
                            System.out.println("Classroom '" + className + "' already exists.");
                        } else {
                            classrooms.put(className, new Classroom(className));
                            System.out.println("Classroom '" + className + "' has been created.");
                        }
                        break;
                    case 2:
                        // Add Student
                        System.out.print("Enter the student ID: ");
                        String studentId = scanner.nextLine();
                        System.out.print("Enter the student's name: ");
                        String studentName = scanner.nextLine();
                        System.out.print("Enter the class name: ");
                        String studentClassName = scanner.nextLine();

                        if (classrooms.containsKey(studentClassName)) {
                            List<Student> students = studentsByClass.getOrDefault(studentClassName, new ArrayList<>());
                            boolean studentExists = students.stream().anyMatch(s -> s.getStudentId().equals(studentId));

                            if (studentExists) {
                                System.out.println("Student with ID '" + studentId + "' is already enrolled in class '" + studentClassName + "'.");
                            } else {
                                students.add(new Student(studentId, studentClassName, studentName));
                                studentsByClass.put(studentClassName, students);
                                System.out.println("Student '" + studentName + "' (ID: " + studentId + ") has been enrolled in class '" + studentClassName + "'.");
                            }
                        } else {
                            System.out.println("Classroom '" + studentClassName + "' does not exist.");
                        }
                        break;
                    case 3:
                        // Schedule Assignment
                        System.out.print("Enter the class name: ");
                        String assignmentClassName = scanner.nextLine();
                        System.out.print("Enter assignment details: ");
                        String assignmentDetails = scanner.nextLine();

                        if (classrooms.containsKey(assignmentClassName)) {
                            Assignment assignment = new Assignment(assignmentClassName, assignmentDetails);
                            assignments.add(assignment);
                            System.out.println("Assignment for class '" + assignmentClassName + "' has been scheduled.");
                        } else {
                            System.out.println("Classroom '" + assignmentClassName + "' does not exist.");
                        }
                        break;
                    case 4:
                        // Submit Assignment
                        submitAssignment(scanner, classrooms, studentsByClass, assignments);
                        break;
                    case 5:
                        // Management services
                        manageUser(scanner, classrooms, studentsByClass, assignments);
                        break;
                    case 6:
                        // Exit
                        System.out.println("Exiting the program.");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    public static void manageUser(Scanner scanner, Map<String, Classroom> classrooms,
                                   Map<String, List<Student>> studentsByClass, List<Assignment> assignments) {
        while (true) {
            try {
                System.out.println("\nSelect a Management Option:");
                System.out.println("1. Classroom Management");
                System.out.println("2. Student Management");
                System.out.println("3. Assignment Management");
                System.out.println("4. Logout");
                System.out.print("Enter your choice: ");
                int managementChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (managementChoice) {
                    case 1:
                        manageClassrooms(scanner, classrooms);
                        break;
                    case 2:
                        manageStudents(scanner, classrooms, studentsByClass);
                        break;
                    case 3:
                        manageAssignments(scanner, classrooms, studentsByClass, assignments);
                        break;
                    case 4:
                        System.out.println("Logging out...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    // Classroom Management Methods
    public static void manageClassrooms(Scanner scanner, Map<String, Classroom> classrooms) {
        Auth auth=new Auth();
        String id;
        String pass;
        boolean isAuthenticated = false;
        while (!isAuthenticated) {
            try {
                System.out.print("Enter ID: ");
                id = scanner.nextLine();
                System.out.print("Enter Password: ");
                pass = scanner.nextLine();

                if (auth.authenticateClass(id, pass)) {
                    System.out.println("Login successful!");
                    isAuthenticated = true; // Exit the loop once authenticated
                } else {
                    System.out.println("Invalid credentials. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("\nClassroom Management:");
                System.out.println("1. Add Classroom");
                System.out.println("2. List Classrooms");
                System.out.println("3. Remove Classroom");
                System.out.println("4. Back to User Management");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        // Add Classroom
                        System.out.print("Enter the class name: ");
                        String className = scanner.nextLine();
                        if (classrooms.containsKey(className)) {
                            System.out.println("Classroom '" + className + "' already exists.");
                        } else {
                            classrooms.put(className, new Classroom(className));
                            System.out.println("Classroom '" + className + "' has been created.");
                        }
                        break;
                    case 2:
                        // List Classrooms
                        System.out.println("Classrooms:");
                        for (String name : classrooms.keySet()) {
                            System.out.println(name);
                        }
                        break;
                    case 3:
                        // Remove Classroom
                        System.out.print("Enter the class name to remove: ");
                        String classToRemove = scanner.nextLine();
                        if (classrooms.containsKey(classToRemove)) {
                            classrooms.remove(classToRemove);
                            System.out.println("Classroom '" + classToRemove + "' has been removed.");
                        } else {
                            System.out.println("Classroom '" + classToRemove + "' does not exist.");
                        }
                        break;
                    case 4:
                        // Back to User Management
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    // Student Management Methods
    public static void manageStudents(Scanner scanner, Map<String, Classroom> classrooms,
                                       Map<String, List<Student>> studentsByClass) {
        Auth auth=new Auth();
        String id;
        String pass;
        boolean isAuthenticated = false;
        while (!isAuthenticated) {
            try {
                System.out.print("Enter ID: ");
                id = scanner.nextLine();
                System.out.print("Enter Password: ");
                pass = scanner.nextLine();

                if (auth.authenticateStudent(id, pass)) {
                    System.out.println("Login successful!");
                    isAuthenticated = true; // Exit the loop once authenticated
                } else {
                    System.out.println("Invalid credentials. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("\nStudent Management:");
                System.out.println("1. Enroll New Student into Classroom");
                System.out.println("2. List Students in Each Classroom");
                System.out.println("3. Back to User Management");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        // Enroll New Student
                        System.out.print("Enter the student ID: ");
                        String studentId = scanner.nextLine();
                        System.out.print("Enter the student's name: ");
                        String studentName = scanner.nextLine();
                        System.out.print("Enter the class name: ");
                        String studentClassName = scanner.nextLine();

                        if (classrooms.containsKey(studentClassName)) {
                            List<Student> students = studentsByClass.getOrDefault(studentClassName, new ArrayList<>());
                            boolean studentExists = students.stream().anyMatch(s -> s.getStudentId().equals(studentId));

                            if (studentExists) {
                                System.out.println("Student with ID '" + studentId + "' is already enrolled in class '" + studentClassName + "'.");
                            } else {
                                students.add(new Student(studentId, studentClassName, studentName));
                                studentsByClass.put(studentClassName, students);
                                System.out.println("Student '" + studentName + "' (ID: " + studentId + ") has been enrolled in class '" + studentClassName + "'.");
                            }
                        } else {
                            System.out.println("Classroom '" + studentClassName + "' does not exist.");
                        }
                        break;
                    case 2:
                        // List Students
                        System.out.println("Students by Classroom:");
                        for (Map.Entry<String, List<Student>> entry : studentsByClass.entrySet()) {
                            System.out.println("Class: " + entry.getKey());
                            for (Student student : entry.getValue()) {
                                System.out.println("ID: " + student.getStudentId() + ", Name: " + student.getName());
                            }
                        }
                        break;
                    case 3:
                        // Back to User Management
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    // Assignment Management Methods
    public static void manageAssignments(Scanner scanner, Map<String, Classroom> classrooms,
                                          Map<String, List<Student>> studentsByClass, List<Assignment> assignments) {
        Auth auth=new Auth();
        String id;
        String pass;
        boolean isAuthenticated = false;
        while (!isAuthenticated) {
            try {
                System.out.print("Enter ID: ");
                id = scanner.nextLine();
                System.out.print("Enter Password: ");
                pass = scanner.nextLine();

                if (auth.authenticateassignment(id, pass)) {
                    System.out.println("Login successful!");
                    isAuthenticated = true; // Exit the loop once authenticated
                } else {
                    System.out.println("Invalid credentials. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("\nAssignment Management:");
                System.out.println("1. Schedule Assignment");
                System.out.println("2. Submit Assignment");
                System.out.println("3. Back to User Management");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        // Schedule Assignment
                        System.out.print("Enter the class name: ");
                        String assignmentClassName = scanner.nextLine();
                        System.out.print("Enter assignment details: ");
                        String assignmentDetails = scanner.nextLine();

                        if (classrooms.containsKey(assignmentClassName)) {
                            Assignment assignment = new Assignment(assignmentClassName, assignmentDetails);
                            assignments.add(assignment);
                            System.out.println("Assignment for class '" + assignmentClassName + "' has been scheduled.");
                        } else {
                            System.out.println("Classroom '" + assignmentClassName + "' does not exist.");
                        }
                        break;
                    case 2:
                        // Submit Assignment
                        submitAssignment(scanner, classrooms, studentsByClass, assignments);
                        break;
                    case 3:
                        // Back to User Management
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    
    public static void submitAssignment(Scanner scanner, Map<String, Classroom> classrooms,
        Map<String, List<Student>> studentsByClass, List<Assignment> assignments) {
        System.out.print("Enter student ID: ");
        String studentIdForSubmission = scanner.nextLine();
        System.out.print("Enter class name: ");
        String classNameForSubmission = scanner.nextLine();
        System.out.print("Enter assignment details: ");
        String assignmentDetailsForSubmission = scanner.nextLine();

        // Check if the class exists
        if (!classrooms.containsKey(classNameForSubmission)) {
            System.out.println("Classroom '" + classNameForSubmission + "' does not exist.");
            return; // Exit if class doesn't exist
        }

        // Check if the student exists in the class
        List<Student> studentsInClass = studentsByClass.get(classNameForSubmission);
        boolean studentExists = studentsInClass.stream()
                .anyMatch(s -> s.getStudentId().equals(studentIdForSubmission));

        if (!studentExists) {
            System.out.println("Student ID '" + studentIdForSubmission + "' not found in class '" + classNameForSubmission + "'.");
            return; // Exit if student doesn't exist
        }

        // Check for the assignment and mark as submitted
        boolean assignmentFound = false;
        for (Assignment assignment : assignments) {
            if (assignment.getClassName().equals(classNameForSubmission) 
                    && assignment.getAssignmentDetails().equals(assignmentDetailsForSubmission)) {
                // Check if the assignment has already been submitted
                if (assignment.isSubmitted()) {
                    System.out.println("Assignment has already been submitted by another student.");
                    return; // Exit if already submitted
                }
                // Mark assignment as submitted
                try {
                    assignment.submitAssignment();
                    System.out.println("Assignment submitted by Student " + studentIdForSubmission + " in class " + classNameForSubmission + ".");
                    assignmentFound = true;
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage()); // Handle already submitted assignment case
                }
                break;
            }
        }

        if (!assignmentFound) {
            System.out.println("Assignment not found.");
        }
    }
}