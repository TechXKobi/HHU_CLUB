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

import de.hhu.hhu_go.R;
import de.hhu.hhu_go.domain.Contact;
import de.hhu.hhu_go.domain.Offer;

public class MessageFragment extends Fragment implements View.OnClickListener {
    private LinearLayout layout;
    private RecyclerView recycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_message, container, false);
        RecyclerView recycler = (RecyclerView) layout.findViewById(R.id.messaging_recycler);
        Contact[] contacts = DummyData.contacts;

        // build view for hot offers
        CaptionedImagesAdapterMessaging adapter = new CaptionedImagesAdapterMessaging(contacts);
        recycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        recycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapterMessaging.Listener() {
            @Override
            public void onClick(int position) {
                //ChatFragment frag = new ChatFragment(data);
                //((MainActivity) getActivity()).replaceFragment(position, frag);
            }
        });

        Button startChatButton = (Button) layout.findViewById(R.id.startChat);
        startChatButton.setOnClickListener(this);

        this.layout = layout;
        this.recycler = recycler;
        return layout;
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.startChat:
                onStartChat();
                break;
        }
    }

    private void onStartChat(){}
}