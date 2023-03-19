package mx.unam.fciencias.materialdesign;

import android.content.res.Resources;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

public class InfiniteListAdapter extends RecyclerView.Adapter<InfiniteListAdapter.ListEntry> {

    private final List<String> DATASET;
    private final Resources RESOURCES;

    public InfiniteListAdapter(Resources res) {
        DATASET = new LinkedList<>();
        RESOURCES = res;
    }

    public  void addItem() {
        int i = DATASET.size();
        DATASET.add(i, RESOURCES.getString(R.string.infinite_list_entry_message, i+1));
        notifyItemInserted(i);
    }

    static class ListEntry extends RecyclerView.ViewHolder {
        private TextView entryText;

        ListEntry(TextView entryTV) {
            super(entryTV);
            entryText = entryTV;
        }
    }
}
