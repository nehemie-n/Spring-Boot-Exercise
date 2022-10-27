package com.jetbrains.marco.photozclone.web;

import com.jetbrains.marco.photozclone.model.Photo;
import com.jetbrains.marco.photozclone.services.PhotozService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadController {

    @Autowired
    PhotozService photozService;

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id) {
        Photo photo = photozService.getOne(id);
        HttpHeaders headers = new HttpHeaders() {{
            setContentType(MediaType.valueOf(photo.getContentType()));
            setContentDisposition(ContentDisposition.builder("attachment").filename(photo.getFileName()).build());
        }};
        return new ResponseEntity<>(photo.getData(), headers, HttpStatus.OK);
    }
}
