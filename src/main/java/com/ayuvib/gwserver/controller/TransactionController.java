package com.ayuvib.gwserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayuvib.gwserver.model.Transaction;
import com.ayuvib.gwserver.service.transaction.TransactionService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/txn")
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;

    public TransactionController() {
    }

    @PostMapping("/add/{userId}/{cIndex}")
    public ResponseEntity<?> add(@PathVariable String userId, @PathVariable int cIndex, @RequestBody Transaction txn){

        return this.transactionService.add(userId, cIndex, txn);
    }

    @GetMapping("/find/{userId}/{cIndex}/{tIndex}")
    public ResponseEntity<?> find(@PathVariable String userId, @PathVariable int cIndex, @PathVariable int tIndex){

        return this.transactionService.find(userId, cIndex, tIndex);
    }

    @PutMapping("/update/{userId}/{oldCIndex}/{oldTIndex}/{newCIndex}")
    public ResponseEntity<?> update(@PathVariable String userId, @PathVariable int oldCIndex, 
                                    @PathVariable int oldTIndex, @PathVariable int newCIndex, @RequestBody Transaction txn) {
        
        return this.transactionService.update(userId, oldCIndex, oldTIndex, newCIndex, txn);
    }

    @DeleteMapping("/delete/{userId}/{cIndex}/{tIndex}")
    public ResponseEntity<?> delete(@PathVariable String userId, @PathVariable int cIndex, @PathVariable int tIndex){

        return this.transactionService.delete(userId, cIndex, tIndex);
    }
    
}
