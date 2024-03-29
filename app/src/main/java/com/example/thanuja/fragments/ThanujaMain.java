package com.example.thanuja.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.imal.MainActivity;
import com.example.imal.R;
import com.example.thanuja.dialogbox.ExampleDialog;
import com.example.thanuja.dialogbox.ExampleDialogMonthly;
import com.example.thanuja.dialogbox.ExampleDialogYearly;
import com.example.thanuja.fragments.FragmentDaily;
import com.example.thanuja.fragments.FragmentMonthly;
import com.example.thanuja.fragments.FragmentYearly;
import com.example.thanuja.fragments.ViewPagerAdapter;
import com.example.thanuja.recyclerview.Expense;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.imal.R.string.thanuja_daily;

public class ThanujaMain extends AppCompatActivity implements ExampleDialog.ExampleDialogListener, ExampleDialogMonthly.ExampleDialogListener, ExampleDialogYearly.ExampleDialogListener {
    private TabLayout tablayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanuja_main);

        tablayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Add fragment here
        adapter.AddFragment(new FragmentDaily(), "Daily");
        adapter.AddFragment(new FragmentMonthly(), "Monthly");
        adapter.AddFragment(new FragmentYearly(), "Yearly");

        viewPager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewPager);


        tablayout.getTabAt(0).setIcon(R.drawable.add_catergory);
        tablayout.getTabAt(1).setIcon(R.drawable.bitcoin);
        tablayout.getTabAt(2).setIcon(R.drawable.cat);

//        FloatingActionButton fab = findViewById(R.id.fab);
//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openDialog();
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        if(backPressedTime + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }
        else{
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
        backPressedTime = System.currentTimeMillis();
    }

    //    public void openDialog(){
//        ExampleDialog exampleDialog = new ExampleDialog();
//        exampleDialog.showNow(getSupportFragmentManager(), "example dialog");
//    }

    @Override
    public void applyTexts(String username, String password) {
//        textViewUsername.setText(username);
//        textViewPassword.setText(password);
    }
}
