package avaitors.flysky;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;

public class BookingSuccessActivity extends AppCompatActivity {
    Button GoHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_success);
        GoHomeButton = (Button) findViewById(R.id.GoHomeButton);
        GoHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SmsManager smsManager = SmsManager.getDefault();
        if (!Variables.num.equals(""))
            smsManager.sendTextMessage(Variables.num, null, "Your friend/family booked ticket for " + Variables.destination, null, null);
    }
}
