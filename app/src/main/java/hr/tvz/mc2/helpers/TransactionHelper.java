package hr.tvz.mc2.helpers;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import hr.tvz.mc2.R;

/**
 * Created by ivankocijan on 14.03.2014..
 */
public class TransactionHelper {

    public static void switchContentNoAnimation (Fragment fragment, FragmentManager manager, String fragmentTag, int contentFrameId) {

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(contentFrameId, fragment, fragmentTag);
        transaction.addToBackStack(fragmentTag);
        transaction.commit();

    }

    public static void switchContentSlideInFromLeft (Fragment fragment, FragmentManager manager, String fragmentTag, int contentFrameId) {

        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.animator.slide_in_from_right, R.animator.slide_out_to_right,
                R.animator.slide_in_from_left, R.animator.slide_out_to_left);
        ft.replace(contentFrameId, fragment, fragmentTag);
        ft.addToBackStack(fragmentTag);
        ft.commit();

    }


}
