package com.hd.helloworld.interview;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import com.sun.corba.se.pept.transport.ContactInfo;


public class Merge {
	/**
	 * 空格标记
	 */
	private final static String MARK_SPACE = " ";
	/**
	 * 回车标记
	 */
	private final static String MARK_RETURN = "\r\n";

	private final static String fileA = "a.txt";
	private final static String fileB = "b.txt";
	
	List<String> store = new LinkedList<String>();
	
	
	/**
	 * 初始化a.txt b.txt
	* @Title: initFiles
	* @Description: TODO
	* @param  
	* @return void    返回类型
	* @throws
	 */
	public static void initFiles(){
		new ReadFile(fileA,MARK_SPACE).run();
		new ReadFile(fileB,MARK_RETURN).run();
	}
	
	public static void main(String[] args) {
		if(ClassLoader.getSystemResource("a.txt") == null || ClassLoader.getSystemResource("b.txt") == null){
			initFiles();
		}
		new Thread(new ReadFile(fileA)).start();
		new Thread(new ReadFile(fileB)).start();;
		
		Store.write("c.txt");
	}
}
class Store{
	private static int code =0;
	public static void exit(String file) {
		System.out.println(file+"exit……");
		code++;
	}
	
	public static LinkedList<String> storeA = new LinkedList<String>();
	public static LinkedList<String> storeB = new LinkedList<String>();
	private static LinkedList<String> tmp = null;
	
	public static void write(String file){
		int index = 1;
		
		try(FileWriter fw = new FileWriter(new File(file))){
			while(code !=2){
				String word = null;
				
				if(code==1){
					if(tmp ==null){
						tmp = storeA.size()==0?storeB:storeA;
						
						storeA=null;
						storeB = null;
					}
					if(tmp.size()==0){
						code = 2;
						continue;
					}
					word = tmp.getFirst()+"\r\n";
					
					tmp.removeFirst();
				}
				else if(storeA.size()==0||storeB.size()==0){
					System.out.println("Store等待读取……");
					Thread.sleep(4000);
					continue;
				}
				if(word == null){
					word = storeA.getFirst()+" "+storeB.getFirst()+"\r\n";
					
					storeA.removeFirst();
					storeB.removeFirst();
				}
				
				fw.write(word);
				System.out.println("c.txt\t"+index++);
			}
		}catch (IOException e) {
			System.out.println("输出目标文件出错！文件已存在？不可读？文件夹？");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}catch (NoSuchElementException e) {
			
		}
	}
	
	public static LinkedList<String> getVar(String file){
		return "a.txt".equals(file)?storeA:storeB;
	}
}
class ReadFile implements Runnable{
	
	private boolean isRead = true;
	private String file = null;
	private String separate = null;
	private LinkedList<String> store = null;
	
	public ReadFile(String file) {
		this.file = file;
	}

	public ReadFile(String file,String reg) {
		this.isRead = false;
		this.file = file;
		separate = reg;
	}
	
	@Override
	public void run() {
		if(isRead)
			read(file);
		else
			init();
	}
	
	private void read(final String file){
		System.out.println(file+" starting read……");
		
		store = Store.getVar(file);
		String s = null;
		
		if(store != null){
			try(RandomAccessFile raf = new RandomAccessFile(new File(file), "r")) {
				while((s=raf.readLine().trim()) != null){
					if(""==s)
						continue;
					if(null != separate){
						Collections.addAll(store, s.split(separate));
					}else{
						store.add(s);
					}
					
					if(store.size()>100){
						System.out.println(file+store.size()+"暂停……");
						Thread.sleep(2000);
					}
				}
				
				Store.exit(file);
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void init(){
		String[] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	
		try (FileWriter fw = new FileWriter(file);){
			for(int i=0;i<10000;i++){
				StringBuilder word = new StringBuilder();
				
				for(int j=0;j<10;j++){
					word.append(alpha[(int)(new Random().nextDouble()*26)]);
				}
				
				fw.write(word.toString()+"\r\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}