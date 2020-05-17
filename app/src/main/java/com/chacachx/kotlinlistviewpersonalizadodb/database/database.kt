package com.chacachx.kotlinlistviewpersonalizadodb.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class database(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USUARIOS (usuario text, nombre text, imagen text, dni text, PRIMARY KEY (usuario))");
        db?.execSQL("INSERT INTO USUARIOS VALUES('chacach', 'Alexander Chacach','https://w7.pngwing.com/pngs/621/411/png-transparent-computer-icons-python-anaconda-anaconda-angle-other-animals.png','789345432')");
        db?.execSQL("INSERT INTO USUARIOS VALUES('lopez', 'Alejandro Lopéz','https://w7.pngwing.com/pngs/177/242/png-transparent-plain-old-java-object-programming-language-computer-programming-object-oriented-programming-others-text-logo-computer-programming.png','6748923')");
        db?.execSQL("INSERT INTO USUARIOS VALUES('perez', 'Hugo Pérez','https://i7.pngflow.com/pngimage/733/997/png-c-programming-basics-for-absolute-beginners-computer-programming-programming-language-c-microsoft-purple-development-magenta-microsoft-clipart.png','73450274')");

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}