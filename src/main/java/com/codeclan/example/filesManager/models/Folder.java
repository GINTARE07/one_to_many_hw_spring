package com.codeclan.example.filesManager.models;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "folder")
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "title")

    private String title;
    @JsonBackReference
    @OneToMany
    private List<File> files;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = true)
    @JsonManagedReference
    private Person person;


    public Folder(String title) {
        this.title = title;
        this.files = new ArrayList<>();
    }
    public Folder(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
    public void addFile(File files){
        this.files.add(files);
    }
}
