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

import java.util.Arrays;

import de.hhu.hhu_go.R;
import de.hhu.hhu_go.domain.Events;

public class EventsFragment extends Fragment implements View.OnClickListener{

    private LinearLayout layout;
    private RecyclerView hotRecycler;

    private RecyclerView eventsRecycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LinearLayout layout = (LinearLayout) inflater
                .inflate(R.layout.fragment_events,
                        container, false);

        RecyclerView hotRecycler = (RecyclerView) layout.getChildAt(2);

        Events[] events = DummyData.events;

        // build view for hot events
        CaptionedImagesAdapterEvents adapter = new CaptionedImagesAdapterEvents(events);
        hotRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        hotRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapterEvents.Listener() {
            @Override
            public void onClick(int position) {
                EventDetailsFragment frag = new EventDetailsFragment(events[position]);
                ((MainActivity) getActivity()).replaceFragment(position, frag);
            }
        });

        // build view for all events

        CaptionedImagesAdapterEventsAll allEventsAdapter = new CaptionedImagesAdapterEventsAll(events);

        RecyclerView eventsRecycler = (RecyclerView) layout.getChildAt(5);
        eventsRecycler.setAdapter(allEventsAdapter);

        StaggeredGridLayoutManager allLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        allLayoutManager.setGapStrategy(2);
        eventsRecycler.setLayoutManager(allLayoutManager);

        allEventsAdapter.setListener(new CaptionedImagesAdapterEventsAll.Listener() {
            @Override
            public void onClick(int position) {
                Events e = DummyData.events[position];
                EventDetailsFragment frag = new EventDetailsFragment(e);
                ((MainActivity) getActivity()).replaceFragment(position, frag);
            }
        });

        Spinner categoryEventsFilter = (Spinner) layout.findViewById(R.id.categoryEventFilter);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                DummyData.eventsCategories);

        categoryEventsFilter.setAdapter(spinnerAdapter);

        Button addEventButton = (Button) layout.findViewById(R.id.addEvent);
        addEventButton.setOnClickListener(this);

        Button applyEventFilterButton = (Button) layout.findViewById(R.id.applyEventFilter);
        applyEventFilterButton.setOnClickListener(this);

        Button resetEventFilterButton = (Button) layout.findViewById(R.id.resetEventFilter);
        resetEventFilterButton.setOnClickListener(this);

        this.layout = layout;
        this.hotRecycler = hotRecycler;
        this.eventsRecycler = eventsRecycler;

        return layout;
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.addEvent:
                onAddEvent();
                break;
            case R.id.applyEventFilter:
                onApplyEventFilter();
                break;
            case R.id.resetEventFilter:
                onResetEventFilter();
                break;
        }
    }

    private void onAddEvent(){
    }

    private void onApplyEventFilter(){
        Spinner categoryEventsFilter = (Spinner) layout.findViewById(R.id.categoryEventFilter);
        String category = String.valueOf(categoryEventsFilter.getSelectedItem());
        boolean isAll = false;

        Events[] events = DummyData.events;
        if(category.equals("Alle")){
            isAll = true;
        }

        if(!isAll)
            events = Arrays.stream(DummyData.events)
                .filter(e->e.getCategory().equals(category))
                .toArray(Events[]::new);


        CaptionedImagesAdapterEventsAll eventsAllAdapter = new CaptionedImagesAdapterEventsAll(events);
        eventsRecycler.setAdapter(eventsAllAdapter);
        setUpAdapter(events, eventsAllAdapter);
    }

    private void onResetEventFilter(){
        Spinner categoryEventsFilter = (Spinner) layout.findViewById(R.id.categoryEventFilter);
        categoryEventsFilter.setSelection(DummyData.eventsCategories.length-1);
        Events[] events = DummyData.events;

        CaptionedImagesAdapterEventsAll adapter = new CaptionedImagesAdapterEventsAll(events);
        eventsRecycler.setAdapter(adapter);

        setUpAdapter(events, adapter);
    }

    private void setUpAdapter(Events[] events, CaptionedImagesAdapterEventsAll eventsAllAdapter){
        // build view for hot events
        Events[] events2 = DummyData.events;
        CaptionedImagesAdapterEvents hotEventsAdapter = new CaptionedImagesAdapterEvents(events2);
        hotRecycler.setAdapter(hotEventsAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        hotRecycler.setLayoutManager(layoutManager);

        hotEventsAdapter.setListener(new CaptionedImagesAdapterEvents.Listener() {
            @Override
            public void onClick(int position) {
                EventDetailsFragment frag = new EventDetailsFragment(events[position]);
                ((MainActivity) getActivity()).replaceFragment(position, frag);
            }
        });

        // build view for all events

        StaggeredGridLayoutManager allLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        allLayoutManager.setGapStrategy(2);
        eventsRecycler.setLayoutManager(allLayoutManager);

        eventsAllAdapter.setListener(new CaptionedImagesAdapterEventsAll.Listener() {
            @Override
            public void onClick(int position) {
                Events e = events[position];
                EventDetailsFragment frag = new EventDetailsFragment(e);
                ((MainActivity) getActivity()).replaceFragment(position, frag);
            }
        });

        Button addEventButton = (Button) layout.findViewById(R.id.addEvent);
        addEventButton.setOnClickListener(this);

        Button applyEventFilterButton = (Button) layout.findViewById(R.id.applyEventFilter);
        applyEventFilterButton.setOnClickListener(this);

        Button resetEventFilterButton = (Button) layout.findViewById(R.id.resetEventFilter);
        resetEventFilterButton.setOnClickListener(this);
    }
}