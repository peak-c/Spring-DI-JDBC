package SpringAndHibernate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import SpringAndHibernate.config.StudentConfig;
import SpringAndHibernate.service.StudentService;

/**
 * Created by peakone on 2015/9/17.
 */
public class StudentDITest {

    private AnnotationConfigApplicationContext context;

    @Before
    public void setUp(){
        context = new AnnotationConfigApplicationContext();
        context.register(StudentConfig.class);
        context.refresh();
    }

    @Test
    //xml配置bean,dao层使用jdbc
    public void testService_di_dao_xml_jdbc_save_findAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = context.getBean("studentService", StudentService.class);
        Student student = new Student();
        student.setName("stu_jdbc");
        studentService.save(student);
        System.out.println("jdbc:" + studentService.findAll().toString());
    }

    @Test
    //java文件形式配置bean,dao层使用JdbcTemplate
    public void testService_di_dao_java_template_save_findAll(){

        StudentService studentService = context.getBean("studentServiceTemplate", StudentService.class);

        Student student = new Student();
        student.setName("stu_template");
        studentService.save(student);
        System.out.println("template:" + studentService.findAll().toString());
    }

    @Test
    //java文件形式配置bean,dao层使用hibernate
    public void testService_di_dao_java_hibernate_save_findAll(){

        StudentService studentService = context.getBean("studentServiceHibernate", StudentService.class);

        Student student = new Student();
        student.setName("stu_hibernate");
        studentService.save(student);

        System.out.println("hibernate:" + studentService.findAll().toString());

    }
    @Test
    public void testService_di_dao_java_hibernate_save_update(){

        StudentService studentService = context.getBean("studentServiceHibernate", StudentService.class);

        Student student = new Student();
        student.setId(37L);
        student.setName("stu_hibernate_update---");
        studentService.update(student);
    }

    @Test
    public void testService_di_dao_java_hibernate_save_delete(){

        StudentService studentService = context.getBean("studentServiceHibernate", StudentService.class);

        Student student = new Student();
        student.setId(36L);
        studentService.delete(student);

    }
}
