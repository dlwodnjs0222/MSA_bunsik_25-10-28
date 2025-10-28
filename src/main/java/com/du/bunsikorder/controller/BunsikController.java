package com.du.bunsikorder.controller;

import com.du.bunsikorder.model.Bunsik;
import com.du.bunsikorder.repository.BunsikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class BunsikController {
    
    @Autowired
    private BunsikRepository bunsikRepository;

    @GetMapping
    public ResponseEntity<List<Bunsik>> findAll() {
        return ResponseEntity.ok(bunsikRepository.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Bunsik> findById(@PathVariable Long id) {
        return bunsikRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping("/{id}")
    public Bunsik create(@PathVariable Long id, @RequestBody Bunsik bunsik) {
        return bunsikRepository.save(bunsik);
    }
    
    @PutMapping("/{id}")
    public  ResponseEntity<Bunsik> update(@PathVariable Long id, @RequestBody Bunsik bunsik) {
        return bunsikRepository.findById(id)
                .map(existingBunsik -> {
                    bunsik.setId(id);
                    return ResponseEntity.ok(bunsikRepository.save(bunsik));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return bunsikRepository.findById(id)
                .map(bunsik ->  {
                    bunsikRepository.delete(bunsik);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
