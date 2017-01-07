package com.toft.recorder;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

public class RecordManager {
	private TargetDataLine targetLine;
	
	public void startRecord(){
		AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100f, 16, 2, 4, 44100f, false);
		
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
		if(!AudioSystem.isLineSupported(info)){
			throw new UnsupportedOperationException();
		}
		
		try {
			targetLine = (TargetDataLine)AudioSystem.getLine(info);
			targetLine.open();
			targetLine.start();
			new Thread(new AudioWriter(targetLine)).start();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void stopRecord(){
		targetLine.stop();
		targetLine.close();
	}
}
