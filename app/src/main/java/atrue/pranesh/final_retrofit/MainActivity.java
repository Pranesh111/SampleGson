package atrue.pranesh.final_retrofit;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import atrue.pranesh.final_retrofit.ui.Home;

public class MainActivity extends AppCompatActivity {
FrameLayout base_container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        base_container=findViewById(R.id.base_container);

        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.base_container,new Home(),"TAG");
        transaction.commit();
    }
}
