package com.jetbrains.marco.photozclone;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PhotozController {

    private List<Photo> db = List.of(new Photo("1", "hello.jpg"));

    @GetMapping("/")
    public Map hello() {
        Map value = new HashMap();
        value.put("dd","dd");
        return value;
    }

    @GetMapping("/photoz")
    public List<Photo> get(){
        return  db;
    }
}
