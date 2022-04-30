package com.muskan.votingsystem.dao;

import com.muskan.votingsystem.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenDao extends JpaRepository<Citizen, Long> {
}
