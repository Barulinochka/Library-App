package com.epam.lab.library.dao.impl;

import com.epam.lab.library.dao.LibDAO;
import com.epam.lab.library.domain.Author;
import com.epam.lab.library.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LibDaoImpl implements LibDAO {

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    NamedParameterJdbcOperations namedParameterJdbcOperations;

    private static final String GET_ALL_AVAILABLE_BOOKS = "SELECT * FROM books WHERE available!=0";
    private static final String GET_AUTHORS = "SELECT * FROM authors JOIN book_authors ON authors.id = book_authors.author_id WHERE book_authors.book_id=?";

    @Override
    public List<Book> getAllBooks() {
        List <Book> books=jdbcOperations.query(GET_ALL_AVAILABLE_BOOKS,new BeanPropertyRowMapper<Book>(Book.class));
        for(Book b:books){
            b.setAuthors(jdbcOperations.query(GET_AUTHORS,new BeanPropertyRowMapper<Author>(Author.class),b.getId()));
        }
        return books;

    }



}
