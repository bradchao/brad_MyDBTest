package brad.tw.mydbtest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 2016/10/13.
 */

public class MyOpenDBHelper extends SQLiteOpenHelper {
    private final static String createTable =
            "CREATE TABLE cust (id INTEGER PRIMARY KEY AUTOINCREMENT,cname TEXT,tel TEXT,birthday DATE)";
    public MyOpenDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
