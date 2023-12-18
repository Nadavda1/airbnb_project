package model;

import java.io.Serializable;
import java.util.ArrayList;

import exception.ClientAlreadyExistExc;
import exception.InvaildAreaInput;
import exception.InvaildMediatorRate;
import exception.InvaildNumOfRoomsExc;


public abstract class Apartment implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	public static int idGenerator = 1000;
	private int id;
	protected String address;
	private double area;
	private int numOfRooms;
	private int mediatorRate;
	private ArrayList<Client> allClients;

	public Apartment(String address, double area, int numOfRooms, int mediatorRate) throws Exception {
		this.id = idGenerator++;
		this.address = address;
		setArea(area);
		setNumOfRooms(numOfRooms);
		setMediatorRate(mediatorRate);
		this.allClients = new ArrayList<Client>();
	}
	
	public static int getIdGenerator() {
		return idGenerator;
	}

	public static void setIdGenerator(int idGenerator) {
		Apartment.idGenerator = idGenerator;
	}

	public int getNumOfRooms() {
		return numOfRooms;
	}

	public void setNumOfRooms(int numOfRooms) throws Exception {
		if (numOfRooms > 0) {
			this.numOfRooms = numOfRooms;
		} else throw new InvaildNumOfRoomsExc();

	}

	public int getMediatorRate() {
		return mediatorRate;
	}

	public void setMediatorRate(int mediatorRate) throws Exception {
		if (mediatorRate > 0 && mediatorRate <= 10) {
			this.mediatorRate = mediatorRate;
		} else throw new InvaildMediatorRate();

	}

	public int getId() {
		return id;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) throws Exception {
		if (area > 0) {
			this.area = area;
		} else throw new InvaildAreaInput();
	}

	public abstract int getPrice();

	public abstract int getPricePerDay();

	public ArrayList<Client> getAllClients() {
		return allClients;
	}

	@Override
	public boolean equals(Object obj) {
		Apartment tmp = (Apartment) obj;
		return tmp.address.equalsIgnoreCase(address);
	}

	public boolean addClient(Client client)throws Exception {
		if (allClients.contains(client)) {
			throw new ClientAlreadyExistExc();
		}
		allClients.add(client);
		return true;
	}

	public String showAllClients() {
		String str = "This apartment has " + allClients.size() + " clients:\n";
		for (int i = 0; i < allClients.size(); i++) {
			str += i + 1 + " - " + allClients.get(i) + "\n";
		}
		return str;
	}

	public static void swap(ArrayList<Client> allClients, int i, int j) {
		Client tmp = allClients.get(i);
		allClients.set(i, allClients.get(j));
		allClients.set(j, tmp);

	}

	public void sort() {
		int i, IndMax;
		for (int n = allClients.size(); n > 1; n--) {
			for (IndMax = 0, i = 1; i < n; i++)
				if (allClients.get(IndMax).getName().compareToIgnoreCase(allClients.get(i).getName()) < 0)
					IndMax = i;
			swap(allClients, n - 1, IndMax);
		}
	}

	public Apartment clone() throws CloneNotSupportedException {
		Apartment tmp = (Apartment) super.clone();
		tmp.allClients = new ArrayList<Client>();
		for (Client c : this.allClients) {
			Client tmpClient = (Client) c.clone();
			tmp.allClients.add(tmpClient);
		}
		return tmp;
	}

	@Override
	public String toString() {
		return "Apartment " + id + " ,in " + address + " ,with " + area + " meter area" + " ,number of rooms: "
				+ numOfRooms + " ,the mediator's rating is: " + mediatorRate;

	}
}