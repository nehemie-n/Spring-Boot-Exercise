package com.jetbrains.marco.photozclone;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class PhotozController {

    private Map<String, Photo> db = new HashMap<>() {{
        put("1", new Photo("1", "hello.jpg"));

    }};


    @GetMapping("/")
    public Map hello() {
        Map value = new HashMap();
        value.put("dd","dd");
        return value;
    }

    @PostMapping("/photoz")
    public Photo create(@RequestBody @Valid Photo photo){
        photo.setId(UUID.randomUUID().toString());
        db.put(photo.getId(), photo);
        return photo;
    }

    @GetMapping("/photoz")
    public List<Photo> get(){
        return  db.values().stream().toList();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id){
        Photo photo =  db.get(id);
        if(photo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public String delete(@PathVariable String id){
        Photo photo =  db.remove(id);
        if(photo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo.getId() + " deleted Successfully.";
    }
}
