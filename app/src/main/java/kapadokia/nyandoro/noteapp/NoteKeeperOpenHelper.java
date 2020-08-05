package kapadokia.nyandoro.noteapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * STEP 2
 */
public class NoteKeeperOpenHelper extends SQLiteOpenHelper {

    // 2.2 end the file name with a .db extension
    public static final String DATABASE_NAME = "NoteKeeper.db";
    public static final int DATABASE_VERSION= 1;

    // 2.1 CursorFactory is used to customize the behaviour of our database interaction but we don't need it.
    public NoteKeeperOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 2.3
        db.execSQL(NoteKeeperDatabaseContract.CourseInfoEntry.SQL_CREATE_TABLE);
        db.execSQL(NoteKeeperDatabaseContract.NoteInfoEntry.SQL_CREATE_TABLE);

        // 2.4  inserting a sample data
        DatabaseDataWorker worker = new DatabaseDataWorker(db);
        worker.insertCourses();
        worker.insertSampleNotes();
    }

    // transition the database from the older version to the new version
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
