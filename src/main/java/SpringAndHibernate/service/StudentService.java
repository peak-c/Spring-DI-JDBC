package SpringAndHibernate.service;

import SpringAndHibernate.dao.StudentDao;
import SpringAndHibernate.Student;

import java.util.List;

/**
 * Created by peakone on 2015/9/17.
 */
public class StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> findAll() {
        System.out.println("StudentService_findAll");
        return studentDao.findAll();
    }

    public void save(Student student){
        System.out.println("StudentService_save");
        studentDao.save(student);
    }

    public void update(Student student){
        System.out.println("StudentService_update");
        studentDao.update(student);
    }
    public void delete(Student student){
        System.out.println("StudentService_delete");
        studentDao.delete(student);
    }

}
