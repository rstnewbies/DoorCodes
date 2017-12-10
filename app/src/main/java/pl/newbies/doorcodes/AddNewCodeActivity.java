package pl.newbies.doorcodes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class AddNewCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_code);
    }

    public void onButtonClick() {
        finish();
    }

    public void onSaveButtonClick() {
        EditText streetEditText = (EditText) findViewById(R.id.streetEditText);
        String street = streetEditText.getText().toString();
        EditText codeEditText = (EditText) findViewById(R.id.codeEditText);
        String code = codeEditText.getText().toString();
        // TODO zapisać zmienne street i code do bazy danych
        finish();
    }
}