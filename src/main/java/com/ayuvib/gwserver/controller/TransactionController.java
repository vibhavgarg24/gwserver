package com.ayuvib.gwserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Transaction> add(@PathVariable String userId, @PathVariable int cIndex, @RequestBody Transaction txn){

        Transaction addedTxn = this.transactionService.add(userId, cIndex, txn);
        return new ResponseEntity<Transaction>(addedTxn, HttpStatus.OK);
    }

    @GetMapping("/find/{userId}/{cIndex}/{tIndex}")
    public ResponseEntity<Transaction> find(@PathVariable String userId, @PathVariable int cIndex, @PathVariable int tIndex){

        Transaction txn = this.transactionService.find(userId, cIndex, tIndex);
        return new ResponseEntity<Transaction>(txn, HttpStatus.OK);
    }

    @PutMapping("/update/{userId}/{oldCIndex}/{oldTIndex}/{newCIndex}")
    public ResponseEntity<Transaction> update(@PathVariable String userId, @PathVariable int oldCIndex, 
                                    @PathVariable int oldTIndex, @PathVariable int newCIndex, @RequestBody Transaction txn) {
        
        Transaction updatedTxn = this.transactionService.update(userId, oldCIndex, oldTIndex, newCIndex, txn);
        return new ResponseEntity<Transaction>(updatedTxn, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}/{cIndex}/{tIndex}")
    public ResponseEntity<Transaction> delete(@PathVariable String userId, @PathVariable int cIndex, @PathVariable int tIndex){
        
        Transaction deletedTxn = this.transactionService.delete(userId, cIndex, tIndex);
        return new ResponseEntity<Transaction>(deletedTxn, HttpStatus.OK);
    }
    
}
