package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;





public class Model implements Serializable {
	private Office office;
	File f = new File("finalProject.bin");
	public Model() {
		this.office = new Office();
		File f = new File("finalProject.bin");
		if (f.exists()) {
			try {
				this.office = readFile();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			office = Office.setTheReadyApartments();

		}
	}

	public boolean AddApartmentForPurchase(String address, double area, int numOfRooms, int mediatorRate, int price)
			throws Exception {
		ApartmentForPurchase apt = new ApartmentForPurchase(address, area, numOfRooms, mediatorRate, price);
		return office.addApartment(apt);
	}

	public boolean AddRegularApartmentForRent(String address, double area, int numOfRooms, int mediatorRate,
			int rentTime, int pricePerMounth) throws Exception {
		RegularApartmentForRent apt = new RegularApartmentForRent(address, area, numOfRooms, mediatorRate, rentTime,
				pricePerMounth);
		return this.office.addApartment(apt);
	}

	public boolean AddApartmentAirBnb(String address, double area, int numOfRooms, int mediatorRate, int rentTime,
			int pricePerDay) throws Exception {
		ApartmentAirbnb apt = new ApartmentAirbnb(address, area, numOfRooms, mediatorRate, rentTime, pricePerDay);
		return this.office.addApartment(apt);
	}

	public Apartment getApartmentByAddress(String address) {
		return office.getApartmentByAddress(address);
	}

	public boolean AddClientToApartment(String address, String clientName, String phoneNumber) throws Exception  {
		Client client = new Client(clientName, phoneNumber);
		Apartment apt = office.getApartmentByAddress(address);
		return apt.addClient(client);
	}

	public String ShowAllApart() {
		return office.ShowAllApart();
	}

	public String showAllApartmentsWithCommission() {
		return office.showAllApartmentsWithCommission();
	}

	public String getAllSpecificApartmentPurchase() {
		return office.getAllSpecificApartmentPurchase();
	}

	public String getAllSpecificApartmentAirbnb() {
		return office.getAllSpecificApartmentAirbnb();
	}
	public String getAllSpecificRegApartmentForRent() {
		return office.getAllSpecificRegApartmentForRent();
	}
	public String showAllClients(String address) throws Exception {
		Apartment apt = getApartmentByAddress(address);
		return apt.showAllClients();
	}
	
	public Apartment getTheMostExpensiveApartmentForRent(int time) {
		 return office.getTheMostExpensiveApartmentForRent(time);
	}
	
	public Apartment clone(Apartment tmp) throws CloneNotSupportedException {
		Apartment tmp1 = getApartmentByAddress(tmp.getAddress());
		ArrayList<Client> allClients = tmp.getAllClients();
		tmp1 = (Apartment) super.clone();
		allClients = new ArrayList<Client>();
		for (Client c : allClients) {
			Client tmpClient = (Client) c.clone();
			allClients.add(tmpClient);
		}
		return tmp1;
	}
	public static ArrayList<Client> sortClientsByName(Apartment apt) {
		ArrayList<Client> allClients = apt.getAllClients();
		int n = allClients.size();
		int i, IndMax; // IndMax is for the index of the maximum
		for (; n > 1; n--) {
			for (IndMax = 0, i = 1; i < n; i++)
				if (allClients.get(IndMax).getName().compareTo(allClients.get(i).getName()) < 0)
					IndMax = i;
			swap(allClients, n - 1, IndMax);
		}

		return allClients;

	}
	public static void swap(ArrayList<Client> a, int i, int j) {
		Client tmp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, tmp);
		
	}
	
	public static Office readFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream i = new ObjectInputStream(new FileInputStream("finalProject.bin"));
		Office o = (Office) i.readObject();
		int lastId = Integer.parseInt(i.readUTF());
		Apartment.setIdGenerator(lastId);
		i.close();
		return o;
	}
	public void saveToFile() throws FileNotFoundException, IOException {
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("finalProject.bin"));
		int lastId = Apartment.getIdGenerator();
		o.writeObject(this.office);
		o.writeUTF(Integer.toString(lastId));
		o.close();
	}
	
	
}