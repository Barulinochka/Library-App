package com.epam.lab.library.dao.impl;

import com.epam.lab.library.dao.BookDao;
import com.epam.lab.library.dao.UserDao;
import com.epam.lab.library.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);

    private static final String GET_USERS_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String GET_ALL_USERS = "SELECT * FROM users ORDER BY id";
    private static final String CREATE_NEW_USER = "INSERT INTO users (id, login, name, access_level, pass) " +
            "VALUES (nextval('users_seq'),?,'','READER',?)";
    private static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id = ?";
    private static final String UPDATE_USER_ACCESS_LEVEL = "UPDATE users SET access_level = ? WHERE id = ?";
    private static final String GET_ALL_ORDER_BY_STATUS = "SELECT * FROM orders WHERE status = ?";
    private static final String GET_ALL_USER_ORDERS = "SELECT * FROM orders WHERE id = ?";
    private static final String GET_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
    private static final String USER_COUNT = "SELECT count(*) FROM users WHERE login=?";

    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public User getUser(Long id) {
        return jdbcOperations.queryForObject(GET_USERS_BY_ID, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = jdbcOperations.query(GET_ALL_USERS, new BeanPropertyRowMapper<>(User.class));
        return !users.isEmpty() ? users : null;
    }

    @Override
    public int createUser(User user) {
        return jdbcOperations.update(CREATE_NEW_USER,
                user.getLogin(),
                user.getPass());
    }

    @Override
    public void deleteUserById(Long id) {
        jdbcOperations.update(DELETE_USER_BY_ID, id);
    }

    @Override
    public void updateUserAccessLevel(Long id, AccessLevel accessLevel) {
        jdbcOperations.update(UPDATE_USER_ACCESS_LEVEL, accessLevel.toString(), id);
    }

    @Override
    public List<Order> getAllOrderByStatus(Status status) {
        return jdbcOperations.query(GET_ALL_ORDER_BY_STATUS, new BeanPropertyRowMapper<>(Order.class), status.toString());
    }

    @Override
    public List<Order> getAllUserOrders(Long id) {
        return jdbcOperations.query(GET_ALL_USER_ORDERS, new BeanPropertyRowMapper<>(Order.class), id);
    }

    @Override
    public User getUserByLogin(String login) {
        User user = (User)jdbcOperations.queryForObject(
                GET_USER_BY_LOGIN, new Object[] { login },
                new BeanPropertyRowMapper(User.class));
        return user;
    }

    @Override
    public boolean isUserLoginAlreadyExists(String login) {
        int rowCount = jdbcOperations.queryForObject(USER_COUNT, new Object[]{login}, Integer.class);
        if (rowCount!=0){ return true; }
        else { return false; }
    }
}
