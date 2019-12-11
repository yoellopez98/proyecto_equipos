package com.example.proyecto_equipos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.proyecto_equipos.adaptadores.AdaptadorLigas;
import com.example.proyecto_equipos.utils.Liga;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorLigas.OnLigaListener {

    RecyclerView recyclerLigas, recyclerEquipos;
    AdaptadorLigas adaptadorLigas;
    ArrayList<Liga> listaLigas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        configurarRecyclerLigas();
        rellenarLigas();
        acciones();
    }

    private void acciones() {

    }

    private void rellenarLigas() {
        listaLigas.add(new Liga("La Liga",R.drawable.laliga));
        listaLigas.add(new Liga("Premier league",R.drawable.premiere));
        listaLigas.add(new Liga("Calcio",R.drawable.calcio));
        adaptadorLigas.notifyDataSetChanged();
    }

    private void configurarRecyclerLigas() {
        recyclerLigas.setAdapter(adaptadorLigas);
        recyclerLigas.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

    }

    private void instancias() {
        recyclerEquipos = findViewById(R.id.recycler_equipos);
        recyclerLigas = findViewById(R.id.recycler_ligas);
        listaLigas = new ArrayList();
        adaptadorLigas = new AdaptadorLigas(listaLigas, MainActivity.this);
    }


    @Override
    public void onLigaSelected(Liga liga) {
        //Toast.makeText(getApplicationContext(),"Comunicado: "+liga.getNombre(),Toast.LENGTH_SHORT).show();
    }
}
