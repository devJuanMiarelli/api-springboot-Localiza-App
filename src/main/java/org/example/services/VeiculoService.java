package org.example.services;

import org.example.models.Veiculo;
import org.example.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public Veiculo save(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public void delete(int id) {
        if (veiculoRepository.existsById(id)) {
            veiculoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Veículo não encontrado!"); // Lidar com a ausência do veículo
        }
    }

    public Veiculo update(int id, Veiculo veiculoAtualizado) {
        Veiculo veiculoExistente = veiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado!"));

        veiculoExistente.setModelo(veiculoAtualizado.getModelo());
        veiculoExistente.setCategoria(veiculoAtualizado.getCategoria());
        veiculoExistente.setValor(veiculoAtualizado.getValor());
        veiculoExistente.setDisponivel(veiculoAtualizado.isDisponivel());
        veiculoExistente.setImagem(veiculoAtualizado.getImagem()); // Atualizando a imagem em Base64

        return veiculoRepository.save(veiculoExistente);
    }

    public void reserve(int id) {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado!"));
        veiculo.setDisponivel(false);
        veiculoRepository.save(veiculo);
    }

    public void liberar(int id) {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado!"));
        veiculo.setDisponivel(true);
        veiculoRepository.save(veiculo);
    }
}
