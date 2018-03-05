package com.Andrzej.Controllers;


import com.Andrzej.DAO.CustomerDAO;
import com.Andrzej.Entity.Customer;
import com.Andrzej.service.CustomerService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/addForm")
    public String showFormAdd(Model model){

        //create model att binding form
        Customer customer = new Customer();

        model.addAttribute("customer", customer);


        return "addForm";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute("customer") Customer customer){


        //save the cusotmer using service
        customerService.addCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/updateForm")
    public String updateForm(@RequestParam("customerId") int id, Model model){

        //retrieve customer from DB
        Customer customer = customerService.getCustomer(id);

        //set customer as a model attribute
        model.addAttribute("customer", customer);

        //send to form
        return "addForm";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int id){

        //delete customer from db
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";

    }

    @PostMapping("/search")
    public String search(@RequestParam("searchName") String searchName, Model model){

        //search customer
        List<Customer> customers = customerService.searchCustomers(searchName);

        //add customer to the model
        model.addAttribute("customers", customers);

        return "customerList";


    }

}
