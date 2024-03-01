package training.advanced.java.advanced.java.db;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import training.advanced.java.advanced.java.annotations.Customer;
import training.advanced.java.advanced.java.enums.EGender;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JdbcBean {
    private final        DataSource dataSource;
    private static final Logger     logger = LoggerFactory.getLogger(JdbcBean.class);

    private static String insertPrep = """
                                       insert
                                           into
                                               customer
                                               (age, gender, height, name, surname, weight, cust_id)
                                           values
                                               (?, ?, ?, ?, ?, ?, ?)
                                       """;
    private static String updatePrep = """
                                           update
                                               customer
                                           set
                                               age=?,
                                               gender=?,
                                               height=?,
                                               name=?,
                                               surname=?,
                                               weight=?
                                           where
                                               cust_id=?
                                       """;

    private static String selectPrep = "select * from customer where cust_id=?";

    private static String selectAgeAndHeightPrep = "select * from customer where age=? and height=?";

    public void insertCustomer() {
        try (Connection connectionLoc = dataSource.getConnection();
             PreparedStatement preparedStatementLoc = connectionLoc.prepareStatement(insertPrep);
        ) {
            preparedStatementLoc.setInt(1,
                                        35);
            preparedStatementLoc.setInt(2,
                                        0);
            preparedStatementLoc.setInt(3,
                                        180);
            preparedStatementLoc.setString(4,
                                           "ali");
            preparedStatementLoc.setString(5,
                                           "yaycıoğlu");
            preparedStatementLoc.setInt(6,
                                        95);
            preparedStatementLoc.setInt(7,
                                        10_000);
            preparedStatementLoc.executeUpdate();
        } catch (Exception eParam) {
            logger.error("[JdbcBean][method]-> *Error* : " + eParam.getMessage(),
                         eParam);
        }
    }

    public void updateCustomer() {
        try (Connection connectionLoc = dataSource.getConnection();
             PreparedStatement preparedStatementLoc = connectionLoc.prepareStatement(updatePrep);
        ) {
            preparedStatementLoc.setInt(1,
                                        36);
            preparedStatementLoc.setInt(2,
                                        0);
            preparedStatementLoc.setInt(3,
                                        179);
            preparedStatementLoc.setString(4,
                                           "ali");
            preparedStatementLoc.setString(5,
                                           "yaycıoğlu");
            preparedStatementLoc.setInt(6,
                                        100);
            preparedStatementLoc.setInt(7,
                                        10_000);
            preparedStatementLoc.executeUpdate();
        } catch (Exception eParam) {
            logger.error("[JdbcBean][method]-> *Error* : " + eParam.getMessage(),
                         eParam);
        }
    }

    public Customer selectCustomer(Long customerId) {
        try (Connection connectionLoc = dataSource.getConnection();
             PreparedStatement preparedStatementLoc = connectionLoc.prepareStatement(selectPrep);
        ) {
            preparedStatementLoc.setLong(1,
                                         customerId);
            try (ResultSet rs = preparedStatementLoc.executeQuery()) {
                if (rs.next()) {
                    return Customer.builder()
                                   .withNameParam(rs.getString("name"))
                                   .withSurnameParam(rs.getString("surname"))
                                   .withAgeParam(rs.getInt("age"))
                                   .withWeightParam(rs.getInt("weight"))
                                   .withHeightParam(rs.getInt("height"))
                                   .withGenderParam(EGender.values()[rs.getInt("gender")])
                                   .build();
                } else {
                    return null;
                }
            }
        } catch (Exception eParam) {
            logger.error("[JdbcBean][method]-> *Error* : " + eParam.getMessage(),
                         eParam);
        }
        return null;
    }

    public List<Customer> selectCustomerAgeandHeigth(int age, int height) {
        try (Connection connectionLoc = dataSource.getConnection();
             PreparedStatement preparedStatementLoc = connectionLoc.prepareStatement(selectAgeAndHeightPrep);
        ) {
            preparedStatementLoc.setLong(1,
                                         age);
            preparedStatementLoc.setLong(2,
                                         height);
            try (ResultSet rs = preparedStatementLoc.executeQuery()) {
                List<Customer> customersLoc = new ArrayList<>();
                while (rs.next()) {
                    Customer customerLoc = Customer.builder()
                                                   .withNameParam(rs.getString("name"))
                                                   .withSurnameParam(rs.getString("surname"))
                                                   .withAgeParam(rs.getInt("age"))
                                                   .withWeightParam(rs.getInt("weight"))
                                                   .withHeightParam(rs.getInt("height"))
                                                   .withGenderParam(EGender.values()[rs.getInt("gender")])
                                                   .build();
                    customerLoc.setCustId(rs.getLong("cust_id"));
                    customersLoc.add(customerLoc);

                }
                return customersLoc;
            }
        } catch (Exception eParam) {
            logger.error("[JdbcBean][method]-> *Error* : " + eParam.getMessage(),
                         eParam);
        }
        return null;
    }

}
