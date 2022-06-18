/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author X1 Carbon Gen 7
 */
public class Medicine {
    private Integer medicienId;
    private String name;
    private Integer quantity;
    private String image;

    public Medicine(Integer medicienId, String name, Integer quantity, String image) {
        this.medicienId = medicienId;
        this.name = name;
        this.quantity = quantity;
        this.image = image;
    }

    public Medicine() {
    }
    
    

    public Integer getMedicienId() {
        return medicienId;
    }

    public void setMedicienId(Integer medicienId) {
        this.medicienId = medicienId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
