package auth.android.app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "msvc23.db";
    private static final int DB_VERSION = 2;

    private static final String TABLE_NAME = "speakerNote";
    private static final String ID_COL = "id";
    private static final String SPEAKER_NAME_COL = "speaker_name";
    private static final String NOTE_COL = "note";
    private static final String IS_SPEAKER_COL = "is_speaker_note";
    private static final String SPEAKER_ID_COL = "speaker_id";

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + SPEAKER_ID_COL + " INTEGER,"
                + SPEAKER_NAME_COL + " TEXT,"
                + IS_SPEAKER_COL + " INTEGER,"
                + NOTE_COL + " TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    public void insertNote(int speakerId, String speakerName, String note, int isSpeaker) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SPEAKER_ID_COL, speakerId);
        contentValues.put(SPEAKER_NAME_COL, speakerName);
        contentValues.put(IS_SPEAKER_COL, isSpeaker);
        contentValues.put(NOTE_COL, note);
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public List<String> getNoteBySpeakerId(int speakerId) {
        List<String> notes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT "
                + NOTE_COL + " FROM " + TABLE_NAME
                + " WHERE "
                + SPEAKER_ID_COL
                + " = "
                + speakerId, null);
        if (cursor.moveToFirst()) {
            do {
                notes.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return notes;
    }

    public List<String> getAllMyNotes() {
        List<String> notes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT "
                + NOTE_COL + " FROM " + TABLE_NAME
                + " WHERE "
                + IS_SPEAKER_COL
                + " = "
                + 0, null);
        if (cursor.moveToFirst()) {
            do {
                notes.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return notes;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
