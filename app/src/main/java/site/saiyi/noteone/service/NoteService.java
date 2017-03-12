package site.saiyi.noteone.service;

import site.saiyi.noteone.Module.NoteBo;
import site.saiyi.noteone.db.BaseService;
import site.saiyi.noteone.db.DbCore;

/**
 * Created by ding-syi on 2017/3/12.
 */

public class NoteService extends BaseService<NoteBo, Long> {
    public NoteService() {
        super(DbCore.getDaoSession().getNoteBoDao());
    }

    public static NoteService getInstance(){
        return SingleLoader.INSTANCE;
    }

    private static class SingleLoader{
        final static NoteService INSTANCE = new NoteService();
    }
}
