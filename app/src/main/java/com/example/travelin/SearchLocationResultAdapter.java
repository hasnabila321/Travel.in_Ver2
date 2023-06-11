package com.example.travelin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SearchLocationResultAdapter extends RecyclerView.Adapter<SearchLocationResultAdapter.ViewHolder> {
    private Context mContext;
    private List<SearchLocationItemsRV> mItemsSearchList;

    public SearchLocationResultAdapter(Context context, List<SearchLocationItemsRV> itemsSearchList){
        this.mContext = context;
        this.mItemsSearchList = itemsSearchList;
    }

    private ListItemClickListener clickListener;

    public interface ListItemClickListener{
        public void onListItemClick(View v, int position);
    }

    public void setListener(ListItemClickListener listener){
        this.clickListener = listener;
    }

    @NonNull
    @Override
    public SearchLocationResultAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_location_viewholder, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchLocationResultAdapter.ViewHolder holder, int position) {
        SearchLocationItemsRV searchLocationItemsRVList = mItemsSearchList.get(position);

        holder.mCity.setText(searchLocationItemsRVList.getSearchLocationInput());
    }

    @Override
    public int getItemCount() {
        return mItemsSearchList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mCity;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mCity = itemView.findViewById(R.id.city);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onListItemClick(v, getAdapterPosition());
                }
            });
        }
    }
}
