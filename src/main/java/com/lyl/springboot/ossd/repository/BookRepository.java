package com.lyl.springboot.ossd.repository;

import com.lyl.springboot.ossd.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    Book findByBookId(String bookId);

    Book findByBookName(String bookName);

    Page<Book> findByBookAuthor(String bookAuthor, Pageable pageable);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Book set bookName=?1 where bookId=?2")
    int modifyBookNameByBookId(String BookName,String BookId);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Book set bookDes=?1 where bookId=?2")
    int modifyBookDesByBookId(String BookDes,String BookId);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Book set bookAdd=?1 where bookId=?2")
    int modifyBookAddByBookId(String BookAdd,String BookId);
}
