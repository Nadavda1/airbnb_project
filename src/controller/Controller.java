package controller;

import java.io.IOException;
import java.util.ArrayList;
import model.Apartment;
import model.Client;
import model.Model;


public class Controller  {
	private Model model;

	public Controller(Model model) {
		this.model = model;
		
	}

	public boolean AddApartmentForPurchase(String address, double area, int rooms_count, int mediator_rating, int price)
			throws Exception {
		return model.AddApartmentForPurchase(address, area, rooms_count, mediator_rating, price);
	}

	public boolean AddRegularApartmentForRent(String address, double area, int numOfRooms, int mediatorRate,
			int rentTime, int pricePerMounth) throws Exception {
		return model.AddRegularApartmentForRent(address, area, numOfRooms, mediatorRate, rentTime, pricePerMounth);
	}

	public boolean AddAirBnbApartment(String address, double area, int numOfRooms, int mediatorRate, int rentTime,
			int pricePerMounth) throws Exception {
		return model.AddApartmentAirBnb(address, area, numOfRooms, mediatorRate, rentTime, pricePerMounth);
	}

	public boolean AddClientToApartment(String address, String clientName, String phoneNumber) throws Exception {
		return model.AddClientToApartment(address, clientName, phoneNumber);
	}

	public Apartment getApartmentByAddress(String address) {
		return model.getApartmentByAddress(address);
	}

	public String ShowAllApart() {
		return model.ShowAllApart();
	}

	public String showAllApartmentsWithCommission() {
		return model.showAllApartmentsWithCommission();
	}

	public String getAllSpecificApartmentPurchase() {
		return model.getAllSpecificApartmentPurchase();
	}

	public String getAllSpecificApartmentAirbnb() {
		return model.getAllSpecificApartmentAirbnb();
	}

	public String getAllSpecificRegApartmentForRent() {
		return model.getAllSpecificRegApartmentForRent();
	}

	public String showAllClients(String address) throws Exception {
		return model.showAllClients(address);
	}

	public Apartment getTheMostExpensiveApartmentForRent(int time) {
		return model.getTheMostExpensiveApartmentForRent(time);
	}
	
	public ArrayList<Client> sortClientsByName(Apartment apt) {
			return Model.sortClientsByName(apt);

	}
	public Apartment clone(Apartment tmp) throws CloneNotSupportedException {
		return model.clone(tmp);
	}
	public void saveDATA() throws IOException {
		model.saveToFile();
	}
}
