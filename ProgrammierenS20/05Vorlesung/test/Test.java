package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.forEach(l -> System.err.println(l));
		Calendar cal = Calendar.getInstance();
//		cal.set(2020, Calendar.APRIL, 20);
		System.out.println(cal.getTime());
		long time = System.currentTimeMillis();
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:S d.M.yyyy");
		System.out.println(sdf.format(now.getTime()));
		
	}
}
