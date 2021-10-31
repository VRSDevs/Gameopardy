package com.mrwojack.gameopardy;

import android.provider.BaseColumns;


public final class QuizContract{

    private QuizContract(){

    }

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "quiz_normal_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_ANSWER = "answer";

    }

    public static class AudioQuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "quiz_audio_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_ANSWER = "answer";

    }

    public static class QuestionsMultipleTable implements BaseColumns {
        public static final String TABLE_NAME = "quiz_multiple_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_OPTION5 = "option5";
        public static final String COLUMN_OPTION6 = "option6";
        public static final String COLUMN_ANSWER = "answer";

    }

    public static class QuestionsImagesTable implements BaseColumns {
        public static final String TABLE_NAME = "quiz_images_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_ANSWER = "answer";

    }

    public static class VerdaderoFalsoQuestions implements BaseColumns {
        public static final String TABLE_NAME = "quiz_verdadero_falso_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_ANSWER = "answer";

    }


}

