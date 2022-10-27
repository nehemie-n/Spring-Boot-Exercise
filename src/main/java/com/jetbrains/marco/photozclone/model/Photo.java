package com.jetbrains.marco.photozclone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class Photo {

    private String id;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    private String contentType;

    @JsonIgnore
    private byte[] data;

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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
