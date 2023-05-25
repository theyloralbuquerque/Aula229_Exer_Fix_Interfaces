package model.services;

public class ServicoDoPaypal implements ServicoDePagamentoOnline{

    @Override
    public double taxaDePagamento(double quantia) {
        return quantia * 0.02;
    }

    @Override
    public double juros(double quantia, int meses) {
        return quantia * 0.01 * meses;
    }
}