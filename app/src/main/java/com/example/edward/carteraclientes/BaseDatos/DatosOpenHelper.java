package com.example.edward.carteraclientes.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.edward.carteraclientes.BaseDatos.FeedReaderContract.FeedEntry;

//
public class DatosOpenHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_ENTRIES  =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry.COLUMN_NAME_NOMBRE + " VARCHAR(250), " +
                    FeedEntry.COLUMN_NAME_DIRECCION + " VARCHAR(250), " +
                    FeedEntry.COLUMN_NAME_EMAIL + " VARCHAR(200), " +
                    FeedEntry.COLUMN_NAME_TELEFONO + " VARCHAR(20))";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;

    public DatosOpenHelper(Context context) {
        super(context, "DATOS", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int il) {

    }
}
