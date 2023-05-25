package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parcela {

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formatação para poder usar no toString().

    private LocalDate data;
    private Double quantia;

    public Parcela() {
    }

    public Parcela(LocalDate data, Double quantia) {
        super();
        this.data = data;
        this.quantia = quantia;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getQuantia() {
        return quantia;
    }

    public void setQuantia(Double quantia) {
        this.quantia = quantia;
    }

    @Override
    public String toString() {
        return data.format(fmt) + " - " + String.format("%.2f", quantia);
    }
}