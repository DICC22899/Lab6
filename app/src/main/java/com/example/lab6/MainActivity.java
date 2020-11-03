package com.example.lab6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class MainActivity extends AppCompatActivity {

    FirstFragment FF=new FirstFragment();
    SecondFragment SF=new SecondFragment();
    ThirdFragment TF=new ThirdFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //SUPER POSICION DE FRAGMENT
        //FirstFragment FF=new FirstFragment();
        //FragmentManager FM=getSupportFragmentManager();
        //FragmentTransaction FT = FM.beginTransaction();
        //FT.add(R.id.activity_main,FF,null);
        //FT.commit();
        BottomNavigationView botNav=(BottomNavigationView)findViewById(R.id.bottomnavi);
        botNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.firstFragment:
                    loadFragment(FF);
                    return true;
                case R.id.secondFragment:
                    loadFragment(SF);
                    return true;
                case R.id.thirdFragment:
                    loadFragment(TF);
                    return true;
            }
            return false;
        }
    };
    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment,fragment);
        transaction.commit();

    }
}