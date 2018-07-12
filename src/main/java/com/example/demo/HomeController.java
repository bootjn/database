package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    CustomersRepository customersRepository;

    @RequestMapping("/")
    public String index(Model model)
    {
        model.addAttribute("customers", customersRepository.findAll());
        return "customer";
    }


    @GetMapping("/search")
    public String getSearch(){
        return "customerform";
    }

    @GetMapping("/add")
    public String customerForm(Model model){
        return "customerform";
    }

    @PostMapping("/process")
    public String showSerchResults(@Valid Customers customers, BindingResult result, HttpServletRequest request, Model model){
        if(result.hasErrors()) {
            return "customerform";
        }

        String search = request.getParameter("lastname");
        model.addAttribute("listResult", customersRepository.findByLastnameIgnoreCase(search));
        return "customerform";
    }

//    @RequestMapping("/")
//    public String index()
//    {
//        return "customer";
//    }
}
