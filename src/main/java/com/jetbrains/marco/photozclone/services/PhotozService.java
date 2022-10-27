package com.jetbrains.marco.photozclone.services;

import com.jetbrains.marco.photozclone.model.Photo;
import com.jetbrains.marco.photozclone.repository.PhotozRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@Service
public class PhotozService {


    private final PhotozRepository photozRepository;

    public PhotozService(PhotozRepository photozRepository){
        this.photozRepository = photozRepository;
    }

    public  Photo create(MultipartFile file) throws IOException {
        Photo photo = new Photo();
        System.out.println("file.getContentType()" + file.getContentType());
        System.out.println("file.getOriginalFilename()" + file.getOriginalFilename());
        System.out.println("file.getName()" + file.getName());
        System.out.println("file.getSize()" + file.getSize());
        photo.setContentType(file.getContentType());
        photo.setFileName(file.getOriginalFilename());
        photo.setData(file.getBytes());
        photo = photozRepository.save(photo);
        return photo;
    }

    public Iterable<Photo> getAll() {
        return photozRepository.findAll();
    }

    public Photo getOne(Integer id) {
        Photo photo = photozRepository.findById(id).orElse(null);
        if(photo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo;
    }

    public String remove(Integer id) {
        photozRepository.deleteById(id);
        return " deleted Successfully.";
    }
}

