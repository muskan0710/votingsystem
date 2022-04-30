package com.muskan.votingsystem.dao;

import com.muskan.votingsystem.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateDao extends JpaRepository<Candidate, Long> {

    Candidate findById(int id);

}
