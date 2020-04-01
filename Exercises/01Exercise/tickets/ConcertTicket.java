package tickets;

public class ConcertTicket extends Ticket {

	private String date = "Not set";
	private int seatRow = 0;

	public ConcertTicket(String concertName, float price, String date, int seatRow) {
		super(concertName, price);
		this.date = date;
		this.seatRow = seatRow;
	}

	@Override
	public float calcTicketPrice() {
		return getPrice() + getPrice()/seatRow;
	}

	public int getSeatRow() {
		return seatRow;
	}

	public String getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "ConcertTicket \"" + getEventName() + "\"\nPrice: " + calcTicketPrice() + "\nSeat row: " + seatRow
				+ "\nDate: " + date + "\n";
	}
	
	

}
