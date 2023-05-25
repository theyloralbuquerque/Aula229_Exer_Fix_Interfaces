package model.services;

public interface ServicoDePagamentoOnline {

    double taxaDePagamento(double quantia);
    double juros(double quantia, int meses);

}