package ie.ul.brianhyland.jerseylab;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private TextView mNameTextView, mNumberTextView;
    private ImageView mJerseyImageView;
    private JerseyItem mCurrentItem;
    private final static String PREFS = "PREFS";
    private static final String KEY_JERSEY_NAME = "KEY_JERSEY_NAME";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameTextView = findViewById(R.id.name_text);
        mNumberTextView = findViewById(R.id.number_text);
        mJerseyImageView = findViewById(R.id.default_jersey);
        //ToggleButton toggleButtonJerseyColour = (ToggleButton)findViewById(R.id.toggleButton);

        //ToggleButton toggleButtonJerseyColour = (ToggleButton)findViewById(R.id.toggleButton);
        //final ImageView lightImageView = (ImageView)findViewById(R.id.default_jersey);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add something later
               addItem();



            }
        });
    }



    private void addItem() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.add_item);

        View view = getLayoutInflater().inflate(R.layout.dialog_add, null,false);
        builder.setView(view);

        final EditText nameEditText = view.findViewById(R.id.edit_name);
        final EditText numberEditText = view.findViewById(R.id.edit_number);
        //final ToggleButton toggleButtonJerseyColour = (ToggleButton)findViewById(R.id.toggleButton);

        /*
        toggleButtonJerseyColour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    // if toggle button is enabled/on
                    mJerseyImageView.setImageResource(R.drawable.green_jersey);

                }
                else{
                    mJerseyImageView.setImageResource(R.drawable.purple_jersey);
                }
                showCurrentItem();}
        });
*/



        builder.setNegativeButton(android.R.string.cancel, null);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //ToggleButton toggleButtonJerseyColour = (ToggleButton)findViewById(R.id.toggleButton);
                String name = nameEditText.getText().toString();
                //int number = Integer.parseInt(numberEditText.getText().toString());
                String numberString = numberEditText.getText().toString();
                int number = 0;
                //if (numberString != null){
                if(numberString.isEmpty() || numberString.length() == 0 || numberString.equals("") || numberString == null) {
                    number = 0;
                }else{
                    number = Integer.parseInt(numberString);
                }
            //checkToggleButton();



                /*Boolean colour = Boolean.FALSE;
                if(colour = Boolean.TRUE){
                    mJerseyImageView.setImageResource(R.drawable.green_jersey);
                }else
                {
                    mJerseyImageView.setImageResource(R.drawable.purple_jersey);
                }*/

                mCurrentItem = new JerseyItem(name, number, true);
                showCurrentItem();}


        });




        builder.create().show();
    }




        /*
        ToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                // Change both toggleButtonTurnLight and lightImageView's background image
                // according to toggle button checked status.
                if(checked)
                {

                }else
                {

                }
            }
        });*/

    //}


    private void showCurrentItem() {
        mNameTextView.setText(mCurrentItem.getmName());
        mNumberTextView.setText(getString(R.string.number_format,mCurrentItem.getmNumber()));
        //mJerseyImageView.setImageResource(R.drawable.green_jersey);
        //mJerseyImageView.setI();
        //mJerseyImageView.setImageResource(mCurrentItem.ismColour());


    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.green_jersey:
                if (checked){
                    mJerseyImageView.setImageResource(R.drawable.green_jersey);
                }

                break;
            case R.id.purple_jersey:
                if (checked){
                    mJerseyImageView.setImageResource(R.drawable.purple_jersey);
                }


                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_reset:
                //mCurrentItem = JerseyItem.getDefaultItem();
                //showCurrentItem();
                clearJersey();
                return true;

            case R.id.action_settings:
                startActivity(new Intent(Settings.ACTION_LOCALE_SETTINGS));
                return true;


        }


        return super.onOptionsItemSelected(item);
    }

    private void clearJersey() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Reset");

        builder.setMessage("Are you sure you want to reset all items?");

        builder.setNegativeButton(android.R.string.cancel, null);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mJerseyImageView.setImageResource(R.drawable.green_jersey);
                mCurrentItem = JerseyItem.getDefaultItem();
                showCurrentItem();

            }
        });

        builder.create().show();

    }
/*
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = getSharedPreferences(PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_JERSEY_NAME, mNameTextView.JerseyItem.getmName());
// Put the other fields into the editor
        editor.commit();
    }
*/

}
