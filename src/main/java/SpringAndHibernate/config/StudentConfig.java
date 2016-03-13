package SpringAndHibernate.config;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import SpringAndHibernate.dao.StudentDao;
import SpringAndHibernate.dao.StudentHbmDao;
import SpringAndHibernate.dao.StudentJDBCDao;
import SpringAndHibernate.dao.StudentTemplateDao;
import SpringAndHibernate.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by peakone on 2015/9/17.
 */
@Configuration
public class StudentConfig {

    /**Java文件形式配置bean,dao层使用hibernate
     * 数据源配置在hibernate.cfg.xml中**/
    @Bean//hibernate
    public StudentService studentServiceHibernate(){
        StudentService studentService = new StudentService();
        studentService.setStudentDao(studentHbmDao());
        return studentService;
    }
    @Bean
    public StudentDao studentHbmDao(){
        return new StudentHbmDao();
    }


    /**Java文件形式配置bean,dao层使用 spring的jdbcTemplate，数据源配置在下边**/
    @Bean//Template
    public StudentService studentServiceTemplate(){
        StudentService studentService = new StudentService();
        studentService.setStudentDao(studentTemplateDao());
        return studentService;
    }

    @Bean
    public StudentDao studentTemplateDao(){
        StudentTemplateDao studentTemplateDao = new StudentTemplateDao();
        studentTemplateDao.setJdbcTemplate(jdbcTemplate());
        return studentTemplateDao;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource());
        return template;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        String url ="jdbc:h2:./students";
        dataSource.setUrl(url);
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }


}
