package com.project.capstone.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.capstone.entity.Billing;

public interface BillingRepository extends JpaRepository<Billing, Long> {

    List<Billing> findByProductName(String string);
}

