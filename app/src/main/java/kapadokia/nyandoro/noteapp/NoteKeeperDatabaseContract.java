package kapadokia.nyandoro.noteapp;

import android.provider.BaseColumns;

/**
 *
 * :: UNDERSTANDING SQLite and SQLite Database creation
 * STEP 1
 * below i will be creating a database contract class that will be having the database schema
 */

public final class NoteKeeperDatabaseContract {

    private NoteKeeperDatabaseContract(){} // 1.1 make it non inheritable

    // 1.2 create a class to describe a table by giving it the name of te table followed by the word entry
    // 1.4 implement BaseColumn
    public static final class CourseInfoEntry implements BaseColumns {
        //1.2.1 giving constants for the table
        public static final String TABLE_NAME ="course_info";
        public static final String COLUMN_COURSE_ID ="course_id";
        public static final String COLUMN_COURSE_TITLE ="course_title";

        // 1.2.2 CREATE TABLE
        // 1.4.1 add _id
        public static final String SQL_CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME +" (" +
                _ID+" INTEGER PRIMARY KEY, "+
                COLUMN_COURSE_ID+" TEXT UNIQUE NOT NULL, "
                +COLUMN_COURSE_TITLE+" TEXT NOT NULL)";

    }

    // 1.3
    // 1.5 implement BaseColumn
    public static final class NoteInfoEntry implements BaseColumns{
        public static final String TABLE_NAME ="note_info";
        public static final String COLUMN_NOTE_TITLE ="note_title";
        public static final String COLUMN_NOTE_TEXT ="note_text";
        public static final String COLUMN_COURSE_ID="course_id";

        // 1.5.1 add _id primary key to wor effectively with android framework
        public static final String SQL_CREATE_TABLE=
                "CREATE TABLE "+ TABLE_NAME +" ("+
                        _ID+ " INTEGER PRIMARY KEY, "+
                        COLUMN_NOTE_TITLE+" TEXT NOT NULL, "+
                        COLUMN_NOTE_TEXT +" TEXT, "+
                        COLUMN_COURSE_ID+ " TEXT NOT NULL)";
    }
}
