package tickets;

public class TicketMain {

	public static void main(String[] args) {
		Ticket[] tickets = new Ticket[4];
		tickets[0] = new CinemaTicket("Into the wild", 8.50f, 148);
		tickets[1] = new CinemaTicket("WALL-E - Der letzte räumt die Erde auf", 7.00f, 198);
		tickets[2] = new ConcertTicket("Foo Fighters", 80, "05.03.2016", 4);
		tickets[3] = new ConcertTicket("Kettcar", 20, "18.07.2018", 5);
		
		for(Ticket ticket : tickets) {
			System.out.println("The ticket price is: " + ticket.calcTicketPrice());
			System.out.println(ticket);
		}
		
	}
}
