package model;

import java.io.Serializable;

import exception.InvaildPriceInput;

public class ApartmentAirbnb extends ApartmentForRent implements Serializable{
	private static final long serialVersionUID = 1L;
	protected int pricePerDay;

	public ApartmentAirbnb(String address, double area, int numOfRooms, int mediatorRate, int rentTime, int pricePerDay)
			throws Exception {
		super(address, area, numOfRooms, mediatorRate, rentTime);
		setPricePerDay(pricePerDay);
	}

	public int getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(int pricePerDay) throws Exception {
		if (pricePerDay > 0) {
			this.pricePerDay = pricePerDay;
		} else throw new InvaildPriceInput();

	}

	public int getPrice() {
		return pricePerDay * this.rentTime;
	}

	@Override
	public int getRentTime() {
		return this.rentTime;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
