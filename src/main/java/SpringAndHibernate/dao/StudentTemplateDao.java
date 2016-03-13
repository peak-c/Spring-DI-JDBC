package SpringAndHibernate.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import SpringAndHibernate.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by peakone on 2015/9/17.
 */
public class StudentTemplateDao implements StudentDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> findAll() {
        System.out.println("StudentTemplateDao_findAll");
        String sql = "select * from student";
        return jdbcTemplate.query(sql,new StudentRowMapper());
    }

    @Override
    public void save(Student student) {
        System.out.println("StudentTemplateDao_save");
        String sql = "insert into student(name) values('" + student.getName() + "')";
        jdbcTemplate.execute(sql);
    }

    @Override
    public void update(Student student) {
        System.out.println("StudentTemplateDao_update");
    }

    @Override
    public void delete(Student student) {
        System.out.println("StudentTemplateDao_delete");
    }

    private static class StudentRowMapper implements RowMapper<Student> {


        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String name = rs.getString("name");

            Student student = new Student();
            student.setId(id);
            student.setName(name);

            return student;
        }
    }
}
