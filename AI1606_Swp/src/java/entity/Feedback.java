/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ADMIN
 */
public class Feedback {
    private String name;
    private String content;
    private int patient;

    public Feedback() {
    }

    public Feedback(String name, String content, int patient) {
        this.name = name;
        this.content = content;
        this.patient = patient;
    }
    
    
    
}
