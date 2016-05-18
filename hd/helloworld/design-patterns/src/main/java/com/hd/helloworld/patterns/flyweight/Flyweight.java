package com.hd.helloworld.patterns.flyweight;
/**
 * <p>享元模式（Flyweight Pattern）</p></br>
 * <b>意图</b>：运用共享技术有效地支持大量细粒度的对象。</br>
 * <b>主要解决</b>：在有大量对象时，有可能会造成内存溢出，我们把其中共同的部分抽象出来，如果有相同的业务请求，直接返回在内存中已有的对象，避免重新创建。</br>
 * <b>何时使用</b>： 1、系统中有大量对象。 2、这些对象消耗大量内存。 3、这些对象的状态大部分可以外部化。 4、这些对象可以按照内蕴状态分为很多组，当把外蕴对象从对象中剔除出来时，每一组对象都可以用一个对象来代替。 5、系统不依赖于这些对象身份，这些对象是不可分辨的。</br>
 * <b>如何解决</b>：用唯一标识码判断，如果在内存中有，则返回这个唯一标识码所标识的对象。</br>
 * <b>关键代码v：用 HashMap 存储这些对象。</br>
 * <b>应用实例</b>： 1、JAVA 中的 String，如果有则返回，如果没有则创建一个字符串保存在字符串缓存池里面。 2、数据库的数据池。</br>
 * <b>优点</b>：大大减少对象的创建，降低系统的内存，使效率提高。</br>
 * <b>缺点</b>：提高了系统的负责度，需要分离出外部状态和内部状态，而且外部状态具有固有化的性质，不应该随着内部状态的变化而变化，否则会造成系统的混乱。</br>
 * <b>使用场景</b>： 1、系统有大量相似对象。 2、需要缓冲池的场景。</br>
 * <b>注意事项</b>： 1、注意划分外部状态和内部状态，否则可能会引起线程安全问题。 2、这些类必须有一个工厂对象加以控制。</br>
* @ClassName: Flyweight
* @Description: TODO
* @author chs cyj91516@aliyun.com
* @date 2016年5月24日 上午11:38:11
*
 */
public class Flyweight {
	private static final String colors[] = 
	      { "Red", "Green", "Blue", "White", "Black" };
	   public static void main(String[] args) {

	      for(int i=0; i < 20; ++i) {
	         Circle circle = 
	            (Circle)Factory.getCircle(getRandomColor());
	         circle.setX(getRandomX());
	         circle.setY(getRandomY());
	         circle.setRadius(100);
	         circle.draw();
	      }
	   }
	   private static String getRandomColor() {
	      return colors[(int)(Math.random()*colors.length)];
	   }
	   private static int getRandomX() {
	      return (int)(Math.random()*100 );
	   }
	   private static int getRandomY() {
	      return (int)(Math.random()*100);
	   }
}
