package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entitites.Pessoa;
import entitites.PessoaFisica;
import entitites.PessoaJuridica;

public class Main {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		List<Pessoa> lista = new ArrayList<>();
		System.out.print("Entre com o número de pagadores de impostos: ");
		int n = leitor.nextInt();
		for(int i = 1; i <= n; i++) {
			System.out.println("Dados do pagador #"+i+": ");
			System.out.print("Pessoa física ou jurídica (f/j)? ");
			char opc = leitor.next().charAt(0);
			
			System.out.print("Nome: ");
			String nome = leitor.next();
			System.out.print("Renda anual: ");
			double renda = leitor.nextDouble();
		
			if(opc == 'f') {
				System.out.print("Gastos com saúde: ");
				double gastoComSaude = leitor.nextDouble();
				lista.add(new PessoaFisica(nome, renda, gastoComSaude));				
			}
			else {
				System.out.print("Quantidade de funcionários: ");
				int funcionarios = leitor.nextInt();
				lista.add(new PessoaJuridica(nome, renda, funcionarios));
			}
			
		}
		double impostoTotal = 0;
		
		System.out.println("\nImpostos pagos: ");
		for(Pessoa pessoa : lista) {
			System.out.print(pessoa.impostoPago());
			impostoTotal = impostoTotal + pessoa.declaraImposto();
		}
		System.out.print("\nTotal de impostos: $ "+ impostoTotal);
		
		leitor.close();
	}
}
