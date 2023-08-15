package com.mgmetehan.bookservice.converter;

import com.mgmetehan.bookservice.dto.BookIdDto;
import org.springframework.stereotype.Component;

@Component
public class BookIdDtoConverter {
    public static BookIdDto convert(String id, String isbn) {
        return new BookIdDto(id, isbn);
    }
}
