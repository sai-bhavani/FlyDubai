package avaitors.flysky;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BookFlightActivity extends AppCompatActivity {

    EditText source;
    EditText destination;

    Spinner adult_passenger;
    Spinner child_passenger;
    Spinner infant_passenger;

    Button FindFlightButton;
    Spinner Class_Selector;

    Button JouneyDateButton;
    Button ReturnDateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_flight);

        destination = (EditText) findViewById(R.id.destination);
        adult_passenger = (Spinner) findViewById(R.id.adult_passengers);
        child_passenger = (Spinner) findViewById(R.id.child_passengers);
        source = (EditText) findViewById(R.id.source);
        infant_passenger = (Spinner) findViewById(R.id.infant_passengers);
        FindFlightButton = (Button) findViewById(R.id.Find_Flight_Button);
        Class_Selector = (Spinner) findViewById(R.id.Class_selector);
        JouneyDateButton = (Button) findViewById(R.id.flightJourneyDate);
        ReturnDateButton = (Button) findViewById(R.id.flightReturnDate);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.adult_passenger_count, R.layout.support_simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.passenger_count, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adult_passenger.setAdapter(adapter1);
        child_passenger.setAdapter(adapter);
        infant_passenger.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.travelling_classes, R.layout.support_simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        Class_Selector.setAdapter(adapter2);


        FindFlightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDetails();
                EditText num = (EditText) findViewById(R.id.emer_num);
                Variables.num = num.getText().toString();
                Intent i = new Intent(BookFlightActivity.this, FlightSearchResultActivity.class);
                startActivity(i);
                finish();
            }
        });

        initLabels();

    }

    private void saveDetails() {
        Variables.source = source.getText().toString();
        Variables.destination = destination.getText().toString();
        Variables.adult_passengers = adult_passenger.getSelectedItemPosition() + 1;
        Variables.Class = Class_Selector.getSelectedItemPosition();
        Variables.child_passengers = child_passenger.getSelectedItemPosition();
        Variables.infant_passengers = infant_passenger.getSelectedItemPosition();
    }

    private void initLabels() {
        source.setText(Variables.source);
        destination.setText(Variables.destination);


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Variables.journeyDate = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Variables.returnDate = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yy");
        JouneyDateButton.setText(sdf.format(Variables.journeyDate));
        ReturnDateButton.setText(sdf.format(Variables.returnDate));
        adult_passenger.setSelection(Variables.adult_passengers - 1);
        child_passenger.setSelection(Variables.child_passengers);
        infant_passenger.setSelection(Variables.infant_passengers);
        Class_Selector.setSelection(Variables.Class);
    }
}
