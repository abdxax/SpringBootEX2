package com.example.springex2.controller;

import com.example.springex2.API.ApiRespon;
import com.example.springex2.Pogo.Customers;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/customers")
public class CustomersController {
    ArrayList<Customers> customers;
    public CustomersController(){
        customers=new ArrayList<>();
    }
    @PostMapping("/addItem")
    public ApiRespon customers(@RequestBody Customers customer){
        customers.add(customer);
        return new ApiRespon("Add is Done");
    }
    @GetMapping("/getAll")
    public ArrayList<Customers> getAll(){
        return  customers;
    }
    @PutMapping("/updateCustomer/{id}")
    public ApiRespon updateCustomer(@RequestBody  Customers customer,@PathVariable int id){
        Customers c=customers.get(id);
        if(c==null){
            return new ApiRespon("Not fount ");
        }
        customers.set(id,customer);
        return new ApiRespon("Update Done");
    }
    @DeleteMapping("/deleteCustomer/{id}")
    public ApiRespon DelelteCustomer(@PathVariable int id){
        Customers c=customers.get(id);
        if(c==null){
            return new ApiRespon("Not Found");
        }
        customers.remove(id);
        return new ApiRespon("Done delete");
    }

    @PutMapping("/deposit/{id}")
    public ApiRespon deposit(@PathVariable int id,@RequestBody double mon){
        Customers ca=customers.get(id);
        double m=ca.getBalance()+mon;
        ca.setBalance(m);
        customers.set(id,ca);
        return  new ApiRespon("Deposit done");
    }

    @PutMapping ("/withdraw/{id}")
    public ApiRespon withdraw(@PathVariable int id, @RequestBody double mon){
        Customers ca=customers.get(id);
        //double m=ca.getBalance()-c.getBalance();
        if(mon>ca.getBalance()){
            return new ApiRespon("Withdraw error - balance is not enough");
        }
        double m=ca.getBalance()-mon;
        ca.setBalance(m);
        customers.set(id,ca);
        return  new ApiRespon("Withdraw done");
    }





}
