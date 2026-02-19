package com.careerit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.careerit.entity.Watch;

@Repository
public interface WatchRepository extends JpaRepository<Watch, Long>{

}
