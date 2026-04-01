package com.example.demo.controller;

import com.example.demo.entity.Room_type;
import com.example.demo.service.Room_typeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roomtypes")
public class Room_typeController {

    @Autowired
    private Room_typeService roomTypeService;

    // Test API
    @GetMapping("/welcome")
    public String welcome() {
        return "Room Type Controller is working";
    }

    // CREATE
    @PostMapping("/create")
    public Room_type createRoomType(@RequestBody Room_type roomType) {
        return roomTypeService.saveRoomType(roomType);
    }

    // GET ALL
    @GetMapping("/all")
    public List<Room_type> getAllRoomTypes() {
        return roomTypeService.getAllRoomTypes();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Room_type getRoomTypeById(@PathVariable Integer id) {
        return roomTypeService.getRoomTypeById(id);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public Room_type updateRoomType(
            @PathVariable Integer id,
            @RequestBody Room_type roomType) {
        return roomTypeService.updateRoomType(id, roomType);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteRoomType(@PathVariable Integer id) {
        roomTypeService.deleteRoomType(id);
        return "Room type deleted successfully with id " + id;
    }
}
