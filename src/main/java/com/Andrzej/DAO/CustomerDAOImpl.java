package com.Andrzej.DAO;

import java.util.List;

import com.Andrzej.Entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public class
CustomerDAOImpl implements CustomerDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;


    @Transactional
    public List<Customer> getCustomers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Customer> theQuery =
                currentSession.createQuery("from Customer order by lastName", Customer.class);

        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        // return the results
        return customers;
    }

    public void addCustomer(Customer customer) {

        //current hibernate session
        Session session = sessionFactory.getCurrentSession();
        //save or update customer
        session.saveOrUpdate(customer);
    }

    public Customer getCustomer(int id) {

        //get current session
        Session session = sessionFactory.getCurrentSession();

        //retrieve customer from db
        Customer customer = session.get(Customer.class, id);

        return customer;
    }

    public void deleteCustomer(int id) {

        //current session
        Session session = sessionFactory.getCurrentSession();

        //delete
        Query query = session.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", id);

        query.executeUpdate();

    }

    public List<Customer> searchCustomers(String searchName) {

        Session session = sessionFactory.getCurrentSession();

        Query query = null;

        //search by name if nameSearch is empty
        if (searchName!=null && searchName.trim().length()>0){

            //search first or last name
            query = session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            query.setParameter("theName", "%" + searchName.toLowerCase()+"%");

        }else{

            //searchName is empty - get all customers
            query = session.createQuery("from Customer", Customer.class);
        }
        //execute
        List<Customer> customers = query.getResultList();

        //return results
        return customers;

    }

}

