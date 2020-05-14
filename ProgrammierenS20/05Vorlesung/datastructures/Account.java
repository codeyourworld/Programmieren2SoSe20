package datastructures;



public class Account {
	
	public String name;
	public long number;
	
	

	public Account(String name,long number) {
		super();
		this.number = number;
		this.name = name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setNumber(long number) {
		this.number=number;
	}
	
	public String getName() {
		return name;
	}
	
	public long getNumber() {
		return number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (number ^ (number >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		return true;
	}
	
}
