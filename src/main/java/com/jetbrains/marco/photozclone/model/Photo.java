package com.jetbrains.marco.photozclone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Table("PHOTOZ")
public class Photo {

    @Id
    private Integer id;

    private String contentType;

    @NotEmpty
    @NotBlank
    private String fileName;

    @JsonIgnore
    private byte[] data;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }




    // Constructor

    public Photo(){

    }

    public Photo(Integer id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    // Raw data
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
