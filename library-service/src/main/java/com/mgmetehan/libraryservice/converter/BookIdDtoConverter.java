package com.mgmetehan.libraryservice.converter;

import com.mgmetehan.libraryservice.dto.BookIdDto;
import org.springframework.stereotype.Component;

@Component
public class BookIdDtoConverter {
    public static BookIdDto convert(String id, String isbn) {
        return new BookIdDto(id, isbn);
    }
}
