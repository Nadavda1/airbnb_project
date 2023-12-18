package model;

import java.io.Serializable;

import exception.InvaildPriceInput;

public class RegularApartmentForRent extends ApartmentForRent implements Commission, Serializable{
	private static final long serialVersionUID = 1L;
	protected int pricePerMounth;

	public RegularApartmentForRent(String address, double area, int numOfRooms, int mediatorRate, int rentTime,
			int pricePerMounth) throws Exception {
		super(address, area, numOfRooms, mediatorRate, rentTime);
		setPricePerMounth(pricePerMounth);
	}

	public int getPricePerMounth() {
		return pricePerMounth;
	}

	public void setPricePerMounth(int pricePerMounth) throws Exception {

		if (pricePerMounth > 0) {
			this.pricePerMounth = pricePerMounth;
		} else throw new InvaildPriceInput();
	}

	public int getPricePerDay() {
		return pricePerMounth / 30;
	}

	@Override
	public int getRentTime() {
		return this.rentTime;
	}

	public int getPrice() {
		return pricePerMounth * this.rentTime;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public double getCommission() {
		return 4000;
	}
}
