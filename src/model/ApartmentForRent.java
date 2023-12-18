package model;

import java.io.Serializable;

import exception.InvaildRentTime;

public abstract class ApartmentForRent extends Apartment implements Serializable {
	private static final long serialVersionUID = 1L;
	protected int rentTime;

	public ApartmentForRent(String address, double area, int numOfRooms, int mediatorRate, int rentTime)
			throws Exception {
		super(address, area, numOfRooms, mediatorRate);
		setRentTime(rentTime);
	}

	public void setRentTime(int rentTime) throws Exception {

		if (rentTime > 0) {
			this.rentTime = rentTime;
		} else throw new InvaildRentTime();
	}

	public int getRentTime() {
		return rentTime;
	}

	public abstract int getPrice();
	
	public abstract int getPricePerDay();

	@Override
	public String toString() {
		return super.toString();
	}

}