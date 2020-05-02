package datastructures;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("d:M:YYYY:HH");
		
		System.out.println(sdf.format(calendar.getTime()));
	}

}
