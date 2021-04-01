package model;

import java.time.LocalDate;
import java.util.ArrayList;

import exceptions.DayNotAvailableException;
import exceptions.UnderAgeException;

public class MiniMarket {
	
	public static ArrayList<People> arrayPeople;
	
	public ArrayList<People> getArrayPeople() {
		return arrayPeople;
	}

	public static void setArrayPeople(ArrayList<People> arrayPeople) {
		MiniMarket.arrayPeople = arrayPeople;
	}

	public MiniMarket() {
		arrayPeople = new ArrayList<>();
	}

	public int addPeople(Document document, String id)throws DayNotAvailableException, UnderAgeException {
		
		int verify = 0;
		
		int monthDay= LocalDate.now().getDayOfMonth();
		
		if(document == Document.TI) {
			throw new UnderAgeException();
		}
		
		try {
			
			int penultimate = Integer.parseInt(id.substring(id.length()-2, id.length()-1));

			if(monthDay % 2 == 0) {
				
				if(penultimate % 2 != 0) {
					addPeopleToArray(document, id);
					verify = 1;
				}else {
					verify = 2;
					throw new DayNotAvailableException();
				}
				
			}else {
				if(penultimate % 2 == 0) {
					verify = 1;
					addPeopleToArray(document, id);
				}else {
					verify = 2;
					throw new DayNotAvailableException();
				}
			}
		}catch(NumberFormatException nfe) {
			verify = -1;
		 }
		return verify;
	}
	
	public void addPeopleToArray(Document document, String id) {
		People peo = new People(document, id);
		arrayPeople.add(peo);
	}
	
	public int getLocalDate() {
		return LocalDate.now().getDayOfMonth();
	}
	
}
