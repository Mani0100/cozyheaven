package com.hexaware.cozyhaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hexaware.cozyhaven.model.Refund;
import com.hexaware.cozyhaven.repository.RefundRepository;

@Repository
public class RefundService{
	@Autowired
    private RefundRepository refundRepo;
    
    public void addRefund(Refund refund) {
        refundRepo.save(refund);
    }
    
    public List<Refund> showRefund() {
    	return refundRepo.findAll();
    }

}
