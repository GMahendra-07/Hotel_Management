
package com.example.demo.dto;

public class Room_typeDto {

    private Integer roomTypeId;
    private String roomType;
    private Integer numRooms;
    private Integer numPeople;
    private Integer roomCharge;

    // getters & setters
    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(Integer numRooms) {
        this.numRooms = numRooms;
    }

    public Integer getNumPeople() {
        return numPeople;
    }

    public void setNumPeople(Integer numPeople) {
        this.numPeople = numPeople;
    }

    public Integer getRoomCharge() {
        return roomCharge;
    }

    public void setRoomCharge(Integer roomCharge) {
        this.roomCharge = roomCharge;
    }
}


