package asm.org.MusicStudio.services;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import asm.org.MusicStudio.dao.EnrollmentDAO;
import asm.org.MusicStudio.entity.Course;
import asm.org.MusicStudio.entity.Enrollment;
import asm.org.MusicStudio.entity.Payment;
import asm.org.MusicStudio.entity.Student;

public class EnrollmentService {
    
    private EnrollmentDAO enrollmentDAO;

    public EnrollmentService() {
        this.enrollmentDAO = new EnrollmentDAO();
    }

    /**
     * Gets all enrollments for the current user
     * @param semester Filter by semester (optional)
     * @return List of enrollments
     */
    public List<Enrollment> getEnrollments(String semester) {
        try {
            // For now, just get all enrollments without semester filter
            return enrollmentDAO.findByTeacherId(getCurrentUserId());
        } catch (SQLException e) {
            System.err.println("Error fetching enrollments: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    /**
     * Enrolls a student in a course
     * @param enrollment The enrollment details
     */
    public void enrollInCourse(Enrollment enrollment) {
        //TODO: Implement enrollment creation in database
        //TODO: Validate course capacity
        //TODO: Check for schedule conflicts
        //TODO: Update course availability
    }
    
    /**
     * Cancels an enrollment
     * @param enrollmentId The ID of the enrollment to cancel
     */
    public void cancelEnrollment(Long enrollmentId) {
        //TODO: Implement enrollment cancellation
        //TODO: Update course availability
        //TODO: Apply cancellation policies
        //TODO: Record cancellation reason
    }
    
    /**
     * Checks if a course has available slots
     * @param courseId The course to check
     * @return boolean indicating availability
     */
    public boolean checkCourseAvailability(Long courseId) {
        //TODO: Implement availability check
        //TODO: Compare current enrollment count with capacity
        //TODO: Consider waitlist status
        return false;
    }
    
    /**
     * Gets enrollments for a student
     * @param student The student
     * @return List of enrollments
     */
    public List<Enrollment> getStudentEnrollments(Student student) {
        //TODO: Query enrollments table for student
        //TODO: Join with courses table
        //TODO: Join with payments table
        //TODO: Filter active enrollments
        return null;
    }
    
    /**
     * Creates a new enrollment
     * @param student The enrolling student
     * @param course The course to enroll in
     * @param startDate Start date
     * @param payment Initial payment
     */
    public void createEnrollment(Student student, Course course, 
            LocalDate startDate, Payment payment) {
        //TODO: Validate course capacity
        //TODO: Check for schedule conflicts
        //TODO: Create enrollment record
        //TODO: Update course enrollments
        //TODO: Process initial payment
    }
    
    /**
     * Updates enrollment status
     * @param enrollment The enrollment to update
     * @param newStatus New status
     */
    public void updateEnrollmentStatus(Enrollment enrollment, String newStatus) {
        //TODO: Validate status transition
        //TODO: Update enrollment record
        //TODO: Update course capacity if needed
        //TODO: Handle payment implications
    }

    public List<Enrollment> getEnrollmentsByTeacher(int teacherId) {
        try {
            return enrollmentDAO.findByTeacherId(teacherId);
        } catch (SQLException e) {
            System.err.println("Error fetching teacher enrollments: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private int getCurrentUserId() {
        // TODO: Implement proper user session management
        return 1; // Temporary default value
    }
} 