package com.muskan.votingsystem.service;

import com.muskan.votingsystem.entity.Candidate;

import java.util.List;
import java.util.Optional;

public interface CandidateService {

    void saveCandidate(Candidate candidate);

    Optional<Candidate> findById(Long id);

    List<Candidate> findAll();
}
