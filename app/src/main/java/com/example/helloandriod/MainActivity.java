package com.example.helloandriod;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionbar = getSupportActionBar();

        actionbar.setTitle("GfG | Action Bar");

        actionbar.setSubtitle("Design a custom Action Bar");

        actionbar.setIcon(R.mipmap.ic_launcher);

        actionbar.setDisplayUseLogoEnabled(true);
        actionbar.setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.search:
                showAlertDialog();
                break;
            case R.id.refresh:
                DialogFragment dialogFragment = new DialogFragment();
                dialogFragment.show(getSupportFragmentManager(),"My Fragment");
                break;
            case R.id.copy:
                Toast.makeText(this, "Copy Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert!")
                .setMessage("Danger your are failing!");
        builder.setPositiveButton("I know", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
