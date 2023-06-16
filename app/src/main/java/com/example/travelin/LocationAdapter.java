package com.example.travelin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;

public class LocationAdapter extends FirebaseRecyclerAdapter<LocationItemsRV, LocationAdapter.ViewHolder> {
    private Context mContext;
    private ListItemClickListener clickListener;
    private List<LocationAdapter> mItemsRVList;
    LocationPage locationPage;

    public LocationAdapter(@NonNull FirebaseRecyclerOptions<LocationItemsRV> options, @NonNull Context context){
        super(options);
        this.mContext = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull LocationAdapter.ViewHolder holder, int position, @NonNull LocationItemsRV model) {
//        LocationItemsRV locationItemsRV = mItemsRVList.get(position);
        holder.mCity.setText(model.getLocationCity());
        holder.mCityDetails.setText(model.getLocationDetails());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext, HomePage.class);
//                intent.putExtra("city", model.getLocationCity());
//                intent.putExtra("cityDetails", model.getLocationDetails());
//                locationPage.setResult(RESULT_FIRST_USER, intent);
//                locationPage.finish();
////                mContext.startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public LocationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_location_viewholder, parent, false);

        return new ViewHolder(view);
    }

    public interface ListItemClickListener{
        public void onListItemClick(View v, int position);
    }

    public void setListener(ListItemClickListener listener){
        this.clickListener = listener;
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
