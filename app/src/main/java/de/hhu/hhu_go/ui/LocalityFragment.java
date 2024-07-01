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

        Button addLocalityButton = (Button) layout.findViewById(R.id.addLocality);
        addLocalityButton.setOnClickListener(this);

        this.layout = layout;
        this.hhuRecycler = hhuRecycler;

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