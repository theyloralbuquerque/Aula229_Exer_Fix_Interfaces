package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contrato {

    private Integer numero;
    private LocalDate data;
    private Double valorTotal;

    private List<Parcela> parcelas = new ArrayList<>(); // Associa��o um-v�rias da classe Parcela, feita por meio de Lista.

    public Contrato() {
    }

    public Contrato(Integer numero, LocalDate data, Double valorTotal) {
        this.numero = numero;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }
}