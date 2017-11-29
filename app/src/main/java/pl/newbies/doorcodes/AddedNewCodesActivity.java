package pl.newbies.doorcodes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AddedNewCodesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.added_new_codes);
    }

    public void onButtonClick() {
        finish();
    }
}
