package avaitors.flysky;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SignInPromptActivity extends AppCompatActivity {

    Button signInButton;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_prompt);
        signInButton = (Button) findViewById(R.id.prompt_sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignInPromptActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
