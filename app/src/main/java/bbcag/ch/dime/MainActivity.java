package bbcag.ch.dime;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import bbcag.ch.dime.fragment.CameraFragment;
import bbcag.ch.dime.fragment.VideoAndPhotoFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {

                case R.id.navigation_camera:
                    fragment = CameraFragment.newInstance();
                    break;
                case R.id.navigation_gallery:
                    fragment = VideoAndPhotoFragment.newInstance();
                    break;

            }
            if (fragment != null) {
/*                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.contentContainer, fragment);
                fragmentTransaction.commit();*/
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.contentContainer, fragment);
                transaction.commit();
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.contentContainer, CameraFragment.newInstance());
        fragmentTransaction.commit();


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
