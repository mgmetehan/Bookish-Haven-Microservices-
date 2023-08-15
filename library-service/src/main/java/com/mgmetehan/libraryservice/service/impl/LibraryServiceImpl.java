package com.mgmetehan.libraryservice.service.impl;

import com.mgmetehan.libraryservice.dto.LibraryDto;
import com.mgmetehan.libraryservice.model.Library;
import com.mgmetehan.libraryservice.repository.LibraryRepository;
import com.mgmetehan.libraryservice.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {
    private final LibraryRepository repository;

    @Override
    public List<String> getAllLibraries() {
        return repository.findAll()
                .stream()
                .map(n -> n.getId())
                .collect(Collectors.toList());
    }

    @Override
    public LibraryDto createLibrary() {
        Library newLibrary = repository.save(new Library());
        return LibraryDto.builder()
                .id(newLibrary.getId())
                .build();
    }

    @Override
    public LibraryDto getAllBooksInLibraryById() {
        return null;
    }


}
