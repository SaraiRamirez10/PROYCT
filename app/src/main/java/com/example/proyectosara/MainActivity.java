package com.example.proyectosara;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {
    private static String APP_DIRECTORY = "MyPictureApp/";
    private static String MEDIA_DIRECTORY = APP_DIRECTORY + "PictureApp";

    private final int MY_PERMISSIONS = 100;
    private final int PHOTO_CODE = 200;
    private final int SELECT_PICTURE = 300;

    private ImageView mSetImage;
    private Button mOptionButton;
    private RelativeLayout mRlView;

    private String mPath;
    private static final int TAKE_PICTURE = 0;
    private Uri imageUri;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        mSetImage = (ImageView) findViewById(R.id.set_picture);
        mOptionButton = (Button) findViewById(R.id.show_options_button);
        mRlView = (RelativeLayout) findViewById(R.id.rl_view);

        mSetImage = (ImageView) findViewById(R.id.set_picture);
        mOptionButton = (Button) findViewById(R.id.show_options_button);
        mRlView = (RelativeLayout) findViewById(R.id.rl_view);


        if(mayRequestStoragePermission())
            mOptionButton.setEnabled(true);
        else
            mOptionButton.setEnabled(false);


        mOptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptions();
            }
        });
    }

        private boolean mayRequestStoragePermission() {
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
                return true;

            if((checkSelfPermission(WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) &&
                    (checkSelfPermission(CAMERA) == PackageManager.PERMISSION_GRANTED))
                return true;


            return false;
        }


        private void showOptions() {
            final CharSequence[] option = {"Tomar foto", "Elegir de galeria", "Cancelar"};
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Eleige una opción");
            builder.setItems(option, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if(option[which] == "Tomar foto") {
                }
    }
}