package polinema.ac.id.starterchapter05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_placeholder);
        pushup();
    }

    public void handlePushup(View view) {
        if (fragment == null || fragment instanceof DipsFragment || fragment instanceof HandstandFragment) {
            pushup();
        }
    }

    public void handleDips(View view) {
        if (fragment == null || fragment instanceof PushupFragment || fragment instanceof HandstandFragment) {
            dips();
        }
    }

    public void handleHandstand(View view) {
        if (fragment == null || fragment instanceof DipsFragment || fragment instanceof PushupFragment) {
            handstand();
        }
    }

    public void pushup() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_from_left, R.anim.enter_from_left, R.anim.exit_from_right);
        fragmentTransaction.replace(R.id.fragment_placeholder, new PushupFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void dips() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_from_left, R.anim.enter_from_left, R.anim.exit_from_right);
        fragmentTransaction.replace(R.id.fragment_placeholder, new DipsFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void handstand() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_from_left, R.anim.enter_from_left, R.anim.exit_from_right);
        fragmentTransaction.replace(R.id.fragment_placeholder, new HandstandFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
