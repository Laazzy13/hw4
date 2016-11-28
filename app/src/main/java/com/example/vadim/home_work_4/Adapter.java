package com.example.vadim.home_work_4;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private String[] Str_1;
    private String[] Str_2;

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name;
        TextView post;

        ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.textView1);
            post = (TextView) v.findViewById(R.id.textView2);
            v.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Item № " + (getAdapterPosition() + 1)
                    +"\nName: " + name.getText().toString()
                    + "\nPost: " + post.getText().toString(),
                    Toast.LENGTH_SHORT).show();
        }
    }

    Adapter(String[] str1, String[] str2) {
        Str_1 = str1;
        Str_2 = str2;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_recycler_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(Str_1[position]);
        holder.post.setText(Str_2[position]);
    }

    @Override
    public int getItemCount() {
        return Str_1.length;
    }

}
