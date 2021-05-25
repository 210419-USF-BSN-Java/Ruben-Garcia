package driver;

import java.util.Calendar;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Date utilDate = new java.util.Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(utilDate);
		cal.set(Calendar.MILLISECOND, 0);
		java.sql.Timestamp time = new java.sql.Timestamp(utilDate.getTime()); 
		System.out.println(time);
	}

}
