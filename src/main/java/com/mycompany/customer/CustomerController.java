package com.mycompany.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired private CustomerService service;

    @GetMapping("/customers")
    public String shoCustomerList(Model model) {
        List<Customer> listCustomers = service.listAll();
        model.addAttribute("listCustomers", listCustomers);

        return "customers";
    }

    @GetMapping("/customers/new")
    public String showNewForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("pageTitle", "Add New Customer");
        return "customer_form";
    }

    @PostMapping ("/customers/save")
    public String saveCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        customer.setCreationDate(LocalDate.now());
        service.save(customer);
        redirectAttributes.addFlashAttribute("message", "The customer has been saved succesfully");
        return "redirect:/customers";
    }

    @GetMapping("/customers/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Customer customer = service.get(id);
            model.addAttribute("customer", customer);
            model.addAttribute("pageTitle", "Edit Customer (ID: " + id + ")");
            return "customer_form";
        } catch (CustomerNotFoundException e) {
            redirectAttributes.addFlashAttribute("message_fail", e.getMessage());
            return "redirect:/customers";
        }
    }

    @GetMapping("/customers/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            service.delete(id);
            redirectAttributes.addFlashAttribute("message", "The customer ID " + id + " has been deleted.");
        } catch (CustomerNotFoundException e) {
            redirectAttributes.addFlashAttribute("message_fail", e.getMessage());
        }
        return "redirect:/customers";
    }


}
