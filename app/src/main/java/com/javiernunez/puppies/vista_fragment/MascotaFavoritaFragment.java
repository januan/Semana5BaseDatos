package com.javiernunez.puppies.vista_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.javiernunez.puppies.R;
import com.javiernunez.puppies.adapter.MiMascotaAdaptador;
import com.javiernunez.puppies.modelo.ConstructorMascotas;
import com.javiernunez.puppies.modelo.Mascota;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotaFavoritaFragment extends Fragment {

    ArrayList<Mascota> fotosMascota;
    private RecyclerView listaMascotas;

    private CircularImageView circularImageView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mascota, container,false);


        listaMascotas= (RecyclerView) v.findViewById(R.id.rvMiMascota);



        circularImageView = (CircularImageView) v.findViewById(R.id.circularImageView);
        circularImageView.setBorderWidth(5 * (int) getResources().getDisplayMetrics().density);
        circularImageView.setShadowRadius(0);
        //circularImageView.setBorderColor();


        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        listaMascotas.setLayoutManager(glm);
        inicializaListaMascotas();
        inicializarAdaptador();

        return v;

    }

    public void inicializarAdaptador(){
        //crea objeto mascotaAdaptador para que reciba la lista y que pueda hacer lo configurado
        MiMascotaAdaptador adaptador = new MiMascotaAdaptador(fotosMascota);
        listaMascotas.setAdapter(adaptador);
    }



    public void inicializaListaMascotas(){
        fotosMascota = new ArrayList<Mascota>();


        fotosMascota.add(new Mascota(R.drawable.labrador1, "Mimascota",1));
        fotosMascota.add(new Mascota(R.drawable.labrador2, "Mimascota",5));
        fotosMascota.add(new Mascota(R.drawable.labrador3, "Mimascota",2));
        fotosMascota.add(new Mascota(R.drawable.labrador4, "Mimascota",6));
        fotosMascota.add(new Mascota(R.drawable.labrador5, "Mimascota",10));
        fotosMascota.add(new Mascota(R.drawable.labrador6, "Mimascota",5));
        fotosMascota.add(new Mascota(R.drawable.labrador7, "Mimascota",3));
        fotosMascota.add(new Mascota(R.drawable.labrador8, "Mimascota",8));
        fotosMascota.add(new Mascota(R.drawable.labrador9, "Mimascota",7));

    }




}

