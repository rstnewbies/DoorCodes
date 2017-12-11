package pl.newbies.doorcodes;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

/**
 * Created by adidaser1 on 11.12.2017.
 */

public class App  extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        MyDevOpenHelper helper = new MyDevOpenHelper(this,"gates-db");
        Database db = helper.getWritableDb();

        daoSession = new DaoMaster(db).newSession();
        instance = this;
    }

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
