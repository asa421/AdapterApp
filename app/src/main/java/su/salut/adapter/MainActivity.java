package su.salut.adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import su.salut.adapter.adapter.RecyclerViewItemAdapter;
import su.salut.adapter.adapter.ViewPagerItemAdapter;
import su.salut.adapter.model.Sound;

/**
 * An application with a test dataset to test adapters and display data in a tile.
 */
public class MainActivity extends AppCompatActivity implements RecyclerViewItemAdapter.ItemClickListener {
    public static final int COLUMN_COUNT = 3;
    public static final int COUNT_PAGE_ROW = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing objects
        initUI();
    }

    /**
     * Initializing objects
     */
    protected void initUI() {
        // Initializing pager
        ViewPager2 vpPager = findViewById(R.id.vp_pager);
        // Launching the test adapter to display the appearance
        vpPager.setAdapter(new ViewPagerItemAdapter(getDefaultData(), this, COLUMN_COUNT, COUNT_PAGE_ROW, this));

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, vpPager,
                (tab, position) -> {

                }).attach();
    }

    /**
     * Default data
     *
     * Test data of only displaying the appearance of the application
     *
     * @return Sound[]
     */
    protected Sound[] getDefaultData () {
        // Default data
        return new Sound[]{
                new Sound("River", 3, false,false,
                        Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                                "://" + getResources().getResourcePackageName(R.drawable.vector_sound_ic_river)
                                + '/' + getResources().getResourceTypeName(R.drawable.vector_sound_ic_river) + '/' + getResources().getResourceEntryName(R.drawable.vector_sound_ic_river) ), null),
                new Sound("Snow", 5, false,true,
                        Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                                "://" + getResources().getResourcePackageName(R.drawable.vector_sound_ic_snow)
                                + '/' + getResources().getResourceTypeName(R.drawable.vector_sound_ic_snow) + '/' + getResources().getResourceEntryName(R.drawable.vector_sound_ic_snow) ), null),
                new Sound("Fire", 10, true,false,
                        Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                                "://" + getResources().getResourcePackageName(R.drawable.vector_sound_ic_fire)
                                + '/' + getResources().getResourceTypeName(R.drawable.vector_sound_ic_fire) + '/' + getResources().getResourceEntryName(R.drawable.vector_sound_ic_fire) ), null),
                new Sound("River", 1, true,false,
                        Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                                "://" + getResources().getResourcePackageName(R.drawable.vector_sound_ic_river)
                                + '/' + getResources().getResourceTypeName(R.drawable.vector_sound_ic_river) + '/' + getResources().getResourceEntryName(R.drawable.vector_sound_ic_river) ), null),
                new Sound("River", 10, true,true,
                        Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                                "://" + getResources().getResourcePackageName(R.drawable.vector_sound_ic_river)
                                + '/' + getResources().getResourceTypeName(R.drawable.vector_sound_ic_river) + '/' + getResources().getResourceEntryName(R.drawable.vector_sound_ic_river) ), null),
                new Sound("River", 10, false,false,
                        Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                                "://" + getResources().getResourcePackageName(R.drawable.vector_sound_ic_river)
                                + '/' + getResources().getResourceTypeName(R.drawable.vector_sound_ic_river) + '/' + getResources().getResourceEntryName(R.drawable.vector_sound_ic_river) ), null),
                new Sound("Fire", 10, false,false,
                        Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                                "://" + getResources().getResourcePackageName(R.drawable.vector_sound_ic_fire)
                                + '/' + getResources().getResourceTypeName(R.drawable.vector_sound_ic_fire) + '/' + getResources().getResourceEntryName(R.drawable.vector_sound_ic_fire) ), null),
                new Sound("River", 2, false,false,
                        Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                                "://" + getResources().getResourcePackageName(R.drawable.vector_sound_ic_river)
                                + '/' + getResources().getResourceTypeName(R.drawable.vector_sound_ic_river) + '/' + getResources().getResourceEntryName(R.drawable.vector_sound_ic_river) ), null),
                new Sound("River", 3, true,true,
                        Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                                "://" + getResources().getResourcePackageName(R.drawable.vector_sound_ic_river)
                                + '/' + getResources().getResourceTypeName(R.drawable.vector_sound_ic_river) + '/' + getResources().getResourceEntryName(R.drawable.vector_sound_ic_river) ), null),
                new Sound("River", 10, false,false,
                        Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                                "://" + getResources().getResourcePackageName(R.drawable.vector_sound_ic_river)
                                + '/' + getResources().getResourceTypeName(R.drawable.vector_sound_ic_river) + '/' + getResources().getResourceEntryName(R.drawable.vector_sound_ic_river) ), null),
                new Sound("Fire", 10, false,false,
                        Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                                "://" + getResources().getResourcePackageName(R.drawable.vector_sound_ic_fire)
                                + '/' + getResources().getResourceTypeName(R.drawable.vector_sound_ic_fire) + '/' + getResources().getResourceEntryName(R.drawable.vector_sound_ic_fire) ), null),
                new Sound("River", 4, true,true,
                        Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                                "://" + getResources().getResourcePackageName(R.drawable.vector_sound_ic_river)
                                + '/' + getResources().getResourceTypeName(R.drawable.vector_sound_ic_river) + '/' + getResources().getResourceEntryName(R.drawable.vector_sound_ic_river) ), null),
                new Sound("River", 5, false,false,
                        Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                                "://" + getResources().getResourcePackageName(R.drawable.vector_sound_ic_river)
                                + '/' + getResources().getResourceTypeName(R.drawable.vector_sound_ic_river) + '/' + getResources().getResourceEntryName(R.drawable.vector_sound_ic_river) ), null),
                new Sound("River", 10, false,false,
                        Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                                "://" + getResources().getResourcePackageName(R.drawable.vector_sound_ic_river)
                                + '/' + getResources().getResourceTypeName(R.drawable.vector_sound_ic_river) + '/' + getResources().getResourceEntryName(R.drawable.vector_sound_ic_river) ), null),
                new Sound("River", 10, true,true,
                        Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                                "://" + getResources().getResourcePackageName(R.drawable.vector_sound_ic_river)
                                + '/' + getResources().getResourceTypeName(R.drawable.vector_sound_ic_river) + '/' + getResources().getResourceEntryName(R.drawable.vector_sound_ic_river) ), null),
                new Sound("River", 10, false,false,
                        Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                                "://" + getResources().getResourcePackageName(R.drawable.vector_sound_ic_river)
                                + '/' + getResources().getResourceTypeName(R.drawable.vector_sound_ic_river) + '/' + getResources().getResourceEntryName(R.drawable.vector_sound_ic_river) ), null),
                new Sound("River", 7, true,false,
                        Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                                "://" + getResources().getResourcePackageName(R.drawable.vector_sound_ic_river)
                                + '/' + getResources().getResourceTypeName(R.drawable.vector_sound_ic_river) + '/' + getResources().getResourceEntryName(R.drawable.vector_sound_ic_river) ), null),
                new Sound("River", 10, false,false,
                        Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                                "://" + getResources().getResourcePackageName(R.drawable.vector_sound_ic_river)
                                + '/' + getResources().getResourceTypeName(R.drawable.vector_sound_ic_river) + '/' + getResources().getResourceEntryName(R.drawable.vector_sound_ic_river) ), null),
                new Sound("Snow", 8, true,true,
                        Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                                "://" + getResources().getResourcePackageName(R.drawable.vector_sound_ic_snow)
                                + '/' + getResources().getResourceTypeName(R.drawable.vector_sound_ic_snow) + '/' + getResources().getResourceEntryName(R.drawable.vector_sound_ic_snow) ), null),
                new Sound("River", 10, false,false,
                        Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                                "://" + getResources().getResourcePackageName(R.drawable.vector_sound_ic_river)
                                + '/' + getResources().getResourceTypeName(R.drawable.vector_sound_ic_river) + '/' + getResources().getResourceEntryName(R.drawable.vector_sound_ic_river) ), null)
        };
    }

    @Override
    public void onItemClick(RecyclerViewItemAdapter.ItemHolder holder, View view, Sound sound, int position) {
        // Set select sound
        Toast.makeText(MainActivity.this, "Set select sound", Toast.LENGTH_LONG).show();

        sound.setSelect(sound.getSelect()?false:true);
        holder.setSelect(sound.getSelect());
    }

    @Override
    public void onItemProgressChanged(RecyclerViewItemAdapter.ItemHolder holder, SeekBar seekBar, int i, boolean b, Sound sound, int position) {
        // Set volume sound
        Toast.makeText(MainActivity.this, "Set volume sound", Toast.LENGTH_LONG).show();

        sound.setVolume(i);
    }

    @Override
    public void onItemStartTrackingTouch(RecyclerViewItemAdapter.ItemHolder holder, SeekBar seekBar, Sound sound, int position) {

    }

    @Override
    public void onItemStopTrackingTouch(RecyclerViewItemAdapter.ItemHolder holder, SeekBar seekBar, Sound sound, int position) {

    }
}