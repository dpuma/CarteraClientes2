package com.example.edward.carteraclientes.BaseDatos;

import android.provider.BaseColumns;

public final class FeedReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "CLIENTE";
        public static final String COLUMN_NAME_NOMBRE = "NOMBRE";
        public static final String COLUMN_NAME_DIRECCION = "DIRECCION";
        public static final String COLUMN_NAME_EMAIL = "EMAIL";
        public static final String COLUMN_NAME_TELEFONO = "TELEFONO";
    }
}