package pl.newbies.doorcodes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddNewCodeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_code);
    }

    public void onButtonClick(View view) {
        finish();
    }

    public void onSaveButtonClick(View view) {

        EditText streetEditText = (EditText) findViewById(R.id.streetEditText);
        String streetact = streetEditText.getText().toString();
        EditText codeEditText = (EditText) findViewById(R.id.codeEditText);
        String codeact = codeEditText.getText().toString();

        DaoSession daoSession = (App.getInstance()).getDaoSession();
        GateDao gateDao = daoSession.getGateDao();
        Gate gate = new Gate();
        gate.name = streetact;
        gate.code = codeact;
        gateDao.save(gate);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


}
