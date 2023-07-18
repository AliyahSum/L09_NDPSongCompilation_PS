package sg.edu.rp.c346.id22015529.ndpsongcompilation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "songcompilation.db" ;
    private static final int DATABASE_VERSION = 1 ;
    private static final String TABLE_SONG = "songs" ;
    private static final String COLUMN_ID = "_id" ;
    private static final String COLUMN_SONG_TITLE_CONTENT = "song_title_content" ;
    private static final String COLUMN_SINGER_CONTENT = "singer_content" ;
    private static final String COLUMN_YEAR_CONTENT = "year_content" ;
    private static final String COLUMN_STARS_CONTENT = "stars_content" ;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION) ;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSongTableSql = "CREATE TABLE " + TABLE_SONG + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_SONG_TITLE_CONTENT + " TEXT, "
                + COLUMN_SINGER_CONTENT + " TEXT, "
                + COLUMN_YEAR_CONTENT + " INTEGER, "
                + COLUMN_STARS_CONTENT + " INTEGER)" ;
        db.execSQL(createSongTableSql) ;
        Log.i("info", "created tables") ;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SONG);
        onCreate(db);

        //db.execSQL("ALTER TABLE " + TABLE_SONG + " ADD COLUMN module_name TEXT ") ;
    }

    public void insertSong(String title, String singers, int year, int stars){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_SONG_TITLE_CONTENT, title);
        values.put(COLUMN_SINGER_CONTENT, singers);
        values.put(COLUMN_YEAR_CONTENT, year);
        values.put(COLUMN_STARS_CONTENT, stars);

        db.insert(TABLE_SONG, null, values);

        db.close();
    }

    public ArrayList<String> getSongContent() {
        ArrayList<String> songs = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID, COLUMN_SONG_TITLE_CONTENT, COLUMN_SINGER_CONTENT, COLUMN_YEAR_CONTENT, COLUMN_STARS_CONTENT};
        Cursor cursor = db.query(TABLE_SONG, columns, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                songs.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return songs;
    }

}
