package com.example.mihogar.HelperClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mihogar.R;

import java.util.ArrayList;

public class FeaturedCaroussel extends RecyclerView.Adapter<FeaturedCaroussel.FeaturedViewHolder> {

    ArrayList<Help_2> featuredLocations;

    public FeaturedCaroussel(ArrayList<Help_2> featuredLocations) {
        this.featuredLocations = featuredLocations;
    }



    @NonNull
    @Override
    public FeaturedCaroussel.FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.caroussel_card, parent, false);
        FeaturedCaroussel.FeaturedViewHolder featuredViewHolder = new FeaturedCaroussel.FeaturedViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedCaroussel.FeaturedViewHolder holder, int position) {
        Help_2 featuredHelperClass = featuredLocations.get(position);

        holder.image.setImageResource(featuredHelperClass.getImage());

    }



    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }


    public static class FeaturedViewHolder extends RecyclerView.ViewHolder{

        ImageView image;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            //hooks
            image = itemView.findViewById(R.id.featured_image_item);
        }
    }
}
