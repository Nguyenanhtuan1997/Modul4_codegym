package com.webthuenha.controller;
import com.webthuenha.model.Image;
import com.webthuenha.service.iService.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/image")
public class ImageController {
    @Autowired
    IImageService imageService;

    @GetMapping
    public ResponseEntity<List<Image>> getAllImages() {
        List<Image> imagesList = imageService.getAll();
        if (imagesList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(imagesList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Image> addImage(@RequestBody Image image) {
        return new ResponseEntity<>(imageService.save(image), HttpStatus.CREATED);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<Image> getImageByID(@PathVariable int id) {
        Image currentImage = imageService.findById(id);
        if (currentImage == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(currentImage, HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Image> editImage(@RequestBody Image image, @PathVariable int id) {
        Image currentImage = imageService.findById(id);
        if (currentImage == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentImage.setName(image.getName());
        currentImage.setRoom(image.getRoom());
        return new ResponseEntity<>(imageService.edit(currentImage), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Image> deleteImage(@PathVariable int id) {
        if (imageService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        imageService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findImagesByRoomID/{id}")
    public ResponseEntity<List<String>> findImagesByRoomID(@PathVariable int id) {
        List<String> listImages = imageService.findImageByRoomID(id);
        if (listImages == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listImages, HttpStatus.OK);
    }

    @GetMapping("/findAllByRoom/{id}")
    public ResponseEntity<List<Image>> getAllImagesByIdRoom(@PathVariable int id) {
        List<Image> imagesList = imageService.findAllByIdRoom(id);
        if (imagesList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(imagesList, HttpStatus.OK);
    }
}
