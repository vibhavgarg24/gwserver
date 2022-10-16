package com.ayuvib.gwserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayuvib.gwserver.model.Transaction;
import com.ayuvib.gwserver.service.transaction.TransactionService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/transaction")
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;

    public TransactionController() {
    }

    @GetMapping("/add/{userId}")
    public ResponseEntity<?> add(@PathVariable String userId, @RequestBody Transaction txn){

        return this.transactionService.add(userId, txn);
    }

    @GetMapping("/find/{userId}/{tIndex}")
    public ResponseEntity<?> find(@PathVariable String userId, @PathVariable int tIndex){

        return this.transactionService.find(userId, tIndex);
    }

    @PutMapping("/update/{userId}/{tIndex}")
    public ResponseEntity<?> update(@PathVariable String userId, @PathVariable int tIndex, @RequestBody Transaction txn) {
        
        return this.transactionService.update(userId, tIndex, txn);
    }

    @DeleteMapping("/delete/{userId}/{tIndex}")
    public ResponseEntity<?> delete(@PathVariable String userId, @PathVariable int tIndex){

        return this.transactionService.delete(userId, tIndex);
    }
    
}
