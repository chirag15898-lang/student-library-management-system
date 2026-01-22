package com.demo.example.student_library_management_system.converter;

import com.demo.example.student_library_management_system.model.Book;
import com.demo.example.student_library_management_system.requestdto.BookRequestDto;

public class BookConverter {

    public static Book convertBookRequestDtoIntoBook(BookRequestDto bookRequestDto)
    {
        Book book = new Book();

        book.setRackNo(bookRequestDto.getRackNo());
        book.setAvailability(book.isAvailability());
        book.setTitle(bookRequestDto.getTitle());
        book.setCategory(bookRequestDto.getCategory());
        book.setPages(bookRequestDto.getPages());
        book.setPublisherName(bookRequestDto.getPublisherName());
        book.setPublishedDate(bookRequestDto.getPublishedDate());

        return book;
    }
}
