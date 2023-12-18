package model;

import java.io.Serializable;

import exception.InvaildPriceInput;

public class ApartmentForPurchase extends Apartment implements Commission, Serializable{
	private static final long serialVersionUID = 1L;
	private int price;

	public ApartmentForPurchase(String address, double area, int numOfRooms, int mediatorRate, int price)
			throws Exception {
		super(address, area, numOfRooms, mediatorRate);
		setPrice(price);
	}

	public void setPrice(int price) throws Exception {
		if (price > 0) {
			this.price = price;
		} else throw new InvaildPriceInput();

	}

	public int getPricePerDay() {
		return 0;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public double getCommission() {
		return price * 0.05;
	}
}
