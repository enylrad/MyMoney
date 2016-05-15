package es.enylrad.economy.mymoney.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import es.enylrad.economy.mymoney.R;
import es.enylrad.economy.mymoney.clases.Concepto;

public class ConceptoAdapter extends RecyclerView.Adapter<ConceptoAdapter.ViewHolder> {

    private Activity activity;
    private ArrayList<Concepto> conceptos;

    public ConceptoAdapter(ArrayList<Concepto> conceptos, Activity activity) {
        this.conceptos = conceptos;
        this.activity = activity;
    }

    @Override
    public int getItemCount() {
        return conceptos.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_concepto, viewGroup, false);
        ViewHolder pvh = new ViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {

        int position = holder.getAdapterPosition() - 1;

        if (conceptos.get(position).isIngreso()) {
            holder.getConcepto().setText("Ingreso " + (position + 1));
            holder.getFondo().setBackgroundColor(activity.getResources().getColor(R.color.ingreso));
        } else {
            holder.getConcepto().setText("Gasto " + (position + 1));
            if (conceptos.get(position).getCantidad() != 0)
                holder.getFondo().setBackgroundColor(activity.getResources().getColor(R.color.gasto));
        }
        holder.getCantidad().setText(conceptos.get(position).getCantidad() + "€");
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout fondo;
        private TextView concepto;
        private TextView cantidad;

        ViewHolder(View view) {
            super(view);

            concepto = (TextView) view.findViewById(R.id.txt_concepto);
            cantidad = (TextView) view.findViewById(R.id.txt_cantidad);
            fondo = (RelativeLayout) view.findViewById(R.id.relative_cell);
        }

        public RelativeLayout getFondo() {
            return fondo;
        }

        public void setFondo(RelativeLayout fondo) {
            this.fondo = fondo;
        }

        public TextView getConcepto() {
            return concepto;
        }

        public void setConcepto(TextView concepto) {
            this.concepto = concepto;
        }

        public TextView getCantidad() {
            return cantidad;
        }

        public void setCantidad(TextView cantidad) {
            this.cantidad = cantidad;
        }
    }

}