package tn.esprit.mini_tradeal_android.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import tn.esprit.mini_tradeal_android.Converters;
import tn.esprit.mini_tradeal_android.dao.UserDao;
import tn.esprit.mini_tradeal_android.dao.ProductDao;
import tn.esprit.mini_tradeal_android.entity.User;
import tn.esprit.mini_tradeal_android.entity.Product;

@Database(entities = {User.class, Product.class}, version = 1, exportSchema = false)

@TypeConverters({Converters.class})
public abstract class AppDataBase extends RoomDatabase {
	
	private static AppDataBase instance;
	
	public static AppDataBase getAppDatabase(Context context) {
		if (instance == null) {
			instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "trade_deal_db")
					.allowMainThreadQueries()
					.build();
		}
		return instance;
	}
	
	public abstract UserDao userDao();
	
	public abstract ProductDao productDao();
	
}
