package site.saiyi.noteone.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

import site.saiyi.noteone.Module.DaoMaster;
import site.saiyi.noteone.Module.NoteBoDao;

/**
 * Created by ding-syi on 2017/3/12.
 */

public class OnlineOpenHelper extends DaoMaster.OpenHelper{
    public OnlineOpenHelper(Context context,String name) {
        super(context, name);
    }

    public OnlineOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion );
        switch(oldVersion){
            //NoteBo表添加字段或删除字段更新
            case 1: MigrationHelper.getInstance().migrate(db,NoteBoDao.class);
        }
    }
}
