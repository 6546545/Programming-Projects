package com.drewbysgames.game.audio;

import java.util.HashMap;
import java.util.Map;

public class AudioManager {

    private Map<String, SoundEffect> soundEffects;
    private Map<String, MusicTrack> musicTracks;

    public AudioManager() {
        soundEffects = new HashMap<>();
        musicTracks = new HashMap<>();
    }

    public void addSoundEffect(String name, String filePath) {
        SoundEffect soundEffect = new SoundEffect(filePath);
        soundEffects.put(name, soundEffect);
    }

    public void addMusicTrack(String name, String filePath) {
        MusicTrack musicTrack = new MusicTrack(filePath);
        musicTracks.put(name, musicTrack);
    }

    public void playSoundEffect(String name) {
        SoundEffect soundEffect = soundEffects.get(name);
        if (soundEffect != null) {
            soundEffect.play();
        }
    }

    public void stopSoundEffect(String name) {
        SoundEffect soundEffect = soundEffects.get(name);
        if (soundEffect != null) {
            soundEffect.stop();
        }
    }

    public void playMusicTrack(String name) {
        MusicTrack musicTrack = musicTracks.get(name);
        if (musicTrack != null) {
            musicTrack.play();
        }
    }

    public void stopMusicTrack(String name) {
        MusicTrack musicTrack = musicTracks.get(name);
        if (musicTrack != null) {
            musicTrack.stop();
        }
    }
}
