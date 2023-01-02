package tn.esprit.mini_tradeal_android.utils;

import androidx.room.TypeConverter;

import java.util.Date;

public class Converters {
	@TypeConverter
	public static Date fromString(String value) {
		return value == null ? null : new Date(value);
	}
	
	@TypeConverter
	public static String dateToString(Date date) {
		return String.valueOf(date == null ? null : date.getTime());
	}
}
