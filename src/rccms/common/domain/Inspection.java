package rccms.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author IT MODERN LTD
 */
public class Inspection implements Serializable {
    private int inspectionId;
    private int churchId;
    private int inspectorId;
    private Date inspectionDate;
    private double overallScore;
    private String status;
    private String notes;
    private Date createdAt;

    public Inspection() {
    }

    public Inspection(int churchId, int inspectorId, Date inspectionDate) {
        this.churchId = churchId;
        this.inspectorId = inspectorId;
        this.inspectionDate = inspectionDate;
        this.createdAt = new Date();
    }

    public int getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(int inspectionId) {
        this.inspectionId = inspectionId;
    }

    public int getChurchId() {
        return churchId;
    }

    public void setChurchId(int churchId) {
        this.churchId = churchId;
    }

    public int getInspectorId() {
        return inspectorId;
    }

    public void setInspectorId(int inspectorId) {
        this.inspectorId = inspectorId;
    }

    public Date getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(Date inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public double getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(double overallScore) {
        this.overallScore = overallScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
