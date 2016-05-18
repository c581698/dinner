package com.hd.helloworld.patterns.composite;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>组合模式（Composite Pattern），又叫"部分-整体"模式</p></br>
 * <b>意图</b>：将对象组合成树形结构以表示"部分-整体"的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性。</br>
 * <b>主要解决</b>：它在我们树型结构的问题中，模糊了简单元素和复杂元素的概念，客户程序可以向处理简单元素一样来处理复杂元素，从而使得客户程序与复杂元素的内部结构解耦。</br>
 * <b>何时使用</b>： 1、您想表示对象的部分-整体层次结构（树形结构）。 2、您希望用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象。</br>
 * <b>如何解决</b>：树枝和叶子实现统一接口，树枝内部组合该接口。</br>
 * <b>关键代码</b>：树枝内部组合该接口，并且含有内部属性 List，里面放 Component。</br>
 * <b>应用实例</b>： 1、算术表达式包括操作数、操作符和另一个操作数，其中，另一个操作符也可以是操作树、操作符和另一个操作数。 2、在 JAVA AWT 和 SWING 中，对于 Button 和 Checkbox 是树叶，Container 是树枝。</br>
 * <b>优点</b>： 1、高层模块调用简单。 2、节点自由增加。</br>
 * <b>缺点</b>：在使用组合模式时，其叶子和树枝的声明都是实现类，而不是接口，违反了依赖倒置原则。</br>
 * <b>使用场景</b>：部分、整体场景，如树形菜单，文件、文件夹的管理。</br>
 * <b>注意事项</b>：定义时为具体类。</br>
* @ClassName: Employee
* @Description: TODO
* @author chs cyj91516@aliyun.com
* @date 2016年5月18日 下午4:53:36
*
 */
public class Employee {
	private String name;
	private String dept;
	private int salary;
	private List<Employee> subs;
	
	public Employee(String name,String dept,int salary) {
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		
		subs = new ArrayList<Employee>();
	}
	
	public void addEmp(Employee emp){
		subs.add(emp);
	}
	
	public void removeEmp(Employee emp) {
		subs.remove(emp);
	}
	
	public String getName() {
		return name;
	}
	public String getDept() {
		return dept;
	}
	public int getSalary() {
		return salary;
	}

	public List<Employee> getSubs() {
		return subs;
	}
}
