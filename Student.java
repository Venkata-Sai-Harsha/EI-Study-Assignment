public class Student {
    private String studentId;
    private String name; // Added name
    private String className;

    public Student(String studentId, String name, String className) {
        this.studentId = studentId;
        this.name = name; // Initialize the student's name
        this.className = className;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name; // Getter for the student's name
    }

    public void setName(String name) {
        this.name = name; // Setter for the student's name
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
