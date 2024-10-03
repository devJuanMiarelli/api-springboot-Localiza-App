package org.example.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Veiculo {
    @Id
    @GeneratedValue
    private int id;
    private String modelo;
    private String categoria;
    private String valor;
    private boolean disponivel;
    @Lob
    private String imagem;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCategoria() { return categoria; }

    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getValor() { return valor; }

    public void setValor(String valor) { this.valor = valor; }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
