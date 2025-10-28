package com.du.bunsikorder.service;

import com.du.bunsikorder.model.Bunsik;
import com.du.bunsikorder.repository.BunsikRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bunsikService {

    private final BunsikRepository bunsikRepository;


    public bunsikService(BunsikRepository bunsikRepository) {
        this.bunsikRepository = bunsikRepository;
    }

    public List<Bunsik> findAll(Long id) {
        return bunsikRepository.findAll();
    }

    public Bunsik findOne(Long id) {
        return bunsikRepository.findById(id).orElse(null);
    }

    public Bunsik save(Bunsik bunsik) {
        return bunsikRepository.save(bunsik);
    }

    public void delete(Long id) {
       bunsikRepository.deleteById(id);
    }
}
