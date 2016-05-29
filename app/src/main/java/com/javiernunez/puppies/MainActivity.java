package com.javiernunez.puppies;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.javiernunez.puppies.adapter.PageAdapter;
import com.javiernunez.puppies.vista_fragment.RecyclerViewFragment;
import com.javiernunez.puppies.vista_fragment.MascotaFavoritaFragment;
import com.javiernunez.puppies.menu_opciones.acercade;
import com.javiernunez.puppies.menu_opciones.contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /* me lo llevo al fragment
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    */

    //2016-05-22
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2016-05-22
        toolbar=(Toolbar) findViewById(R.id.toolBar);
        tabLayout=(TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if(toolbar!=null){
            setSupportActionBar(toolbar);
        }

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        /* me lo llevo al fragment
        listaMascotas= (RecyclerView) findViewById(R.id.rvMascotas);
        //GridLayoutManager lm = new GridLayoutManager(this,2);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(lm);
        inicializaListaMascotas();
        inicializarAdaptador();
         */


    }


    //Menú Opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intentContacto = new Intent(this, contacto.class);
                startActivity(intentContacto);
                break;
            case R.id.mAcercaDe:
                Intent intentAcercade= new Intent(this, acercade.class);
                startActivity(intentAcercade);
                break;

        }

        return super.onOptionsItemSelected(item);
    }


    public void irActividadFavoritos(View v){
        Intent intent = new Intent(MainActivity.this, Favoritas.class);
        //intent.putExtra("listado",mascotas);
        startActivity(intent);
    }

    //2016-05-22
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new MascotaFavoritaFragment());
        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.dog);
    }

}
