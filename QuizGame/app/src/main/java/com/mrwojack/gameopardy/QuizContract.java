package com.mrwojack.gameopardy;

import android.provider.BaseColumns;


public final class QuizContract{
    public class QuestionsTable implements BaseColumns {

        public static final String TABLE_NAME = "quiz_normal_questions";
        public static final String COLUMN_QUESTION = "questions";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_ANSWER = "answer_nr";

    }
}

