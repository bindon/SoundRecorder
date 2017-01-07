package com.toft.recorder;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.TargetDataLine;

public class AudioWriter implements Runnable {
	TargetDataLine targetLine;

	public AudioWriter(TargetDataLine targetLine) {
		this.targetLine = targetLine;
	}

	@Override
	public void run() {
		AudioInputStream audioStream = new AudioInputStream(targetLine);
		File audioFile = new File(
				new SimpleDateFormat("yyyyMMdd_hhmmss").format(Calendar
						.getInstance().getTime()) + ".wav");
		try {
			AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE, audioFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
