package com.codeclan.example.filesManager.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "file")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "extension")
    private String extension;

    @Column(name = "size")
    private int size;

    @JsonBackReference
    @OneToMany
    private List<File> files;

    @ManyToOne
    @JoinColumn(name = "folder_id", nullable = true)
    @JsonManagedReference
    private Folder folder;


    public File(String name, String extension, int size) {
        this.name = name;
        this.extension = extension;
        this.size = size;

    }
    public File(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
//    public void addFolder(Folder folder){
//        this.folder.add(folder);
//    }
}
