package com.dera.BookShopApplication.controller;

import com.dera.BookShopApplication.dto.BookDto;
import com.dera.BookShopApplication.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/create-book/{id}")
    public ResponseEntity<BookDto> createBook(@PathVariable Long id,
                                              @RequestBody BookDto bookDto){
        bookDto = bookService.createBook(id, bookDto);
        return new ResponseEntity<>(bookDto, HttpStatus.CREATED);
    }

    @GetMapping("/get-book/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id){
        BookDto bookDto = bookService.getBookById(id);
        bookDto = bookService.getBookById(id);

        return ResponseEntity.ok(bookDto);
    }
}
