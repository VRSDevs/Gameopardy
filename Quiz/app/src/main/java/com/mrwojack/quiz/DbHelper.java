package com.mrwojack.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mrwojack.quiz.QuizContract.*;
import com.mrwojack.quiz.classes.questions.Question;

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

        Question M1 = new Question("¿Cual es la videoconsola con el mayor número de ventas?","Nintendo DS","PlayStation 1","PlayStation 2","Nintendo Wii","","","","","historia");
        addQuestionM(M1);
        Question M2 = new Question("¿Cual es el mapa más grande (en kilometros cuadrados) de la historia de los videojuegos?","Minecraft","Fuel","Just Cause 4","No Man's Sky","","","No Man's Sky","","historia");
        addQuestionM(M2);
        Question M3 = new Question("¿Quién fue el creador de la GameBoy?","Shigeru Miyamoto","Hiroshi Yamauchi","Satoru Iwata","Gunpei Yokoi","","","Gunpei Yokoi","","historia");
        addQuestionM(M3);
        Question M4 = new Question("¿Cuál es considerado el primer videjuego de la historia?","Pong","Tennis for Two","Arkanoid","Space Invaders","a","a","Tennis for Two","","historia");
        addQuestionM(M4);
        Question M5 = new Question("¿Que juego fue el más vendido de la primera PlayStation?","Tomb Raider","Gran Turismo","Metal Gear Solid","Final Fantasy VII","","","Gran Turismo","","historia");
        addQuestionM(M5);
        Question M6 = new Question("¿Es Grand Theft Auto V el juego más vendido de la historia?","","","","","","","Falso","","historia");
        addQuestionM(M6);
        Question M7 = new Question("PlayStation originalmente iba a ser una expansion de la Super Nintendo, pero fue cancelada por Nintendo.","","","","","","","Verdadero","","historia");
        addQuestionM(M7);
        Question M8 = new Question("¿A qué empresa pertenece la saga de videojuegos Metal Gear Solid? ","Bandai Namco","Konami","Capcom","Square Enix","","","Konami","","empresa");
        addQuestionM(M8);
        Question M9= new Question("¿Cual fue el primer videojuego exitoso de Activision?","Call of Duty","Doom","Pitfall!","Spyro the Dragon","","","Pitfall!","","empresa");
        addQuestionM(M9);
        Question M10 = new Question("¿Cuales de estos juegos pertenecen a la empresa de videojuegos Level-5?","Inazuma Eleven","Phoenix Wright: Ace Attorney","Octopath Traveller","Danganronpa: Trigger Happy Havoc","Ni No Kuni","Profesor Layton","Inazuma Eleven, Ni No Kuni, Profesor Layton","","empresa");
        addQuestionM(M10);
        Question M11 = new Question("De todos estos videojuegos de SEGA, ¿cuales salieron en Sega Dreamcast?","Sonic Heroes","Sonic Adventure","Yakuza ","Shenmue","Super Monkey Ball","Alex Kidd in Miracle World","Sonic Adventure,Shenmue","","empresa");
        addQuestionM(M11);
        Question M12 = new Question("De esta lista, ¿que sagas pertenecen a la empresa CAPCOM?","Silent Hill","Mega-Man","Resident Evil","Devil May Cry","Bayonetta","Bomberman","Mega-Man,Resident Evil, Devil May Cry","","empresa");
        addQuestionM(M12);
        Question M13 = new Question("¿A que empresa de videojuegos pertenece este logo?","Game Freak","Virtual Ravens","Bandai","Sony","","","Game Freak","","empresa");
        addQuestionM(M13);
        Question M14 = new Question("¿A que empresa de videojuegos pertenece este logo?","Respawn","Treyarch","Capcom","Sony","","","Respawn","","empresa");
        addQuestionM(M14);
        Question M15 = new Question("¿A que empresa de videojuegos pertenece este logo?","FromSoftware","Guerrilla","Bethesda","Naughty Dog","","","Guerrilla","","empresa");
        addQuestionM(M15);
        Question M16 = new Question("¿A que empresa de videojuegos pertenece este logo?","Square Enix","EA","Rovio","Valve","","","Rovio","","empresa");
        addQuestionM(M16);
        Question M17 = new Question("¿Cual es el famoso eslogan que SEGA utilizó para promocionar su videoconsola SEGA GENESIS? Genesis does what [...]","no other can.","seems outrecheable","Nintendo can't","Nintendon't","","","Nintendon't","","empresa");
        addQuestionM(M17);
        Question M18 = new Question("¿Cual fue el primer videojuego de la famosa saga de videojuegos FIFA? ","FIFA 98","FIFA INTERNATIONAL SOCCER (FIFA 94)","FIFA 95","FIFA 2000","","","FIFA INTERNATIONAL SOCCER (FIFA 94)","","sagas");
        addQuestionM(M18);
        Question M19 = new Question("¿De que lugar es originario el personaje Sonic?","Mobius","Reino Champiñon","Sinnoh","Tierra","","","Mobius","","sagas");
        addQuestionM(M19);
        Question M20 = new Question("¿Cual de estos videojuegos de Dragon Ball NO es de peleas en 2D?","Dragon Ball FighterZ","Dragon Ball Z: SuperSonic Warriors 2","Dragon Ball Z: Super Butoden","Dragon Ball Z: Budokai Tenkaichi 3","","","Dragon Ball Z: Budokai Tenkaichi 3","","sagas");
        addQuestionM(M20);
        Question M21 = new Question("¿Cuantos videojuegos de la saga Mega-Man fueron lanzados en Nintendo NES?","Dos","Tres","Cinco","Seis","","","Seis","","sagas");
        addQuestionM(M21);
        Question M22 = new Question("¿Cuales de estos juegos son considerados spin-offs de la saga Mario?","Super Mario 64","New Super Mario Bros U","Paper Mario","Mario & Luigi: Superstar Saga","Super Mario World","Super Mario Bros: The Lost Levels","Paper Mario,Mario & Luigi: Superstar Saga","","sagas");
        addQuestionM(M22);
        Question M23 = new Question("¿Cuales de estos seres enemigos en la saga Metroid?","Metroides","Zoomers","Sanghelis","Wendigos","Creepers","Zebesianos","Metroides, Zoomers, Zebesianos","","sagas");
        addQuestionM(M23);
        Question M24 = new Question("¿En cuales de estos años ha salido un videojuego de plataformas 2D de Sonic? ","1991","1994","1997","2006","2013","2017","1991, 1994, 2017","","sagas");
        addQuestionM(M24);
        Question M25 = new Question("La inteligencia artificial que ayuda a Master Chief en Halo se llama Alexa","","","","","","","Falso","","sagas");
        addQuestionM(M25);
        Question M26 = new Question("El primer Metal Gear salió en el año 1987","","","","","","","Verdadero","","sagas");
        addQuestionM(M26);
        Question M27 = new Question("El Red Dead Redemption 2 es una precuela de la primera entrega","","","","","","","Verdadero","","sagas");
        addQuestionM(M27);
        Question M28 = new Question("En la saga de videojuegos Super Smash Bros, Kirby puede copiar al menos una habilidad de todos los personajes","","","","","","","Verdadero","","sagas");
        addQuestionM(M28);
        Question M29 = new Question("¿Cual es el subtítulo del tercer juego de la saga Metal Gear Solid?","Sons of Anarchy","Guns of The Patriots","Snake Eater","The Phantom Pain ","","","Snake Eater","","sagas");
        addQuestionM(M29);
        Question M30 = new Question("De estos videojuegos, ¿cuales tienen una banda sonora compuesta por Koji Kondo?","Sonic The Hedgehog","Super Mario Bros","The Legend of Zelda: Ocarina of Time","Kirby's Adventure","Spyro the Dragon ","Yoshi's Island","Super Mario Bros, The Legend of Zelda: Ocarina of Time, Yoshi's Island","","sagas");
        addQuestionM(M30);
        Question M31 = new Question("¿A que videojuego pertenece esta canción?","Diddy Kong Racing","Crash Bandicoot","Super Mario 64","Sonic R","","","Diddy Kong Racing","","sagas");
        addQuestionM(M31);
        Question M32 = new Question("¿A que videojuego pertenece esta canción?","Crash Team Racing","Gran Turismo 5","Sonic Adventure 2","Dragon Ball Z: Budokai 3","","","Sonic Adventure 2","","sagas");
        addQuestionM(M32);
        Question M33 = new Question("¿De que videojuego es este tema musical?","Hades","Persona 5","Jet Set Radio","Shin Megami Tensei III: Nocturne","","","Persona 5","","curiosidades");
        addQuestionM(M33);
        Question M34 = new Question("¿De cuales de estas bandas sonoras se ha ocupado el compositor Shoji Meguro?","Dragon Quest V","Final Fantasy VIII","Shin Megami Tense III: Nocturne","Persona 3","Persona 5","Chrono Trigger","Shin Megami Tense III: Nocturne, Persona 3, Persona 5","","curiosidades");
        addQuestionM(M34);
        Question M35 = new Question("¿Cual de estos videojuegos se planteó originalmente como un videojuego infantil, pero acabó convertido en un juego de carácter irreverente para el publico adulto?","Grand Theft Auto","Conker's Bad Fur Day","Bully","Leisure Suit Larry in the Land of the Lounge Lizards","","","Conker's Bad Fur Day","","curiosidades");
        addQuestionM(M35);
        Question M36 = new Question("¿Cual de estos videojuegos está protagonizado por una mujer?","The Legend of Zelda","Metroid","The Last of Us","Heavy Rain","","","Metroid","","curiosidades");
        addQuestionM(M36);
        Question M37 = new Question("¿Cual de estos videojuegos NO está disponible en PlayStation 3?","Sonic Generations","The Elder Scrolls IV: Oblivion","Gran Turismo 7","Mass Effect 2","","","Gran Turismo 7","","curiosidades");
        addQuestionM(M37);
        Question M38 = new Question("La última versión oficial de Minecraft es la 1.18","","","","","","","Falso","curiosidades");
        addQuestionM(M38);
        Question M39 = new Question("¿Cual es la mítica frase que Toad le dice a Mario cuando supera el primer castillo en Super Mario Bros? Thank You Mario! [...]","But our princess is in another castle!","But princess Peach is in other castle!","But the princess isn't here!","But Bowser took the princess to another castle!","","","But our princess is in another castle!","","curiosidades");
        addQuestionM(M39);
        Question M40 = new Question("¿Que quick-time event es famoso por el videojuego Call of Duty: Advanced Warfare? Press [...] ","X to doubt","A to insult","F to pay respects","R to die","","","F to pay respects","","curiosidades");
        addQuestionM(M40);
        Question M41 = new Question("¿A que videojuego pertenece este logo? ","Halo","Space Invaders","Metroid","Alien Isolation","","","Metroid","","curiosidades");
        addQuestionM(M41);
        Question M42 = new Question("¿A que videojuego pertenece este zombi?","Doom 64","Half-Life","Perfect Dark","Wolfenstein 3D","","","Half-Life","","curiosidades");
        addQuestionM(M42);
        Question M43 = new Question("¿Que consola tiene el menor número de unidades vendidas?","Virtual Boy","Atari Lynx","PS Vita","Sega Dreamcast","","","Virtual Boy","","historia");
        addQuestionM(M43);
        Question M44 = new Question("¿Cuantos bits tiene la arquitectura de la Nintendo GameCube?","16","32","64","128","","","128","","historia");
        addQuestionM(M44);
        Question M45 = new Question("¿Que consolas han vendido menos de 15 millones de unidades?","Wii U","Sega Master System","Xbox","Sega Dreamcast","PlayStation Vita","Nintendo 64","Sega Dreamcast,Sega Master System,Sega Dreamcast","","historia");
        addQuestionM(M45);
        Question M46 = new Question("¿Cual es el nombre de la consola que aparece en esta imagen?","Sega Saturn","NEO-GEO","Atari Jaguar","Sega Dreamcast","","","Atari Jaguar","","historia");
        addQuestionM(M46);
        Question M47 = new Question("¿Cual de las siguientes consolas es la Sega Dreamcast? ","NEO-GEO","Nintendo 64","Sega Saturn","Sega Dreamcast","","","Sega Dreamcast","","historia");
        addQuestionM(M47);
        Question M48 = new Question("¿Es la GameBoy Advanced una consola de 32 bits?","Verdadero","Falso","","","","","Verdadero","","historia");
        addQuestionM(M48);
        Question M49 = new Question("¿Cual es la consola de SEGA con mayor número de ventas? ","Sega Master System","Sega Mega Drive/Genesis","Sega Game Gear","Sega Saturn","","","Sega Mega Drive/Genesis","","empresa");
        addQuestionM(M49);
        Question M50 = new Question("","","","","","","","","","");
        addQuestionM(M50);
        Question M51 = new Question("","","","","","","","","","");
        addQuestionM(M51);
        Question M52 = new Question("","","","","","","","","","");
        addQuestionM(M52);
        Question M53 = new Question("","","","","","","","","","");
        addQuestionM(M53);
        Question M54 = new Question("","","","","","","","","","");
        addQuestionM(M54);
        Question M55 = new Question("","","","","","","","","","");
        addQuestionM(M55);
        Question M56 = new Question("","","","","","","","","","");
        addQuestionM(M56);
        Question M57 = new Question("","","","","","","","","","");
        addQuestionM(M57);
        Question M58 = new Question("","","","","","","","","","");
        addQuestionM(M58);
        Question M59 = new Question("","","","","","","","","","");
        addQuestionM(M59);
        Question M60 = new Question("","","","","","","","","","");
        addQuestionM(M60);

    }

    private void addQuestionM(Question Multiplequestion){
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

    public List<Question> getAllMultipleQuestions(){
        List<Question> questionList4 = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsMultipleTable.TABLE_NAME, null);

        if(c.moveToFirst()){
            do{
                Question Multiplequestion = new Question();
                Multiplequestion.setQuestion(c.getString(c.getColumnIndex(QuestionsMultipleTable.COLUMN_QUESTION)));
                Multiplequestion.setOption1(c.getString(c.getColumnIndex(QuestionsMultipleTable.COLUMN_OPTION1)));
                Multiplequestion.setOption2(c.getString(c.getColumnIndex(QuestionsMultipleTable.COLUMN_OPTION2)));
                Multiplequestion.setOption3(c.getString(c.getColumnIndex(QuestionsMultipleTable.COLUMN_OPTION3)));
                Multiplequestion.setOption4(c.getString(c.getColumnIndex(QuestionsMultipleTable.COLUMN_OPTION4)));
                Multiplequestion.setOption5(c.getString(c.getColumnIndex(QuestionsMultipleTable.COLUMN_OPTION5)));
                Multiplequestion.setOption6(c.getString(c.getColumnIndex(QuestionsMultipleTable.COLUMN_OPTION6)));
                Multiplequestion.setAnswer(c.getString(c.getColumnIndex(QuestionsMultipleTable.COLUMN_ANSWER)));
                Multiplequestion.setCategory(c.getString(c.getColumnIndex(QuestionsMultipleTable.COLUMN_CATEGORY)));

                questionList4.add(Multiplequestion);
            }while(c.moveToNext());
        }
        c.close();
        return questionList4;
    }


}
