package training.advanced.java.advanced.java.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import training.advanced.java.advanced.java.annotations.Customer;

import java.util.List;

public interface ICustomerDao extends JpaRepository<Customer, Long> {

    @Modifying
    @Query("update Customer c set c.height=?1 where c.custId=?2")
    void updateCustHeight(Integer height,
                          Long custId);

    List<Customer> findByAgeAndHeight(int age,int height);
}
