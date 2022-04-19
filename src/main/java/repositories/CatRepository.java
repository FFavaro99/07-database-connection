package repositories;

import entities.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CatRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CatRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Cat> catRowMapper = (rs, i) -> {
        Cat cat = new Cat();
        cat.setId(rs.getInt("id"));
        cat.setName(rs.getString("name"));
        cat.setAge(rs.getInt("age"));
        return cat;
    };

    public void addNewCat(Cat cat) {
        String sql = "INSERT INTO cat VALUES ( DEFAULT, ?, ? )";
        jdbcTemplate.update(sql, cat.getName(), cat.getAge());
    }

    public List<Cat> getAllCats() {
        String sql = "SELECT * FROM cat";
        List<Cat> cats = jdbcTemplate.query(sql, catRowMapper);
        return cats;
    }

    public Cat getCatById(int id) {
        String sql = "SELECT * FROM cat WHERE id = ?";
        Cat cat = jdbcTemplate.queryForObject(sql, catRowMapper, id);
        return cat;
    }

}
