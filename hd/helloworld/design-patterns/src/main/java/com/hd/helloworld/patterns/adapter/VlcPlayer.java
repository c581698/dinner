package com.hd.helloworld.patterns.adapter;

public class VlcPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVlc(String filename) {
		System.out.println("Playing……filename:"+filename);
	}

	@Override
	public void playMp4(String filename) {
	}
}
