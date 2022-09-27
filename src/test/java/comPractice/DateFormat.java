package comPractice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

	public static void main(String[] args) throws ParseException {
		Date d = new Date();
		String d1 = d.toString();
		String[] arr = d1.split(" ");
		String DD = arr[2];
		int MM = d.getMonth()+1;
		String YYYY = arr[5];
		
		
		String DDMMYYYY = DD+"-"+MM+"-"+YYYY;
		
		
		SimpleDateFormat sdf =  new SimpleDateFormat("DD-MM-YYYY");
		Date date = sdf.parse(DDMMYYYY);
		
		System.out.println(date);
		
	}
}
