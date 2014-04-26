package hr.tvz.mc2.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import hr.tvz.mc2.R;

/**
 * Created by ivankocijan on 26.04.2014..
 */
public class SettingsFragment extends Fragment {

    private SettingsFragment settingsFragment;
    private NavigationDrawerFragment.NavigationDrawerCallbacks mCallbacks;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        ButterKnife.inject(rootView);

        return rootView;
    }

    @Override
    public void onStop () {
        super.onStop();

        mCallbacks.unlockDrawer();

    }

    @Override
    public void onDestroy () {
        super.onDestroy();
        ButterKnife.reset(this);
    }

    @Override
    public void onAttach (Activity activity) {
        super.onAttach(activity);
        try {
            mCallbacks = (NavigationDrawerFragment.NavigationDrawerCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
        }
    }


}
