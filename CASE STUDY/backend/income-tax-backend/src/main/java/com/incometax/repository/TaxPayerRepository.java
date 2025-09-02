package com.incometax.repository;

import com.incometax.model.TaxPayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxPayerRepository extends JpaRepository<TaxPayer, Long> {
    boolean existsByPanNumber(String panNumber);
}
