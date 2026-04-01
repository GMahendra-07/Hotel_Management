package com.example.demo.service;

import com.example.demo.entity.RoomType;
import com.example.demo.repository.Room_typeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Room_typeService {

    @Autowired
    private Room_typeRepository roomTypeRepository;

    // CREATE
    public RoomType saveRoomType(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    // GET ALL
    public List<Room_type> getAllRoomTypes() {
        return roomTypeRepository.findAll();
    }

    // GET BY ID
    public Room_type getRoomTypeById(Integer id) {
        Optional<Room_type> optional = roomTypeRepository.findById(id);
        return optional.orElse(null);
    }

    // UPDATE
    public Room_type updateRoomType(Integer id, Room_type roomTypeDetails) {
        Room_type roomType = getRoomTypeById(id);

        if (roomType != null) {
            roomType.setRoomType(roomTypeDetails.getRoomType());
            roomType.setNumRooms(roomTypeDetails.getNumRooms());
            roomType.setNumPeople(roomTypeDetails.getNumPeople());
            roomType.setRoomCharge(roomTypeDetails.getRoomCharge());

            return roomTypeRepository.save(roomType);
        }
        return null;
    }

    // DELETE
    public void deleteRoomType(Integer id) {
        roomTypeRepository.deleteById(id);
    }
}
