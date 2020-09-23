package su.salut.adapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import su.salut.adapter.R;
import su.salut.adapter.model.Sound;

/**
 * Item adapter RecyclerView
 *
 * RecyclerView + GridLayoutManager
 *  https://stackoverflow.com/questions/40587168/simple-android-grid-example-using-recyclerview-with-gridlayoutmanager-like-the
 */
public class RecyclerViewItemAdapter extends RecyclerView.Adapter<RecyclerViewItemAdapter.ItemHolder> {
    private Sound[] mData;
    private Context mContext;
    private int mPageCount;
    private int mPage;
    private ItemClickListener mClickListener;

    public RecyclerViewItemAdapter(Sound[] data, Context context, int pageCount, int position, ItemClickListener clickListener) {
        this.mData = data;
        this.mContext = context;
        this.mPageCount = pageCount;
        this.mPage = position;
        this.mClickListener = clickListener;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(mContext).inflate(R.layout.item_sound, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        // Better to say sorry than asking permission all the time
        // https://habr.com/ru/post/21376/
        try {
            Sound sound = mData[((mPage * mPageCount) + position)];

            // Set data
            holder.tvName.setText(sound.getName());
            holder.ivIcon.setImageURI(sound.getIcon());
            holder.sbVolume.setMax(Sound.MAX_VOLUME);
            holder.sbVolume.setProgress(sound.getVolume());
            holder.setPremium(sound.getPremium());
            holder.setSelect(sound.getSelect());
        } catch (Exception e) {

        }
    }

    @Override
    public int getItemCount() {
        return Math.min((mData.length - (mPage * mPageCount)), mPageCount);
    }

    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
        public CardView cvContent;
        public ImageView ivIcon;
        public ImageView ivPremium;
        public TextView tvName;
        public SeekBar sbVolume;

        private boolean mPremium;
        private boolean mSelect;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            cvContent =  itemView.findViewById(R.id.cv_content);
            ivIcon =  itemView.findViewById(R.id.iv_icon);
            ivPremium =  itemView.findViewById(R.id.iv_premium);
            tvName =  itemView.findViewById(R.id.tv_name);
            sbVolume =  itemView.findViewById(R.id.sb_volume);

            mPremium = false;
            mSelect = false;

            cvContent.setOnClickListener(this);
            sbVolume.setOnSeekBarChangeListener(this);
        }

        public void setPremium(boolean premium) {
            mPremium = premium;

            if (premium){
                ivPremium.setVisibility(View.VISIBLE);
                sbVolume.setVisibility(View.GONE);
                cvContent.setCardBackgroundColor(mContext.getColor(R.color.windowPremium));
            } else {
                ivPremium.setVisibility(View.GONE);
                setSelect(mSelect);
            }
        }

        public void setSelect(boolean select) {
            mSelect = select;

            if (mPremium) {
                setPremium(mPremium);
            } else if (select){
                ivPremium.setVisibility(View.GONE);
                sbVolume.setVisibility(View.VISIBLE);
                cvContent.setCardBackgroundColor(mContext.getColor(R.color.windowSelect));
            } else {
                ivPremium.setVisibility(View.GONE);
                sbVolume.setVisibility(View.GONE);
                cvContent.setCardBackgroundColor(mContext.getColor(R.color.windowDefault));
            }
        }

        @Override
        public void onClick(View view) {
            // Better to say sorry than asking permission all the time
            // https://habr.com/ru/post/21376/
            try {
                // The listener may not be set here,
                // but the adapter position and the real position are shifted from the open page
                int position = (mPage * mPageCount) + getAdapterPosition();
                mClickListener.onItemClick(this, view, mData[position], position);
            } catch (Exception e) {

            }
        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            // Better to say sorry than asking permission all the time
            // https://habr.com/ru/post/21376/
            try {
                // The listener may not be set here,
                // but the adapter position and the real position are shifted from the open page
                int position = (mPage * mPageCount) + getAdapterPosition();
                mClickListener.onItemProgressChanged(this, seekBar, i, b, mData[position], position);
            } catch (Exception e) {

            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // Better to say sorry than asking permission all the time
            // https://habr.com/ru/post/21376/
            try {
                // The listener may not be set here,
                // but the adapter position and the real position are shifted from the open page
                int position = (mPage * mPageCount) + getAdapterPosition();
                mClickListener.onItemStartTrackingTouch(this, seekBar, mData[position], position);
            } catch (Exception e) {

            }
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // Better to say sorry than asking permission all the time
            // https://habr.com/ru/post/21376/
            try {
                // The listener may not be set here,
                // but the adapter position and the real position are shifted from the open page
                int position = (mPage * mPageCount) + getAdapterPosition();
                mClickListener.onItemStopTrackingTouch(this, seekBar, mData[position], position);
            } catch (Exception e) {

            }
        }
    }

    /**
     * parent activity will implement this method to respond to click events
     */
    public interface ItemClickListener {
        void onItemClick(ItemHolder holder, View view, Sound sound, int position);

        void onItemProgressChanged(ItemHolder holder,SeekBar seekBar, int i, boolean b, Sound sound, int position);

        void onItemStartTrackingTouch(ItemHolder holder, SeekBar seekBar, Sound sound, int position);

        void onItemStopTrackingTouch(ItemHolder holder, SeekBar seekBar, Sound sound, int position);
    }
}
