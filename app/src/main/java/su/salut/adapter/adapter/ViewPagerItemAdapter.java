package su.salut.adapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import su.salut.adapter.R;
import su.salut.adapter.model.Sound;

/**
 * Paging adapter ViewPager
 *
 * Load the RecyclerView + GridLayoutManager adapter for each page
 */
public class ViewPagerItemAdapter extends RecyclerView.Adapter<ViewPagerItemAdapter.ItemHolder> {
    private Sound[] mData;
    private Context mContext;
    private int mColumnCount;
    private int mPageCount;
    private RecyclerViewItemAdapter.ItemClickListener mClickListener;

    public ViewPagerItemAdapter(Sound[] data, Context context, int columnCount, int pageCount, RecyclerViewItemAdapter.ItemClickListener clickListener) {
        this.mData = data;
        this.mContext = context;
        this.mColumnCount = columnCount;
        this.mPageCount = pageCount;
        this.mClickListener = clickListener;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(mContext).inflate(R.layout.item_page, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        // Create new adapter
        holder.rvContent.setAdapter(new RecyclerViewItemAdapter(mData, mContext, mPageCount, position, mClickListener));
    }

    @Override
    public int getItemCount() {
        return (int) Math.ceil((double)mData.length/mPageCount);
    }

    /**
     * convenience method for getting data at click position
     */
    public Sound getItem(int id) {
        return mData[id];
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        public RecyclerView rvContent;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            // Initializing RecyclerView
            rvContent = itemView.findViewById(R.id.rv_content);
            rvContent.setLayoutManager(new GridLayoutManager(mContext, mColumnCount));
        }
    }
}
