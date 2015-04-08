package com.beer.wass.mobcostcontrol;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    String[] names = {"Автомобиль", "Квартплата", "Кредиты", "Развлечения", "Другое"};
    ListView listView = null;
    Animation anim = null;
    Button btn_add = null;
    Button btn_del = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.checked_list, names);
        listView.setAdapter(adapter);

        btn_add = (Button) findViewById(R.id.button);
        btn_del = (Button) findViewById(R.id.button2);

        btn_add.setOnClickListener(this);
        btn_del.setOnClickListener(this);

        anim = AnimationUtils.loadAnimation(this, R.anim.btn_anim);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.button:
                btn_add.startAnimation(anim);
                intent = new Intent("com.beer.wass.mobcostcontrol.addgroup");
                startActivity(intent);
                break;
            case R.id.button2:
                btn_del.startAnimation(anim);
                SparseBooleanArray sbArray = listView.getCheckedItemPositions();
                if (sbArray.size() == 0){
                    Toast.makeText(this, "no items", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(this, "qqq", Toast.LENGTH_LONG).show();
                }
                break;
        }


    }

    class DBHelper extends SQLiteOpenHelper{

        public DBHelper(Context context) {
            super(context, "CostControl", null, 1);
        }

        @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table groups ("
                    + "id integer primary key autoincrement,"
                    + "name text"  + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}
}
