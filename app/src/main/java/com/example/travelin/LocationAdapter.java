package com.example.travelin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {
    private Context mContext;
    private List<LocationItemsRV> mlocationList;

    public LocationAdapter(Context context, List<LocationItemsRV> locationList){
        this.mContext = context;
        this.mlocationList = locationList;
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
    public LocationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_location_viewholder, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationAdapter.ViewHolder holder, int position) {
        LocationItemsRV locationItemsRVList = mlocationList.get(position);

        holder.mCity.setText(locationItemsRVList.getLocationInput());
        holder.mCityDetails.setText(locationItemsRVList.getLocationDetails());
    }

    @Override
    public int getItemCount() {
        return mlocationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mCity;
        private TextView mCityDetails;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mCity = itemView.findViewById(R.id.city);
            mCityDetails = itemView.findViewById(R.id.city_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onListItemClick(v, getAdapterPosition());
                }
            });
        }
    }
}
