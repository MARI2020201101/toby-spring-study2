package com.mariworld.spring.serviceabstraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoJdbc implements UserDao{

    private JdbcTemplate jdbcTemplate;
    private RowMapper<User> rowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getString(1));
            user.setName(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setLevel(Level.valueOf(rs.getInt(4)));
            user.setLogin(rs.getInt(5));
            user.setRecommend(rs.getInt(6));
            return user;
        }
    };
    public UserDaoJdbc(DataSource dataSource){
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("select * from users" , rowMapper);
    }

    @Override
    public User get(String id) {
        return jdbcTemplate.queryForObject("select * from users where id = ?",rowMapper,id);
    }

    @Override
    public void add(User user) {
        jdbcTemplate.update("insert into users(id, name, password, level, login, recommend ) values (?,?,?,?,?,?)"
                ,user.getId(),user.getName(),user.getPassword(),user.getLevel().getValue(),user.getLogin(),user.getRecommend());
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update("update users set name =? , password =? , level=?, login=?, recommend=? where id=?"
                ,user.getName(),user.getPassword(),user.getLevel().getValue(),user.getLogin(),user.getRecommend(),user.getId());

    }

    @Override
    public void deleteAll() {
        jdbcTemplate.execute("delete from users");
    }

}
