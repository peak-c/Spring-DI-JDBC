package SpringAndHibernate.dao;

import SpringAndHibernate.Student;

import java.util.List;

/**
 * Created by peakone on 2015/9/17.
 */
public interface StudentDao {
    public List<Student> findAll();
    public void save(Student student);

    public void update(Student student);

    public void delete(Student student);
}
