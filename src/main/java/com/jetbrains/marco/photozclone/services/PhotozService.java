package com.jetbrains.marco.photozclone.services;

import com.jetbrains.marco.photozclone.model.Photo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class PhotozService {

    private Map<String, Photo> db = new HashMap<>() {{
        put("1", new Photo("1", "hello.jpg"));
    }};


    public  Photo create(MultipartFile file) throws IOException {
        Photo photo = new Photo();
        System.out.println("file.getContentType()" + file.getContentType());
        System.out.println("file.getOriginalFilename()" + file.getOriginalFilename());
        System.out.println("file.getName()" + file.getName());
        System.out.println("file.getSize()" + file.getSize());
        photo.setContentType(file.getContentType());
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(file.getOriginalFilename());
        photo.setData(file.getBytes());
        db.put(photo.getId(), photo);
        return photo;
    }

    public List<Photo> getAll() {
        return db.values().stream().toList();
    }

    public Photo getOne(String id) {
        Photo photo = db.get(id);
        if(photo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo;
    }

    public String remove(String id) {
        Photo photo = db.remove(id);
        if(photo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo.getId() + " deleted Successfully.";
    }
}

