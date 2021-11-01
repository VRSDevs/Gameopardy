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

        final String SQL_CREATE_AUDIO_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizContract.AudioQuestionsTable.TABLE_NAME + " ( " +
                QuizContract.AudioQuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract.AudioQuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuizContract.AudioQuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuizContract.AudioQuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuizContract.AudioQuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuizContract.AudioQuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuizContract.AudioQuestionsTable.COLUMN_ANSWER + " INTEGER " + ")";

        final String SQL_CREATE_TRUE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizContract.VerdaderoFalsoQuestionsTable.TABLE_NAME + " ( " +
                QuizContract.VerdaderoFalsoQuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract.VerdaderoFalsoQuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuizContract.VerdaderoFalsoQuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuizContract.VerdaderoFalsoQuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuizContract.VerdaderoFalsoQuestionsTable.COLUMN_ANSWER + " INTEGER " + ")";

        db.execSQL(SQL_CREATE_TRUE_QUESTIONS_TABLE);
        db.execSQL(SQL_CREATE_AUDIO_QUESTIONS_TABLE);
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
        addQuestionI(qI1);

        VerdaderoFalsoQuestions qVF1 = new VerdaderoFalsoQuestions("","","",1);
        addQuestionVF(qVF1);

        AudioQuestions qA1 = new AudioQuestions("¿hola?", "A", "B", "C", "D", 1);
        addQuestionA(qA1);

        MultipleChoiceQuestions qM1 = new MultipleChoiceQuestions("a","a","a","a","a","a","a",1);
        addQuestionM(qM1);
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

    private void addQuestionA(AudioQuestions audioQuestions){
        ContentValues cv = new ContentValues();
        cv.put(AudioQuestionsTable.COLUMN_QUESTION, audioQuestions.getQuestion());
        cv.put(AudioQuestionsTable.COLUMN_OPTION1, audioQuestions.getOption1());
        cv.put(AudioQuestionsTable.COLUMN_OPTION2, audioQuestions.getOption2());
        cv.put(AudioQuestionsTable.COLUMN_OPTION3, audioQuestions.getOption3());
        cv.put(AudioQuestionsTable.COLUMN_OPTION4, audioQuestions.getOption4());
        cv.put(AudioQuestionsTable.COLUMN_ANSWER, audioQuestions.getAnswer());
        db.insert(AudioQuestionsTable.TABLE_NAME, null, cv);
    }

    private void addQuestionVF(VerdaderoFalsoQuestions VFquestions){
        ContentValues cv = new ContentValues();
        cv.put(VerdaderoFalsoQuestionsTable.COLUMN_QUESTION, VFquestions.getQuestion());
        cv.put(VerdaderoFalsoQuestionsTable.COLUMN_OPTION1, VFquestions.getOption1());
        cv.put(VerdaderoFalsoQuestionsTable.COLUMN_OPTION2, VFquestions.getOption2());
        cv.put(VerdaderoFalsoQuestionsTable.COLUMN_ANSWER, VFquestions.getAnswer());
        db.insert(VerdaderoFalsoQuestionsTable.TABLE_NAME, null, cv);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsMultipleTable.TABLE_NAME);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + AudioQuestionsTable.TABLE_NAME);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + VerdaderoFalsoQuestionsTable.TABLE_NAME);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsImagesTable.TABLE_NAME);
        onCreate(db);
    }

    public List<NormalQuestion> getAllNormalQuestions(){
        List<NormalQuestion> questionList2 = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

    if(c.moveToFirst()){
        do{
            NormalQuestion question = new NormalQuestion();
            question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)+1));
            question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)+1));
            question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)+1));
            question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)+1));
            question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)+1));
            question.setAnswer(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER)+1));
            questionList2.add(question);
        }while(c.moveToNext());
    }
    c.close();
    return questionList2;

    }

    public List<VerdaderoFalsoQuestions> getAllVTQuestions(){
        List<VerdaderoFalsoQuestions> questionList1 = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + VerdaderoFalsoQuestionsTable.TABLE_NAME, null);

        if(c.moveToFirst()){
            do{
                VerdaderoFalsoQuestions VFquestion = new VerdaderoFalsoQuestions();
                VFquestion.setQuestion(c.getString(c.getColumnIndex(VerdaderoFalsoQuestionsTable.COLUMN_QUESTION)+1));
                VFquestion.setOption1(c.getString(c.getColumnIndex(VerdaderoFalsoQuestionsTable.COLUMN_OPTION1)+1));
                VFquestion.setOption2(c.getString(c.getColumnIndex(VerdaderoFalsoQuestionsTable.COLUMN_OPTION2)+1));
                VFquestion.setAnswer(c.getInt(c.getColumnIndex(VerdaderoFalsoQuestionsTable.COLUMN_ANSWER)+1));

                questionList1.add(VFquestion);
            }while(c.moveToNext());
        }
        c.close();
        return questionList1;

    }

    public List<AudioQuestions> getAllAudioQuestions(){
        List<AudioQuestions> questionList3 = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + AudioQuestionsTable.TABLE_NAME, null);

        if(c.moveToFirst()){
            do{
                AudioQuestions audioquestion = new AudioQuestions();
                audioquestion.setQuestion(c.getString(c.getColumnIndex(AudioQuestionsTable.COLUMN_QUESTION)+1));
                audioquestion.setOption1(c.getString(c.getColumnIndex(AudioQuestionsTable.COLUMN_OPTION1)+1));
                audioquestion.setOption2(c.getString(c.getColumnIndex(AudioQuestionsTable.COLUMN_OPTION2)+1));
                audioquestion.setOption3(c.getString(c.getColumnIndex(AudioQuestionsTable.COLUMN_OPTION2)+1));
                audioquestion.setOption4(c.getString(c.getColumnIndex(AudioQuestionsTable.COLUMN_OPTION2)+1));
                audioquestion.setAnswer(c.getInt(c.getColumnIndex(AudioQuestionsTable.COLUMN_ANSWER)+1));

                questionList3.add(audioquestion);
            }while(c.moveToNext());
        }
        c.close();
        return questionList3;

    }
    public List<MultipleChoiceQuestions> getAllMultipleQuestions(){
        List<MultipleChoiceQuestions> questionList4 = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsMultipleTable.TABLE_NAME, null);

        if(c.moveToFirst()){
            do{
                MultipleChoiceQuestions Multiplequestion = new MultipleChoiceQuestions();
                Multiplequestion.setQuestion(c.getString(c.getColumnIndex(QuestionsMultipleTable.COLUMN_QUESTION)+1));
                Multiplequestion.setOption1(c.getString(c.getColumnIndex(QuestionsMultipleTable.COLUMN_OPTION1)+1));
                Multiplequestion.setOption2(c.getString(c.getColumnIndex(QuestionsMultipleTable.COLUMN_OPTION2)+1));
                Multiplequestion.setOption3(c.getString(c.getColumnIndex(QuestionsMultipleTable.COLUMN_OPTION2)+1));
                Multiplequestion.setOption4(c.getString(c.getColumnIndex(QuestionsMultipleTable.COLUMN_OPTION2)+1));
                Multiplequestion.setOption5(c.getString(c.getColumnIndex(QuestionsMultipleTable.COLUMN_OPTION2)+1));
                Multiplequestion.setOption6(c.getString(c.getColumnIndex(QuestionsMultipleTable.COLUMN_OPTION2)+1));
                Multiplequestion.setAnswer(c.getInt(c.getColumnIndex(QuestionsMultipleTable.COLUMN_ANSWER)+1));

                questionList4.add(Multiplequestion);
            }while(c.moveToNext());
        }
        c.close();
        return questionList4;
    }
    public List<ImagesQuestions> getAllImagesQuestions(){
        List<ImagesQuestions> questionList5 = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsImagesTable.TABLE_NAME, null);

        if(c.moveToFirst()){
            do{
                ImagesQuestions imagesquestion = new ImagesQuestions;

                ImagesQuestions.setQuestion(c.getString(c.getColumnIndex(QuestionsImagesTable.COLUMN_QUESTION)+1));
                ImagesQuestions.setOption1(c.getString(c.getColumnIndex(QuestionsImagesTable.COLUMN_OPTION1)+1));
                ImagesQuestions.setOption2(c.getString(c.getColumnIndex(QuestionsImagesTable.COLUMN_OPTION2)+1));
                ImagesQuestions.setOption3(c.getString(c.getColumnIndex(QuestionsImagesTable.COLUMN_OPTION2)+1));
                ImagesQuestions.setOption4(c.getString(c.getColumnIndex(QuestionsImagesTable.COLUMN_OPTION2)+1));
                ImagesQuestions.setAnswer(c.getInt(c.getColumnIndex(QuestionsImagesTable.COLUMN_ANSWER)+1));

                questionList5.add(imagesquestion);
            }while(c.moveToNext());
        }
        c.close();
        return questionList5;

    }

}
