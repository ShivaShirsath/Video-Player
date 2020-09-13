package td.VideoPlayer;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import net.alhazmy13.mediapicker.Video.*;
import android.content.*;
import java.util.*;
import android.net.*;

public class GetVideoActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getvideo);
    }
	public void openVideo(View view){
		new VideoPicker.Builder(GetVideoActivity.this).mode(VideoPicker.Mode.GALLERY).directory(VideoPicker.Directory.DEFAULT).extension(VideoPicker.Extension.MP4).enableDebuggingMode(true).build();
	}
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == VideoPicker.VIDEO_PICKER_REQUEST_CODE && resultCode == RESULT_OK) {        
			startActivity( new Intent(GetVideoActivity.this, MainActivity.class).putExtra( "url", data.getStringArrayListExtra(VideoPicker.EXTRA_VIDEO_PATH).get(0) ) );
			finish();
        }
    }
}
