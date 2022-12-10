package com.example.frontend_crud.controller;


import com.example.frontend_crud.entity.Employee;
import com.example.frontend_crud.service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;



@Controller
public class EmpController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public String home(Model model){

//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("index");
//        model.addAttribute("emp", list);
//        return modelAndView;

        List<Employee> list = service.getAllEmp();
        model.addAttribute("emp", list);

        return "index";
    }
    @GetMapping("/addEmp")
    public String addEmp(){

        return "add_emp";
    }
    @PostMapping("/postEmp")
    public String postEmp(@ModelAttribute Employee employee, HttpSession session){

        service.addEmp(employee);
        session.setAttribute("msg", "Employee added successfully ....");
        //System.out.println(employee);

        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m){

        Employee e = service.getEmployeeById(id);
        m.addAttribute("emp", e);
        return "edit";
    }
    @PostMapping("/updateData")
    public String update(@ModelAttribute Employee e, HttpSession session){

        service.update(e,e.getId());
        session.setAttribute("msg", "Employee is updated successfully.");
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id, HttpSession session){

        service.deleteEmp(id);
        session.setAttribute("msg", "Deleted data successfully.");
        return "redirect:/";
    }
//    public void removeVerificationMessageFromSession() {
//        try {
//            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//            HttpSession session = request.getSession();
//            session.removeAttribute("verificationMessage");
//        } catch (RuntimeException ex) {
//            log.error("No Request: ", ex);
//        }
//    }
}
