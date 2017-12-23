package pl.newbies.doorcodes;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import java.util.List;

/**
 * Created by adidaser1 on 11.12.2017.
 */

@Entity
public class Gate implements Serializable {
static final long serialVersionUID = 1L;
    @Id
    public Long id;


    public String name;
    public String code;
    @Generated(hash = 2120593570)
    public Gate(Long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
    @Generated(hash = 833346218)
    public Gate() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return this.code;
    }
    public void setCode(String code) {
        this.code = code;
    }

//TODO stworzyc creata

    public static List<Gate> getAllData() {
        DaoSession daoSession = (App.getInstance()).getDaoSession();
        GateDao gateDao = daoSession.getGateDao();

        return gateDao.queryBuilder().orderAsc(GateDao.Properties.Name).list();
    }
}