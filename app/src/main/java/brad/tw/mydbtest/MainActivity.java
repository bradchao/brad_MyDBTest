package brad.tw.mydbtest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MyOpenDBHelper helper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new MyOpenDBHelper(this,"brad",null,1);
        db = helper.getReadableDatabase();
    }

    public void insert(View v){
        // INSERT INTO cust (cname,tel,birthday) VALUES ('brad','123','1919-12-12');
        //db.execSQL();
        ContentValues values = new ContentValues();
        values.put("cname", "brad");
        values.put("tel", "123");
        values.put("birthday", "1919-12-12");
        db.insert("cust",null,values);
        query(null);
    }


    public void query(View v){
        // SELECT * FROM cust
        //db.rawQuery()
        Cursor c = db.query("cust",null,null,null,null,null,null);
        while (c.moveToNext()){
            String id = c.getString(0);
            String cname = c.getString(1);
            String tel = c.getString(2);
            String birthday = c.getString(3);
            Log.v("brad", id + ":" + cname + ":" + tel +":" + birthday);
        }
    }


}
