package es.enylrad.economy.mymoney.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;

import java.util.ArrayList;

import es.enylrad.economy.mymoney.R;
import es.enylrad.economy.mymoney.adapter.ConceptoAdapter;
import es.enylrad.economy.mymoney.clases.Concepto;

public class GastosFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerViewMaterialAdapter mAdapter;

    private View view;

    // Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static GastosFragment newInstance(int page, String title) {
        GastosFragment fragmentFirst = new GastosFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("1", 1);
        title = getArguments().getString("Gastos");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.gastos_fragment, container, false);

        configReferences();
        configRecyclerView();

        return view;
    }

    private void configRecyclerView() {

        ArrayList<Concepto> conceptos = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int random = (int) (Math.random() * ((-20) + 1));
            conceptos.add(new Concepto(random));
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        mAdapter = new RecyclerViewMaterialAdapter(new ConceptoAdapter(conceptos, getActivity()));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(layoutManager);

        MaterialViewPagerHelper.registerRecyclerView(getActivity(), mRecyclerView, null);


    }

    private void configReferences() {

        mRecyclerView = (RecyclerView) view.findViewById(R.id.gastos_recycler);

    }
}