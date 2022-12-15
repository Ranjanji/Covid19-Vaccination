package com.covidproof.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covidproof.model.Entity.IdCard;
@Repository
public interface ApplicantDAO extends JpaRepository<IdCard, Integer> {

}
