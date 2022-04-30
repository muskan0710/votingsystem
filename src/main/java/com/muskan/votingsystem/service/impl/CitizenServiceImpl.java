package com.muskan.votingsystem.service.impl;

import com.muskan.votingsystem.dao.CitizenDao;
import com.muskan.votingsystem.entity.Citizen;
import com.muskan.votingsystem.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CitizenServiceImpl implements CitizenService {

    @Autowired
    private CitizenDao citizenDao;

    @Override
    public void saveCitizen(Citizen citizen) {
        citizenDao.save(citizen);
    }

    @Override
    public Optional<Citizen> findById(Long id) {
        return citizenDao.findById(id);
    }

}
