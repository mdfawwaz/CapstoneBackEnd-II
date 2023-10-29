package com.project.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.capstone.entity.Billing;
import com.project.capstone.repository.BillingRepository;

@Service
public class BillingService {
    private final BillingRepository billingRepository;

    @Autowired
    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    public Billing saveBillingData(Billing billing) {
        return billingRepository.save(billing);
    }

    public List<Billing> getAllBillingData() {
        return billingRepository.findAll();
    }

    public double getTotalBillingAmount() {
        return 0;
    }

    public List<Billing> findByProductName() {
        return findByProductName();
    }
}
