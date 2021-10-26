package com.mrwojack.gameopardy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mrwojack.gameopardy.QuizContract.*;
import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static  final String DATABASE_NAME = "Quizz.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;



    public DbHelper(@Nullable Context context, ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
              QuizContract.QuestionsTable.TABLE_NAME + "(" +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER + " INTEGER, " + ")";


        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

   private void fillQuestionsTable(){
       Question
   }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
db.execSQL("DROP TABLE IF EXISTS" + QuestionsTable.TABLE_NAME);
onCreate(db);
    }
}
