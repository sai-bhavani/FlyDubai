package avaitors.flysky;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FlightSearchResultActivity extends AppCompatActivity {

    TextView source;
    TextView destination;
    Button bookButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_search_result);
        source = (TextView) findViewById(R.id.sourceLabel);
        destination = (TextView) findViewById(R.id.destinationLabel);
        source.setText(Variables.source);
        destination.setText(Variables.destination);
        bookButton = (Button) findViewById(R.id.bookButton);
        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FlightSearchResultActivity.this, SignInPromptActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
