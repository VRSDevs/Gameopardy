package com.mrwojack.quiz.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mrwojack.quiz.classes.questions.QuizContract.*;
import com.mrwojack.quiz.classes.questions.Question;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    //region Variables

    private static final String DATABASE_NAME = "GameopardyDB.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    //endregion

    //region Constructores

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //endregion

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        // Creación de la tabla de las preguntas
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION5 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION6 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER + " TEXT, " +
                QuestionsTable.COLUMN_TYPE + " TEXT, " +
                QuestionsTable.COLUMN_CATEGORY + " TEXT " + ")";

        // Ejecución del comando SQL
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);

        // Inserción de la información en la tabla
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    //region Métodos - Obtención de datos

    public List<Question> getQuestions(String category){
        // Creación de la lista de preguntas
        List<Question> questionsList = new ArrayList<>();

        // Obtención de tabla y de cursor para operar en la tabla
        db = getReadableDatabase();
        Cursor _cursor = db.rawQuery(
                "SELECT * FROM " + QuestionsTable.TABLE_NAME + " WHERE category = " + "'" + category + "'",
                null);

        if(_cursor.moveToFirst()){
            do {
                Question q = new Question();

                q.setQuestion(_cursor.getString(1));
                q.setOption1(_cursor.getString(2));
                q.setOption2(_cursor.getString(3));
                q.setOption3(_cursor.getString(4));
                q.setOption4(_cursor.getString(5));
                q.setOption5(_cursor.getString(6));
                q.setOption6(_cursor.getString(7));
                q.setAnswer(_cursor.getString(8));
                q.setType(_cursor.getString(9));
                q.setCategory(_cursor.getString(10));

                questionsList.add(q);
            } while(_cursor.moveToNext());
        }
        _cursor.close();
        return questionsList;
    }

    public List<Question> getAllQuestions(){
        // Creación de la lista de preguntas
        List<Question> questionsList = new ArrayList<>();

        // Obtención de tabla y de cursor para operar en la tabla
        db = getReadableDatabase();
        Cursor _cursor = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if(_cursor.moveToFirst()){
            do {
                Question q = new Question();

                q.setQuestion(_cursor.getString(1));
                q.setOption1(_cursor.getString(2));
                q.setOption2(_cursor.getString(3));
                q.setOption3(_cursor.getString(4));
                q.setOption4(_cursor.getString(5));
                q.setOption5(_cursor.getString(6));
                q.setOption6(_cursor.getString(7));
                q.setAnswer(_cursor.getString(8));
                q.setType(_cursor.getString(9));
                q.setCategory(_cursor.getString(10));

                questionsList.add(q);
            } while(_cursor.moveToNext());
        }
        _cursor.close();
        return questionsList;
    }

    //endregion

    //region Métodos - Otros

    /**
     * Método para crear las preguntas
     */
    private void fillQuestionsTable(){

        Question M1 = new Question("¿Cual es la videoconsola con el mayor número de ventas?","Nintendo DS","PlayStation 1","PlayStation 2","Nintendo Wii","","","PlayStation 2","normal","historia");
        addQuestionToTable(M1);
        Question M2 = new Question("¿Cual es el mapa más grande (en kilometros cuadrados) de la historia de los videojuegos?","Minecraft","Fuel","Just Cause 4","No Man's Sky","","","No Man's Sky","normal","historia");
        addQuestionToTable(M2);
        Question M3 = new Question("¿Quién fue el creador de la GameBoy?","Shigeru Miyamoto","Hiroshi Yamauchi","Satoru Iwata","Gunpei Yokoi","","","Gunpei Yokoi","normal","historia");
        addQuestionToTable(M3);
        Question M4 = new Question("¿Cuál es considerado el primer videjuego de la historia?","Pong","Tennis for Two","Arkanoid","Space Invaders","a","a","Tennis for Two","normal","historia");
        addQuestionToTable(M4);
        Question M5 = new Question("¿Que juego fue el más vendido de la primera PlayStation?","Tomb Raider","Gran Turismo","Metal Gear Solid","Final Fantasy VII","","","Gran Turismo","normal","historia");
        addQuestionToTable(M5);
        Question M6 = new Question("¿Es Grand Theft Auto V el juego más vendido de la historia?","","","","","","","Falso","binario","historia");
        addQuestionToTable(M6);
        Question M7 = new Question("PlayStation originalmente iba a ser una expansion de la Super Nintendo, pero fue cancelada por Nintendo.","","","","","","","Verdadero","binario","historia");
        addQuestionToTable(M7);
        Question M8 = new Question("¿A qué empresa pertenece la saga de videojuegos Metal Gear Solid? ","Bandai Namco","Konami","Capcom","Square Enix","","","Konami","normal","empresa");
        addQuestionToTable(M8);
        Question M9= new Question("¿Cual fue el primer videojuego exitoso de Activision?","Call of Duty","Doom","Pitfall!","Spyro the Dragon","","","Pitfall!","normal","empresa");
        addQuestionToTable(M9);
        Question M10 = new Question("¿Cuales de estos juegos pertenecen a la empresa de videojuegos Level-5?","Inazuma Eleven","Phoenix Wright: Ace Attorney","Octopath Traveller","Danganronpa: Trigger Happy Havoc","Ni No Kuni","Profesor Layton","Inazuma Eleven, Ni No Kuni, Profesor Layton,","multiple","empresa");
        addQuestionToTable(M10);
        Question M11 = new Question("De todos estos videojuegos de SEGA, ¿cuales salieron en Sega Dreamcast?","Sonic Heroes","Sonic Adventure","Yakuza ","Shenmue","Super Monkey Ball","Alex Kidd in Miracle World","Sonic Adventure,Shenmue,","multiple","empresa");
        addQuestionToTable(M11);
        Question M12 = new Question("De esta lista, ¿que sagas pertenecen a la empresa CAPCOM?","Silent Hill","Mega-Man","Resident Evil","Devil May Cry","Bayonetta","Bomberman","Mega-Man,Resident Evil, Devil May Cry,","multiple","empresa");
        addQuestionToTable(M12);
        Question M13 = new Question("¿A que empresa de videojuegos pertenece este logo? ","Game Freak","Virtual Ravens","Bandai","Sony","","","Game Freak","multimedia","empresa");
        addQuestionToTable(M13);
        Question M14 = new Question("¿A que empresa de videojuegos pertenece este logo?","Respawn","Treyarch","Capcom","Sony","","","Respawn","multimedia","empresa");
        addQuestionToTable(M14);
        Question M15 = new Question("¿A que empresa de videojuegos pertenece este logo?","FromSoftware","Guerrilla","Bethesda","Naughty Dog","","","Guerrilla","multimedia","empresa");
        addQuestionToTable(M15);
        Question M16 = new Question("¿A que empresa de videojuegos pertenece este logo?","Square Enix","EA","Rovio","Valve","","","Rovio","multimedia","empresa");
        addQuestionToTable(M16);
        Question M17 = new Question("¿Cual es el famoso eslogan que SEGA utilizó para promocionar su videoconsola SEGA GENESIS? Genesis does what [...]","no other can.","seems outrecheable","Nintendo can't","Nintendon't","","","Nintendon't","normal","empresa");
        addQuestionToTable(M17);
        Question M18 = new Question("¿Cual fue el primer videojuego de la famosa saga de videojuegos FIFA? ","FIFA 98","FIFA INTERNATIONAL SOCCER (FIFA 94)","FIFA 95","FIFA 2000","","","FIFA INTERNATIONAL SOCCER (FIFA 94)","normal","sagas");
        addQuestionToTable(M18);
        Question M19 = new Question("¿De que lugar es originario el personaje Sonic?","Mobius","Reino Champiñon","Sinnoh","Tierra","","","Mobius","normal","sagas");
        addQuestionToTable(M19);
        Question M20 = new Question("¿Cual de estos videojuegos de Dragon Ball NO es de peleas en 2D?","Dragon Ball FighterZ","Dragon Ball Z: SuperSonic Warriors 2","Dragon Ball Z: Super Butoden","Dragon Ball Z: Budokai Tenkaichi 3","","","Dragon Ball Z: Budokai Tenkaichi 3","","sagas");
        addQuestionToTable(M20);
        Question M21 = new Question("¿Cuantos videojuegos de la saga Mega-Man fueron lanzados en Nintendo NES?","Dos","Tres","Cinco","Seis","","","Seis","","sagas");
        addQuestionToTable(M21);
        Question M22 = new Question("¿Cuales de estos juegos son considerados spin-offs de la saga Mario?","Super Mario 64","New Super Mario Bros U","Paper Mario","Mario & Luigi: Superstar Saga","Super Mario World","Super Mario Bros: The Lost Levels","Paper Mario,Mario & Luigi: Superstar Saga,","multiple","sagas");
        addQuestionToTable(M22);
        Question M23 = new Question("¿Cuales de estos seres enemigos en la saga Metroid?","Metroides","Zoomers","Sanghelis","Wendigos","Creepers","Zebesianos","Metroides, Zoomers, Zebesianos,","multiple","sagas");
        addQuestionToTable(M23);
        Question M24 = new Question("¿En cuales de estos años ha salido un videojuego de plataformas 2D de Sonic? ","1991","1994","1997","2006","2013","2017","1991, 1994, 2017,","multiple","sagas");
        addQuestionToTable(M24);
        Question M25 = new Question("La inteligencia artificial que ayuda a Master Chief en Halo se llama Alexa","","","","","","","Falso","binario","sagas");
        addQuestionToTable(M25);
        Question M26 = new Question("El primer Metal Gear salió en el año 1987","","","","","","","Verdadero","binario","sagas");
        addQuestionToTable(M26);
        Question M27 = new Question("El Red Dead Redemption 2 es una precuela de la primera entrega","","","","","","","Verdadero","binario","sagas");
        addQuestionToTable(M27);
        Question M28 = new Question("En la saga de videojuegos Super Smash Bros, Kirby puede copiar al menos una habilidad de todos los personajes","","","","","","","Verdadero","binario","sagas");
        addQuestionToTable(M28);
        Question M29 = new Question("¿Cual es el subtítulo del tercer juego de la saga Metal Gear Solid?","Sons of Anarchy","Guns of The Patriots","Snake Eater","The Phantom Pain ","","","Snake Eater","normal","sagas");
        addQuestionToTable(M29);
        Question M30 = new Question("De estos videojuegos, ¿cuales tienen una banda sonora compuesta por Koji Kondo?","Sonic The Hedgehog","Super Mario Bros","The Legend of Zelda: Ocarina of Time","Kirby's Adventure","Spyro the Dragon ","Yoshi's Island","Super Mario Bros, The Legend of Zelda: Ocarina of Time, Yoshi's Island,","multiple","sagas");
        addQuestionToTable(M30);
        Question M31 = new Question("¿A que videojuego pertenece esta canción?","Diddy Kong Racing","Crash Bandicoot","Super Mario 64","Sonic R","","","Diddy Kong Racing","multimedia","sagas");
        addQuestionToTable(M31);
        Question M32 = new Question("¿A que videojuego pertenece esta canción?","Crash Team Racing","Gran Turismo 5","Sonic Adventure 2","Dragon Ball Z: Budokai 3","","","Sonic Adventure 2","multimedia","sagas");
        addQuestionToTable(M32);
        Question M33 = new Question("¿De que videojuego es este tema musical?","Hades","Persona 5","Jet Set Radio","Shin Megami Tensei III: Nocturne","","","Persona 5","multimedia","curiosidades");
        addQuestionToTable(M33);
        Question M34 = new Question("¿De cuales de estas bandas sonoras se ha ocupado el compositor Shoji Meguro?","Dragon Quest V","Final Fantasy VIII","Shin Megami Tense III: Nocturne","Persona 3","Persona 5","Chrono Trigger","Shin Megami Tense III: Nocturne, Persona 3, Persona 5,","multiple","curiosidades");
        addQuestionToTable(M34);
        Question M35 = new Question("¿Cual de estos videojuegos se planteó originalmente como un videojuego infantil, pero acabó convertido en un juego de carácter irreverente para el publico adulto?","Grand Theft Auto","Conker's Bad Fur Day","Bully","Leisure Suit Larry in the Land of the Lounge Lizards","","","Conker's Bad Fur Day","normal","curiosidades");
        addQuestionToTable(M35);
        Question M36 = new Question("¿Cual de estos videojuegos está protagonizado por una mujer?","The Legend of Zelda","Metroid","The Last of Us","Heavy Rain","","","Metroid","normal","curiosidades");
        addQuestionToTable(M36);
        Question M37 = new Question("¿Cual de estos videojuegos NO está disponible en PlayStation 3?","Sonic Generations","The Elder Scrolls IV: Oblivion","Gran Turismo 7","Mass Effect 2","","","Gran Turismo 7","normal","curiosidades");
        addQuestionToTable(M37);
        Question M38 = new Question("La última versión oficial de Minecraft es la 1.18","","","","","","","Falso","binario","curiosidades");
        addQuestionToTable(M38);
        Question M39 = new Question("¿Cual es la mítica frase que Toad le dice a Mario cuando supera el primer castillo en Super Mario Bros? Thank You Mario! [...]","But our princess is in another castle!","But princess Peach is in other castle!","But the princess isn't here!","But Bowser took the princess to another castle!","","","But our princess is in another castle!","binario","curiosidades");
        addQuestionToTable(M39);
        Question M40 = new Question("¿Que quick-time event es famoso por el videojuego Call of Duty: Advanced Warfare? Press [...] ","X to doubt","A to insult","F to pay respects","R to die","","","F to pay respects","normal","curiosidades");
        addQuestionToTable(M40);
        Question M41 = new Question("¿A que videojuego pertenece este logo? ","Halo","Space Invaders","Metroid","Alien Isolation","","","Metroid","multimedia","curiosidades");
        addQuestionToTable(M41);
        Question M42 = new Question("¿A que videojuego pertenece este zombi?","Doom 64","Half-Life","Perfect Dark","Wolfenstein 3D","","","Half-Life","multimedia","curiosidades");
        addQuestionToTable(M42);
        Question M43 = new Question("¿Que consola tiene el menor número de unidades vendidas?","Virtual Boy","Atari Lynx","PS Vita","Sega Dreamcast","","","Virtual Boy","normal","historia");
        addQuestionToTable(M43);
        Question M44 = new Question("¿Cuantos bits tiene la arquitectura de la Nintendo GameCube?","16","32","64","128","","","128","normal","historia");
        addQuestionToTable(M44);
        Question M45 = new Question("¿Que consolas han vendido menos de 15 millones de unidades?","Wii U","Sega Master System","Xbox","Sega Dreamcast","PlayStation Vita","Nintendo 64","Sega Dreamcast,Sega Master System,Sega Dreamcast,","multiple","historia");
        addQuestionToTable(M45);
        Question M46 = new Question("¿Cual es el nombre de la consola que aparece en esta imagen?","Sega Saturn","NEO-GEO","Atari Jaguar","Sega Dreamcast","","","Atari Jaguar","multimedia","historia");
        addQuestionToTable(M46);
        Question M47 = new Question("¿Cual de las siguientes consolas es la Sega Dreamcast? ","NEO-GEO","Nintendo 64","Sega Saturn","Sega Dreamcast","","","Sega Dreamcast","multimedia","historia");
        addQuestionToTable(M47);
        Question M48 = new Question("¿Es la GameBoy Advanced una consola de 32 bits?","Verdadero","Falso","","","","","Verdadero","binario","historia");
        addQuestionToTable(M48);
        Question M49 = new Question("¿Cual es la consola de SEGA con mayor número de ventas? ","Sega Master System","Sega Mega Drive/Genesis","Sega Game Gear","Sega Saturn","","","Sega Mega Drive/Genesis","normal","empresa");
        addQuestionToTable(M49);
        Question M50 = new Question("¿Fue Toby Fox, el creador de Undertale, el que compuso también su banda sonora?","","","","","","","Verdadero","binario","curiosidades");
        addQuestionToTable(M50);
        Question M51 = new Question("¿Cuales de estas consolas fueron lanzadas al mercado entre los años 2000 y 2010?","Sega Dreamcast","Nintendo Wii U ","PlayStation 2","PlayStation 3","Xbox","Xbox 360","PlayStation 2, PlayStation 3, Xbox, Xbox 360,","multiple","historia");
        addQuestionToTable(M51);
        Question M52 = new Question("¿En qué juego situarías al personaje de Broxigar?","WoW","Diablo","Lol","Deus Ex","","","WoW","normal","curiosidades");
        addQuestionToTable(M52);
        Question M53 = new Question("¿Hay algún juego en el que el mítico personaje de Mario sea el villano en vez del héroe?","","","","","","","Verdadero","binario","curiosidades");
        addQuestionToTable(M53);
        Question M54 = new Question("¿En qué videojuego puedes escuchar la frase:“Nulla è reale, tutto è lecito. Requiescat in pace”?","Assassin's Creed I","Assassin's Creed II","Assassin's Creed III","The Elder Scrolls V: Skyrim","","","Assassin's Creed II","normal","curiosidades");
        addQuestionToTable(M54);
        Question M55 = new Question("¿El personaje de Lara Croft originalmente iba a ser hombre?","","","","","","","Verdadero","binario","curiosidades");
        addQuestionToTable(M55);
        Question M56 = new Question("¿Cuál de estos juegos no se ha estrenado en 2018?","Darksiders III","Biomutant","Dead or Alive 6","Pillars of Eternity II: Deadfire","","","Dead or Alive 6","normal","historia");
        addQuestionToTable(M56);
        Question M57 = new Question("¿Cual de estas empresas no española?","Ratalaika Games","Ubisoft","Valhalla Cats","Tequila Works","","","Ubisoft","normal","empresa");
        addQuestionToTable(M57);
        Question M58 = new Question("¿A qué empresa pertenece el videojuego League of Legends?","Riot","Electronic Arts","Nintendo","Tequila Works","","","Riot","normal","empresa");
        addQuestionToTable(M58);
        Question M59 = new Question("¿Cuales de estos videojuegos pertenecen al estudio Naughty Dog? ","Uncharted 2: El reino de los ladrones","Gran Turismo 4","Tomb Raider","Crash Bandicoot","The Last of Us","Spec Ops: The Line","Uncharted 2: El reino de los ladrones, The Last of Us, Crash Bandicoot,","multiple","empresa");
        addQuestionToTable(M59);
        Question M60 = new Question("Tequila Works es una empresa norteamericana","","","","","","","Falso","binario","empresa");
        addQuestionToTable(M60);

    }

    /**
     * Método para agregar la pregunta a la tabla
     * @param q
     */
    private void addQuestionToTable(Question q){
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, q.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, q.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, q.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, q.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, q.getOption4());
        cv.put(QuestionsTable.COLUMN_OPTION5, q.getOption5());
        cv.put(QuestionsTable.COLUMN_OPTION6, q.getOption6());
        cv.put(QuestionsTable.COLUMN_ANSWER, q.getAnswer());
        cv.put(QuestionsTable.COLUMN_CATEGORY, q.getAnswer());

        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    //endregion


}
