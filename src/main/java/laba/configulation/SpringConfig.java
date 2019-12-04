package laba.configulation;

import laba.dao.*;
import laba.security.AuthProviderImp;
import laba.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }
   @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        dataSource.setUrl("jdbc:mysql://localhost:3306/hospital?useSSL=false");
        return dataSource;
    }

    @Bean
    public UserDao getUserDao() {
        return new UserDaoImp(getJdbcTemplate());
    }

    @Bean
    public UserService getUserService() {
        return new UserServiceImp();
    }

    @Bean
    public PatientDao getPatientDao() {
        return new PatientDaoImp(getJdbcTemplate());
    }

    @Bean
    public PatientService getPatientService() {
        return new PatientServiceImp();
    }

    @Bean
    public DoctorsDao getDoctorsDao() { return new DoctorsDaoImp(getJdbcTemplate()); }

    @Bean
    public DoctorsService getDoctorsService() {
        return new DoctorsServiceImp();
    }

    @Bean
    public ProfessionDao getProfessionDao() {
        return new ProfessionDaoImp(getJdbcTemplate());
    }

    @Bean
    public ProfessionService getProfessionService() {
        return new ProfessionServiceImp();
    }

    @Bean
    public ServiceDao getServiceDao() {
        return new ServiceDaoImp(getJdbcTemplate());
    }

    @Bean
    public ServService getServService() {
        return new ServServiceImp();
    }

    @Bean
    public ServiceTypeDao getServiceTypeDao() {
        return new ServiceTypeDaoImp(getJdbcTemplate());
    }

    @Bean
    public ServTypeService getServTypeService() {
        return new ServTypeServiceImp();
    }

    @Bean
    public CompleteServicesDao getCompleteServicesDao() {
        return new CompleteServicesDaoImp(getJdbcTemplate());
    }

    @Bean CompleteServService getCompleteServService() {
        return new CompleteServServiceImp();
    }

    @Bean
    public AuthProviderImp getAuthProviderImp() {
        return new AuthProviderImp();
    }
}
