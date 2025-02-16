package com.example.gradeapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GradeManager {
    /**
     * Computes the average grade for a given student.
     */
    public double computeStudentAverage(int studentId) {
        String sql = "SELECT AVG(grade) AS avg_grade FROM grades WHERE student_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            try(ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    return rs.getDouble("avg_grade");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    /**
     * Computes the average grade for a given assignment.
     */
    public double computeAssignmentAverage(int assignmentId) {
        String sql = "SELECT AVG(grade) AS avg_grade FROM grades WHERE assignment_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, assignmentId);
            try(ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    return rs.getDouble("avg_grade");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
    
    /**
     * Computes the overall average grade across all entries.
     */
    public double computeOverallAverage() {
        String sql = "SELECT AVG(grade) AS avg_grade FROM grades";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getDouble("avg_grade");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
}
