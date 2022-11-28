package com.example.springrest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class CSVFile {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @Lob
    private byte[] data;

    public CSVFile(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }

    public CSVFile() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
