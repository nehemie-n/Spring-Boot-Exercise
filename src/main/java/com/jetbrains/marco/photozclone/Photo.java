package com.jetbrains.marco.photozclone;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class Photo {

    private String id;

    @NotEmpty
    @NotBlank
    private String fileName;
    // Constructor

    public Photo(){

    }

    public Photo(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    // Raw data
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
