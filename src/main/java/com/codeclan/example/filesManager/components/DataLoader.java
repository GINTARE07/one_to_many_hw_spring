package com.codeclan.example.filesManager.components;

import com.codeclan.example.filesManager.models.File;
import com.codeclan.example.filesManager.models.Folder;
import com.codeclan.example.filesManager.models.Person;
import com.codeclan.example.filesManager.repositories.FileRepository;
import com.codeclan.example.filesManager.repositories.FolderRepository;
import com.codeclan.example.filesManager.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FolderRepository folderRepository;
    @Autowired
    FileRepository fileRepository;
    @Autowired
    PersonRepository personRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args) {
        Person lily = new Person("Lily");
        personRepository.save(lily);
        Person lucy = new Person("Lucy");
        personRepository.save(lucy);
        Person lucky = new Person("Lucky");
        personRepository.save(lucky);
        File planning = new File("Planning", ".doc", 45);
        fileRepository.save(planning);
        File budgeting = new File("budgeting", ".docx", 95);
        fileRepository.save(budgeting);
        File marketing = new File("Marketing", ".php", 60);
        fileRepository.save(marketing);
        Folder sales = new Folder ("sales");
        folderRepository.save(sales);
        Folder upgrades = new Folder ("Upgrades");
        folderRepository.save(upgrades);
        Folder management = new Folder ("management");
        folderRepository.save(management);

        lucy.addFolder(upgrades);
        lucy.addFolder(management);
        personRepository.save(lucy);

        lucky.addFolder(upgrades);
        lucky.addFolder(sales);
        personRepository.save(lucky);

        lily.addFolder(sales);
        lucy.addFolder(management);
        personRepository.save(lily);

        management.addFile(planning);
        management.addFile(marketing);
        folderRepository.save(management);

        sales.addFile(budgeting);
        sales.addFile(marketing);
        folderRepository.save(sales);

        upgrades.addFile(budgeting);
        upgrades.addFile(planning);
        folderRepository.save(upgrades);

    }
}

