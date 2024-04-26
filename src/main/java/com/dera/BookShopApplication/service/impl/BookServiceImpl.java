package com.dera.BookShopApplication.service.impl;

import com.dera.BookShopApplication.dto.BookDto;
import com.dera.BookShopApplication.enums.BookStatus;
import com.dera.BookShopApplication.exceptions.BookNotFoundException;
import com.dera.BookShopApplication.exceptions.UserNotFoundException;
import com.dera.BookShopApplication.model.Book;
import com.dera.BookShopApplication.model.User;
import com.dera.BookShopApplication.repository.BookRepository;
import com.dera.BookShopApplication.repository.UserRepository;
import com.dera.BookShopApplication.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Override
    public BookDto createBook(Long id, BookDto bookDto) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("User does not exist!"));
        Book book = Book.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .pages(bookDto.getPages())
                .bookStatus(bookDto.getBookStatus())
                .user(user)
                .build();
        bookRepository.save(book);

        return bookDto;
    }
    public BookDto getBookById(Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(()-> new BookNotFoundException("Book Not Found"));

        BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(book, bookDto);
        return bookDto;
    }
}
