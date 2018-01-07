package pl.newbies.doorcodes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        String street = streetEditText.getText().toString().trim();
        EditText codeEditText = (EditText) findViewById(R.id.codeEditText);
        String code = codeEditText.getText().toString().trim();

        if(street.isEmpty())
        {
            Toast.makeText(getApplicationContext(), R.string.field_street_empty_msg, Toast.LENGTH_SHORT).show();
            return;
        }
        else if(code.isEmpty())
        {
            Toast.makeText(getApplicationContext(), R.string.field_code_empty_msg, Toast.LENGTH_SHORT).show();
            return;
        }

        DaoSession daoSession = (App.getInstance()).getDaoSession();
        GateDao gateDao = daoSession.getGateDao();
        Gate gate = new Gate();
        gate.name = street;
        gate.code = code;
        gateDao.save(gate);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


}
