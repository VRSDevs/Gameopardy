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

        MultipleChoiceQuestions M0 = new MultipleChoiceQuestions("¿Cual es la videoconsola con el mayor número de ventas?","Nintendo DS","PlayStation 1","PlayStation 2","Nintendo Wii","","","","historia");
        addQuestionM(M0);
        MultipleChoiceQuestions M1 = new MultipleChoiceQuestions("¿Cual es el mapa más grande (en kilometros cuadrados) de la historia de los videojuegos?","Minecraft","Fuel","Just Cause 4","No Man's Sky","","","No Man's Sky","historia");
        addQuestionM(M1);
        MultipleChoiceQuestions M2 = new MultipleChoiceQuestions("¿Quién fue el creador de la GameBoy?","Shigeru Miyamoto","Hiroshi Yamauchi","Satoru Iwata","Gunpei Yokoi","","","Gunpei Yokoi","historia");
        addQuestionM(M2);
        MultipleChoiceQuestions M3 = new MultipleChoiceQuestions("¿Cuál es considerado el primer videjuego de la historia?","Pong","Tennis for Two","Arkanoid","Space Invaders","a","a","Tennis for Two","historia");
        addQuestionM(M3);
        MultipleChoiceQuestions M4 = new MultipleChoiceQuestions("¿Que juego fue el más vendido de la primera PlayStation?","Tomb Raider","Gran Turismo","Metal Gear Solid","Final Fantasy VII","","","Gran Turismo","historia");
        addQuestionM(M4);
        MultipleChoiceQuestions M7 = new MultipleChoiceQuestions("¿Es Grand Theft Auto V el juego más vendido de la historia?","","","","","","","Falso","historia");
        addQuestionM(M7);
        MultipleChoiceQuestions M8 = new MultipleChoiceQuestions("PlayStation originalmente iba a ser una expansion de la Super Nintendo, pero fue cancelada por Nintendo.","","","","","","","Verdadero","historia");
        addQuestionM(M8);
        MultipleChoiceQuestions M9 = new MultipleChoiceQuestions("¿A qué empresa pertenece la saga de videojuegos Metal Gear Solid? ","Bandai Namco","Konami","Capcom","Square Enix","","","Konami","empresa");
        addQuestionM(M9);
        MultipleChoiceQuestions M10= new MultipleChoiceQuestions("¿Cual fue el primer videojuego exitoso de Activision?","Call of Duty","Doom","Pitfall!","Spyro the Dragon","","","Pitfall!","empresa");
        addQuestionM(M10);
        MultipleChoiceQuestions M11 = new MultipleChoiceQuestions("¿Cuales de estos juegos pertenecen a la empresa de videojuegos Level-5?","Inazuma Eleven","Phoenix Wright: Ace Attorney","Octopath Traveller","Danganronpa: Trigger Happy Havoc","Ni No Kuni","Profesor Layton","Inazuma Eleven, Ni No Kuni, Profesor Layton","empresa");
        addQuestionM(M11);
        MultipleChoiceQuestions M12 = new MultipleChoiceQuestions("De todos estos videojuegos de SEGA, ¿cuales salieron en Sega Dreamcast?","Sonic Heroes","Sonic Adventure","Yakuza ","Shenmue","Super Monkey Ball","Alex Kidd in Miracle World","Sonic Adventure,Shenmue","empresa");
        addQuestionM(M12);
        MultipleChoiceQuestions M13 = new MultipleChoiceQuestions("De esta lista, ¿que sagas pertenecen a la empresa CAPCOM?","Silent Hill","Mega-Man","Resident Evil","Devil May Cry","Bayonetta","Bomberman","Mega-Man,Resident Evil, Devil May Cry","empresa");
        addQuestionM(M13);
        MultipleChoiceQuestions M14 = new MultipleChoiceQuestions("¿A que empresa de videojuegos pertenece este logo?","Game Freak","Virtual Ravens","Bandai","Sony","","","Game Freak","empresa");
        addQuestionM(M14);
        MultipleChoiceQuestions M15 = new MultipleChoiceQuestions("¿A que empresa de videojuegos pertenece este logo?","Respawn","Treyarch","Capcom","Sony","","","Respawn","empresa");
        addQuestionM(M15);
        MultipleChoiceQuestions M16 = new MultipleChoiceQuestions("¿A que empresa de videojuegos pertenece este logo?","FromSoftware","Guerrilla","Bethesda","Naughty Dog","","a","Guerrilla","empresa");
        addQuestionM(M16);
        MultipleChoiceQuestions M17 = new MultipleChoiceQuestions("¿A que empresa de videojuegos pertenece este logo?","Square Enix","EA","Rovio","Valve","","","Rovio","empresa");
        addQuestionM(M17);
        MultipleChoiceQuestions M18 = new MultipleChoiceQuestions("¿Cual es el famoso eslogan que SEGA utilizó para promocionar su videoconsola SEGA GENESIS? Genesis does what [...]","no other can.","seems outrecheable","Nintendo can't","Nintendon't","","","Nintendon't","empresa");
        addQuestionM(M18);
        MultipleChoiceQuestions M19 = new MultipleChoiceQuestions("¿Cual fue el primer videojuego de la famosa saga de videojuegos FIFA? ","FIFA 98","FIFA INTERNATIONAL SOCCER (FIFA 94)","FIFA 95","FIFA 2000","","","FIFA INTERNATIONAL SOCCER (FIFA 94)","sagas");
        addQuestionM(M19);
        MultipleChoiceQuestions M20 = new MultipleChoiceQuestions("¿De que lugar es originario el personaje Sonic?","Mobius","Reino Champiñon","Sinnoh","Tierra","","","Mobius","sagas");
        addQuestionM(M20);
        MultipleChoiceQuestions M21 = new MultipleChoiceQuestions("¿Cual de estos videojuegos de Dragon Ball NO es de peleas en 2D?","Dragon Ball FighterZ","Dragon Ball Z: SuperSonic Warriors 2","Dragon Ball Z: Super Butoden","Dragon Ball Z: Budokai Tenkaichi 3","","","Dragon Ball Z: Budokai Tenkaichi 3","sagas");
        addQuestionM(M21);
        MultipleChoiceQuestions M22 = new MultipleChoiceQuestions("¿Cuantos videojuegos de la saga Mega-Man fueron lanzados en Nintendo NES?","Dos","Tres","Cinco","Seis","","","Seis","sagas");
        addQuestionM(M22);
        MultipleChoiceQuestions M23 = new MultipleChoiceQuestions("¿Cuales de estos juegos son considerados spin-offs de la saga Mario?","Super Mario 64","New Super Mario Bros U","Paper Mario","Mario & Luigi: Superstar Saga","Super Mario World","Super Mario Bros: The Lost Levels","Paper Mario,Mario & Luigi: Superstar Saga","sagas");
        addQuestionM(M23);
        MultipleChoiceQuestions M24 = new MultipleChoiceQuestions("¿Cuales de estos seres enemigos en la saga Metroid?","Metroides","Zoomers","Sanghelis","Wendigos","Creepers","Zebesianos","Metroides, Zoomers, Zebesianos","sagas");
        addQuestionM(M24);
        MultipleChoiceQuestions M25 = new MultipleChoiceQuestions("¿En cuales de estos años ha salido un videojuego de plataformas 2D de Sonic? ","1991","1994","1997","2006","2013","2017","1991, 1994, 2017","sagas");
        addQuestionM(M25);
        MultipleChoiceQuestions M26 = new MultipleChoiceQuestions("La inteligencia artificial que ayuda a Master Chief en Halo se llama Alexa","","","","","","","Falso","sagas");
        addQuestionM(M26);
        MultipleChoiceQuestions M27 = new MultipleChoiceQuestions("El primer Metal Gear salió en el año 1987","","","","","","","Verdadero","sagas");
        addQuestionM(M27);
        MultipleChoiceQuestions M28 = new MultipleChoiceQuestions("El Red Dead Redemption 2 es una precuela de la primera entrega","","","","","","","Verdadero","sagas");
        addQuestionM(M28);
        MultipleChoiceQuestions M29 = new MultipleChoiceQuestions("En la saga de videojuegos Super Smash Bros, Kirby puede copiar al menos una habilidad de todos los personajes","","","","","","","Verdadero","sagas");
        addQuestionM(M29);
        MultipleChoiceQuestions M30 = new MultipleChoiceQuestions("¿Cual es el subtítulo del tercer juego de la saga Metal Gear Solid?","Sons of Anarchy","Guns of The Patriots","Snake Eater","The Phantom Pain ","","","Snake Eater","sagas");
        addQuestionM(M30);
        MultipleChoiceQuestions M31 = new MultipleChoiceQuestions("De estos videojuegos, ¿cuales tienen una banda sonora compuesta por Koji Kondo?","Sonic The Hedgehog","Super Mario Bros","The Legend of Zelda: Ocarina of Time","Kirby's Adventure","Spyro the Dragon ","Yoshi's Island","Super Mario Bros, The Legend of Zelda: Ocarina of Time, Yoshi's Island","musica");
        addQuestionM(M31);
        MultipleChoiceQuestions M32 = new MultipleChoiceQuestions("¿A que videojuego pertenece esta canción?","Diddy Kong Racing","Crash Bandicoot","Super Mario 64","Sonic R","","","Diddy Kong Racing","musica");
        addQuestionM(M32);
        MultipleChoiceQuestions M33 = new MultipleChoiceQuestions("¿A que videojuego pertenece esta canción?","Crash Team Racing","Gran Turismo 5","Sonic Adventure 2","Dragon Ball Z: Budokai 3","","","Sonic Adventure 2","musica");
        addQuestionM(M33);
        MultipleChoiceQuestions M34 = new MultipleChoiceQuestions("¿De que videojuego es este tema musical?","Hades","Persona 5","Jet Set Radio","Shin Megami Tensei III: Nocturne","","","Persona 5","musica");
        addQuestionM(M34);
        MultipleChoiceQuestions M35 = new MultipleChoiceQuestions("¿De cuales de estas bandas sonoras se ha ocupado el compositor Shoji Meguro?","Dragon Quest V","Final Fantasy VIII","Shin Megami Tense III: Nocturne","Persona 3","Persona 5","Chrono Trigger","Shin Megami Tense III: Nocturne, Persona 3, Persona 5","musica");
        addQuestionM(M35);
        MultipleChoiceQuestions M36 = new MultipleChoiceQuestions("¿Cual de estos videojuegos se planteó originalmente como un videojuego infantil, pero acabó convertido en un juego de carácter irreverente para el publico adulto?","Grand Theft Auto","Conker's Bad Fur Day","Bully","Leisure Suit Larry in the Land of the Lounge Lizards","","","Conker's Bad Fur Day","curiosidades");
        addQuestionM(M36);
        MultipleChoiceQuestions M37 = new MultipleChoiceQuestions("¿Cual de estos videojuegos está protagonizado por una mujer?","The Legend of Zelda","Metroid","The Last of Us","Heavy Rain","","","Metroid","curiosidades");
        addQuestionM(M37);
        MultipleChoiceQuestions M38 = new MultipleChoiceQuestions("¿Cual de estos videojuegos NO está disponible en PlayStation 3?","Sonic Generations","The Elder Scrolls IV: Oblivion","Gran Turismo 7","Mass Effect 2","","","Gran Turismo 7","curiosidades");
        addQuestionM(M38);
        MultipleChoiceQuestions M39 = new MultipleChoiceQuestions("La última versión oficial de Minecraft es la 1.18","","","","","","","Falso","curiosidades");
        addQuestionM(M39);
        MultipleChoiceQuestions M40 = new MultipleChoiceQuestions("¿Cual es la mítica frase que Toad le dice a Mario cuando supera el primer castillo en Super Mario Bros? Thank You Mario! [...]","But our princess is in another castle!","But princess Peach is in other castle!","But the princess isn't here!","But Bowser took the princess to another castle!","","","But our princess is in another castle!","curiosidades");
        addQuestionM(M40);
        MultipleChoiceQuestions M41 = new MultipleChoiceQuestions("¿Que quick-time event es famoso por el videojuego Call of Duty: Advanced Warfare? Press [...] ","X to doubt","A to insult","F to pay respects","R to die","","","F to pay respects","curiosidades");
        addQuestionM(M41);
        MultipleChoiceQuestions M42 = new MultipleChoiceQuestions("¿A que videojuego pertenece este logo? ","Halo","Space Invaders","Metroid","Alien Isolation","","","Metroid","curiosidades");
        addQuestionM(M42);
        MultipleChoiceQuestions M43 = new MultipleChoiceQuestions("¿A que videojuego pertenece este zombi?","Doom 64","Half-Life","Perfect Dark","Wolfenstein 3D","","","Half-Life","curiosidades");
        addQuestionM(M43);
        MultipleChoiceQuestions M44 = new MultipleChoiceQuestions("¿Que consola tiene el menor número de unidades vendidas?","Virtual Boy","Atari Lynx","PS Vita","Sega Dreamcast","","","Virtual Boy","consolas");
        addQuestionM(M44);
        MultipleChoiceQuestions M45 = new MultipleChoiceQuestions("¿Cuantos bits tiene la arquitectura de la Nintendo GameCube?","16","32","64","128","","","128","consolas");
        addQuestionM(M45);
        MultipleChoiceQuestions M46 = new MultipleChoiceQuestions("¿Que consolas han vendido menos de 15 millones de unidades?","Wii U","Sega Master System","Xbox","Sega Dreamcast","PlayStation Vita","Nintendo 64","Sega Dreamcast,Sega Master System,Sega Dreamcast","consolas");
        addQuestionM(M46);
        MultipleChoiceQuestions M47 = new MultipleChoiceQuestions("¿Cual es el nombre de la consola que aparece en esta imagen?","Sega Saturn","NEO-GEO","Atari Jaguar","Sega Dreamcast","","","Atari Jaguar","consolas");
        addQuestionM(M47);
        MultipleChoiceQuestions M48 = new MultipleChoiceQuestions("¿Cual de las siguientes consolas es la Sega Dreamcast? ","NEO-GEO","Nintendo 64","Sega Saturn","Sega Dreamcast","","","Sega Dreamcast","consolas");
        addQuestionM(M48);
        MultipleChoiceQuestions M49 = new MultipleChoiceQuestions("¿Es la GameBoy Advanced una consola de 32 bits?","Verdadero","Falso","","","","","Verdadero","consolas");
        addQuestionM(M49);
        MultipleChoiceQuestions M50 = new MultipleChoiceQuestions("¿Cual es la consola de SEGA con mayor número de ventas? ","Sega Master System","Sega Mega Drive/Genesis","Sega Game Gear","Sega Saturn","","","Sega Mega Drive/Genesis","empresa");
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
                Multiplequestion.setAnswer(c.getString(c.getColumnIndex(QuestionsMultipleTable.COLUMN_ANSWER)+1));
                Multiplequestion.setCategoria(c.getString(c.getColumnIndex(QuestionsMultipleTable.COLUMN_CATEGORY)+1));

                questionList4.add(Multiplequestion);
            }while(c.moveToNext());
        }
        c.close();
        return questionList4;
    }


}
