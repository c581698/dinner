package com.hd.helloworld.patterns.command;

import java.util.HashMap;
import java.util.Map;
/**
 * <p>命令模式（Command Pattern）</p></br>
 * {@link http://www.ibm.com/developerworks/cn/java/j-lo-serialNo/}</br>
 * <b>意图</b>：将一个请求封装成一个对象，从而使您可以用不同的请求对客户进行参数化。</br>
 * <b>主要解决</b>：在软件系统中，行为请求者与行为实现者通常是一种紧耦合的关系，但某些场合，比如需要对行为进行记录、撤销或重做、事务等处理时，这种无法抵御变化的紧耦合的设计就不太合适。</br>
 * <b>何时使用</b>：在某些场合，比如要对行为进行"记录、撤销/重做、事务"等处理，这种无法抵御变化的紧耦合是不合适的。在这种情况下，如何将"行为请求者"与"行为实现者"解耦？将一组行为抽象为对象，可以实现二者之间的松耦合。</br>
 * <b>如何解决</b>：通过调用者调用接受者执行命令，顺序：调用者→接受者→命令。</br>
 * <b>关键代码</b>：定义三个角色：1、received 真正的命令执行对象 2、Command 3、invoker 使用命令对象的入口</br>
 * <b>应用实例</b>：struts 1 中的 action 核心控制器 ActionServlet 只有一个，相当于 Invoker，而模型层的类会随着不同的应用有不同的模型类，相当于具体的 Command。</br>
 * <b>优点</b>： 1、降低了系统耦合度。 2、新的命令可以很容易添加到系统中去。</br>
 * <b>缺点</b>：使用命令模式可能会导致某些系统有过多的具体命令类。</br>
 * <b>使用场景</b>：认为是命令的地方都可以使用命令模式，比如： 1、GUI 中每一个按钮都是一条命令。 2、模拟 CMD。</br>
 * <b>注意事项</b>：系统需要支持命令的撤销(Undo)操作和恢复(Redo)操作，也可以考虑使用命令模式，见命令模式的扩展。</br>
* @ClassName: SNGenerateApp
* @Description: TODO
* @author chs cyj91516@aliyun.com
* @date 2016年5月30日 下午4:45:36
*
 */
public class SNGenerateApp {
	private SNGeneratorEngine snGenEngine = SNGeneratorEngine.getInstance();

	private void addBuildInGenerator() {
		snGenEngine.addGenerator(new CharacterSequenceGenerator());
		snGenEngine.addGenerator(new DateTimeGenerator());
		snGenEngine.addGenerator(new NumberSequenceGenerator());
		snGenEngine.addGenerator(new StringGenerator());
	}

	public void addGenerator(IGenerator generator) {
		snGenEngine.addGenerator(generator);
	}

	public String generateSN(String snFormatStr, Map parameterMap) {
		snGenEngine.setFormatStr(snFormatStr);
		return snGenEngine.generate(parameterMap);
	}

	public static void main(String[] args) {
		SNGenerateApp appication = new SNGenerateApp();//创建 App 实例
		appication.addBuildInGenerator(); //设置内置 Generator
		//1. 设定流水号生成规则 国务院办公厅发文号（国办发〔2014〕48 号）
		System.out.println("1. 生成 国务院办公厅发文号（国办发〔2014〕48 号）");
		//设定流水号生成规则
		String snFormatStr = "Str@ 国办发〔#DateTime@yyyy#Str@〕#Num@0C0#Str@ 号"; 
		Map parameterMap1 = new HashMap(); //设定参数
		for(int i=1;i<=5;i++)//生成 5 个流水号
		{
		 System.out.println("流水号"+i+":"+appication.generateSN(snFormatStr,parameterMap1));
		}
	}
}
