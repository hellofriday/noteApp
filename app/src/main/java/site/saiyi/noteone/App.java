package site.saiyi.noteone;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import site.saiyi.noteone.Module.DaoMaster;
import site.saiyi.noteone.Module.DaoSession;
import site.saiyi.noteone.db.DbCore;

/**
 * Created by ding-syi on 2017/3/12.
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        DbCore.init(this);                 //初始化GreenDao
        DbCore.enableQueryBuilderLog();    //打印sql语句日志
    }

}
