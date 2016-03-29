package com.hd.helloworld.patterns.adapter;

public class AudioPlayer implements MediaPlayer {

	@Override
	public void play(String mediaType, String fileName) {
		System.out.println("Playing……filename:"+fileName);
	}

}
