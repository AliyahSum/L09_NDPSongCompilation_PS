package sg.edu.rp.c346.id22015529.ndpsongcompilation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context ;
    int layout_id ;
    ArrayList<Song> songList ;

    public CustomAdapter(Context context, int resource, ArrayList<Song> objects) {
        super(context, resource, objects);

        parent_context = context ;
        layout_id = resource ;
        songList = objects ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View rowView = inflater.inflate(layout_id, parent, false) ;

        TextView tvTitle = rowView.findViewById(R.id.textViewTitle) ;
        TextView tvSingers = rowView.findViewById(R.id.textViewSinger) ;
        TextView tvYear = rowView.findViewById(R.id.textViewYear) ;
        TextView tvStars = rowView.findViewById(R.id.textViewStars) ;

        Song currentSong = songList.get(position) ;

        tvTitle.setText(currentSong.getTitle()); ;
        tvSingers.setText(currentSong.getSingers()) ;
        tvYear.setText(currentSong.getYear()) ;
        tvStars.setText(currentSong.getStars()) ;

        return rowView ;
    }
}