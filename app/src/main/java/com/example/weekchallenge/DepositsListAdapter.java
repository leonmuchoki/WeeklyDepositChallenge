package com.example.weekchallenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DepositsListAdapter extends RecyclerView.Adapter<DepositsListAdapter.DepositViewHolder> {

    private final LayoutInflater mInflater;
    private List<Deposits> mDeposits; // Cached copy of words

    DepositsListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public DepositViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new DepositViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DepositViewHolder holder, int position) {
        if (mDeposits != null) {
            Deposits current = mDeposits.get(position);
            holder.depositAmountItemView.setText(current.DepositAmount.toString());
            holder.depositDateItemView.setText(current.DepositDate.toString());
        } else {
            // Covers the case of data not being ready yet.
            holder.depositAmountItemView.setText("No Deposits so far");
        }
    }

    void setDeposits(List<Deposits> deposits){
        mDeposits = deposits;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mDeposits != null)
            return mDeposits.size();
        else return 0;
    }

    class DepositViewHolder extends RecyclerView.ViewHolder {
        private final TextView depositAmountItemView;
        private final TextView depositDateItemView;

        private DepositViewHolder(View itemView) {
            super(itemView);
            depositAmountItemView = itemView.findViewById(R.id.textViewAmount);
            depositDateItemView = itemView.findViewById(R.id.textViewDate);
        }
    }

}
