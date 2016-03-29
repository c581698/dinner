package com.hd.helloworld.patterns.singleton;
/**
 * <p>单例模式（Singleton Pattern）</p>
 * <b>意图<b/>：保证一个类仅有一个实例，并提供一个访问它的全局访问点。<br/>
<b>主要解决<b/>：一个全局使用的类频繁地创建与销毁。<br/>
<b>何时使用<b/>：当您想控制实例数目，节省系统资源的时候。<br/>
<b>如何解决<b/>：判断系统是否已经有这个单例，如果有则返回，如果没有则创建。<br/>
<b>关键代码<b/>：构造函数是私有的。<br/>
<b>应用实例<b/>： 1、一个党只能有一个主席。 2、Windows 是多进程多线程的，在操作一个文件的时候，就不可避免地出现多个进程或线程同时操作一个文件的现象，所以所有文件的处理必须通过唯一的实例来进行。 3、一些设备管理器常常设计为单例模式，比如一个电脑有两台打印机，在输出的时候就要处理不能两台打印机打印同一个文件。<br/>
<b>优点<b/>： 1、在内存里只有一个实例，减少了内存的开销，尤其是频繁的创建和销毁实例（比如管理学院首页页面缓存）。 2、避免对资源的多重占用（比如写文件操作）。<br/>
<b>缺点<b/>：没有接口，不能继承，与单一职责原则冲突，一个类应该只关心内部逻辑，而不关心外面怎么样来实例化。<br/>
<b>使用场景<b/>： 1、要求生产唯一序列号。 2、WEB 中的计数器，不用每次刷新都在数据库里加一次，用单例先缓存起来。 3、创建的一个对象需要消耗的资源过多，比如 I/O 与数据库的连接等。<br/>
<b>注意事项<b/>：getInstance() 方法中需要使用同步锁 synchronized (Singleton.class) 防止多线程同时进入造成 instance 被多次实例化。<br/>
* @ClassName: SingletonInst
* @Description: TODO
* @author chs cyj91516@aliyun.com
* @date 2016年3月30日 下午4:09:37
*
 */
public final class SingletonInst {
	private static SingletonInst inst=null;
	
	private SingletonInst(){
	}
	
	public static SingletonInst getInstance(){
		if(null == inst){
			synchronized (SingletonInst.class) {
				if(null == inst)
					//初始化
					inst = new SingletonInst();
			}
		}
		
		return inst;
	}
}
