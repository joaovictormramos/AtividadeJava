package application;

import xadrez.PartidaXadrez;

public class Application {

	public static void main(String[] args) {
		
		PartidaXadrez partida = new PartidaXadrez();
		UI.printTabuleiro(partida.getPecas());
	}

}
