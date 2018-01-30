package ientertainapp.proxim.com.myslidingapplication.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ientertainapp.proxim.com.myslidingapplication.R;

public class Second extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent inavigationLogin = new Intent(Second.this, First.class);
                inavigationLogin.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                inavigationLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                inavigationLogin.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(inavigationLogin);

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
