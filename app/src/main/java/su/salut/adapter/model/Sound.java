package su.salut.adapter.model;

import android.net.Uri;

/**
 * Test model with some kind of variables and changeable parameters.
 */
public class Sound {
    public static final int MAX_VOLUME = 10;

    private String mName;
    private int mVolume;
    private boolean mPremium;
    private boolean mSelect;
    private Uri mIcon;
    private Uri mSound;

    public Sound(String name, int volume, boolean premium, boolean select, Uri icon, Uri sound) {
        this.mName = name;
        this.mVolume = volume;
        this.mPremium = premium;
        this.mSelect = select;
        this.mIcon = icon;
        this.mSound = sound;
    }


    public void setVolume(int volume) {
        this.mVolume = volume;
    }

    public void setPremium(boolean premium) {
        this.mPremium = premium;
    }

    public void setSelect(boolean select) {
        this.mSelect = select;
    }


    public String getName() {
        return mName;
    }

    public int getVolume() {
        return mVolume;
    }

    public boolean getPremium() {
        return mPremium;
    }

    public boolean getSelect() {
        return mSelect;
    }

    public Uri getIcon() {
        return mIcon;
    }

    public Uri getSound() {
        return mSound;
    }
}
