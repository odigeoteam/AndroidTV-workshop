package pabloazana.controllers.video;

import android.view.Surface;

import java.io.IOException;

public interface VideoController {

    void setDataSource(String uri, Surface surface) throws IOException;
    void releaseMediaPlayer();
    void pausePlaying();
    void continuePlaying();

}
