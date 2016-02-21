package com.hd.berkeley;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import com.hd.berkeley.entity.Article;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.PrimaryIndex;
import com.sleepycat.persist.StoreConfig;

public class Main {
	static Environment env = null;
	static EntityStore es = null;

	public static void main(String[] args) {
		PrimaryIndex<String, Article> pi = es.getPrimaryIndex(String.class, Article.class);
	}

	static void open() {
		EnvironmentConfig cfg = new EnvironmentConfig();
		cfg.setAllowCreate(true);
		cfg.setReadOnly(true);
		
		StoreConfig sc = new StoreConfig();
		sc.setAllowCreate(true);
		sc.setReadOnly(true);

		env = new Environment(new File(getClassPath() + "/data"), cfg);
		
		es = new EntityStore(env, "EntityStore", sc);
	}

	public static String getClassPath() {
		String path = System.getProperty("java.class.path");

		path = path.substring(0, path.indexOf(";"));

		return path;
	}

	public static String getRandomChar(int len) {
		String ret = "";
		for (int i = 0; i < len; i++) {
			ret += (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
		}
		return ret;
	}
}
