package edu.temple.mobilelabsix;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class PaletteFragment extends Fragment {

    String[] colors = {"red","green","blue","yellow","magenta"};

    public static PaletteFragment newInstance() {
        return new PaletteFragment();
    }

    public PaletteFragment() {} // Required empty public constructor

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_palette_fragment, container, false);
        ListView gList = (ListView) v.findViewById(R.id.listView);

        GAdapter mine = new GAdapter(getActivity(), android.R.layout.simple_list_item_1, colors );

        gList.setAdapter(mine);

        gList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 ( (OnFragmentInteractionListener) getActivity() ).onFragmentInteraction(position);
            }
        });

        return v;

    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(int position);
    }

}
