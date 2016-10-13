package brad.tw.mydbtest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MyOpenDBHelper helper;
    private SQLiteDatabase db;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv);

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

    public void delete(View v){
        // DELETE FROM cust WHERE id = 3 and cname = 'brad'
        db.delete("cust","id = ? and cname = ?",new String[]{"3","brad"});
        query(null);
    }

    public void update(View v){
        // UPDATE cust SET cname='peter',tel='321' WHERE id = 5;
        ContentValues values = new ContentValues();
        values.put("cname", "peter");
        values.put("tel", "321");
        db.update("cust",values,"id = ?",new String[]{"5"});
        query(null);
    }


    public void query(View v){
        // SELECT * FROM cust WHERE .... GROUP BY ... HAVING ... ORDER BY ...
        //db.rawQuery()
        tv.setText("");
        Cursor c = db.query("cust",new String[]{"id","cname","tel","birthday"},
                null,null,null,null,"cname desc");
        while (c.moveToNext()){
            String id = c.getString(c.getColumnIndex("id"));
            String cname = c.getString(c.getColumnIndex("cname"));
            String tel = c.getString(c.getColumnIndex("tel"));
            String birthday = c.getString(c.getColumnIndex("birthday"));
            tv.append(id + ":" + cname + ":" + tel +":" + birthday + "\n");
        }
    }


}
