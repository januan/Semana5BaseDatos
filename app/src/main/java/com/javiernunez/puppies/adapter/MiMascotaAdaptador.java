package com.javiernunez.puppies.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.javiernunez.puppies.R;
import com.javiernunez.puppies.modelo.Mascota;

import java.util.ArrayList;

/**
 * Created by Javier Núñez on 22/05/2016.
 */
public class MiMascotaAdaptador extends RecyclerView.Adapter<MiMascotaAdaptador.MiMascotaViewHolder>{

    ArrayList<Mascota> mascotas;

    public MiMascotaAdaptador(ArrayList<Mascota> mascotas){
        //contructor para pasarle la lista de mascotas
        this.mascotas=mascotas;
    }


    @Override
    public MiMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Infla nuestro layout cardview y lo pasa al ViewHolder para que obtenga cada elemento (los views)
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mi_mascota,parent,false);
        return new MiMascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MiMascotaViewHolder miMascotaViewHolder, int position) {
        //Asocia cada elemento de la lista con cada view
        Mascota mascota = mascotas.get(position);

        miMascotaViewHolder.imgFotoCV2.setImageResource(mascota.getFoto());
        //mascotaViewHolder.tvNombreCV2.setText(mascota.getNombre());
        miMascotaViewHolder.tvPuntosCV2.setText(String.valueOf(mascota.getPuntos()));
    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class MiMascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoCV2;
        //private TextView tvNombreCV;
        private TextView tvPuntosCV2;

        public MiMascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoCV2   =(ImageView) itemView.findViewById(R.id.imgFotoCV2);
            //tvNombreCV  =(TextView) itemView.findViewById(R.id.tvNombreCV);
            tvPuntosCV2  =(TextView) itemView.findViewById(R.id.tvPuntosCV2);

        }
    }
}

