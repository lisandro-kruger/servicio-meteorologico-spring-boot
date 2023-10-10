package com.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.domain.EstadoClima;

@Repository
public interface EstadoClimaRepository extends JpaRepository<EstadoClima, Long> {

}
