package com.toft.recorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Recorder extends JFrame {
	private static final long serialVersionUID = 1L;
	private boolean isStarted = false;
	private RecordManager recordManager;
	
	public Recorder() {
		recordManager = new RecordManager();
		
		initFrame();
		addButtons();
		showFrame();
	}
	
	private void initFrame(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setTitle("");
		setLayout(new GridLayout(1, 1));
	}
	
	private void addButtons(){
		final JButton button = new JButton("≥Ï¿ΩΩ√¿€");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				isStarted = !isStarted;
				if(isStarted){
					button.setText("≥Ï¿Ω¡æ∑·");
					recordManager.startRecord();
				}else{
					button.setText("≥Ï¿ΩΩ√¿€");
					recordManager.stopRecord();
				}
				
			}
		});
		
		add(button);
	}
	
	private void showFrame(){
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Recorder();
	}
}
