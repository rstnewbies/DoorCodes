package pl.newbies.doorcodes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DoorCodeAdapter extends RecyclerView.Adapter<DoorCodeAdapter.ViewHolder>
{
    private Context context;
    private List<Gate> content = new ArrayList<>();

   public DoorCodeAdapter(Context context)
    {
        this.context = context;
   }

    @Override
    public DoorCodeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position)
    {

        holder.txtContent.setText(content.get(position).getName());
        holder.txtContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DisplayDoorCodeActivity.class);
                intent.putExtra(DisplayDoorCodeActivity.EXTRA_GATE, content.get(holder.getAdapterPosition()));
                context.startActivity(intent);
            }
        });
        holder.editButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                TODO add activity edit code
//                Intent intent = new Intent(context, DisplayDoorCodeActivity.class);
//                intent.putExtra(MainActivity.EXTRA_DOOR_ID, holder.getAdapterPosition());
//                context.startActivity(intent);
            }
        });
    }



    public void remove(int position)
    {
        content.remove(position);
        notifyItemRemoved(position);
    }


    public void addData(Gate content) {
        this.content.add(content);
        notifyDataSetChanged();
    }
    public void clear() {
        this.content.clear();
    }

    @Override
    public int getItemCount()
    {
        return content.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtContent;
        public ImageView editButton;
        public View layout;

        public ViewHolder(View view)
        {
            super(view);
            layout = view;
            txtContent = view.findViewById(R.id.contentTextView);
            editButton = view.findViewById(R.id.editImageView);
        }
    }

}
