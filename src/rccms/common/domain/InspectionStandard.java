package rccms.common.domain;

import java.io.Serializable;

/**
 *
 * @author IT MODERN LTD
 */
public class InspectionStandard implements Serializable {
    private int standardId;
    private String standardCode;
    private String standardName;
    private String description;
    private String category;
    private boolean mandatory;
    private int maxScore;

    public InspectionStandard() {
    }

    public InspectionStandard(String standardCode, String standardName,
            String description, String category,
            boolean mandatory, int maxScore) {
        this.standardCode = standardCode;
        this.standardName = standardName;
        this.description = description;
        this.category = category;
        this.mandatory = mandatory;
        this.maxScore = maxScore;
    }

    public int getStandardId() {
        return standardId;
    }

    public void setStandardId(int standardId) {
        this.standardId = standardId;
    }

    public String getStandardCode() {
        return standardCode;
    }

    public void setStandardCode(String standardCode) {
        this.standardCode = standardCode;
    }

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }
}
