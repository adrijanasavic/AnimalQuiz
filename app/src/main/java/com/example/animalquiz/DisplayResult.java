package com.example.animalquiz;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;

import androidx.annotation.Nullable;


public class DisplayResult extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.finallayout );

        TextView your_name = findViewById( R.id.name );
        TextView your_score = findViewById( R.id.score );

        Intent mint = getIntent();

        String value = mint.getStringExtra( "total" );
        String s = mint.getStringExtra( "user_name" );

        your_name.setText( s );
        your_score.setText( "Your Total Score is " + value );

    }
}
