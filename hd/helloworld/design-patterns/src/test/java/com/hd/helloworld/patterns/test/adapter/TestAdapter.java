package com.hd.helloworld.patterns.test.adapter;

import org.junit.Test;

import com.hd.helloworld.patterns.adapter.MediaAdapter;

public class TestAdapter {
	@Test
	public void test(){
		new MediaAdapter().play("mp3", "1.mp3");
		new MediaAdapter().play("mp4", "1.mp4");
		new MediaAdapter().play("vlc", "1.vlc");
		new MediaAdapter().play("mkv", "1.mkv");
	}
}
