package ientertainapp.proxim.com.myslidingapplication.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ientertainapp.proxim.com.myslidingapplication.R;

public class First extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent inavigationLogin = new Intent(First.this, Second.class);
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
        finish();
    }
}
