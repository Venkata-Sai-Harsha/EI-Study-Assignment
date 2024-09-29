public class Assignment {
    private String className;
    private String assignmentDetails;
    private boolean isSubmitted; // Track submission status

    public Assignment(String className, String assignmentDetails) {
        this.className = className;
        this.assignmentDetails = assignmentDetails;
        this.isSubmitted = false; // Default to not submitted
    }

    public String getClassName() {
        return className;
    }

    public String getAssignmentDetails() {
        return assignmentDetails;
    }

    public boolean isSubmitted() {
        return isSubmitted; // Return the submission status
    }

    public void submitAssignment() {
        if (!isSubmitted) {
            isSubmitted = true; // Mark as submitted
        } else {
            throw new IllegalStateException("Assignment has already been submitted."); // Throw an exception if already submitted
        }
    }
}
