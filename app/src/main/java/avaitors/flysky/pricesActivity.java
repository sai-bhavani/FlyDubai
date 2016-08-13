package avaitors.flysky;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class pricesActivity extends AppCompatActivity {

    Button proceedToPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prices);
        proceedToPayment = (Button) findViewById(R.id.proceed_to_payment_button);
        proceedToPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pricesActivity.this, BookingSuccessActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
