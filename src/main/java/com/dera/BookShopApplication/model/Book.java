package com.dera.BookShopApplication.model;

import com.dera.BookShopApplication.enums.BookStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "book_tbl")

public class Book extends BaseClass{
    private String title;

    private  String author;

    private int pages;

    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
