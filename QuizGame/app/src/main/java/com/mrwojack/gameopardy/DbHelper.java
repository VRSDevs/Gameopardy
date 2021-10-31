package com.mrwojack.gameopardy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mrwojack.gameopardy.QuizContract.*;
import com.mrwojack.gameopardy.fragments.questions.NormalQuestion;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    private static  final String DATABASE_NAME = "Quiz.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;



    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
              QuizContract.QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER + " INTEGER " + ")";


        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

   private void fillQuestionsTable(){

        NormalQuestion q1 = new NormalQuestion("¿hola?", "A", "B", "C", "D", 1);
        addQuestion(q1);
        NormalQuestion q2 = new NormalQuestion("¿?", "A", "B", "C", "D", 1);
        addQuestion(q2);
        NormalQuestion q3 = new NormalQuestion("¿?", "A", "B", "C", "D", 1);
        addQuestion(q3);

    }

    private void addQuestion(NormalQuestion normalquestion){
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, normalquestion.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, normalquestion.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, normalquestion.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, normalquestion.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, normalquestion.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER, normalquestion.getAnswer());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    public List<NormalQuestion> getAllQuestions(){
        List<NormalQuestion> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

    if(c.moveToFirst()){
        do{
            NormalQuestion question = new NormalQuestion();
            question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)+1));
            question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)+1));
            question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)+1));
            question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)+1));
            question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)+1));
            questionList.add(question);
        }while(c.moveToNext());
    }
    c.close();
    return questionList;

    }

}
