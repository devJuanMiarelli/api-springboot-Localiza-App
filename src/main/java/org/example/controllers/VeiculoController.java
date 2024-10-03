package org.example.controllers;

import org.example.models.Veiculo;
import org.example.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin(origins = "http://localhost:51893")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> getAllVeiculos() {
        return veiculoService.findAll();
    }

    @PostMapping
    public ResponseEntity<Veiculo> createVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo novoVeiculo = veiculoService.save(veiculo);
        return new ResponseEntity<>(novoVeiculo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> updateVeiculo(
            @PathVariable int id,
            @RequestBody Veiculo veiculoAtualizado) {

        Veiculo veiculo = veiculoService.update(id, veiculoAtualizado);
        return new ResponseEntity<>(veiculo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable int id) {
        veiculoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}/reserve")
    public ResponseEntity<Void> reserveVeiculo(@PathVariable int id) {
        veiculoService.reserve(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}/liberar")
    public ResponseEntity<Void> liberarVeiculo(@PathVariable int id) {
        veiculoService.liberar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
