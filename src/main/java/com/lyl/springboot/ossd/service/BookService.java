package com.lyl.springboot.ossd.service;

import com.lyl.springboot.ossd.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    void save(Book book);

    void deleteById(String bookId);

    Book findByBookId(String bookId);

    Book findByBookName(String bookName);

    Page<Book> findByBookAuthor(String bookAuthor, Pageable pageable);

    int modifyBookNameByBookId(String BookName,String BookId);

    int modifyBookDesByBookId(String BookDes,String BookId);

    int modifyBookAddByBookId(String BookAdd,String BookId);
}
