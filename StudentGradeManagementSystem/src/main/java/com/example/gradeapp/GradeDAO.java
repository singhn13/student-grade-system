package com.example.gradeapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradeDAO {

    public int addGrade(Grade grade) {
        String sql = "INSERT INTO grades (student_id, assignment_id, grade) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, grade.getStudentId());
            stmt.setInt(2, grade.getAssignmentId());
            stmt.setDouble(3, grade.getGrade());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Adding grade failed, no rows affected.");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    grade.setId(id);
                    return id;
                } else {
                    throw new SQLException("Adding grade failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public List<Grade> getAllGrades() {
        List<Grade> grades = new ArrayList<>();
        String sql = "SELECT * FROM grades";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                grades.add(new Grade(rs.getInt("id"), rs.getInt("student_id"), rs.getInt("assignment_id"), rs.getDouble("grade")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades;
    }
    
}
