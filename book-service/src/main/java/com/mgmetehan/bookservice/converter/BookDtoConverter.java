package com.mgmetehan.bookservice.converter;

import com.mgmetehan.bookservice.dto.BookDto;
import com.mgmetehan.bookservice.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookDtoConverter {
    public BookDto convert(Book from) {
        return new BookDto(
                from.getId() != null ? BookIdDtoConverter.convert(from.getId(), from.getIsbn()) : null,
                from.getTitle(),
                from.getBookYear(),
                from.getAuthor(),
                from.getPressName()
        );
    }
}
