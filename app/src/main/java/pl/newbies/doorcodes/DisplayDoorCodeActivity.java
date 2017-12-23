package pl.newbies.doorcodes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayDoorCodeActivity extends AppCompatActivity
{
    public static final String EXTRA_GATE="pl.newbies.doorcodes.GATE";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_door_code);

        Intent intent = getIntent();
        Gate gate = (Gate) intent.getSerializableExtra(EXTRA_GATE);

        TextView textView = (TextView)findViewById(R.id.textView);
        if(gate == null)
            textView.setText(R.string.door_code_error);
        else
            textView.setText(String.format(getResources().getString(R.string.door_code_msg), gate.getCode()));
    }

}
