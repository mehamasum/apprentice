package com.batfia.apprentice.todo;

import android.content.res.Resources;

import com.batfia.apprentice.R;

/**
 * Created by avjindersinghsekhon on 9/21/15.
 */

public class PreferenceKeys {
    final String night_mode_pref_key;

    public PreferenceKeys(Resources resources){
        night_mode_pref_key = resources.getString(R.string.night_mode);
    }
}
