package de.hhu.hhu_go.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.time.LocalDateTime;
import java.util.Arrays;

import de.hhu.hhu_go.R;
import de.hhu.hhu_go.domain.Events;
import de.hhu.hhu_go.domain.Offer;

public class TradeFragment extends Fragment implements View.OnClickListener{
    private LinearLayout layout;
    private RecyclerView recycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_trade, container, false);
        RecyclerView recycler = (RecyclerView) layout.findViewById(R.id.trade_recycler);
        Offer[] offers = DummyData.offers;

        // build view for hot offers
        CaptionedImagesAdapterTradeAll adapter = new CaptionedImagesAdapterTradeAll(offers);
        recycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        recycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapterTradeAll.Listener() {
            @Override
            public void onClick(int position) {
                TradeDetailsFragment frag = new TradeDetailsFragment(offers[position]);
                ((MainActivity) getActivity()).replaceFragment(position, frag);
            }
        });

        Spinner categoryTradeFilter = (Spinner) layout.findViewById(R.id.categoryTradeFilter);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                new String[]{"Buch","Kleidung","Alle"});

        categoryTradeFilter.setAdapter(spinnerAdapter);

        Button addOfferButton = (Button) layout.findViewById(R.id.addOffer);
        addOfferButton.setOnClickListener(this);

        Button applyTradeFilterButton = (Button) layout.findViewById(R.id.applyTradeFilter);
        applyTradeFilterButton.setOnClickListener(this);

        Button resetTradeFilterButton = (Button) layout.findViewById(R.id.resetTradeFilter);
        resetTradeFilterButton.setOnClickListener(this);

        this.layout = layout;
        this.recycler = recycler;
        return layout;
    }

    @Override
    public void onClick(View view){
        switch(view.getId()) {
            case R.id.addOffer:
                onAddOffer();
                break;

            case R.id.applyTradeFilter:
                onApplyTradeFilter();
                break;
            case R.id.resetTradeFilter:
                onResetTradeFilter();
                break;
        }
    }

    private void onAddOffer(){

    }

    private void onApplyTradeFilter(){
        Spinner categoryTradeFilter = (Spinner) layout.findViewById(R.id.categoryTradeFilter);
        String category = String.valueOf(categoryTradeFilter.getSelectedItem());
        boolean isAll = false;

        Offer[] offers = DummyData.offers;
        if(category.equals("Alle")){
            isAll = true;
        }

        if(!isAll)
            offers = Arrays.stream(offers)
                    .filter(o->o.getCategory().equals(category))
                    .toArray(Offer[]::new);


        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                new String[]{"Buch","Kleidung","Alle"});

        int categoryPos = 0;

        if(category.equals("Kleidung")) categoryPos=1;
        else if(category.equals("Alle")) categoryPos = 2;

        categoryTradeFilter.setAdapter(spinnerAdapter);
        categoryTradeFilter.setSelection(categoryPos);

        CaptionedImagesAdapterTradeAll tradeAllAdapter = new CaptionedImagesAdapterTradeAll(offers);
        recycler.setAdapter(tradeAllAdapter);
        setUpAdapter(offers, tradeAllAdapter);
    }

    private void onResetTradeFilter(){
        Spinner categoryTradeFilter = (Spinner) layout.findViewById(R.id.categoryTradeFilter);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                new String[]{"Buch","Kleidung","Alle"});

        categoryTradeFilter.setAdapter(spinnerAdapter);
        categoryTradeFilter.setSelection(2);

        Offer[] offers = DummyData.offers;

        CaptionedImagesAdapterTradeAll adapter = new CaptionedImagesAdapterTradeAll(offers);
        recycler.setAdapter(adapter);

        setUpAdapter(offers, adapter);
    }

    private void setUpAdapter(Offer[] offers, CaptionedImagesAdapterTradeAll tradeAllAdapter){
        // build view for hot offers
        recycler.setAdapter(tradeAllAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        recycler.setLayoutManager(layoutManager);

        tradeAllAdapter.setListener(new CaptionedImagesAdapterTradeAll.Listener() {
            @Override
            public void onClick(int position) {
                TradeDetailsFragment frag = new TradeDetailsFragment(offers[position]);
                ((MainActivity) getActivity()).replaceFragment(position, frag);
            }
        });

        Button addOfferButton = (Button) layout.findViewById(R.id.addOffer);
        addOfferButton.setOnClickListener(this);

        Button applyTradeFilterButton = (Button) layout.findViewById(R.id.applyTradeFilter);
        applyTradeFilterButton.setOnClickListener(this);

        Button resetTradeFilterButton = (Button) layout.findViewById(R.id.resetTradeFilter);
        resetTradeFilterButton.setOnClickListener(this);
    }
}