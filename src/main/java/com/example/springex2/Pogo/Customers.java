package com.example.springex2.Pogo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customers {
    private int id;
    private String userName;
    private double balance;
}
