package org.academiadecodigo.bootcamp.controller;

import org.academiadecodigo.bootcamp.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    @RequestMapping(method = RequestMethod.GET, value = "/customerDetails")
    public String customerDetails(Model model){

        Customer customer = new Customer("Doe", 35);

        model.addAttribute(customer);
        return "customerView";
    }
}
