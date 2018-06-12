package com.tiwarithetiger11gmail.myengineeringpdfs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by MURARI TIWARI on 10/24/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.myViewHolder> {

    private List<modal> modals;
    private Context context;

    public RecyclerAdapter(List<modal> modals,Context context) {
        this.modals = modals;
        this.context = context;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

     View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view,parent,false);
        return new myViewHolder(view);
    }


    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        holder.subject.setText(modals.get(position).getSubject());
        holder.description.setText(modals.get(position).getDescription());
        holder.pdf.setText(modals.get(position).getPdfname());
    }

    @Override
    public int getItemCount() {
        return modals.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView subject,description,pdf;
        public myViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            subject=(TextView)itemView.findViewById(R.id.subject);
            description=(TextView)itemView.findViewById(R.id.description);
            pdf=(TextView)itemView.findViewById(R.id.pdfname);
        }

        @Override
        public void onClick(View view) {
            String url = "http://10.0.2.2:3000/tplain/empty/"+pdf.getText().toString();
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            context.startActivity(i);


        }
    }

}
