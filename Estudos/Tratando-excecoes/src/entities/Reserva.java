package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva() {
	}

	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
		super();
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diferenca = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}

	public String atualizarDatas(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Erro! As datas para reserva devem ser futuras.";
		} else {
			if (checkOut.before(checkIn)) {
				return "Erro! Data de check-out anterior ao check-in.";
			} else {
				this.checkIn = checkIn;
				this.checkOut = checkOut;
				return null;
			}
		}
	}

	@Override
	public String toString() {
		return "Quarto " + getNumeroQuarto() + ", Check-In: " + sdf1.format(getCheckIn()) + ", Check-out: "
				+ sdf1.format(getCheckOut()) + ", " + duration() + " noites.";
	}

}
