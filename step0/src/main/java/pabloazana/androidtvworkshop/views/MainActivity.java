package pabloazana.androidtvworkshop.views;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import pabloazana.androidtvworkshop.R;
import pabloazana.androidtvworkshop.controllers.CameraController;
import pabloazana.androidtvworkshop.controllers.PhotoController;

import static pabloazana.androidtvworkshop.controllers.CameraController.REQUEST_IMAGE_CAPTURE;

public class MainActivity extends AppCompatActivity implements MainView {

    private Button mActionButton;
    private PhotoController mPhotoController;
    private LinearLayout mMainLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActionButton = (Button) findViewById(R.id.action_button);
        mMainLinearLayout = (LinearLayout) findViewById(R.id.activity_main);
        setListener();
        initializePhotoController();
    }

    public void setListener() {
        mActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPhotoController.doPhotoAction();
            }
        });
    }

    public void initializePhotoController() {
        /* Here you need to control what kind of action you want to do.
        *  If the device has not camera, you need to do another action.
        *  Tip: CameraController and PictureController implements the same interface. */
        mPhotoController = new CameraController(this);
    }

    @Override
    public void changeBackground(Drawable drawable) {
        mMainLinearLayout.setBackground(drawable);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            changeBackground(new BitmapDrawable(getResources(),
                    (Bitmap) data.getExtras().get("data")));
        }
    }
}
