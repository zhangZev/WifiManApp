/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package cn.icanfitness.ican.app.common.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.wanzhong.core.utils.CommonUtil;

import cn.icanfitness.ican.app.common.AppCommon;
import cn.icanfitness.ican.app.common.R;
import cn.icanfitness.ican.app.common.utils.FileUtils;


/**
 * 数据库创建工具
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String CREATE_TABLE_START_SQL = "CREATE TABLE IF NOT EXISTS ";
    private static final String CREATE_TABLE_PRIMIRY_SQL = " integer primary key autoincrement,";

    /**
     * 数据库名称
     */
    public static final String DB_NAME = "ican.db";
    /**
     * 数据库版本
     */
    private static final int VERSION = 1;

    /**
     * 行政区域 表
     */
    public static final String TABLE_AREA = "area";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
        CommonUtil.log("cx"," DBHelper === ");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //createTables(db);
        CommonUtil.log("cx"," onCreate === ");
        String dbPath = "/data/data/"+ AppCommon.getInstance().getPackageName()+"/databases/"+ DBHelper.DB_NAME;
        boolean succ = FileUtils.copyRawFile(AppCommon.getInstance(), R.raw.area,dbPath);
        CommonUtil.log("cx"," succ === "+succ);
    }

    @Override
    public synchronized void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        CommonUtil.log("cx"," onUpgrade === ");

        if (newVersion > oldVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_AREA);
            onCreate(db);
        }
    }

    public synchronized void createTables(SQLiteDatabase db) {
        if (db == null || db.isReadOnly()) {
            db = getWritableDatabase();
        }

        // 创建行政区域表的SQL语句
        StringBuffer groupSql = new StringBuffer();
        groupSql.append(CREATE_TABLE_START_SQL).append(TABLE_AREA).append(" ( ");
        groupSql.append(" _id").append(CREATE_TABLE_PRIMIRY_SQL);
        groupSql.append(" code").append(" varchar(32) default \"\" ,");
        groupSql.append(" name").append(" varchar(256) default \"\"  ,");
        groupSql.append(" firstletter").append(" varchar(2) default \"\" ,");
        groupSql.append(" parent_code").append(" varchar(32) default \"\" )");

        try {
            db.execSQL(groupSql.toString());
            db.execSQL("CREATE INDEX code ON "+TABLE_AREA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
