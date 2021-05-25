package com.krylov.springbootlesson.service;

import com.krylov.springbootlesson.model.Customer;
import com.krylov.springbootlesson.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getById(Long id) {
        log.info("IN CustomerServiceImpl <getById> {}",id);
        return customerRepository.findById(id).get();
    }

    @Override
    public void save(Customer customer) {
        log.info("IN CustomerServiceImpl <save> {}",customer);
        customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        log.info("IN CustomerServiceImpl <delete> {}",id);
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {
        log.info("IN CustomerServiceImpl <getAll> ");
        return customerRepository.findAll();
    }
}
