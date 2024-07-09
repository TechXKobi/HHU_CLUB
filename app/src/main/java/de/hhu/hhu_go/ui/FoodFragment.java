package de.hhu.hhu_go.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.Arrays;

import de.hhu.hhu_go.R;
import de.hhu.hhu_go.domain.Locality;
import de.hhu.hhu_go.domain.Offer;

public class FoodFragment extends Fragment implements View.OnClickListener{
    private LinearLayout layout;
    private RecyclerView recycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_food, container, false);
        RecyclerView recycler = (RecyclerView) layout.findViewById(R.id.food_recycler);
        Locality[] foodLocalities = DummyData.foodLocalities;

        // build view for hot offers
        CaptionedImagesAdapterFood adapter = new CaptionedImagesAdapterFood(foodLocalities);
        recycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        recycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapterFood.Listener() {
            @Override
            public void onClick(int position) {
                FoodDetailsFragment frag = new FoodDetailsFragment(foodLocalities[position]);
                ((MainActivity) getActivity()).replaceFragment(position, frag);
            }
        });

        Spinner categoryFilter = (Spinner) layout.findViewById(R.id.categoryFilter);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                new String[]{"Vegan","Vegetarisch","Alles"});

        categoryFilter.setAdapter(spinnerAdapter);

        Button addEmpfehlungButton = (Button) layout.findViewById(R.id.addEmpfehlung);
        addEmpfehlungButton.setOnClickListener(this);

        Button applyFilterButton = (Button) layout.findViewById(R.id.applyFilter);
        applyFilterButton.setOnClickListener(this);

        Button resetFilterButton = (Button) layout.findViewById(R.id.resetFilter);
        resetFilterButton.setOnClickListener(this);

        this.layout = layout;
        this.recycler = recycler;
        return layout;
    }

    @Override
    public void onClick(View view){
        switch(view.getId()) {
            case R.id.addEmpfehlung:
                onAddEmpfehlung();
                break;

            case R.id.applyFilter:
                onApplyFilter();
                break;
            case R.id.resetFilter:
                onResetFilter();
                break;
        }
    }

    private void onAddEmpfehlung(){

    }

    private void onApplyFilter(){
        Spinner categoryFilter = (Spinner) layout.findViewById(R.id.categoryFilter);
        String category = String.valueOf(categoryFilter.getSelectedItem());
        boolean isAll = false;

        Locality[] foodLocalities = DummyData.foodLocalities;
        if(category.equals("Alle")){
            isAll = true;
        }

        if(!isAll)
            foodLocalities = Arrays.stream(foodLocalities)
                    .filter(l->l.getLocationCategory().equals(category))
                    .toArray(Locality[]::new);


        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                new String[]{"Vegan","Vegetarisch","Alles"});

        int categoryPos = 0;

        if(category.equals("Vegetarisch")) categoryPos=1;
        else if(category.equals("Alles")) categoryPos = 2;

        categoryFilter.setAdapter(spinnerAdapter);
        categoryFilter.setSelection(categoryPos);

        CaptionedImagesAdapterFood adapter = new CaptionedImagesAdapterFood(foodLocalities);
        recycler.setAdapter(adapter);
        setUpAdapter(foodLocalities, adapter);
    }

    private void onResetFilter(){
        Spinner categoryFilter = (Spinner) layout.findViewById(R.id.categoryFilter);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                new String[]{"Vegan","Vegetarisch","Alles"});

        categoryFilter.setAdapter(spinnerAdapter);
        categoryFilter.setSelection(2);

        Locality[] foodLocalities = DummyData.foodLocalities;

        CaptionedImagesAdapterFood adapter = new CaptionedImagesAdapterFood(foodLocalities);
        recycler.setAdapter(adapter);

        setUpAdapter(foodLocalities, adapter);
    }

    private void setUpAdapter(Locality[] foodLocalities, CaptionedImagesAdapterFood adapter){
        // build view for hot offers
        recycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        recycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapterFood.Listener() {
            @Override
            public void onClick(int position) {
                FoodDetailsFragment frag = new FoodDetailsFragment(foodLocalities[position]);
                ((MainActivity) getActivity()).replaceFragment(position, frag);
            }
        });

        Button addEmpfehlungButton = (Button) layout.findViewById(R.id.addEmpfehlung);
        addEmpfehlungButton.setOnClickListener(this);

        Button applyFilterButton = (Button) layout.findViewById(R.id.applyFilter);
        applyFilterButton.setOnClickListener(this);

        Button resetFilterButton = (Button) layout.findViewById(R.id.resetFilter);
        resetFilterButton.setOnClickListener(this);
    }
}