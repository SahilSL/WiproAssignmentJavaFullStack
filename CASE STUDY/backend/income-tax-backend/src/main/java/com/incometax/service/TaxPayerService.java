package com.incometax.service;

import com.incometax.model.TaxPayer;
import com.incometax.repository.TaxPayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxPayerService {
    private final TaxPayerRepository repo;

    public TaxPayerService(TaxPayerRepository repo) {
        this.repo = repo;
    }

    public TaxPayer save(TaxPayer t){ return repo.save(t); }
    public List<TaxPayer> findAll(){ return repo.findAll(); }
    public Optional<TaxPayer> findById(Long id){ return repo.findById(id); }
    public void deleteById(Long id){ repo.deleteById(id); }
}
