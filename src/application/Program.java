package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contrato;
import model.entities.Parcela;
import model.services.ContratoDeServico;
import model.services.ServicoDoPaypal;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato de data aceitado pelo programa. 

		System.out.println("Entre com os dados do contrato:");
		System.out.print("Número: ");
		int numero = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate data = LocalDate.parse(sc.next(), fmt); // O que o usuário digitar (no formato fmt) convertido em LocalDate e armazenado em data.
		System.out.print("Valor do contrato: R$ ");
		Double valorTotal = sc.nextDouble();

		Contrato contrato = new Contrato(numero, data, valorTotal); // Instanciação da classe Contrato.

		System.out.print("Entre com o número de parcelas: ");
		int numeroDeParcelas = sc.nextInt();

		ContratoDeServico contratoDeServico = new ContratoDeServico(new ServicoDoPaypal());

		contratoDeServico.processarContrato(contrato, numeroDeParcelas);

		System.out.println("Parcelas: ");
		for (Parcela parcela : contrato.getParcelas()) {
			System.out.println(parcela);
		}
		sc.close();
	}
}