package model.services;

import java.time.LocalDate;

import model.entities.Contrato;
import model.entities.Parcela;

public class ContratoDeServico {

    private ServicoDePagamentoOnline servicoDePagamentoOnline; // Associação da classe ServicoDePagamentoOnline.

    public ContratoDeServico(ServicoDePagamentoOnline servicoDePagamentoOnline) {
        this.servicoDePagamentoOnline = servicoDePagamentoOnline;
    }

    public void processarContrato(Contrato contrato, Integer meses) { // meses = numeroDeParcelas.

        for (int i = 1; i <= meses; i++) {

            double parcelaBasica = contrato.getValorTotal() / meses;
            // getData().plusMonths(i) retorna a data atualizada mais + quantidade de meses de i.
            // plusMonths() adiciona meses à data, conforme o valor entre parênteses.
            LocalDate vencimentoDaParcela = contrato.getData().plusMonths(i);

            double juros = servicoDePagamentoOnline.juros(parcelaBasica, i);
            double taxaDePagamento = servicoDePagamentoOnline.taxaDePagamento(parcelaBasica + juros);

            double parcela = parcelaBasica + juros + taxaDePagamento;

            contrato.getParcelas().add(new Parcela(vencimentoDaParcela, parcela));
        }
    }

}