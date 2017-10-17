package bandera;

public class Carretel {

	private double largo;

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}

	public Carretel() {
		this.setLargo(0);
	}

	public Carretel(double largo) {
		this.setLargo(largo);
	}

	public boolean cortarRetazo(double largo) {

		if (!puedeCortarDelCarretel(largo))
			return false;

		this.largo -= largo;
		return true;
	} // O(1)

	public boolean puedeCortarDelCarretel(double largo) {
		return largo <= this.largo;
	}// O(1)

}
