package com.fiap.microservicos.atividadecap8.service;

import com.fiap.microservicos.atividadecap8.model.ColetaLixo;
import com.fiap.microservicos.atividadecap8.repository.ColetaLixoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColetaLixoService {
    @Autowired
    private ColetaLixoRepository repository;

    public List<ColetaLixo> findAll() {
        return repository.findAll();
    }

    public Optional<ColetaLixo> findById(Long id) {
        return repository.findById(id);
    }

    public ColetaLixo save(ColetaLixo coletaLixo) {
        return repository.save(coletaLixo);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
