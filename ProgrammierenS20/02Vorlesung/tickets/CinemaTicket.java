package tickets;

public class CinemaTicket extends Ticket{

	private float duration;
	
	
	public CinemaTicket(float duration, float price) {
		super();
		this.duration = duration;
		setPrice(price);
	}

	@Override
	public float calcTicketPrice() {
//		float tmp = getPrice();
//		if(duration > 180) {
//			tmp += 3;
//		}
//		return tmp;
		return (duration > 180) ? getPrice() + 3 : getPrice();
	}

//	() ? tu was, wenn es wahr ist : tu was wenn es falsch ist  
}
