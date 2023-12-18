package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;

import exception.ApartmentAlredyExistExc;




public class Office implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<Apartment> allApartment;

	public Office(String name) {
		this.name = name;
		this.allApartment = new ArrayList<Apartment>();
	}
	
	public Office() {
		this.name = "";
		this.allApartment = new ArrayList<Apartment>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Apartment> getAllApartment() {
		return allApartment;
	}

	public boolean addApartment(Apartment apartment)throws Exception {
		if (allApartment.contains(apartment)) {
			throw new ApartmentAlredyExistExc();
		}
		allApartment.add(apartment);
		return true;
	}

	public Apartment getApartmentByAddress(String address) {
		for (int i = 0; i < allApartment.size(); i++) {
			if (allApartment.get(i).getAddress().equalsIgnoreCase(address))
				return allApartment.get(i);
		}

		return null;
	}

	public String getAllSpecificApartmentPurchase() {
		String str = "The apartment for purchase is:\n";
		for (int i = 0; i < allApartment.size(); i++) {
			if (allApartment.get(i) instanceof ApartmentForPurchase) {
				str += allApartment.get(i).toString() + "\n";
			}
		}
		return str;
	}
	
	public String getAllSpecificApartmentAirbnb() {
		String str = "The airbnb apartment is:\n";
		for (int i = 0; i < allApartment.size(); i++) {
			if (allApartment.get(i) instanceof ApartmentAirbnb) {
				str += allApartment.get(i).toString() + "\n";
			}
		}
		return str;
	}
	
	public String getAllSpecificRegApartmentForRent() {
		String str = "The apartment for regular rent is:\n";
		for (int i = 0; i < allApartment.size(); i++) {
			if (allApartment.get(i) instanceof RegularApartmentForRent) {
				str += allApartment.get(i).toString() + "\n";
			}
		}
		return str;
	}

	public Apartment getTheMostExpensiveApartmentForRent(int time) {
		Apartment tmp = null;
		for (int i = 0; i < allApartment.size(); i++) {

			if (allApartment.get(i) instanceof ApartmentForRent) {
				if (tmp == null || allApartment.get(i).getPricePerDay() * time > tmp.getPricePerDay() * time) {
					tmp = allApartment.get(i);
				}
			}
		}
		if (tmp == null) {
			return null;
		} else
			return tmp;
	}

	public String showAllApartmentsWithCommission() {
		String str;
		str = "The apartments with commission:\n";
		for (int i = 0; i < allApartment.size(); i++) {
			str += (i + 1) + " - " + allApartment.get(i).getAddress();
			if (allApartment.get(i) instanceof Commission) {
				str += " his commission is :" + ((Commission) allApartment.get(i)).getCommission();
			}
			str += "\n";
		}
		return str;
	}

	public String ShowAllApart() {
		String str;
		str = "Office " + name + " has " + allApartment.size() + " apartments: " + "\nThe apartments:\n";
		for (int i = 0; i < allApartment.size(); i++) {
			str += i + 1 + " - " + allApartment.get(i).getClass().getSimpleName() + " ," + allApartment.get(i) + "\n";
		}
		return str;
	}
	
	@Override
	public String toString() {
		String str = "Office " + name + " has " + allApartment.size() + " apartments: " + "\nThe apartments:\n";
		for (int i = 0; i < allApartment.size(); i++) {
			str += i + 1 + " - " + allApartment.get(i).getClass().getSimpleName() + " ," + allApartment.get(i) + "\n";
		}

		return str;
	}
	public static Office setTheReadyApartments() {
		
		Office o1 = new Office("Afeka");
		o1 = new Office("Afeka");
		try {
		Client c1 = new Client("Nadav", "100000");
		Client c2 = new Client("Guy", "100001");
		Client c3 = new Client("Tomer", "100002");
		Client c4 = new Client("Koral", "100003");
		Client c5 = new Client("Marry", "100004");
		Client c6 = new Client("Carmel", "100005");
		Client c7 = new Client("Ido", "100006");
		Client c8 = new Client("Yona", "100007");
		Client c9 = new Client("Lee", "100008");
		Client c10 = new Client("Roee", "100009");
		Client c11 = new Client("Shahar", "100010");
		Client c12 = new Client("Saar", "100011");
		Client c13 = new Client("Yarden", "100012");
		Client c14 = new Client("Efi", "100013");
		Client c15 = new Client("Ricardo", "100014");
		Client c16 = new Client("Max", "100015");
		Client c17 = new Client("Alex", "100016");
		Client c18 = new Client("Dan", "100017");
		Client c19 = new Client("Omri", "100018");
		Client c20 = new Client("Yuval", "100019");
		
		
			Apartment a1 = new ApartmentForPurchase("Vainshel-21", 6, 5, 9, 4000000);
			a1.addClient(c1);
			a1.addClient(c2);
			a1.addClient(c3);
			a1.addClient(c4);
			Apartment a2 = new ApartmentForPurchase("Menora-34", 4, 4, 7, 2000000);
			a2.addClient(c5);
			a2.addClient(c6);
			a2.addClient(c7);
			a2.addClient(c8);
			Apartment a3 = new ApartmentForPurchase("Reuven-Rubin-14", 5, 4, 8, 3500000);
			a3.addClient(c9);
			a3.addClient(c10);
			a3.addClient(c11);
			a3.addClient(c12);
			Apartment a4 = new ApartmentForPurchase("Rotshild-45", 5, 5, 10, 5000000);
			a4.addClient(c13);
			a4.addClient(c14);
			a4.addClient(c15);
			a4.addClient(c16);

			Apartment ab1 = new ApartmentAirbnb("Ben-Yhuda-52", 4, 3, 7, 5, 350);
			ab1.addClient(c17);
			ab1.addClient(c18);
			ab1.addClient(c19);
			ab1.addClient(c20);
			Apartment ab2 = new ApartmentAirbnb("Timna-50", 10, 5, 8, 4, 150);
			ab2.addClient(c1);
			ab2.addClient(c2);
			ab2.addClient(c3);
			ab2.addClient(c4);
			Apartment ab3 = new ApartmentAirbnb("Ben-Gurion-19", 6, 4, 4, 4, 250);
			ab3.addClient(c5);
			ab3.addClient(c6);
			ab3.addClient(c7);
			ab3.addClient(c8);
			Apartment ab4 = new ApartmentAirbnb("Haasger-4", 2, 3, 7, 5, 355);
			ab4.addClient(c9);
			ab4.addClient(c10);
			ab4.addClient(c11);
			ab4.addClient(c12);

			Apartment ar1 = new RegularApartmentForRent("Cafrisin-8", 4, 3, 7, 4, 1550);
			ar1.addClient(c13);
			ar1.addClient(c14);
			ar1.addClient(c15);
			ar1.addClient(c16);
			Apartment ar2 = new RegularApartmentForRent("Menora-14", 3, 4, 6, 5, 1400);
			ar2.addClient(c17);
			ar2.addClient(c18);
			ar2.addClient(c19);
			ar2.addClient(c20);
			Apartment ar3 = new RegularApartmentForRent("Even-Gvirol-33", 5, 5, 8, 5, 3500);
			ar3.addClient(c1);
			ar3.addClient(c2);
			ar3.addClient(c3);
			ar3.addClient(c4);
			Apartment ar4 = new RegularApartmentForRent("Dizingof-120", 6, 5, 9, 5, 4000);
			ar4.addClient(c5);
			ar4.addClient(c6);
			ar4.addClient(c7);
			ar4.addClient(c8);

			o1.addApartment(a1);
			o1.addApartment(a2);
			o1.addApartment(a3);
			o1.addApartment(a4);
			o1.addApartment(ab1);
			o1.addApartment(ab2);
			o1.addApartment(ab3);
			o1.addApartment(ab4);
			o1.addApartment(ar1);
			o1.addApartment(ar2);
			o1.addApartment(ar3);
			o1.addApartment(ar4);
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return o1;

	}
}
