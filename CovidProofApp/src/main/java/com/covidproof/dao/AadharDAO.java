package com.covidproof.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covidproof.model.Entity.AadharCard;
@Repository
public interface AadharDAO extends JpaRepository<AadharCard, Integer> {

}
