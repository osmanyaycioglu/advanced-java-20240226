package training.advanced.java.advanced.java.db;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import training.advanced.java.advanced.java.annotations.Customer;
import training.advanced.java.advanced.java.enums.EGender;

@Component
@RequiredArgsConstructor
public class DbOpHelp implements CommandLineRunner {
    private final JpaBean jpaBean;
    private final SpringDataBean springDataBean;
    private final JdbcBean jdbcBean;

    @Override
    public void run(final String... args) throws Exception {

        // jdbcBean.insertCustomer();
        // jpaBean.insert();
        // springDataBean.insert();
        // springDataBean.update2();
        // jpaBean.update2();
        jdbcBean.updateCustomer();
    }
}
