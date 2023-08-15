package com.mgmetehan.libraryservice.repository;

import com.mgmetehan.libraryservice.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, String> {
}
