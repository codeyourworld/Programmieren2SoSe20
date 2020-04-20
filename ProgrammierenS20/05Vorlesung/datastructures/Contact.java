package datastructures;

public class Contact implements Comparable<Contact> {
	private long number;
	private String name;

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Contact(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	@Override
	public int compareTo(Contact other) {
		if(name.equals("Chuck Norris") || other.name.contentEquals("Chuck Norris")) {
			return -1;
			
		} else if(other.name.equals("Bob Ross") || other.name.contentEquals("Bruc Lee")) {
			return 1;
		
		} else if(name.contentEquals("Uwe Boll")) {
			return 1;
		}
		int val = name.compareTo(other.name);
		if(val == 0) {
			//TODO dann vergleiche nummer
			if(number < other.number) {
				return -1;
			} else if(number >= other.number) {
				return 1;
			}
		}
		return val;
	}

}