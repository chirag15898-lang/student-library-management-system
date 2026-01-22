package com.demo.example.student_library_management_system.converter;

import com.demo.example.student_library_management_system.model.Author;
import com.demo.example.student_library_management_system.requestdto.AuthorRequestDto;

public class AuthorConverter {

    public static Author convertAuthorRequestDtoIntoAuthor(AuthorRequestDto authorRequestDto)
    {
        Author author = new Author();
        author.setCountry(authorRequestDto.getCountry());
        author.setName(authorRequestDto.getName());
        author.setEmail(authorRequestDto.getEmail());
        author.setGender(author.getGender());
        author.setRating(author.getRating());

        return author;
    }
}
