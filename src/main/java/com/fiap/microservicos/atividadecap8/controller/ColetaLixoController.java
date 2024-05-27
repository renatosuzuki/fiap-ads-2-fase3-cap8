package com.fiap.microservicos.atividadecap8.controller;

import com.fiap.microservicos.atividadecap8.model.ColetaLixo;
import com.fiap.microservicos.atividadecap8.service.ColetaLixoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ColetaLixoController {

    @Autowired
    private ColetaLixoService service;

    @GetMapping("/coleta-lixo")
    public List<ColetaLixo> getAllColetaLixo() {
        return service.findAll();
    }

    @GetMapping("/coleta-lixo/{id}")
    public ResponseEntity<ColetaLixo> getOneColetaLixo(@PathVariable Long id) {
        try {
            Optional<ColetaLixo> coletaLixoOpt = service.findById(id);

            if(coletaLixoOpt.isPresent()) {
                ColetaLixo coletaLixo = coletaLixoOpt.get();

                return ResponseEntity.ok(coletaLixo);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/agendar-coleta-lixo")
    public ResponseEntity<ColetaLixo> createColetaLixo(@RequestBody ColetaLixo coletaLixo) {
        try {
            ColetaLixo saveColeta = service.save(coletaLixo);

            return new ResponseEntity<>(saveColeta, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/agendar-coleta-lixo/{id}")
    public ResponseEntity<ColetaLixo> updateColetaLixo(@PathVariable Long id, @RequestBody ColetaLixo coletaLixo) {
       try {
           Optional<ColetaLixo> coleta = service.findById(id);

           if(coleta.isPresent()) {
               ColetaLixo toUpdateColeta = coleta.get();

               toUpdateColeta.setEndereco(coletaLixo.getEndereco());
               toUpdateColeta.setDataColeta(coletaLixo.getDataColeta());
               toUpdateColeta.setHorarioColeta(coletaLixo.getHorarioColeta());
               toUpdateColeta.setTipoResiduo(coletaLixo.getTipoResiduo());
               toUpdateColeta.setObservacoes(coletaLixo.getObservacoes());

               service.save(toUpdateColeta);

               return new ResponseEntity<>(HttpStatus.OK);
           } else {
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
           }
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @DeleteMapping("/agendar-coleta-lixo/{id}")
    public ResponseEntity<Object> deleteColetaLixo(@PathVariable Long id) {
        try {
            Optional<ColetaLixo> coleta = service.findById(id);

            if(coleta.isPresent()) {
                service.deleteById(id);

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
