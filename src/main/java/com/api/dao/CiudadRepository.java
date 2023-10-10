package com.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.domain.Ciudad;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {

}
