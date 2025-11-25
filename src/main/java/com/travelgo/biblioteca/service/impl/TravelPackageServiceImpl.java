package com.travelgo.biblioteca.service.impl;

import com.travelgo.biblioteca.exception.NotFoundException;
import com.travelgo.biblioteca.model.TravelPackage;
import com.travelgo.biblioteca.repository.TravelPackageRepository;
import com.travelgo.biblioteca.service.TravelPackageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TravelPackageServiceImpl implements TravelPackageService {

    private final TravelPackageRepository repo;

    public TravelPackageServiceImpl(TravelPackageRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<TravelPackage> findAll() {
        return repo.findAll();
    }

    @Override
    public TravelPackage findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Paquete no encontrado con id " + id));
    }

    @Override
    public List<TravelPackage> searchByName(String q) {
        return repo.findByNameContainingIgnoreCase(q);
    }

    @Override
    public TravelPackage create(TravelPackage travelPackage) {
        return repo.save(travelPackage);
    }

    @Override
    public TravelPackage update(Long id, TravelPackage data) {
        TravelPackage current = findById(id);

        current.setName(data.getName());
        current.setDestination(data.getDestination());
        current.setDurationDays(data.getDurationDays());
        current.setCategory(data.getCategory());
        current.setStock(data.getStock());
        current.setPrice(data.getPrice());
        current.setImageUrl(data.getImageUrl());

        return repo.save(current);
    }

    @Override
    public void delete(Long id) {
        TravelPackage current = findById(id);
        repo.delete(current);
    }
}
