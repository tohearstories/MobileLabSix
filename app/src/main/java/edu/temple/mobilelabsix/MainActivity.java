package edu.temple.mobilelabsix;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PaletteFragment.OnFragmentInteractionListener {

    boolean twoPanes;
    String[] colors = {"red","green","blue","yellow","magenta"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        twoPanes = (findViewById(R.id.canvas) != null);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.palette, new PaletteFragment());
            fragmentTransaction.commit();


        if(twoPanes) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.canvas, new CanvasFragment());
            fragmentTransaction.commit();
        }

    }//end onCreate(Bundle savedInstanceState) {


    @Override
    public void onFragmentInteraction(int position) {
        String toPass = colors[position];
        CanvasFragment toReplaceWith = CanvasFragment.newInstance(toPass);

        if (twoPanes) {
            getFragmentManager().beginTransaction().replace(R.id.canvas, toReplaceWith).commit();
        }

        if (!twoPanes){
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.palette, toReplaceWith)
                    .addToBackStack(null)
                    .commit();
        }


    }
}
