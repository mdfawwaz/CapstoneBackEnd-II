package com.project.capstone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.capstone.entity.Quote;
import com.project.capstone.entity.User;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    List<Quote> findByUser(User user);
}
