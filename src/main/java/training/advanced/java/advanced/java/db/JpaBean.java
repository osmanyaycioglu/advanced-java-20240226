package training.advanced.java.advanced.java.db;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import training.advanced.java.advanced.java.annotations.Customer;
import training.advanced.java.advanced.java.enums.EGender;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JpaBean {
    private final EntityManager        entityManager;
    private final EntityManagerFactory entityManagerFactory;

    private static final Logger logger = LoggerFactory.getLogger(JpaBean.class);

    @Transactional
    public void insert() {
        EntityTransaction transactionLoc = null;
        try (EntityManager entityManagerLoc = entityManagerFactory.createEntityManager()) {
            // entityManagerLoc.joinTransaction();
            transactionLoc = entityManagerLoc.getTransaction();
            transactionLoc.begin();
            Customer customerLoc = Customer.builder()
                                        .withNameParam("mehmet")
                                        .withSurnameParam("yaycıoğlu")
                                        .withGenderParam(EGender.MALE)
                                        .withAgeParam(44)
                                        .withHeightParam(200)
                                        .withWeightParam(95)
                                        .build();
            entityManagerLoc.persist(customerLoc);
            customerLoc.setAge(40);
            transactionLoc.commit();
        } catch (Exception exp) {
            if (transactionLoc != null) {
                transactionLoc.rollback();
            }
            logger.error("[JpaBean][method]-> *Error* : " + exp.getMessage(),
                         exp);
        }
    }

    @Transactional
    public void update1() {
        EntityTransaction transactionLoc = null;
        try (EntityManager entityManagerLoc = entityManagerFactory.createEntityManager()) {
            // entityManagerLoc.joinTransaction();
            transactionLoc = entityManagerLoc.getTransaction();
            transactionLoc.begin();
            Customer customerLoc = entityManagerLoc.find(Customer.class,
                                                          102);
            customerLoc.setHeight(177);
            transactionLoc.commit();
        } catch (Exception exp) {
            if (transactionLoc != null) {
                transactionLoc.rollback();
            }
            logger.error("[JpaBean][method]-> *Error* : " + exp.getMessage(),
                         exp);
        }
    }


    @Transactional
    public void update2() {
        EntityTransaction transactionLoc = null;
        try (EntityManager entityManagerLoc = entityManagerFactory.createEntityManager()) {
            // entityManagerLoc.joinTransaction();
            transactionLoc = entityManagerLoc.getTransaction();
            transactionLoc.begin();
            Query queryLoc = entityManagerLoc.createQuery("update Customer c set c.height=?1 where c.custId=?2");
            queryLoc.setParameter(1, 197);
            queryLoc.setParameter(2, 102);
            queryLoc.executeUpdate();
            transactionLoc.commit();
        } catch (Exception exp) {
            if (transactionLoc != null) {
                transactionLoc.rollback();
            }
            logger.error("[JpaBean][method]-> *Error* : " + exp.getMessage(),
                         exp);
        }
    }

    public void delete(){
        EntityTransaction transactionLoc = null;
        try (EntityManager entityManagerLoc = entityManagerFactory.createEntityManager()) {
            // entityManagerLoc.joinTransaction();
            transactionLoc = entityManagerLoc.getTransaction();
            transactionLoc.begin();
            Customer customerLoc = entityManagerLoc.find(Customer.class,
                                                         102);

            entityManagerLoc.remove(customerLoc);
            transactionLoc.commit();
        } catch (Exception exp) {
            if (transactionLoc != null) {
                transactionLoc.rollback();
            }
            logger.error("[JpaBean][method]-> *Error* : " + exp.getMessage(),
                         exp);
        }
    }

    public Customer getCustomer(Long cid){
        try (EntityManager entityManagerLoc = entityManagerFactory.createEntityManager()) {
            return entityManagerLoc.find(Customer.class, cid);
        }
    }

    public List<Customer> selectCustomerAgeandHeigth(int age, int height) {
        try (EntityManager entityManagerLoc = entityManagerFactory.createEntityManager()) {
            TypedQuery<Customer> queryLoc = entityManagerLoc.createQuery("select c from Customer c where c.age=?1 and c.height=?2",
                                                                          Customer.class);
            queryLoc.setParameter(1,
                                  age);
            queryLoc.setParameter(2,
                                  height);
            return queryLoc.getResultList();
        }
    }
}
