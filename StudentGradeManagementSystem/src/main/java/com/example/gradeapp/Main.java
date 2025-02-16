package com.example.gradeapp;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        AssignmentDAO assignmentDAO = new AssignmentDAO();
        GradeDAO gradeDAO = new GradeDAO();
        GradeManager gradeManager = new GradeManager();

        Student alice = new Student("Alice Johnson");
        Student bob = new Student("Bob Smith");
        int aliceId = studentDAO.addStudent(alice);
        int bobId = studentDAO.addStudent(bob);

        Assignment mathAssignment = new Assignment("Math Homework");
        Assignment scienceAssignment = new Assignment("Science Project");
        int mathId = assignmentDAO.addAssignment(mathAssignment);
        int scienceId = assignmentDAO.addAssignment(scienceAssignment);

        gradeDAO.addGrade(new Grade(aliceId, mathId, 88.5));
        gradeDAO.addGrade(new Grade(aliceId, scienceId, 92.0));
        gradeDAO.addGrade(new Grade(bobId, mathId, 75.0));
        gradeDAO.addGrade(new Grade(bobId, scienceId, 80.5));

        double aliceAvg = gradeManager.computeStudentAverage(aliceId);
        double bobAvg = gradeManager.computeStudentAverage(bobId);
        double mathAvg = gradeManager.computeAssignmentAverage(mathId);
        double overallAvg = gradeManager.computeOverallAverage();

        System.out.println("=== Student Averages ===");
        System.out.printf("%s: %.2f%n", alice.getName(), aliceAvg);
        System.out.printf("%s: %.2f%n", bob.getName(), bobAvg);
        
        System.out.println("\n=== Assignment Average ===");
        System.out.printf("%s: %.2f%n", mathAssignment.getTitle(), mathAvg);
        
        System.out.println("\n=== Overall Average ===");
        System.out.printf("Overall: %.2f%n", overallAvg);
    }
}
