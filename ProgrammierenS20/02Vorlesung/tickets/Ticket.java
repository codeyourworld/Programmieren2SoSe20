package tickets;

public abstract class Ticket {

	private float price;
	
	public abstract float calcTicketPrice();

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
