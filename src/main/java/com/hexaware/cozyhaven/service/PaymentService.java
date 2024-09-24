package com.hexaware.cozyhaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.model.Payment;
import com.hexaware.cozyhaven.repository.PaymentRepository;

@Service
public class PaymentService {
	
	 @Autowired
	    private PaymentRepository paymentRepo;

	 public List<Payment> showRefund() {
	    	return paymentRepo.findAll();
	    }

}
