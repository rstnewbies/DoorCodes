package pl.newbies.doorcodes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayDoorCodeActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_door_code);

        Intent intent = getIntent();
        int doorId = intent.getIntExtra(MainActivity.EXTRA_DOOR_ID, -1);

        TextView textView = (TextView)findViewById(R.id.textView);
        if(doorId<0)
            textView.setText(R.string.door_code_error);
        else
            textView.setText(String.format(getResources().getString(R.string.door_code_msg), doorId));
    }

}
