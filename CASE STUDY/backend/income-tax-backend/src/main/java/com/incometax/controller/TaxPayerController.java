package com.incometax.controller;

import com.incometax.model.TaxPayer;
import com.incometax.service.TaxPayerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taxpayers")
public class TaxPayerController {
    private final TaxPayerService service;
    public TaxPayerController(TaxPayerService service){ this.service = service; }

    @GetMapping
    public List<TaxPayer> getAll(){ return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<TaxPayer> getById(@PathVariable Long id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TaxPayer> create(@Valid @RequestBody TaxPayer t){
        return ResponseEntity.ok(service.save(t));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaxPayer> update(@PathVariable Long id, @Valid @RequestBody TaxPayer t){
        return service.findById(id).map(existing -> {
            existing.setName(t.getName());
            existing.setPanNumber(t.getPanNumber());
            existing.setAnnualIncome(t.getAnnualIncome());
            return ResponseEntity.ok(service.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
