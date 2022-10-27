package com.jetbrains.marco.photozclone.web;
import com.jetbrains.marco.photozclone.model.Photo;
import com.jetbrains.marco.photozclone.services.PhotozService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class PhotozController {

    private final PhotozService photozService;

    public PhotozController(PhotozService photozService){
        this.photozService = photozService;
    }
    @GetMapping("/")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/photoz")
    public Photo createOne(@RequestPart("file") MultipartFile file) throws IOException {
        return photozService.create(file);
    }

    @GetMapping("/photoz")
    public List<Photo> geAll(){
        return  photozService.getAll();
    }

    @GetMapping("/photoz/{id}")
    public Photo getOne(@PathVariable String id){
        return photozService.getOne(id);
    }

    @DeleteMapping("/photoz/{id}")
    public String deleteOne(@PathVariable String id){
        return photozService.remove(id);
    }
}
