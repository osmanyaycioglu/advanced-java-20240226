package training.advanced.java.advanced.java.db;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import training.advanced.java.advanced.java.annotations.Customer;
import training.advanced.java.advanced.java.enums.EGender;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SpringDataBean {
    private final ICustomerDao customerDao;

    public void insert() {
        customerDao.save(Customer.builder()
                                 .withNameParam("pakize")
                                 .withSurnameParam("yaycıoğlu")
                                 .withGenderParam(EGender.FEMALE)
                                 .withAgeParam(30)
                                 .withHeightParam(180)
                                 .withWeightParam(95)
                                 .build());
    }

    public void update1(){
        Customer customerLoc = Customer.builder()
                                       .withNameParam("pakize")
                                       .withSurnameParam("yaycıoğlu")
                                       .withGenderParam(EGender.FEMALE)
                                       .withAgeParam(30)
                                       .withHeightParam(90)
                                       .withWeightParam(95)
                                       .build();
        customerLoc.setCustId(152L);
        customerDao.save(customerLoc);
    }

    @Transactional
    public void update2(){
        customerDao.updateCustHeight(190, 152L);
    }

    @Transactional
    public void delete(){
        customerDao.deleteById(152L);
    }

    public Customer getCustomer(Long customerId){
        return customerDao.findById(customerId).orElse(null);
    }

    public List<Customer> getCustomerAgeAndHeight(int age,int height){
        return customerDao.findByAgeAndHeight(age, height);
    }

}
