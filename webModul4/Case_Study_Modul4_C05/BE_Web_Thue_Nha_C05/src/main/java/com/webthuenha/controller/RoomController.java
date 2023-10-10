package com.webthuenha.controller;

import com.webthuenha.model.Room;
import com.webthuenha.service.iService.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private IRoomService iRoomService;

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> roomsList = iRoomService.getAll();
        if (roomsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(roomsList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
        return new ResponseEntity<>(iRoomService.save(room), HttpStatus.CREATED);
    }

    @GetMapping("/detailRoom/{id}")
    public ResponseEntity<Room> getRoomByID(@PathVariable int id) {
        Room currentRoom = iRoomService.findById(id);
        if (currentRoom == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(currentRoom, HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Room> editRoom(@RequestBody Room room, @PathVariable int id) {
        Room currentRoom = iRoomService.findById(id);
        if (currentRoom == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentRoom.setTitle(room.getTitle());
        currentRoom.setSquare(room.getSquare());
        currentRoom.setNumberOfRooms(room.getNumberOfRooms());
        currentRoom.setNumberOfWcRooms(room.getNumberOfWcRooms());
        currentRoom.setPrice(room.getPrice());
        currentRoom.setImageMain(room.getImageMain());
        currentRoom.setStatus(room.getStatus());
        currentRoom.setDetail(room.getDetail());
        currentRoom.setAddress(room.getAddress());
        currentRoom.setCategory(room.getCategory());
        currentRoom.setArea(room.getArea());

        return new ResponseEntity<>(iRoomService.edit(currentRoom), HttpStatus.OK);
    }


    @GetMapping("/findAllByArea/{id}")
    public ResponseEntity<List<Room>> getAllRooms(@PathVariable int id) {
        List<Room> roomList = iRoomService.findAllByArea(id);
        if (roomList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(roomList);
    }

    @GetMapping("/findAllByCategory/{id}")
    public ResponseEntity<List<Room>> getAllRoomsByCategory(@PathVariable int id) {
        List<Room> roomList = iRoomService.findAllByCategory(id);
        if (roomList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(roomList);
    }
}