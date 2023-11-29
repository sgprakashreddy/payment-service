package com.javatechie.ps.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.javatechie.ps.api.entity.Payment;
import com.javatechie.ps.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pay")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping("/savePayment")
    public Payment savePayment(@RequestBody Payment payment) throws JsonProcessingException {
        System.out.println("***********Inside the controller******");
        return service.savePayment(payment);
    }

    @GetMapping("{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable int orderId) throws JsonProcessingException {
        return service.findPaymentHistoryByOrderId(orderId);
    }

}

