package com.Andrzej.service;

import com.Andrzej.DAO.CustomerDAO;
import com.Andrzej.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    //infects customer service
    @Autowired
    private CustomerDAO customerDAO;

    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Transactional
    public void addCustomer(Customer customer) {


        customerDAO.addCustomer(customer);

    }
    @Transactional
    public Customer getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }
    @Transactional
    public void deleteCustomer(int id) {
         customerDAO.deleteCustomer(id);
    }

    @Transactional
    public List<Customer> searchCustomers(String searchName) {
        return customerDAO.searchCustomers(searchName);
    }

}
