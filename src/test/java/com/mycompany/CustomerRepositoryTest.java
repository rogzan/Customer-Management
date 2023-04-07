package com.mycompany;

import com.mycompany.customer.Customer;
import com.mycompany.customer.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class CustomerRepositoryTest {
    @Autowired private CustomerRepository repository;

    @Test
    public void testAddNew() {
        Customer customer = new Customer();
        customer.setName("Magda Nowak");
        customer.setAddress("Kielce");
        customer.setVatId(BigInteger.valueOf(743199032));
        customer.setCreationDate(LocalDate.now());

        Customer savedCustomer = repository.save(customer);

        Assertions.assertNotNull(savedCustomer);
        Assertions.assertTrue(savedCustomer.getId() > 0);
    }

    @Test
    public void testListAll() {
        Iterable<Customer> customers = repository.findAll();
        List<Customer> customerList = new ArrayList<>();
        customers.forEach(customerList::add);

        Assertions.assertTrue(customerList.size() > 0);

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Test
    public void testUpdate() {
        Integer customerId = 2;
        Optional<Customer> optionalCustomer = repository.findById(customerId);
        Customer customer = optionalCustomer.get();
        customer.setName("Alicja Nowak");
        repository.save(customer);

        Customer updatedCustomer = repository.findById(customerId).get();
        Assertions.assertSame("Alicja Nowak", updatedCustomer.getName());
    }

    @Test
    public void testDelete() {
        Integer customerId = 3;
        repository.deleteById(customerId);

        Optional<Customer> optionalCustomer = repository.findById(customerId);
        Assertions.assertFalse(optionalCustomer.isPresent());
    }
}
