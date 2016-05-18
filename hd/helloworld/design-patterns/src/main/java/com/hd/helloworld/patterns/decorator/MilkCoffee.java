package com.hd.helloworld.patterns.decorator;
/**
 * <p>装饰器模式（Decorator Pattern）</p></br>
 * <b>意图</b>：动态地给一个对象添加一些额外的职责。就增加功能来说，装饰器模式相比生成子类更为灵活。</br>
 * <b>主要解决</b>：一般的，我们为了扩展一个类经常使用继承方式实现，由于继承为类引入静态特征，并且随着扩展功能的增多，子类会很膨胀。</br>
 * <b>何时使用</b>：在不想增加很多子类的情况下扩展类。</br>
 * <b>如何解决</b>：将具体功能职责划分，同时继承装饰者模式。</br>
 * <b>关键代码</b>： 1、Component 类充当抽象角色，不应该具体实现。 2、修饰类引用和继承 Component 类，具体扩展类重写父类方法。</br>
 * <b>应用实例</b>： 1、孙悟空有 72 变，当他变成"庙宇"后，他的根本还是一只猴子，但是他又有了庙宇的功能。 2、不论一幅画有没有画框都可以挂在墙上，但是通常都是有画框的，并且实际上是画框被挂在墙上。在挂在墙上之前，画可以被蒙上玻璃，装到框子里；这时画、玻璃和画框形成了一个物体。</br>
 * <b>优点</b>：装饰类和被装饰类可以独立发展，不会相互耦合，装饰模式是继承的一个替代模式，装饰模式可以动态扩展一个实现类的功能。</br>
 * <b>缺点</b>：多层装饰比较复杂。</br>
 * <b>使用场景</b>： 1、扩展一个类的功能。 2、动态增加功能，动态撤销。</br>
 * <b>注意事项</b>：可代替继承。
* @ClassName: MilkCoffee
* @Description: TODO
* @author chs cyj91516@aliyun.com
* @date 2016年5月24日 上午10:58:08
*
 */
public class MilkCoffee extends Decorator {
	private String desc = "加了牛奶的咖啡";
	private Beverage bev;
	
	public MilkCoffee(Beverage bev) {
		this.bev = bev;
	}
	
	@Override
	public String desc() {
		return bev.desc()+"\n"+desc;
	}

	@Override
	public Double price() {
		return bev.price()+80d;
	}
	
}
