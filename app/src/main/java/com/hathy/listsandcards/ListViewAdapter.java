package com.hathy.listsandcards;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.PersonViewHolder> {

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        ImageView personPhoto;
        LinearLayout layoutDescription;

        PersonViewHolder(View itemView) {
            super(itemView);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
            layoutDescription = (LinearLayout) itemView.findViewById(R.id.lltDescription);
        }
    }

    List<Boat> boats;

    ListViewAdapter(List<Boat> boats){
        this.boats = boats;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        Boat currBoat = boats.get(i);
        personViewHolder.personPhoto.setImageResource(currBoat.photoId);
        for(int j =0;j<currBoat.description.size();j++){
            Log.d("MyLog", "Description №" + (j+1) + " showed!");
            View v = LayoutInflater.from(personViewHolder.layoutDescription.getContext()).inflate(R.layout.description_layout, personViewHolder.layoutDescription, false);
            TextView textView = (TextView) v.findViewById(R.id.txtDescription);
            textView.setText(currBoat.description.toArray()[j].toString());
            personViewHolder.layoutDescription.addView(v);
        }
    }

    @Override
    public int getItemCount() {
        return boats.size();
    }
}
