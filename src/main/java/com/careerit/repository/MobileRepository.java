package com.careerit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.careerit.entity.Mobile;

import jakarta.persistence.Entity;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Long> {

}
