package pl.newbies.doorcodes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{
    public static final String EXTRA_DOOR_ID = "pl.newbies.doorcodes.DOOR_ID";

    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list_view);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        String[] content = {"ul. Wałbrzyska 13/4", "ul. Długa 5/1", "ul. Krótka 6/3"};

        adapter.addAll(content);

        listView.setOnItemClickListener(new OnItemClickListener(){
            public void onItemClick(AdapterView parent, View view, int position, long id){
                startDoorCodeActivity(position);
            }});
    }

    public void startDoorCodeActivity(int position)
    {
        Intent intent = new Intent(this, DisplayDoorCodeActivity.class);
        intent.putExtra(EXTRA_DOOR_ID, position);
        startActivity(intent);
    }
}
