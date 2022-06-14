/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Thanh Duy
 */
import java.util.Date;

public class Patient {

    private Integer patientId;

    private String patientName;

    private int age;

    private String passport;

    private String gender;

    private String address;

    private int phoneNumber;

    private String region;

    private String suspicionLevel;
    
    private Date timeIn;

    private Date timeOut;

    private Room room;

    private Area area;
    private String roomName;
    private String areaName;
    public Patient() {
    }

    public Patient(Integer patientId, String patientName, int age, String passPort, String gender, String address, int phoneNumber, String region, String suspicionLevel, Date timeIn, Date timeOut, Room phong, Area khuCachLy) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.passport = passPort;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.region = region;
        this.suspicionLevel = suspicionLevel;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.room = phong;
        this.area = khuCachLy;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Patient(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSuspicionLevel() {
        return suspicionLevel;
    }

    public void setSuspicionLevel(String suspicionLevel) {
        this.suspicionLevel = suspicionLevel;
    }

    public Date getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room phong) {
        this.room = phong;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area khuCachLy) {
        this.area = khuCachLy;
    }

    @Override
    public String toString() {
        String result = "Patient ID = " + patientId + "\n"
                + "Patient Name = " + patientName + "\n"
                + "Patient Phone = " + age + "\n"
                + "Patient Fullname = " + passport + "\n"
                + "Patient Account_Id = " + gender + "\n"
                + "Patient Address = " + address + "\n"
                + "Patient Phone Number = " + phoneNumber + "\n"
                + "Patient Region = " + region + "\n"
                + "Patient Suspicion Level = " + suspicionLevel + "\n"
                + "Patient Time In = " + timeIn + "\n"
                + "Patient Time Out = " + timeOut + "\n"
                + "Patient Room Name = " + room.getRoomName() + "\n"
                + "Patient Area Name = " + area.getAreaName() + "\n";
        return result;
    }

}
