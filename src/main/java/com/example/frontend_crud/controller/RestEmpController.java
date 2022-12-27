package com.example.frontend_crud.controller;

import com.example.frontend_crud.entity.Account;
import com.example.frontend_crud.entity.Employee;
import com.example.frontend_crud.service.AccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class RestEmpController {
@Autowired
    private AccountService accountService;

    @GetMapping("/test")
    public ResponseEntity<List<Account>> getAllAccounts(){

        List<Account> list = accountService.getAllAcc();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/primeAccs")
    public ResponseEntity<List<Account>> getAllPrimesAcc(){
        List<Account> result = accountService.getPrimeAccount();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

//    @GetMapping("/addEmp")
//    public String addEmp(){
//
//        return "add_emp";
//    }
//    @PostMapping("/postEmp")
//    public String postEmp(@ModelAttribute Employee employee, HttpSession session){
//
//        service.addEmp(employee);
//        session.setAttribute("msg", "Employee added successfully ....");
//        //System.out.println(employee);
//
//        return "redirect:/";
//    }
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable int id, Model m){
//
//        Employee e = service.getEmployeeById(id);
//        m.addAttribute("emp", e);
//        return "edit";
//    }
//    @PostMapping("/updateData")
//    public String update(@ModelAttribute Employee e, HttpSession session){
//
//        service.update(e,e.getId());
//        session.setAttribute("msg", "Employee is updated successfully.");
//        return "redirect:/";
//    }
//    @GetMapping("/delete/{id}")
//    public String deleteEmp(@PathVariable int id, HttpSession session){
//
//        service.deleteEmp(id);
//        session.setAttribute("msg", "Deleted data successfully.");
//        return "redirect:/";
//    }
}
