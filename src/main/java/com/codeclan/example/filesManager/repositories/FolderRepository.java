package com.codeclan.example.filesManager.repositories;

import com.codeclan.example.filesManager.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}
