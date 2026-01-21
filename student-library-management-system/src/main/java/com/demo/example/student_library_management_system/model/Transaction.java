package com.demo.example.student_library_management_system.model;

import com.demo.example.student_library_management_system.enums.TransactionType;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    private int id;

    @Column(name = "transaction_Type" , nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;

    @Column(name = "transaction_Date" , nullable = false)
    private Date transactionDate;

    @Column(name = "due_Date" , nullable = false)
    private String dueDate;

    @Column(name = "fine" , nullable = false)
    private double fine;

}
