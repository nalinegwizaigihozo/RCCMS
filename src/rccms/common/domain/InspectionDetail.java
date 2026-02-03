package rccms.common.domain;

import java.io.Serializable;

/**
 *
 * @author IT MODERN LTD
 */
public class InspectionDetail implements Serializable {
    private int detailId;
    private int inspectionId;
    private int standardId;
    private double score;
    private String comments;

    public InspectionDetail() {
    }

    public InspectionDetail(int inspectionId, int standardId, double score) {
        this.inspectionId = inspectionId;
        this.standardId = standardId;
        this.score = score;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public int getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(int inspectionId) {
        this.inspectionId = inspectionId;
    }

    public int getStandardId() {
        return standardId;
    }

    public void setStandardId(int standardId) {
        this.standardId = standardId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
