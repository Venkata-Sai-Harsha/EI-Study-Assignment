class Auth {
    private String adminId = "admin"; // Example admin ID
    private String adminPassword = "admin123"; // Example admin password

    private String classId="class";
    private String classPassword="class123";

    private String studentId="student";
    private String studentPassword="student123";

    private String username="assignment";
    private String passworda="assignment123";
    

    // Method to authenticate the user
    public boolean authenticate(String id, String password) {
        return adminId.equals(id) && adminPassword.equals(password);
    }

    public boolean authenticateClass(String id, String password) {
        return classId.equals(id) && classPassword.equals(password);
    }

    public boolean authenticateStudent(String id, String password) {
        return studentId.equals(id) && studentPassword.equals(password);
    }

    public boolean authenticateassignment(String id, String password){
        return username.equals(id) && passworda.equals(password);
    }
}