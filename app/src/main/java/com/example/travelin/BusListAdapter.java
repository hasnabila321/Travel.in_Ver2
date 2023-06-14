package com.example.travelin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class BusListAdapter extends RecyclerView.Adapter<BusListAdapter.ViewHolder> {
    private Context mContext;
    private List<BusItem> mBusItemList;

    public BusListAdapter(Context mContext, List<BusItem> busItemList) {
        this.mContext = mContext;
        this.mBusItemList = busItemList;
    }

    private ListItemClickListener mListener;
    public interface ListItemClickListener{
        public void onListItemClick(View v, int position);
    }

    public void setListener(ListItemClickListener listener){
        this.mListener = listener;
    }

    @NonNull
    @Override
    public BusListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bus_viewholder, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BusListAdapter.ViewHolder holder, int position) {
        BusItem busItem = mBusItemList.get(position);

        holder.busName.setText(busItem.getBusName());
        holder.busRegNumber.setText(busItem.getBusRegNumber());
        holder.departureLoc.setText(busItem.getDepartureLoc());
        holder.departureLocDetails.setText(busItem.getDepartureLocDetails());
        holder.departureTime.setText(busItem.getDepartureTime());
        holder.arrivalLoc.setText(busItem.getArrivalLoc());
        holder.arrivalLocDetails.setText(busItem.getArrivalLocDetails());
        holder.arrivalTime.setText(busItem.getArrivalTime());
        holder.price.setText(String.valueOf(busItem.getPrice()));
        holder.rating.setText(String.valueOf(busItem.getRating()));
        holder.totalReviewers.setText(String.valueOf(busItem.getTotalReviewers()));
        holder.availableSeat.setText(String.valueOf(busItem.getAvailableSeat()));
    }

    @Override
    public int getItemCount() {
        return mBusItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView busName;
        private TextView busRegNumber;
        private TextView departureLoc;
        private TextView departureLocDetails;
        private TextView departureTime;
        private TextView arrivalLoc;
        private TextView arrivalLocDetails;
        private TextView arrivalTime;
        private TextView price;
        private TextView rating;
        private TextView totalReviewers;
        private TextView availableSeat;
        private Button btnBook;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            busName = itemView.findViewById(R.id.tvBusName);
            busRegNumber = itemView.findViewById(R.id.tvBusRegNumber);
            departureLoc = itemView.findViewById(R.id.tvDepartureCity);
            departureLocDetails = itemView.findViewById(R.id.tvDepartureDetails);
            departureTime = itemView.findViewById(R.id.tvDepartureTime);
            arrivalLoc = itemView.findViewById(R.id.tvArrivalCity);
            arrivalLocDetails = itemView.findViewById(R.id.tvArrivalDetails);
            arrivalTime = itemView.findViewById(R.id.tvArrivalTime);
            price = itemView.findViewById(R.id.tvPrice);
            rating = itemView.findViewById(R.id.tvBusRate);
            totalReviewers = itemView.findViewById(R.id.tvBusReviewers);
            availableSeat = itemView.findViewById(R.id.tvAvailableSeat);
            btnBook = itemView.findViewById(R.id.btnBook);

            btnBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onListItemClick(v, getAdapterPosition());
                }
            });
        }
    }
}
