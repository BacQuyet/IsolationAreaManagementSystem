/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Timestamp;

/**
 *
 * @author Administrator
 */
public class Feedback {
    private int feedback_id;
    private String content;
    private Timestamp createDate;
    private int patient_id;

    public Feedback() {
    }

    public Feedback(int feedback_id, String content, Timestamp createDate, int patient_id) {
        this.feedback_id = feedback_id;
        this.content = content;
        this.createDate = createDate;
        this.patient_id = patient_id;
    }

    public int getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    @Override
    public String toString() {
        return "Feedback{" + "feedback_id=" + feedback_id + ", content=" + content + ", createDate=" + createDate + ", patient_id=" + patient_id + '}';
    }
    
    
}
