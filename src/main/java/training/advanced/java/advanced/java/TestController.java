package training.advanced.java.advanced.java;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import training.advanced.java.advanced.java.annotations.Customer;
import training.advanced.java.advanced.java.db.JdbcBean;
import training.advanced.java.advanced.java.db.JpaBean;
import training.advanced.java.advanced.java.db.SpringDataBean;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    private final AdvancedJavaApplication advancedJavaApplication;
    private final SpringDataBean springDataBean;
    private final JpaBean jpaBean;
    private final JdbcBean jdbcBean;


    // public  long         counter; // yanlış
    public AtomicLong  counter = new AtomicLong();
    // private List<String> strings = new ArrayList<>(); // yanlış
    // private List<String> strings = new Vector<>(); // doğru
    private List<String> strings = Collections.synchronizedList(new ArrayList<>()); // doğru
    private List<String> stringsConcurRead = new CopyOnWriteArrayList<>();

    // private Map<String, Customer> customerMap = new HashMap<>(); // yanlış
    private Map<String, Customer> customerMap = new ConcurrentHashMap<>();

    // private Set<Long> longs = new HashSet<>(); // yanlış
    private Set<Long> longs = ConcurrentHashMap.newKeySet();


    @GetMapping("/increase")
    public long increase() {
        Future<String> stringFutureLoc = advancedJavaApplication.asyncMetod();
        List<String> stringsLoc = new ArrayList<>();
        stringsLoc.add("deneme");
        long lLoc = counter.incrementAndGet();
        strings.add("arttırma işlemi " + counter);
        // customerMap.put("osman",Customer.builder().build);
        try {
            String stringLoc = stringFutureLoc.get();
        } catch (InterruptedException eParam) {
            throw new RuntimeException(eParam);
        } catch (ExecutionException eParam) {
            throw new RuntimeException(eParam);
        }
        return lLoc;
    }

    @GetMapping("/get/jdbc/customer")
    public Customer method1(@RequestParam Long cid){
        return jdbcBean.selectCustomer(cid);
    }

    @GetMapping("/get/spring/customer")
    public Customer method2(@RequestParam Long cid){
        return springDataBean.getCustomer(cid);
    }

    @GetMapping("/get/jpa/customer")
    public Customer method3(@RequestParam Long cid){
        return jpaBean.getCustomer(cid);
    }

    @GetMapping("/all/jdbc/customer")
    public List<Customer> all1(@RequestParam Integer age,@RequestParam Integer h){
        return jdbcBean.selectCustomerAgeandHeigth(age, h);
    }

    @GetMapping("/all/jpa/customer")
    public List<Customer> all2(@RequestParam Integer age,@RequestParam Integer h){
        return jpaBean.selectCustomerAgeandHeigth(age, h);
    }

    @GetMapping("/all/spring/customer")
    public List<Customer> all3(@RequestParam Integer age,@RequestParam Integer h){
        return springDataBean.getCustomerAgeAndHeight(age, h);
    }

}
