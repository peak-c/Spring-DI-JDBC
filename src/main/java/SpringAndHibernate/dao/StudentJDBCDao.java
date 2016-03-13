package SpringAndHibernate.dao;

import SpringAndHibernate.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peakone on 2015/9/17.
 */
public class StudentJDBCDao implements StudentDao {

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;

        Class.forName("org.h2.Driver");
        String url = "jdbc:h2:./students";
        connection = DriverManager.getConnection(url, "sa", "");
        return connection;
    }

    @Override
    public List<Student> findAll() {
        System.out.println("StudentJDBCDao_findAll");

        List<Student> students = new ArrayList<Student>();
        String sql = "select * from student";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);) {
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                students.add(student);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void save(Student student) {
        System.out.println("StudentJDBCDao_save");
        String sql = "insert into student(name) values('" + student.getName() + "')";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();) {
            statement.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student student) {
        System.out.println("StudentJDBCDao_update");
    }

    @Override
    public void delete(Student student) {
        System.out.println("StudentJDBCDao_delete");
    }
}
