package com.example.mylistvie096;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataName;
    private String[] datadescription;
    private TypedArray dataPhoto;
    private HeroAdapter adapter;
    private ArrayList<Hero> heroes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new HeroAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                if (position == 0) {

                    startActivity(new Intent(MainActivity.this, Sri_HidayantiActivity.class));
                } else if (position == 1) {
                    //clicked Ahmad Dahlan
                    startActivity(new Intent(MainActivity.this, ahmad_dahlanActivity.class));
                } else if (position == 2) {
                    //clicked Ahmad Yani
                    startActivity(new Intent(MainActivity.this, ahmad_yaniActivity.class));
                } else if (position == 3) {
                    //clicked Sutomo
                    startActivity(new Intent(MainActivity.this, SoetomoActivity.class));
                } else if (position == 4) {
                    //clicked Gatot Soebroto
                    startActivity(new Intent(MainActivity.this, gatot_soebrotoActivity.class));
                } else if (position == 5) {
                    //clicked Ki Hadjar Dewantara
                    startActivity(new Intent(MainActivity.this, Ki_HajarActivity.class));
                } else if (position == 6) {
                    //clicked Mohammad Hatta
                    startActivity(new Intent(MainActivity.this, Moh_HattaActivity.class));
                } else if (position == 7) {
                    //clicked Soedirman
                    startActivity(new Intent(MainActivity.this, SoedirmanActivity.class));
                } else if (position == 8) {
                    //clicked Soepomo
                    startActivity(new Intent(MainActivity.this, SoekarnoActivity.class));
                } else if (position == 9) {
                    startActivity(new Intent(MainActivity.this, SoepomoActivity.class));
                } else {
                    startActivity(new Intent(MainActivity.this, Tan_MalakaActivity.class));


                }
            }
        });
    }

    private void prepare() {
        dataName =
                getResources().getStringArray(R.array.data_name);
        datadescription =
                getResources().getStringArray(R.array.data_description);
        dataPhoto =
                getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem() {
        heroes = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Hero hero = new Hero();
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            hero.setName(dataName[i]);
            hero.setDescription(datadescription[i]);
            heroes.add(hero);

        }
        adapter.setHeroes(heroes);

    }


}