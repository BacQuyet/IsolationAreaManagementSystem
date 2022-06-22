/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author X1 Carbon Gen 7
 */
public class Presciption {
    private Integer presciptionId;
    private String presciptionName;
    private Date createDate;
    private Patient patient;
    private Doctor doctor;
    private Medicine medicine;
    private Integer quantity;

    public Presciption() {
    }

    public Presciption(Integer presciptionId, String presciptionName, Date createDate, Patient patient, Doctor doctor, Medicine medicine, Integer quantity) {
        this.presciptionId = presciptionId;
        this.presciptionName = presciptionName;
        this.createDate = createDate;
        this.patient = patient;
        this.doctor = doctor;
        this.medicine = medicine;
        this.quantity = quantity;
    }
    
    

    public Integer getPresciptionId() {
        return presciptionId;
    }

    public void setPresciptionId(Integer presciptionId) {
        this.presciptionId = presciptionId;
    }

    public String getPresciptionName() {
        return presciptionName;
    }

    public void setPresciptionName(String presciptionName) {
        this.presciptionName = presciptionName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
            
}
