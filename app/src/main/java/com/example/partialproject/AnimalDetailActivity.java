package com.example.partialproject;



import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AnimalDetailActivity extends AppCompatActivity {



    MediaPlayer mediaPlayer;
    int soundResId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        String animal = getIntent().getStringExtra("animal");
        if (animal == null) {
            Toast.makeText(this, "Animal not found!", Toast.LENGTH_SHORT).show();
            finish();
        }

        TextView animalName = findViewById(R.id.animalName);
        ImageView animalImage = findViewById(R.id.animalImage);

        switch (animal) {
            case "Lion":
                animalImage.setImageResource(R.drawable.lion);
                soundResId = R.raw.lion_roar;
                break;
            case "Elephant":
                animalImage.setImageResource(R.drawable.elephant);
                soundResId = R.raw.elephant_sound;
                break;
            case "Tiger":
                animalImage.setImageResource(R.drawable.tiger);
                soundResId = R.raw.tiger_sound;
                break;
            case "Monkey":
                animalImage.setImageResource(R.drawable.monkey);
                soundResId = R.raw.monkey_sound;
                break;
            default:
                Toast.makeText(this, "Animal not recognized!", Toast.LENGTH_SHORT).show();
                finish();
                return;

        }

        animalName.setText(animal);
        mediaPlayer = MediaPlayer.create(this, soundResId);
    }

    public void playSound(View view) {
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    public void pauseSound(View view) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public void stopSound(View view) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = MediaPlayer.create(this, soundResId);
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        super.onDestroy();
    }
}

