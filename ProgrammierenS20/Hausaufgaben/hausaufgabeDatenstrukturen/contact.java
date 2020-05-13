package hausaufgabeDatenstrukturen;

import java.util.ArrayList;
import java.util.Collections;

import datastructures.Contact;

public class contact implements Comparable<contact> {

	private String name;
	private int number;

	public contact(String name, int number) {
		super();
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int points) {
		this.number = number;
	}


	public static void main(String[] args) {
		ArrayList<contact> Contact = new ArrayList<>();
		Contact.add(new contact("SubjectA", 1234567));
		Contact.add(new contact("SubjectC", 9876543));
		Contact.add(new contact("SubjectB", 1111111));
		Contact.add(new contact("SubjectI", 4242424));
		Contact.add(new contact("SubjectJ", 0000001));
	
		Collections.sort(Contact);
		
		for (contact Data : Contact) {
		System.out.println(String.format("%20s:\t%d", Data.name, Data.number));
		}
	}

	@Override
	public int compareTo(contact other) {
		int val = name.compareTo(other.name);
		if(val==0) {
			if(number < other.number) {
				return -1;
			}else if(number <= other.number) {
				return 1;
			}
		}
		return val;
	}
	
}