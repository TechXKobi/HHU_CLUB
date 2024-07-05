package de.hhu.hhu_go.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import de.hhu.hhu_go.R;
import de.hhu.hhu_go.domain.Events;
import de.hhu.hhu_go.domain.Locality;

public class LocalityFragment extends Fragment implements View.OnClickListener{

    private LinearLayout layout;
    private RecyclerView hhuRecycler;
    private RecyclerView secondRecycler;
    private RecyclerView thirdRecycler;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_locality, container, false);
        RecyclerView hhuRecycler = layout.findViewById(R.id.hhu_locality_recycler);
        Locality[] hhuLocalities = DummyData.hhuLocalities;

        // build view for hhu locality
        CaptionedImagesAdapterLocality hhuAdapter = new CaptionedImagesAdapterLocality(hhuLocalities);
        hhuRecycler.setAdapter(hhuAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        hhuRecycler.setLayoutManager(layoutManager);

        hhuAdapter.setListener(new CaptionedImagesAdapterLocality.Listener() {
            @Override
            public void onClick(int position) {
                LocalityDetailsFragment frag = new LocalityDetailsFragment(hhuLocalities[position]);
                ((MainActivity) getActivity()).replaceFragment(position, frag);
            }
        });

        // build view for downtown localities
        RecyclerView secondRecycler = (RecyclerView) layout.findViewById(R.id.second_locality_recycler);
        Locality[] localities = DummyData.localities;

        CaptionedImagesAdapterLocality secondAdapter = new CaptionedImagesAdapterLocality(localities);
        secondRecycler.setAdapter(secondAdapter);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        secondRecycler.setLayoutManager(layoutManager2);

        secondAdapter.setListener(new CaptionedImagesAdapterLocality.Listener() {
            @Override
            public void onClick(int position) {
                LocalityDetailsFragment frag = new LocalityDetailsFragment(localities[position]);
                ((MainActivity) getActivity()).replaceFragment(position, frag);
            }
        });

        // build view for rhine attractions
        RecyclerView thirdRecycler = (RecyclerView) layout.findViewById(R.id.third_locality_recycler);
        Locality[] localities2 = DummyData.localities2;

        CaptionedImagesAdapterLocality thirdAdapter = new CaptionedImagesAdapterLocality(localities2);
        thirdRecycler.setAdapter(thirdAdapter);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        thirdRecycler.setLayoutManager(layoutManager3);

        thirdAdapter.setListener(new CaptionedImagesAdapterLocality.Listener() {
            @Override
            public void onClick(int position) {
                LocalityDetailsFragment frag = new LocalityDetailsFragment(localities2[position]);
                ((MainActivity) getActivity()).replaceFragment(position, frag);
            }
        });

        Button addLocalityButton = (Button) layout.findViewById(R.id.addLocality);
        addLocalityButton.setOnClickListener(this);

        this.layout = layout;
        this.hhuRecycler = hhuRecycler;
        this.secondRecycler = secondRecycler;
        this.thirdRecycler = thirdRecycler;

        return layout;
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.addLocality:
                onAddLocality();
                break;
        }
    }

    private void onAddLocality(){}
}