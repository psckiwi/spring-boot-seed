package com.springboot.seed.sample.jpa.repository;

import com.springboot.seed.sample.jpa.domain.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
