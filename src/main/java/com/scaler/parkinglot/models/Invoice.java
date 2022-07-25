package com.scaler.parkinglot.models;

import java.util.Date;

public class Invoice extends BaseModel {
    private Ticket ticket;
    private double amount;
    private Date exitTime;
    private Operator operator;
    private InvoicePaidStatus invoicePaidStatus;

}
