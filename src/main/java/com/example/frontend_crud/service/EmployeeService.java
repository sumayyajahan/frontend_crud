package com.example.frontend_crud.service;

import com.example.frontend_crud.entity.Employee;
import com.example.frontend_crud.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmpRepo empRepo;

    public void addEmp(Employee employee){
        empRepo.save(employee);
    }
    public List<Employee> getAllEmp(){
        return empRepo.findAll();
    }
    public Employee getEmployeeById(int id){
       Optional<Employee> emp = empRepo.findById(id);
       if(emp.isPresent()){

           return emp.get();
       }
       return null;
    }

    public Employee update(Employee employee, int id){

      Employee existingEmp = empRepo.findById(employee.getId()).orElse(null);
      existingEmp.setName(employee.getName());
      existingEmp.setAddress(employee.getAddress());
      existingEmp.setEmail(employee.getEmail());
      existingEmp.setPhone(employee.getPhone());
      existingEmp.setSalary(employee.getSalary());

      return empRepo.save(existingEmp);
    }
    public void deleteEmp(int id){

        empRepo.deleteById(id);
    }
}
