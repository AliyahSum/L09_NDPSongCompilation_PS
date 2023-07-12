package sg.edu.rp.c346.id22015529.ndpsongcompilation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
                + COLUMN_SONG_TITLE_CONTENT + " TEXT "
                + COLUMN_SINGER_CONTENT + " TEXT "
                + COLUMN_YEAR_CONTENT + " TEXT "
                + COLUMN_STARS_CONTENT + " TEXT)" ;
        db.execSQL(createSongTableSql) ;
        Log.i("info", "created tables") ;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER TABLE " + TABLE_SONG + " ADD COLUMN module_name TEXT ") ;
    }
}
