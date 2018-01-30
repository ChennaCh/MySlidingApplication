package ientertainapp.proxim.com.myslidingapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import ientertainapp.proxim.com.myslidingapplication.Fragment.FirstFragment;
import ientertainapp.proxim.com.myslidingapplication.Fragment.SecondFragment;

public class MainActivity extends AppCompatActivity{

    // index to identify current nav menu item
    public static int navItemIndex = 0;

    private SlidingRootNav slidingRootNav;
    private Button dashboard_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Sliding Menu");
        setSupportActionBar(toolbar);

        slidingRootNav = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withMenuLayout(R.layout.left_drawer)
                .inject();


        dashboard_btn = (Button) findViewById(R.id.dashboard_btn);
//        dashboard_btn.setOnClickListener(this);
//        findViewById(R.id.account_btn).setOnClickListener(this);

        findViewById(R.id.account_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment1 = new SecondFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack if needed
//                transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                // transaction.set(R.anim.fade_in,R.anim.fade_out);
                transaction.replace(R.id.container, newFragment1).commit();
//                transaction.addToBackStack(null);
                // Commit the transaction
//                transaction.commit();
                slidingRootNav.closeMenu();
            }
        });
        dashboard_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Create new fragment and transaction
                Fragment newFragment = new FirstFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                transaction.replace(R.id.container, newFragment).commit();
//                transaction.commit();
                slidingRootNav.closeMenu();
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if (navItemIndex == 0) {
            getMenuInflater().inflate(R.menu.main, menu);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Toast.makeText(getApplicationContext(), "Settings!", Toast.LENGTH_LONG).show();
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public void onClick(View view) {
//
//        switch (view.getId()){
//            case R.id.dashboard_btn:
//                Fragment newFragment = new FirstFragment();
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out).replace(R.id.container, newFragment).commit();
////                transaction.replace(R.id.container, newFragment);
////                transaction.commit();
//                slidingRootNav.closeMenu();
//
//            case R.id.account_btn:
//                Fragment newFragment1 = new SecondFragment();
//                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
//                transaction1.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
//                transaction1.replace(R.id.container, newFragment1);
//                transaction1.commit();
//                slidingRootNav.closeMenu();
//
//        }
//    }
}
