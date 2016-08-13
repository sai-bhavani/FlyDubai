package avaitors.flysky;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button firstTravelButton;
    Button bookFlightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstTravelButton = (Button) findViewById(R.id.firstTravelButton);
        firstTravelButton.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     Intent i = new Intent(MainActivity.this, FirstTravelActivity.class);
                                                     startActivity(i);
                                                 }
                                             }
        );
        bookFlightButton = (Button) findViewById(R.id.bookFlightButton);
        bookFlightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, BookFlightActivity.class);
                startActivity(i);
            }
        });
    }
}
