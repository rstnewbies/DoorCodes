package pl.newbies.doorcodes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        String[] content = {"foo", "bar", "hey"};
        adapter.addAll(content);
        listView.setOnItemClickListener(mMessageClickedHandler);
    }

    private OnItemClickListener mMessageClickedHandler = new OnItemClickListener()
    {
        public void onItemClick(AdapterView parent, View view, int position, long id)
        {
            adapter.add("Hello button #"+position+": "+adapter.getItem(position));
        }
    };
}
