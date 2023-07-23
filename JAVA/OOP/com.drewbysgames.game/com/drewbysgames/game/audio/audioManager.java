package com.drewbysgames.game.audio;

import java.util.HashMap;
import java.util.Map;

public class audioManager {

    private Map<String, soundEffect> soundEffects;
    private Map<String, musicTrack> musicTracks;

    public audioManager() {
        soundEffects = new HashMap<>();
        musicTracks = new HashMap<>();
    }

    public void addSoundEffect(String name, String filePath) {
        soundEffect soundEffect = new soundEffect(filePath);
        soundEffects.put(name, soundEffect);
    }

    public void addMusicTrack(String name, String filePath) {
        musicTrack musicTrack = new musicTrack(filePath);
        musicTracks.put(name, musicTrack);
    }

    public void playSoundEffect(String name) {
        soundEffect soundEffect = soundEffects.get(name);
        if (soundEffect != null) {
            soundEffect.play();
        }
    }

    public void stopSoundEffect(String name) {
        soundEffect soundEffect = soundEffects.get(name);
        if (soundEffect != null) {
            soundEffect.stop();
        }
    }

    public void playMusicTrack(String name) {
        musicTrack musicTrack = musicTracks.get(name);
        if (musicTrack != null) {
            musicTrack.play();
        }
    }

    public void stopMusicTrack(String name) {
        musicTrack musicTrack = musicTracks.get(name);
        if (musicTrack != null) {
            musicTrack.stop();
        }
    }
}
