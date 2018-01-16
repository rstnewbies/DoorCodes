package pl.newbies.doorcodes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.greendao.query.DeleteQuery;
import org.greenrobot.greendao.query.QueryBuilder;

public class DisplayDoorCodeActivity extends AppCompatActivity {
    public static final String EXTRA_GATE = "pl.newbies.doorcodes.GATE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_door_code);

        Intent intent = getIntent();
        Gate gate = (Gate) intent.getSerializableExtra(EXTRA_GATE);
        TextView gateView = (TextView) findViewById(R.id.gateView);
        TextView textView = (TextView) findViewById(R.id.textView);
        if (gate == null)
            textView.setText(R.string.door_code_error);
        else {
            textView.setText(String.format(getResources().getString(R.string.door_code_msg), gate.getCode()));
            gateView.setText(String.format(getResources().getString(R.string.door_name_msg), gate.getName()));

        }
    }

    public void onDeleteButton(View view) {
        Long id;


        DaoSession daoSession = (App.getInstance()).getDaoSession();
        GateDao gateDao = daoSession.getGateDao();

        Intent intent = getIntent();
        Gate gate = (Gate) intent.getSerializableExtra(EXTRA_GATE);

        if (gate != null) {

            id = gate.getId();


            QueryBuilder<Gate> qb = gateDao.queryBuilder();
            DeleteQuery<Gate> bd = qb.where(GateDao.Properties.Id.eq(id)).buildDelete();
            bd.executeDeleteWithoutDetachingEntities();
            Toast.makeText(getApplicationContext(), R.string.delete_success, Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(getApplicationContext(), R.string.delete_problem_null, Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
