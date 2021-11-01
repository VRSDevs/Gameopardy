package com.mrwojack.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mrwojack.quiz.QuizContract.*;

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


        //Creacion de la tabla de las preguntas
        final String SQL_CREATE_MULTIPLE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsMultipleTable.TABLE_NAME + " ( " +
                QuestionsMultipleTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsMultipleTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsMultipleTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsMultipleTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsMultipleTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsMultipleTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsMultipleTable.COLUMN_OPTION5 + " TEXT, " +
                QuestionsMultipleTable.COLUMN_OPTION6 + " TEXT, " +
                QuestionsMultipleTable.COLUMN_ANSWER + " INTEGER, " +
                QuestionsMultipleTable.COLUMN_CATEGORY + " TEXT " + ")";

        db.execSQL(SQL_CREATE_MULTIPLE_QUESTIONS_TABLE);

        fillQuestionsTable();
    }

   private void fillQuestionsTable(){

        MultipleChoiceQuestions M1 = new MultipleChoiceQuestions("¿Cual es la videoconsola con el mayor número de ventas?","Nintendo DS","PlayStation 1","PlayStation 2","Nintendo Wii","","",3,"historia");
        addQuestionM(M1);
        MultipleChoiceQuestions M2 = new MultipleChoiceQuestions("¿Cual es el mapa más grande (en kilometros cuadrados) de la historia de los videojuegos?","","",""," ","","",2,"");
        addQuestionM(M2);
        MultipleChoiceQuestions M3 = new MultipleChoiceQuestions("¿Quién fue el creador de la GameBoy?","a","a","a","a","a","a",1,"e");
        addQuestionM(M3);
        MultipleChoiceQuestions M4 = new MultipleChoiceQuestions("¿Cuál es considerado el primer videjuego de la historia?","a","a","a","a","a","a",1,"e");
        addQuestionM(M4);
        MultipleChoiceQuestions M5 = new MultipleChoiceQuestions("¿Que juego fue el más vendido de la primera PlayStation?","a","a","a","a","a","a",1,"e");
        addQuestionM(M5);
        MultipleChoiceQuestions M6 = new MultipleChoiceQuestions("¿Cuál es considerado el primer videjuego de la historia?","a","a","a","a","a","a",1,"e");
        addQuestionM(M6);
        MultipleChoiceQuestions M7 = new MultipleChoiceQuestions("¿Que juego fue el más vendido de la primera PlayStation?","a","a","a","a","a","a",1,"e");
        addQuestionM(M7);
        MultipleChoiceQuestions M8 = new MultipleChoiceQuestions("¿Es Grand Theft Auto V el juego más vendido de la historia?","a","a","a","a","a","a",1,"e");
        addQuestionM(M8);
        MultipleChoiceQuestions M9 = new MultipleChoiceQuestions("PlayStation originalmente iba a ser una expansion de la Super Nintendo, pero fue cancelada por Nintendo.","a","a","a","a","a","a",1,"e");
        addQuestionM(M9);
        MultipleChoiceQuestions M10 = new MultipleChoiceQuestions("¿A qué empresa pertenece la saga de videojuegos Metal Gear Solid? ","a","a","a","a","a","a",1,"e");
        addQuestionM(M10);
        MultipleChoiceQuestions M11= new MultipleChoiceQuestions("¿Cual fue el primer videojuego exitoso de Activision?","a","a","a","a","a","a",1,"e");
        addQuestionM(M11);
        MultipleChoiceQuestions M12 = new MultipleChoiceQuestions("¿Cuales de estos juegos pertenecen a la empresa de videojuegos Level-5?","a","a","a","a","a","a",1,"e");
        addQuestionM(M12);
        MultipleChoiceQuestions M13 = new MultipleChoiceQuestions("De todos estos videojuegos de SEGA, ¿cuales salieron en Sega Dreamcast?","a","a","a","a","a","a",1,"e");
        addQuestionM(M13);
        MultipleChoiceQuestions M14 = new MultipleChoiceQuestions("De esta lista, ¿que sagas pertenecen a la empresa CAPCOM?","a","a","a","a","a","a",1,"e");
        addQuestionM(M14);
        MultipleChoiceQuestions M15 = new MultipleChoiceQuestions("¿A que empresa de videojuegos pertenece este logo?","a","a","a","a","a","a",1,"e");
        addQuestionM(M15);
        MultipleChoiceQuestions M16 = new MultipleChoiceQuestions("¿A que empresa de videojuegos pertenece este logo?","a","a","a","a","a","a",1,"e");
        addQuestionM(M16);
        MultipleChoiceQuestions M17 = new MultipleChoiceQuestions("¿A que empresa de videojuegos pertenece este logo?","a","a","a","a","a","a",1,"e");
        addQuestionM(M17);
        MultipleChoiceQuestions M18 = new MultipleChoiceQuestions("¿A que empresa de videojuegos pertenece este logo?","a","a","a","a","a","a",1,"e");
        addQuestionM(M18);
        MultipleChoiceQuestions M19 = new MultipleChoiceQuestions("¿Cual es el famoso eslogan que SEGA utilizó para promocionar su videoconsola SEGA GENESIS?","a","a","a","a","a","a",1,"e");
        addQuestionM(M19);
        MultipleChoiceQuestions M20 = new MultipleChoiceQuestions("¿Cual fue el primer videojuego de la famosa saga de videojuegos \"FIFA\"? ","a","a","a","a","a","a",1,"e");
        addQuestionM(M20);
        MultipleChoiceQuestions M21 = new MultipleChoiceQuestions("¿De que lugar es originario el personaje Sonic?","a","a","a","a","a","a",1,"e");
        addQuestionM(M21);
        MultipleChoiceQuestions M22 = new MultipleChoiceQuestions("¿Cual de estos videojuegos de Dragon Ball NO es de peleas en 2D?","a","a","a","a","a","a",1,"e");
        addQuestionM(M22);
        MultipleChoiceQuestions M23 = new MultipleChoiceQuestions("¿Cuantos videojuegos de la saga Mega-Man fueron lanzados en Nintendo NES?","a","a","a","a","a","a",1,"e");
        addQuestionM(M23);
        MultipleChoiceQuestions M24 = new MultipleChoiceQuestions("¿Cuales de estos juegos son considerados spin-offs de la saga Mario?","a","a","a","a","a","a",1,"e");
        addQuestionM(M24);
        MultipleChoiceQuestions M25 = new MultipleChoiceQuestions("¿Cuales de estos seres enemigos en la saga Metroid?","a","a","a","a","a","a",1,"e");
        addQuestionM(M25);
        MultipleChoiceQuestions M26 = new MultipleChoiceQuestions("¿En cuales de estos años ha salido un videojuego de plataformas 2D de Sonic? ","a","a","a","a","a","a",1,"e");
        addQuestionM(M26);
        MultipleChoiceQuestions M27 = new MultipleChoiceQuestions("La inteligencia artificial que ayuda a Master Chief en Halo se llama Alexa","a","a","a","a","a","a",1,"e");
        addQuestionM(M27);
        MultipleChoiceQuestions M28 = new MultipleChoiceQuestions("El primer Metal Gear salió en el año 1987","a","a","a","a","a","a",1,"e");
        addQuestionM(M28);
        MultipleChoiceQuestions M29 = new MultipleChoiceQuestions("El Red Dead Redemption 2 es una precuela de la primera entrega","a","a","a","a","a","a",1,"e");
        addQuestionM(M29);
        MultipleChoiceQuestions M30 = new MultipleChoiceQuestions("En la saga de videojuegos Super Smash Bros, Kirby puede copiar al menos una habilidad de todos los personajes","a","a","a","a","a","a",1,"e");
        addQuestionM(M30);
        MultipleChoiceQuestions M31 = new MultipleChoiceQuestions("¿Cual es el subtítulo del tercer juego de la saga Metal Gear Solid?","a","a","a","a","a","a",1,"e");
        addQuestionM(M31);
        MultipleChoiceQuestions M32 = new MultipleChoiceQuestions("De estos videojuegos, ¿cuales tienen una banda sonora compuesta por Koji Kondo?","a","a","a","a","a","a",1,"e");
        addQuestionM(M32);
        MultipleChoiceQuestions M33 = new MultipleChoiceQuestions("¿A que videojuego pertenece esta canción?","a","a","a","a","a","a",1,"e");
        addQuestionM(M33);
        MultipleChoiceQuestions M34 = new MultipleChoiceQuestions("¿A que videojuego pertenece esta canción?","a","a","a","a","a","a",1,"e");
        addQuestionM(M34);
        MultipleChoiceQuestions M35 = new MultipleChoiceQuestions("¿De que videojuego es este tema musical?","a","a","a","a","a","a",1,"e");
        addQuestionM(M35);
        MultipleChoiceQuestions M36 = new MultipleChoiceQuestions("¿De cuales de estas bandas sonoras se ha ocupado el compositor Shoji Meguro?","a","a","a","a","a","a",1,"e");
        addQuestionM(M36);
        MultipleChoiceQuestions M37 = new MultipleChoiceQuestions("¿Cual de estos videojuegos se planteó originalmente como un videojuego infantil, pero acabó convertido en un juego de carácter irreverente para el publico adulto?\n","a","a","a","a","a","a",1,"e");
        addQuestionM(M37);
        MultipleChoiceQuestions M38 = new MultipleChoiceQuestions("¿Cual de estos videojuegos está protagonizado por una mujer?","a","a","a","a","a","a",1,"e");
        addQuestionM(M38);
        MultipleChoiceQuestions M39 = new MultipleChoiceQuestions("¿Cual de estos videojuegos NO está disponible en PlayStation 3?","a","a","a","a","a","a",1,"e");
        addQuestionM(M39);
        MultipleChoiceQuestions M40 = new MultipleChoiceQuestions("La última versión oficial de Minecraft es la 1.18","a","a","a","a","a","a",1,"e");
        addQuestionM(M40);
        MultipleChoiceQuestions M41 = new MultipleChoiceQuestions("¿Cual es la mítica frase que Toad le dice a Mario cuando supera el primer castillo en Super Mario Bros?","a","a","a","a","a","a",1,"e");
        addQuestionM(M41);
        MultipleChoiceQuestions M42 = new MultipleChoiceQuestions("¿Que quick-time event es famoso por el videojuego Call of Duty: Advanced Warfare? ","a","a","a","a","a","a",1,"e");
        addQuestionM(M42);
        MultipleChoiceQuestions M43 = new MultipleChoiceQuestions("¿A que videojuego pertenece este logo? ","a","a","a","a","a","a",1,"e");
        addQuestionM(M43);
        MultipleChoiceQuestions M44 = new MultipleChoiceQuestions("¿A que videojuego pertenece este zombi? (Imagen Zombi)","a","a","a","a","a","a",1,"e");
        addQuestionM(M44);
        MultipleChoiceQuestions M45 = new MultipleChoiceQuestions("¿Que consola tiene el menor número de unidades vendidas?","a","a","a","a","a","a",1,"e");
        addQuestionM(M45);
        MultipleChoiceQuestions M46 = new MultipleChoiceQuestions("¿Cuantos bits tiene la arquitectura de la Nintendo GameCube?","a","a","a","a","a","a",1,"e");
        addQuestionM(M46);
        MultipleChoiceQuestions M47 = new MultipleChoiceQuestions("¿Que consolas han vendido menos de 15 millones de unidades?","a","a","a","a","a","a",1,"e");
        addQuestionM(M47);
        MultipleChoiceQuestions M48 = new MultipleChoiceQuestions("¿Cual es el nombre de la consola que aparece en esta imagen?","a","a","a","a","a","a",1,"e");
        addQuestionM(M48);
        MultipleChoiceQuestions M49 = new MultipleChoiceQuestions("¿Cual de las siguientes consolas es la Sega Dreamcast? ","a","a","a","a","a","a",1,"e");
        addQuestionM(M49);
        MultipleChoiceQuestions M50 = new MultipleChoiceQuestions("¿Es la GameBoy Advanced una consola de 32 bits?","a","a","a","a","a","a",1,"e");
        addQuestionM(M50);
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
        cv.put(QuestionsMultipleTable.COLUMN_CATEGORY, Multiplequestion.getAnswer());

        db.insert(QuestionsMultipleTable.TABLE_NAME, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsMultipleTable.TABLE_NAME);
        onCreate(db);
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
                Multiplequestion.setCategoria(c.getString(c.getColumnIndex(QuestionsMultipleTable.COLUMN_CATEGORY)+1));

                questionList4.add(Multiplequestion);
            }while(c.moveToNext());
        }
        c.close();
        return questionList4;
    }


}
