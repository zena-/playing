package com.test.sec.playing;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private Button answerYesButton, answerNoButton;
    private EditText usersNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerYesButton = (Button) findViewById(R.id.answer_yes_button);
        answerNoButton = (Button) findViewById(R.id.answer_no_button);
        usersNameEditText = (EditText) findViewById(R.id.users_name_edit_text);

        String[] favoriteTVShows = {"Orphan Black", "Walking Dead", "Breaking Bad", "Girls", "Shameless", "Scandal"};
// this will generate the rows for the list view, we ca choose a list provided simple_list_item_1 or make your own
//        ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.row_layout, favoriteTVShows);
        ListAdapter theAdapter = new MyAdaptor(this, favoriteTVShows);
// get the list view itself
        ListView theListView = (ListView) findViewById(R.id.theListView);
//        tell the list what data to use
        theListView.setAdapter(theAdapter);
//        to listen for any clicks
        theListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                String tvShowPicked = "You selected " + String.valueOf(adapterView.getItemAtPosition(position));

                Toast.makeText(MainActivity.this, tvShowPicked, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onYesButtonClick(View view) {
        String usersName = String.valueOf(usersNameEditText.getText());
        String yourYesResponse = "I like them to " + usersName;
        Toast.makeText(this, yourYesResponse, Toast.LENGTH_SHORT).show();
    }

    public void onNoButtonClick(View view) {
        String usersName = String.valueOf(usersNameEditText.getText());
        String yourNoResponse = " well, thats a bummer " + usersName;
        Toast.makeText(this, yourNoResponse, Toast.LENGTH_SHORT).show();
    }
}
