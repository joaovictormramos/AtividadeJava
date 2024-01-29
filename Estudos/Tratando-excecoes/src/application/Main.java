package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reserva;

public class Main {
	public static void main(String[] args) throws ParseException {

		Scanner leitor = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Número do quarto: ");
		int numeroQuarto = leitor.nextInt();
		System.out.print("Data de check-in (dia/mês/ano): ");
		Date checkIn = sdf1.parse(leitor.next());
		System.out.print("Data de check-out (dia/mês/ano): ");
		Date checkOut = sdf1.parse(leitor.next());
		Date now = new Date();

		if (checkOut.before(checkIn)) {
			System.out.print("Erro! Data de check-out anterior ao check-in.");
		} else if (checkOut.before(now) || checkIn.before(now)) {
			System.out.print("Erro! As datas para reserva devem ser futuras.");
		} else {
			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			System.out.print("Reserva: " + reserva);
			System.out.println();
			System.out.println("\nAtualize as datas da reserva");
			System.out.print("Data de check-in (dia/mês/ano): ");
			checkIn = sdf1.parse(leitor.next());
			System.out.print("Data de check-out (dia/mês/ano): ");
			checkOut = sdf1.parse(leitor.next());

			if (!checkIn.before(now) || !checkOut.before(now)) {
				if (checkOut.before(checkIn)) {
					System.out.print("Erro! Data de check-out anterior ao check-in.");
				} else {
					reserva.atualizarDatas(checkIn, checkOut);
					System.out.print("Reserva: " + reserva);
				}
			} else {
				System.out.print("Erro! As datas para reserva devem ser futuras.");
			}
		}
		leitor.close();
	}
}
