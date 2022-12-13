package com.example.frontend_crud.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String accountNum;
    private String accountType;
    private LocalDate dateOpened;
    private Double balance;
    @OneToOne
    private Employee employee;

    public Account() {
    }
    public Account(int id, String accountNum, String accountType, LocalDate dateOpened, Double balance, Employee employee) {
        this.id = id;
        this.accountNum = accountNum;
        this.accountType = accountType;
        this.dateOpened = dateOpened;
        this.balance = balance;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public LocalDate getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(LocalDate dateOpened) {
        this.dateOpened = dateOpened;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public void findBalanceLessThan(){

    }
}
