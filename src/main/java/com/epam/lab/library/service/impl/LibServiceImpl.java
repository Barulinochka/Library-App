package com.epam.lab.library.service.impl;

import com.epam.lab.library.dao.LibDao;
import com.epam.lab.library.domain.Book;
import com.epam.lab.library.domain.Order;
import com.epam.lab.library.domain.Status;
import com.epam.lab.library.service.LibService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibServiceImpl implements LibService {
    private static final Logger LOG = LoggerFactory.getLogger(LibServiceImpl.class);
    private LibDao libDao;

    @Autowired
    LibServiceImpl(LibDao libDao) {
        this.libDao = libDao;
    }

    @Override
    public List<Book> getAllBooks(){
        return libDao.getAllBooks();
    }

    public Book addBook(Book book) {
        try {
            book = libDao.addBook(book);
        }
        catch(DataAccessException e) {
            LOG.error("Book not add to database -- " + e);
            book.setId(null);
        }
        return book;
    }
  
    @Override
    public List<Order> getAllOrderByStatus(Status status) {
        return libDao.getAllOrderByStatus(status);
    }

    @Override
    public void setBookStatus(Status status, Long id) {
        libDao.setBookStatus(status, id);
    }
}
