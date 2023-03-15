    package com.example.helloandriod;

    import android.content.res.Configuration;
    import android.os.Bundle;
    import androidx.fragment.app.FragmentTransaction;
    import androidx.appcompat.app.AppCompatActivity;
    import android.util.Log;
    import android.widget.Toast;

    import com.example.helloandriod.fragments.PizzaDetailFragment;
    import com.example.helloandriod.fragments.PizzaMenuFragment;

    public class MainActivity3 extends AppCompatActivity  implements PizzaMenuFragment.OnItemSelectedListener {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            Log.d("DEBUG", getResources().getConfiguration().orientation + "");

            if (savedInstanceState == null) {
                // Instance of first fragment
                PizzaMenuFragment firstFragment = new PizzaMenuFragment();

                // Add Fragment to FrameLayout (flContainer), using FragmentManager
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.add(R.id.flContainer, firstFragment);
                ft.commit();
            }

            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                PizzaDetailFragment secondFragment = new PizzaDetailFragment();
                Bundle args = new Bundle();
                args.putInt("position", 0);
                secondFragment.setArguments(args);
                FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                ft2.add(R.id.flContainer2, secondFragment);
                ft2.commit();
            }
        }

        @Override
        public void onPizzaItemSelected(int position) {
            Toast.makeText(this, "Called By Fragment A: position - "+ position, Toast.LENGTH_SHORT).show();

            // Load Pizza Detail Fragment
            PizzaDetailFragment secondFragment = new PizzaDetailFragment();

            Bundle args = new Bundle();
            args.putInt("position", position);
            secondFragment.setArguments(args);


            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flContainer2, secondFragment)
                        .commit();
            }else{
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flContainer, secondFragment)
                        .addToBackStack(null)
                        .commit();
            }
        }
    }
