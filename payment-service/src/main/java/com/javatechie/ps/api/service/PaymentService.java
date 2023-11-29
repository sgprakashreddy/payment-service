package com.javatechie.ps.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatechie.ps.api.entity.Payment;
import com.javatechie.ps.api.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    // loggers to the Order Service
    private Logger log = LoggerFactory.getLogger(PaymentService.class);

    public Payment savePayment(Payment payment) throws JsonProcessingException {
        log.info("Payment-Service Request ",new ObjectMapper().writeValueAsString(payment));
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return repository.save(payment);
    }

    public String paymentProcessing(){
        // api should be a 3rd party API payments
        return new Random().nextBoolean() ? "success" : "false";
    }

    public Payment findPaymentHistoryByOrderId(int orderId) throws JsonProcessingException {
        Payment payment=repository.findByOrderId(orderId);
        log.info("Payment-Service findPaymentHistoryByOrderId ",new ObjectMapper().writeValueAsString(payment));
        return payment;
    }
}
