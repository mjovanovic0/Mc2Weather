package hr.tvz.mc2.helpers;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

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

}
