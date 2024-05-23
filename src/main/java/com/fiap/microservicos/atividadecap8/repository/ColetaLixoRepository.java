package com.fiap.microservicos.atividadecap8.repository;

import com.fiap.microservicos.atividadecap8.model.ColetaLixo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColetaLixoRepository extends JpaRepository<ColetaLixo, Long> {
}
