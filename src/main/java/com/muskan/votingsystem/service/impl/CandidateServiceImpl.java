package com.muskan.votingsystem.service.impl;

import com.muskan.votingsystem.dao.CandidateDao;
import com.muskan.votingsystem.entity.Candidate;
import com.muskan.votingsystem.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateDao candidateDao;

    @Override
    public void saveCandidate(Candidate candidate) {
        candidateDao.save(candidate);
    }

    @Override
    public Optional<Candidate> findById(Long id) {
        return candidateDao.findById(id);
    }

    public List<Candidate> findAll() {
        return candidateDao.findAll();
    }

}
