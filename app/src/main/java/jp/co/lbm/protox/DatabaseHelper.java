package jp.co.lbm.protox;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "configuration";
    private static String DATABASE_ASSET = "configuration.db";
    private static final int DATABASE_VERSION = 1;

    private final Context m_context;
    private final File m_databasePath;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.m_context = context;
        m_databasePath = m_context.getDatabasePath(DATABASE_NAME);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
