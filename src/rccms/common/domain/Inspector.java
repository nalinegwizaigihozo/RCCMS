package rccms.common.domain;

import java.io.Serializable;

/**
 *
 * @author IT MODERN LTD
 */
public class Inspector implements Serializable {
    private int inspectorId;
    private String inspectorIdNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String qualifications;
    private String assignedDistrict;
    private String employmentStatus;
    private int userId;

    public Inspector() {
    }

    public Inspector(String inspectorIdNumber, String firstName, String lastName,
            String email, String phone, String qualifications,
            String assignedDistrict, String employmentStatus) {
        this.inspectorIdNumber = inspectorIdNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.qualifications = qualifications;
        this.assignedDistrict = assignedDistrict;
        this.employmentStatus = employmentStatus;
    }

    public int getInspectorId() {
        return inspectorId;
    }

    public void setInspectorId(int inspectorId) {
        this.inspectorId = inspectorId;
    }

    public String getInspectorIdNumber() {
        return inspectorIdNumber;
    }

    public void setInspectorIdNumber(String inspectorIdNumber) {
        this.inspectorIdNumber = inspectorIdNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getAssignedDistrict() {
        return assignedDistrict;
    }

    public void setAssignedDistrict(String assignedDistrict) {
        this.assignedDistrict = assignedDistrict;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
