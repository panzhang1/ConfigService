package com.sf.bizx.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sf.bizx.BIZXConstants;
import com.sf.bizx.user.bean.User;

@Repository
public class UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public User getUser(String userId) {
        String querySql = String.format("SELECT USERS_SYS_ID,USERS_SYS_USERNAME,USERS_SYS_FIRSTNAME,USERS_SYS_LASTNAME FROM %s.USERS_SYSINFO WHERE USERS_SYS_ID = ?", BIZXConstants.DB_SCHEMA);
        List<User> users = jdbcTemplate.query( querySql, new Object[] { userId },new UserMapper());
        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }
    
    class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User(rs.getString("USERS_SYS_ID"), rs.getString("USERS_SYS_USERNAME"));
            user.setFirstName(rs.getString("USERS_SYS_FIRSTNAME"));
            user.setLastName(rs.getString("USERS_SYS_LASTNAME"));
            return user;
        }
        
    }
}
