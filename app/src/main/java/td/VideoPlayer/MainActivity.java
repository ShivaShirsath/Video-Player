package td.VideoPlayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.khizar1556.mkvideoplayer.*;
import net.alhazmy13.mediapicker.Video.*;
import android.content.*;
import java.util.*;
import android.content.res.*;

public class MainActivity extends AppCompatActivity{
	private MKPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
			
		player = new  MKPlayer(this);
		
		player.play(getIntent().getStringExtra("url"));
		
		player.setPlayerCallbacks(new MKPlayer.playerCallbacks() {
			@Override
			public void onNextClick() {
				player.stop();
				startActivity( new Intent( MainActivity.this, GetVideoActivity.class) );
				finish();
			}
			@Override
			public void onPreviousClick() {
				player.stop();
				startActivity( new Intent( MainActivity.this, GetVideoActivity.class) );
				finish();
			}
		});
    }
	@Override
    protected void onPause() {
        super.onPause();
        if (player != null) player.onPause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (player != null) player.onResume();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) player.onDestroy();
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (player != null) player.onConfigurationChanged(newConfig);
    }
    @Override
    public void onBackPressed() {
        if ( player != null && player.onBackPressed() ) {
            return;
        }
        super.onBackPressed();
    }
}
