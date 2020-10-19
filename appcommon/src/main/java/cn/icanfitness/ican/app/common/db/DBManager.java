package cn.icanfitness.ican.app.common.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.wanzhong.common.util.StringUtil;
import com.wanzhong.common.util.SysContants;
import com.wanzhong.core.utils.CommonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import cn.icanfitness.ican.app.common.po.ProviceCityAreaItemPo;


/**
 * 数据库管理类
 */
public class DBManager {
    /**
     * The constant TAG
     */
    private static final String TAG = "DBManager";

    private AtomicInteger mOpenCounter = new AtomicInteger();
    private static DBManager instance;
    private static SQLiteOpenHelper mDBHelper;
    private SQLiteDatabase mDatabase;
    private boolean allowTransaction = true;
    private Lock writeLock = new ReentrantLock();
    private volatile boolean writeLocked = false;

    /**
     * 单例模式，初始化DBManager
     *
     * @return DBManager实例
     */
    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    /**
     * 数据库初始化
     *
     * @param context 当前上下文
     */
    public void init(Context context) {
        if (context == null) {
            return;
        }

        if (mDBHelper == null) {
            mDBHelper = new DBHelper(context.getApplicationContext());
        }
    }

    /**
     * 释放数据库
     */
    public void release() {
        if (mDBHelper != null) {
            mDBHelper.close();
            mDBHelper = null;
        }
        instance = null;
    }

    /**
     * 打开数据库
     */
    public synchronized SQLiteDatabase openDatabase() {
        if (mOpenCounter.incrementAndGet() == 1) {
            // Opening new database
            try {
                mDatabase = mDBHelper.getWritableDatabase();
            } catch (Exception e) {
                Log.e(TAG, "openDatabase e = " + e.getMessage());
                mDatabase = mDBHelper.getReadableDatabase();
            }
        }
        return mDatabase;
    }

    /**
     * 关闭数据库
     */
    public synchronized void closeDatabase() {
        if (mOpenCounter.decrementAndGet() == 0) {
            // Closing database
            mDatabase.close();
        }
    }

    private void beginTransaction(SQLiteDatabase mDatabase) {
        if (allowTransaction) {
            mDatabase.beginTransaction();
        } else {
            writeLock.lock();
            writeLocked = true;
        }
    }

    private void setTransactionSuccessful(SQLiteDatabase mDatabase) {
        if (allowTransaction) {
            mDatabase.setTransactionSuccessful();
        }
    }

    private void endTransaction(SQLiteDatabase mDatabase) {
        try{
            if (allowTransaction && mDatabase != null) {
                mDatabase.endTransaction();
            }
            if (writeLocked) {
                writeLock.unlock();
                writeLocked = false;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void closeCursor(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable e) {
                Log.e(TAG, "closeCursor e = " + e.getMessage());
            }
        }
    }
    /**
     * 添加信息
     */
    public boolean addAreaData(ProviceCityAreaItemPo po) {
        if (mDBHelper == null) {
            return false;
        }
        try {
            mDatabase = mDBHelper.getWritableDatabase();
            beginTransaction(mDatabase);

            ContentValues cv = new ContentValues();
            cv.put("code", po.getCode());
            cv.put("name", po.getName());
            cv.put("firstletter", po.getFirstletter());
            cv.put("parent_code", po.getParent_code());


            long rowId = mDatabase.insert(DBHelper.TABLE_AREA, null, cv);
            if (rowId < 0) {
                Log.i(TAG, "add failed :" + po.getName());
                return false;
            }

            setTransactionSuccessful(mDatabase);
            //Log.i(TAG, "insert user success:" + rowId);
        } catch (Exception e) {
            //Log.e(TAG, "addUser e = " + e.getMessage());
            Log.i(TAG, "add failed :" + po.getName());

            return false;
        } finally {
            endTransaction(mDatabase);
        }

        Log.i(TAG, "add succ== :" + po.getName());
        return true;
    }

    public List<ProviceCityAreaItemPo> queryAreaInfo(Context context,String parentCode) {
        List<ProviceCityAreaItemPo> list = new ArrayList<ProviceCityAreaItemPo>();
        Cursor cursor = null;
        SQLiteDatabase db = null;
        try {
            if (mDBHelper == null) {
                init(context);
                //return null;
            }
            db = mDBHelper.getReadableDatabase();
            String where =  "1 = 1";
                    //"user_id = ? and type1 = ? and type2 = ? and type3 = ?";
            String[] whereValue = null;
            if(StringUtil.isNullOrSpace(parentCode)){
                //省级
                where = "parent_code ISNULL";
            } else {
                where = "parent_code = ? ";
                whereValue = new String[]{parentCode};
            }
                    //{userId,App.getInstance().getType1(),App.getInstance().getType2(),App.getInstance().getType3()};
            cursor = db.query(DBHelper.TABLE_AREA, null, where, whereValue, null, null, " firstletter ASC ");

            if (cursor != null && cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    int dbId = cursor.getInt(cursor.getColumnIndex("_id"));
                    String code = cursor.getString(cursor.getColumnIndex("code"));
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String firstletter = cursor.getString(cursor.getColumnIndex("firstletter"));
                    String parent_code = cursor.getString(cursor.getColumnIndex("parent_code"));

                    ProviceCityAreaItemPo areaItemPo = new ProviceCityAreaItemPo();
                    areaItemPo.setCode(code);
                    areaItemPo.setName(name);
                    areaItemPo.setFirstletter(firstletter == null ? SysContants.CHAR_EMPTY : firstletter.toUpperCase());
                    areaItemPo.setParent_code(parent_code);

                    list.add(areaItemPo);
                }
            }
        } catch (Exception e) {
            CommonUtil.err("e.getMessage() "+e.getMessage());
        } finally {
            closeCursor(cursor);
            if(db != null){
                db.close();
            }

        }
        return list;
    }

    public void initDB(Context context){
        SQLiteDatabase db = null;
        try{
            if (mDBHelper == null) {
                init(context);
                //return null;
            }
            db = mDBHelper.getReadableDatabase();
        } catch (Exception e){

        } finally {
            if(db != null){
                db.close();
            }
            release();
        }

    }


}