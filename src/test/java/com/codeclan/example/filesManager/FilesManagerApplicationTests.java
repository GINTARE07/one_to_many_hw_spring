package com.codeclan.example.filesManager;

import com.codeclan.example.filesManager.models.File;
import com.codeclan.example.filesManager.models.Folder;
import com.codeclan.example.filesManager.models.Person;
import com.codeclan.example.filesManager.repositories.FileRepository;
import com.codeclan.example.filesManager.repositories.FolderRepository;
import com.codeclan.example.filesManager.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.codeclan.example.filesManager.repositories.FolderRepository.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class FilesManagerApplicationTests {
	@Autowired
	PersonRepository personRepository;

	@Autowired
	FileRepository fileRepository;

	@Autowired
	FolderRepository folderRepository;

	@Test
	void contextLoads() {
	}
	@Test
	public void createPersonAndFolder(){
		Person person = new Person("Ellis");
		personRepository.save(person);

		Folder folder1 = new Folder();
		folderRepository.save(folder1);
	}

	@Test
	public void addFoldersAndFiles(){
		Folder quarter1 = new Folder("Quarter1");
		folderRepository.save(quarter1);

		File promotions = new File("finances", "doc", 34);
		fileRepository.save(promotions);

		Person person1 = new Person("Jay");
		personRepository.save(person1);

		quarter1.addFile(promotions);
		folderRepository.save(quarter1);

	}

}
