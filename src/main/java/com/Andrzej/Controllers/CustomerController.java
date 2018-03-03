package com.Andrzej.Controllers;


import com.Andrzej.DAO.CustomerDAO;
import com.Andrzej.Entity.Customer;
import com.Andrzej.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //inject DAO to controller
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model){

        //get customers from DAO
        List<Customer> customers= customerService.getCustomers();

        //add the customers to the model
        model.addAttribute("customers", customers);

        return "customerList";
    }
}
