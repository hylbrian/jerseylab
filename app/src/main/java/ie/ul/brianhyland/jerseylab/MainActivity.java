package ie.ul.brianhyland.jerseylab;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mNameTextView, mNumberTextView;
    private ImageView mJerseyImageView;
    private JerseyItem mCurrentItem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameTextView = findViewById(R.id.name_text);
        mNumberTextView = findViewById(R.id.number_text);
        mJerseyImageView = findViewById(R.id.default_jersey);




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
        //numberEditText.setText("0");



        builder.setNegativeButton(android.R.string.cancel, null);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = nameEditText.getText().toString();
                String numberString = numberEditText.getText().toString();
                int number;
                if(numberString != null){


                number = Integer.parseInt(numberString+0);}

                else{  number = 0;}
                //if (number > 1000 || number < 0 ){
                   // number = 0;
                //}
                mCurrentItem = new JerseyItem(name, number, true);
                showCurrentItem();}


        });

        builder.create().show();
    }

    private void showCurrentItem() {
        mNameTextView.setText(mCurrentItem.getmName());
        mNumberTextView.setText(getString(R.string.number_format,mCurrentItem.getmNumber()));
        //mJerseyImageView.setI();
        //mJerseyImageView.setImageResource(mCurrentItem.ismColour());


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
                mCurrentItem = JerseyItem.getDefaultItem();
                showCurrentItem();
                return true;

            case R.id.action_settings:
                startActivity(new Intent(Settings.ACTION_LOCALE_SETTINGS));
                return true;


        }


        return super.onOptionsItemSelected(item);
    }
}
