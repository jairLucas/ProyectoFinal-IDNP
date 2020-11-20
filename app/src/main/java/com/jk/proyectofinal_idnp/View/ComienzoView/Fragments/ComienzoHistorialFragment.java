package com.jk.proyectofinal_idnp.View.ComienzoView.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jk.proyectofinal_idnp.Adapters.RecyclerView.RecyclerAdapter;
import com.jk.proyectofinal_idnp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ComienzoHistorialFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ComienzoHistorialFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recycler;
    ArrayList<String>  lista_items;

    public ComienzoHistorialFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ComienzoHistorialFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ComienzoHistorialFragment newInstance(String param1, String param2) {
        ComienzoHistorialFragment fragment = new ComienzoHistorialFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_comienzo_historial, container, false);
        recycler = vista.findViewById(R.id.recyclerView_historial);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        lista_items = new ArrayList<String>();
        llenarLista();
        RecyclerAdapter adapter = new RecyclerAdapter(lista_items);
        recycler.setAdapter(adapter);
        return vista;
    }
    private void llenarLista(){
        for (int i=1; i<50; i++){
            lista_items.add(i+".\t Trayectoria \t\t\t\t Dia \t\t\t\t Tiempo \t\t\t");
        }
    }
}