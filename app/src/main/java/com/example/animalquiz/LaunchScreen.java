package com.example.animalquiz;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class LaunchScreen extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.launch_screen );
    }

    public void onStartClicked(View view) {
        final EditText name = findViewById( R.id.txtname );
        if (name.length() == 0) {
            Toast.makeText( getApplicationContext(), "Please enter your name!!!", Toast.LENGTH_LONG ).show();
        } else {
            Intent intent = new Intent( getApplicationContext(), MainActivity.class );
            intent.putExtra( "name", name.getText().toString() );
            startActivity( intent );
        }
    }

}
