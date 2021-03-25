package com.lyl.springboot.ossd.service.ServiceImplement;

import com.lyl.springboot.ossd.domain.Book;
import com.lyl.springboot.ossd.repository.BookRepository;
import com.lyl.springboot.ossd.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteById(String bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Book findByBookId(String bookId) {
        return bookRepository.findByBookId(bookId);
    }

    @Override
    public Book findByBookName(String bookName) {
        return bookRepository.findByBookName(bookName);
    }

    @Override
    public Page<Book> findByBookAuthor(String bookAuthor, Pageable pageable) {
        return bookRepository.findByBookAuthor(bookAuthor, pageable);
    }

    @Override
    public int modifyBookNameByBookId(String BookName, String BookId) {
        return bookRepository.modifyBookNameByBookId(BookName, BookId);
    }

    @Override
    public int modifyBookDesByBookId(String BookDes, String BookId) {
        return bookRepository.modifyBookDesByBookId(BookDes, BookId);
    }

    @Override
    public int modifyBookAddByBookId(String BookAdd, String BookId) {
        return bookRepository.modifyBookAddByBookId(BookAdd, BookId);
    }
}
