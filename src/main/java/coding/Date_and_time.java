package coding;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Date_and_time {

	public static void main(String[] args) throws ParseException {
		//String locale = "1033";
		/*DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		Date date = dateFormat.parse("2012-02-02T14:12:12Z");
		
		SimpleDateFormat format = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT, Locale.forLanguageTag("en-IN"));//Locale.forLanguageTag("en"));
		
		String pattern = format.toPattern();
		if(pattern.startsWith("yy")) {
			pattern = "yy" + pattern;
		} else {
			pattern = pattern + "yy";
		}
		System.out.println(pattern);
		
		DateFormat df = new SimpleDateFormat(pattern + " HH:MM");
		
		String d2 = df.format(date);
		System.out.println(d2);*/
		
		
		String bcpCode2 = "en-US";
		Locale locale = Locale.forLanguageTag(bcpCode2);
		DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", locale);
		Date date2 = dateFormat2.parse("2019-03-32T12:12:12Z");
		SimpleDateFormat format2 = (SimpleDateFormat) dateFormat2.getDateInstance(DateFormat.SHORT, locale);
		String pattern2 = format2.toPattern();
		pattern2 = pattern2.startsWith("yy") ? "yy" + pattern2 : pattern2 + "yy";
		pattern2 += " hh:mm";
		DateFormat resDateFormat2 = new SimpleDateFormat(pattern2, locale);
		String res2 = resDateFormat2.format(date2);
		System.out.println(res2);
	}
}
