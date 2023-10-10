package com.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.domain.Clima;

@Repository
public interface ClimaRepository extends JpaRepository<Clima, Long> {

}
