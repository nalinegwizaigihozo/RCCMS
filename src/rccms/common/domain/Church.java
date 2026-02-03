package rccms.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author IT MODERN LTD
 */
public class Church implements Serializable {
    private int churchId;
    private String churchName;
    private String registrationNumber;
    private String pastorName;
    private String pastorPhone;
    private String pastorEmail;
    private String address;
    private String district;
    private String sector;
    private String cell;
    private int capacity;
    private String buildingType;
    private String complianceStatus;
    private Date registrationDate;
    private Date lastInspectionDate;

    public Church() {
    }

    public Church(String churchName, String registrationNumber, String pastorName,
            String pastorPhone, String pastorEmail, String address,
            String district, String sector, String cell, int capacity,
            String buildingType) {
        this.churchName = churchName;
        this.registrationNumber = registrationNumber;
        this.pastorName = pastorName;
        this.pastorPhone = pastorPhone;
        this.pastorEmail = pastorEmail;
        this.address = address;
        this.district = district;
        this.sector = sector;
        this.cell = cell;
        this.capacity = capacity;
        this.buildingType = buildingType;
        this.complianceStatus = "PENDING";
        this.registrationDate = new Date();
    }

    public int getChurchId() {
        return churchId;
    }

    public void setChurchId(int churchId) {
        this.churchId = churchId;
    }

    public String getChurchName() {
        return churchName;
    }

    public void setChurchName(String churchName) {
        this.churchName = churchName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getPastorName() {
        return pastorName;
    }

    public void setPastorName(String pastorName) {
        this.pastorName = pastorName;
    }

    public String getPastorPhone() {
        return pastorPhone;
    }

    public void setPastorPhone(String pastorPhone) {
        this.pastorPhone = pastorPhone;
    }

    public String getPastorEmail() {
        return pastorEmail;
    }

    public void setPastorEmail(String pastorEmail) {
        this.pastorEmail = pastorEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public String getComplianceStatus() {
        return complianceStatus;
    }

    public void setComplianceStatus(String complianceStatus) {
        this.complianceStatus = complianceStatus;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getLastInspectionDate() {
        return lastInspectionDate;
    }

    public void setLastInspectionDate(Date lastInspectionDate) {
        this.lastInspectionDate = lastInspectionDate;
    }
}
