package sg.edu.rp.c346.id22015529.ndpsongcompilation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SongActivity extends AppCompatActivity {
    Button btn5stars ;
    ListView lvSongs ;
    ArrayList<Song> alSong ;
    CustomAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        btn5stars = findViewById(R.id.buttonShowAll) ;
        lvSongs = findViewById(R.id.listViewAllSongs) ;

        Intent intentReceived = getIntent() ;

        alSong = new ArrayList<>() ;

        Song song1 = new Song()
    }
}