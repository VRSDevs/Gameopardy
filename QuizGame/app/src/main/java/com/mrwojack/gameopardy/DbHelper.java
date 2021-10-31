package com.mrwojack.gameopardy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mrwojack.gameopardy.QuizContract.*;
import com.mrwojack.gameopardy.fragments.questions.ImagesQuestions;
import com.mrwojack.gameopardy.fragments.questions.NormalQuestion;
import com.mrwojack.gameopardy.fragments.questions.AudioQuestions;
import com.mrwojack.gameopardy.fragments.questions.VerdaderoFalsoQuestions;
import com.mrwojack.gameopardy.fragments.questions.MultipleChoiceQuestions;

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
        //Creacion de la tabla de las preguntas normales
        final String SQL_CREATE_NORMAL_QUESTIONS_TABLE = "CREATE TABLE " +
              QuizContract.QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER + " INTEGER " + ")";

        //Creacion de la tabla de las preguntas de varias opciones
        final String SQL_CREATE_MULTIPLE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizContract.QuestionsMultipleTable.TABLE_NAME + " ( " +
                QuestionsMultipleTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsMultipleTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsMultipleTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsMultipleTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsMultipleTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsMultipleTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsMultipleTable.COLUMN_OPTION5 + " TEXT, " +
                QuestionsMultipleTable.COLUMN_OPTION6 + " TEXT, " +
                QuestionsMultipleTable.COLUMN_ANSWER + " INTEGER " + ")";

        final String SQL_CREATE_IMAGES_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizContract.QuestionsImagesTable.TABLE_NAME + " ( " +
                QuestionsImagesTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsImagesTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsImagesTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsImagesTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsImagesTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsImagesTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsImagesTable.COLUMN_ANSWER + " INTEGER " + ")";

        final String SQL_CREATE_TRUE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizContract.VerdaderoFalsoQuestions.TABLE_NAME + " ( " +
                QuizContract.VerdaderoFalsoQuestions._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract.VerdaderoFalsoQuestions.COLUMN_QUESTION + " TEXT, " +
                QuizContract.VerdaderoFalsoQuestions.COLUMN_OPTION1 + " TEXT, " +
                QuizContract.VerdaderoFalsoQuestions.COLUMN_OPTION2 + " TEXT, " +
                QuizContract.VerdaderoFalsoQuestions.COLUMN_ANSWER + " INTEGER " + ")";


        db.execSQL(SQL_CREATE_NORMAL_QUESTIONS_TABLE);
        db.execSQL(SQL_CREATE_MULTIPLE_QUESTIONS_TABLE);
        db.execSQL(SQL_CREATE_IMAGES_QUESTIONS_TABLE);

        fillQuestionsTable();
    }

   private void fillQuestionsTable(){
        //Preguntas normales
        NormalQuestion qN1 = new NormalQuestion("¿hola?", "A", "B", "C", "D", 1);
        addQuestionN(qN1);
        NormalQuestion qN2 = new NormalQuestion("¿?", "A", "B", "C", "D", 1);
        addQuestionN(qN2);
        NormalQuestion qN3 = new NormalQuestion("¿?", "A", "B", "C", "D", 1);
        addQuestionN(qN3);

        ImagesQuestions qI1 = new ImagesQuestions("¿hola?", "A", "B", "C", "D", 1);

        VerdaderoFalsoQuestions qVF1 = new VerdaderoFalsoQuestions("","","",1);

        MultipleChoiceQuestions qM1 = new MultipleChoiceQuestions("a","a","a","a","a","a","a",1);
    }

    private void addQuestionN(NormalQuestion normalquestion){
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, normalquestion.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, normalquestion.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, normalquestion.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, normalquestion.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, normalquestion.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER, normalquestion.getAnswer());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    private void addQuestionM(MultipleChoiceQuestions Multiplequestion){
        ContentValues cv = new ContentValues();
        cv.put(QuestionsMultipleTable.COLUMN_QUESTION, Multiplequestion.getQuestion());
        cv.put(QuestionsMultipleTable.COLUMN_OPTION1, Multiplequestion.getOption1());
        cv.put(QuestionsMultipleTable.COLUMN_OPTION2, Multiplequestion.getOption2());
        cv.put(QuestionsMultipleTable.COLUMN_OPTION3, Multiplequestion.getOption3());
        cv.put(QuestionsMultipleTable.COLUMN_OPTION4, Multiplequestion.getOption4());
        cv.put(QuestionsMultipleTable.COLUMN_OPTION5, Multiplequestion.getOption5());
        cv.put(QuestionsMultipleTable.COLUMN_OPTION6, Multiplequestion.getOption6());
        cv.put(QuestionsMultipleTable.COLUMN_ANSWER, Multiplequestion.getAnswer());
        db.insert(QuestionsMultipleTable.TABLE_NAME, null, cv);
    }

    private void addQuestionI(ImagesQuestions imagesQuestions){
        ContentValues cv = new ContentValues();
        cv.put(QuestionsImagesTable.COLUMN_QUESTION, imagesQuestions.getQuestion());
        cv.put(QuestionsImagesTable.COLUMN_OPTION1, imagesQuestions.getOption1());
        cv.put(QuestionsImagesTable.COLUMN_OPTION2, imagesQuestions.getOption2());
        cv.put(QuestionsImagesTable.COLUMN_OPTION3, imagesQuestions.getOption3());
        cv.put(QuestionsImagesTable.COLUMN_OPTION4, imagesQuestions.getOption4());
        cv.put(QuestionsImagesTable.COLUMN_ANSWER, imagesQuestions.getAnswer());
        db.insert(QuestionsImagesTable.TABLE_NAME, null, cv);
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
