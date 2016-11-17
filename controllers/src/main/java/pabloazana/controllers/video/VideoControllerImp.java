package pabloazana.controllers.video;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;

import java.io.IOException;


public class VideoControllerImp extends MediaPlayer implements VideoController {

    private Context mContext;

    public VideoControllerImp(Context context) {
        super();
        mContext = context;
        setAudioStreamType(AudioManager.ADJUST_MUTE);
        setOnPreparedListener(buildOnPrepareListener());
        setOnErrorListener(buildOnErrorListener());
    }

    public void releaseMediaPlayer() {
        stop();
        release();
    }

    @Override
    public void pausePlaying() {
        pause();
    }

    @Override
    public void continuePlaying() {
        start();
    }

    public void setDataSource(String uri, Surface surface) {
        setSurface(surface);
        try {
            setDataSource(mContext, Uri.parse(uri));
            prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private OnPreparedListener buildOnPrepareListener() {
        return new OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        };
    }

    private OnErrorListener buildOnErrorListener() {
        return new OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                return false;
            }
        };
    }
}
