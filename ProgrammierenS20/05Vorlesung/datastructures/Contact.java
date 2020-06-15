package datastructures;

import java.io.Serializable;

public class Contact implements Comparable<Contact>, Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private int handynr;
	
	
	public Contact(String name, int handynr) {
		super();
		this.name = name;
		this.handynr = handynr;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getHandynr() {
		return handynr;
	}


	public void setHandynr(int handynr) {
		this.handynr = handynr;
	}
	
	@Override
	public int compareTo(Contact other) {
		if(name.equals("Ami Mizuno")) {
			return -1;
		}
		else if(other.name.equals("Ami Mizuno")){
			return 1;
		}
		else if(other.name.equals("Makoto Kino")|| other.name.contentEquals("Rei Hino")) {
			return 1;
		}
		else if(name.contentEquals("Bunny Tsukino")) {
			return 1;
		}
		int val= name.compareTo(other.name);
		if(val ==0) {
			//TODO dann vergleiche Nummer
			if(handynr < other.handynr) {
				return -1;
			} else if(handynr >= other.handynr) {
				return 1;
			}
		}

		return val;

	}
	

}