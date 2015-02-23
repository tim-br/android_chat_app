package com.example.brucewil.simple_chat_client;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Main_Chat extends ActionBarActivity {

    private final String userName = "jake";
    private EditText userInput;
    private static TextView chatView;
    private String userEntry;
    private Button enterButton;
    private String userInputString;
    private static Client client;
    private static String returnedSentence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__chat);

        userInput = (EditText) findViewById(R.id.userInput);
        chatView = (TextView) findViewById(R.id.chatView);
        enterButton = (Button) findViewById(R.id.enterButton);

        enterButton.setOnClickListener(buttonListener);

        userInput.addTextChangedListener(userInputListener);
        returnedSentence = null;
        //client = new Client();
        //InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //imm.showSoftInput(userInput, InputMethodManager.SHOW_IMPLICIT);

    }

    private OnClickListener buttonListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            chatView.append(userInputString + "\n");
            //client.setSentence(userInputString + "\n");
        }

    };

    private TextWatcher userInputListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //userEntry = s.toString();
            //updateMainChat();

        }

        @Override
        public void afterTextChanged(Editable s) {
            userInputString = s.toString();
            //userInput.setText(s.toString());

            //chatView.setText(String.format("%.02f", s.toString()));

            //userInput.setText("");
            //chatView.append(s.toString() + "\n");
            //chatView.setText(s.toString());



        }
    };

    /*private void  updateMainChat(){
        String text_entry = String.format("%.02f", userInput.getText());

        chatView.append(text_entry);
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main__chat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

   /* static class RetrieveFromServer implements Runnable{

        @Override
        public void run(){
             returnedSentence = client.getReturnedSentence();
            chatView.append(returnedSentence + "\n");

        }
    }*/
}