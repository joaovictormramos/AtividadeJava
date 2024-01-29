package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import models.entities.Reserva;
import models.exceptions.DominioException;

public class Main {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Número do quarto: ");
			int numeroQuarto = leitor.nextInt();
			System.out.print("Data de check-in (dia/mês/ano): ");
			Date checkIn = sdf1.parse(leitor.next());
			System.out.print("Data de check-out (dia/mês/ano): ");
			Date checkOut = sdf1.parse(leitor.next());
			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			System.out.print("Reserva: " + reserva);
			System.out.println();
			System.out.println("\nAtualize as datas da reserva");
			System.out.print("Data de check-in (dia/mês/ano): ");
			checkIn = sdf1.parse(leitor.next());
			System.out.print("Data de check-out (dia/mês/ano): ");
			checkOut = sdf1.parse(leitor.next());
			reserva.atualizarDatas(checkIn, checkOut);
			System.out.print("Reserva: " + reserva);
		} catch (ParseException e) {
			System.out.print("Data inválida.");
		} catch (DominioException e) {
			System.out.print(e.getMessage());
		} catch (RuntimeException e) {
			System.out.print("Erro inesperado.");
		}
		leitor.close();
	}
}
