package FileServer.Service;

import FileServer.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhy on 1/16/17.
 */
@Repository
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public User findUserByName(String name) {
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(
                    "select * from User where name = ?",
                    new RowMapper<User>() {
                        public User mapRow(ResultSet resultSet, int i) throws SQLException {
                            User user = new User();
                            user.setName(resultSet.getString("name"));
                            user.setPassword(resultSet.getString("password"));
                            return user;
                        }
                    },
                    name
            );
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            return user;
        }
    }
    public void save(User user) {
        jdbcTemplate.update(
                "insert into User(name, password) values(?,?)",
                new Object[]{user.getName(), user.getPassword()}
                );
    }

    public List<User> findAll() {
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        return (List<User>)jdbcTemplate.query(
                "SELECT * from User",
                rowMapper
        );
    }
}
