package com.Andrzej.DAO;

import com.Andrzej.Entity.Customer;

import java.util.List;



public interface CustomerDAO {

    public List<Customer> getCustomers();

    void addCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);

    List<Customer> searchCustomers(String searchName);
}