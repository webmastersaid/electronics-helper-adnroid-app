package com.example.electronicshelper.ui.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electronicshelper.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SubItemAdapter extends RecyclerView.Adapter<SubItemAdapter.SubItemViewHolder> implements Filterable {

    private final List<SubItem> subItemList;
    private final List<SubItem> subItemListFull;
    private final OnSubItemListener mOnSubItemListener;

    public interface OnSubItemListener{
        void OnSubItemClick(int position);
    }

    public SubItemAdapter(List<SubItem> subItemList, OnSubItemListener onSubItemListener) {
        this.subItemList = subItemList;
        this.mOnSubItemListener = onSubItemListener;
        subItemListFull = new ArrayList<>(subItemList);
    }

    @NonNull
    @Override
    public SubItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_sub_item, viewGroup, false);
        return new SubItemViewHolder(view, mOnSubItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SubItemViewHolder subItemViewHolder, int position) {
        SubItem subItem = subItemList.get(position);
        subItemViewHolder.ivSubItemImage.setImageResource(subItem.getSubItemImage());
        subItemViewHolder.tvSubItemTitle.setText(subItem.getSubItemTitle());
        subItemViewHolder.tvSubItemDesc.setText(subItem.getSubItemDesc());
    }

    @Override
    public int getItemCount() {
        return subItemList.size();
    }



    public static class SubItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ivSubItemImage;
        TextView tvSubItemTitle;
        TextView tvSubItemDesc;
        OnSubItemListener onSubItemListener;

        SubItemViewHolder(View itemView, OnSubItemListener onSubItemListener) {
            super(itemView);
            ivSubItemImage = itemView.findViewById(R.id.img_sub_item);
            tvSubItemTitle = itemView.findViewById(R.id.tv_sub_item_title);
            tvSubItemDesc = itemView.findViewById(R.id.tv_sub_item_desc);
            this.onSubItemListener = onSubItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onSubItemListener.OnSubItemClick(getLayoutPosition());
        }
    }

    @Override
    public Filter getFilter() {
        return itemFilter;
    }

    private final Filter itemFilter = new Filter() {
        @NotNull
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<SubItem> filteredList = new ArrayList<>();
            if (charSequence == null || charSequence.length() == 0){
                filteredList.addAll(subItemListFull);
            } else {
                String filterPattern = charSequence.toString().toLowerCase().trim();
                for(SubItem item : subItemListFull){
                    if (item.getSubItemTitle().toLowerCase().contains(filterPattern) ||
                            item.getSubItemDesc().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;

        }

        @SuppressLint("NotifyDataSetChanged")
        @Override
        protected void publishResults(CharSequence charSequence, @NotNull FilterResults filterResults) {
            subItemList.clear();
            subItemList.addAll((Collection<? extends SubItem>) filterResults.values);
            notifyDataSetChanged();
        }
    };


}
