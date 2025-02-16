package com.example.gradeapp;

public class Grade {
    private int id;
    private int studentId;
    private int assignmentId;
    private double grade;

    public Grade() {}

    public Grade(int studentId, int assignmentId, double grade) {
        this.studentId = studentId;
        this.assignmentId = assignmentId;
        this.grade = grade;
    }
    
    public Grade(int id, int studentId, int assignmentId, double grade) {
        this.id = id;
        this.studentId = studentId;
        this.assignmentId = assignmentId;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public int getAssignmentId() {
        return assignmentId;
    }
    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }
    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }
    
    @Override
    public String toString() {
        return "Grade{id=" + id + ", studentId=" + studentId + ", assignmentId=" + assignmentId + ", grade=" + grade + "}";
    }
}
