package com.codeclan.example.filesManager.models;



import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "name")

    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "Folder")
    private List<Folder> folders;


    public Person(String name) {
        this.name = name;
        this.folders = new ArrayList<>();
    }
    public Person(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }
    public void addFolder(Folder folder){
        this.folders.add(folder);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
