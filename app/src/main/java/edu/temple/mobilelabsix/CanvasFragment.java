package edu.temple.mobilelabsix;

import android.app.Fragment;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CanvasFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public CanvasFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    public static CanvasFragment newInstance(String param1) {
        CanvasFragment fragment = new CanvasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_canvas_fragment, container, false);

       if(getArguments() != null) {
          v.setBackgroundColor(Color.parseColor(mParam1));
        }

        return v;
    }
}
