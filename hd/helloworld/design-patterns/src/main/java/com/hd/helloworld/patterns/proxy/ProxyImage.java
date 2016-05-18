package com.hd.helloworld.patterns.proxy;

/**
 * <p>代理模式（Proxy Pattern）</p></br>
 * <b>意图</b>：为其他对象提供一种代理以控制对这个对象的访问。</br>
 * <b>主要解决</b>：在直接访问对象时带来的问题，比如说：要访问的对象在远程的机器上。在面向对象系统中，有些对象由于某些原因（比如对象创建开销很大，或者某些操作需要安全控制，或者需要进程外的访问），直接访问会给使用者或者系统结构带来很多麻烦，我们可以在访问此对象时加上一个对此对象的访问层。</br>
 * <b>何时使用</b>：想在访问一个类时做一些控制。</br>
 * <b>如何解决</b>：增加中间层。</br>
 * <b>关键代码</b>：实现与被代理类组合。</br>
 * <b>应用实例</b>： 1、Windows 里面的快捷方式。 2、猪八戒去找高翠兰结果是孙悟空变的，可以这样理解：把高翠兰的外貌抽象出来，高翠兰本人和孙悟空都实现了这个接口，猪八戒访问高翠兰的时候看不出来这个是孙悟空，所以说孙悟空是高翠兰代理类。 3、买火车票不一定在火车站买，也可以去代售点。 4、一张支票或银行存单是账户中资金的代理。支票在市场交易中用来代替现金，并提供对签发人账号上资金的控制。 5、spring aop。</br>
 * <b>优点</b>： 1、职责清晰。 2、高扩展性。 3、智能化。</br>
 * <b>缺点</b>： 1、由于在客户端和真实主题之间增加了代理对象，因此有些类型的代理模式可能会造成请求的处理速度变慢。 2、实现代理模式需要额外的工作，有些代理模式的实现非常复杂。</br>
 * <b>使用场景</b>：按职责来划分，通常有以下使用场景： 1、远程代理。 2、虚拟代理。 3、Copy-on-Write 代理。 4、保护（Protect or Access）代理。 5、Cache代理。 6、防火墙（Firewall）代理。 7、同步化（Synchronization）代理。 8、智能引用（Smart Reference）代理。</br>
 * <b>注意事项</b>： 1、和适配器模式的区别：适配器模式主要改变所考虑对象的接口，而代理模式不能改变所代理类的接口。 2、和装饰器模式的区别：装饰器模式为了增强功能，而代理模式是为了加以控制。</br>
* @ClassName: ProxyImage
* @Description: TODO
* @author chs cyj91516@aliyun.com
* @date 2016年5月24日 下午5:49:49
*
 */
public class ProxyImage implements Image {
	private String filePath;
	private RealImage RealImage;
	
	public ProxyImage(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public void display() {
		if(null == RealImage)
			RealImage = new RealImage(filePath);
		
		RealImage.display();
	}

}
