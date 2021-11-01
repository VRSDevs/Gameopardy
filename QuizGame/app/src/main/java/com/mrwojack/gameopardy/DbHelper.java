package com.mrwojack.gameopardy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mrwojack.gameopardy.QuizContract.*;
import com.mrwojack.gameopardy.fragments.questions.Questions;

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
        //Creacion de la tabla de las preguntas normales
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
              QuizContract.QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION5 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION6 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER + " INTEGER, " +
                QuestionsTable.COLUMN_CATEGORY + " TEXT " + ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);

        fillQuestionsTable();
    }

   private void fillQuestionsTable(){
        //Preguntas normales

        Questions qM1 = new Questions("quien eres","a","b","c","g","","",2,"historia");
        addQuestionM(qM1);
    }



    private void addQuestionM(Questions questions){
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION,questions.getQuestion() );
        cv.put(QuestionsTable.COLUMN_OPTION1, questions.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, questions.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, questions.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, questions.getOption4());
        cv.put(QuestionsTable.COLUMN_OPTION5, questions.getOption5());
        cv.put(QuestionsTable.COLUMN_OPTION6, questions.getOption6());
        cv.put(QuestionsTable.COLUMN_ANSWER, questions.getAnswer());
        cv.put(QuestionsTable.COLUMN_CATEGORY, questions.getAnswer());

        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);

    }

    public List<Questions> getAllNormalQuestions(){
        List<Questions> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

    if(c.moveToFirst()){
        do{
            Questions question = new Questions();
            question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)+1));
            question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)+1));
            question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)+1));
            question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)+1));
            question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)+1));
            question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION5)+1));
            question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION6)+1));
            question.setAnswer(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER)+1));
            question.setCategoria(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY)+1));

            questionList.add(question);
        }while(c.moveToNext());
    }
    c.close();
        return questionList;

    }
}
