package com.muskan.votingsystem.service;

import com.muskan.votingsystem.entity.Citizen;

import java.util.Optional;

public interface CitizenService {

    void saveCitizen(Citizen citizen);

    Optional<Citizen> findById(Long id);
}
