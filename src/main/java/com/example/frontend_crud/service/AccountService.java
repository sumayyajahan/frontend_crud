package com.example.frontend_crud.service;

import com.example.frontend_crud.entity.Account;
import com.example.frontend_crud.entity.Employee;
import com.example.frontend_crud.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    public void addAcc(Account account){

        accountRepo.save(account);
    }
    public List<Account> getAllAcc(){
        return accountRepo.findAll();
    }
    public Account getAccountById(int id){
        Optional<Account> acc = accountRepo.findById(id);
        if(acc.isPresent()){

            return acc.get();
        }
        return null;
    }

    public Account update(Account account, int id){

        Account existingAcc = accountRepo.findById(account.getId()).orElse(null);
        existingAcc.setAccountNum(account.getAccountNum());
        existingAcc.setAccountType(account.getAccountType());
        existingAcc.setDateOpened(account.getDateOpened());
        existingAcc.setBalance(account.getBalance());
        existingAcc.setEmployee(account.getEmployee());

        return accountRepo.save(existingAcc);
    }
    public void delete(int id){

        accountRepo.deleteById(id);
    }
    public void accPrimesNum(){
        //accountRepo.
    }
}
