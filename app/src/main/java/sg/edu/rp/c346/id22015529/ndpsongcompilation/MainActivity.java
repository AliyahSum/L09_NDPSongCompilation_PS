package sg.edu.rp.c346.id22015529.ndpsongcompilation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etSongTitle, etSingers, etYear ;
    RadioGroup rgStars ;
    Button btnInsert, btnViewList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSongTitle = findViewById(R.id.etSongTitle) ;
        etSingers = findViewById(R.id.etSingers) ;
        etYear = findViewById(R.id.etYear) ;
        rgStars = findViewById(R.id.radioGroupStars) ;
        btnInsert = findViewById(R.id.buttonInsert) ;
        btnViewList = findViewById(R.id.buttonShowList) ;

        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);

                String title = etSongTitle.getText().toString() ;
                String singers = etSingers.getText().toString() ;
                int year = Integer.parseInt(etYear.getText().toString()) ;
                int stars = rgStars.getCheckedRadioButtonId() ;

                db.insertSong(title, singers, year, stars);
            }
        });

    }
}