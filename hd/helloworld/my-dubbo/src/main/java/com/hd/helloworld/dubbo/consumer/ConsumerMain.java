package com.hd.helloworld.dubbo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hd.helloworld.dubbo.provider.HelloDubbo;

public class ConsumerMain {

	public static void main(String[] args) throws InterruptedException {
		hello();
		Thread.sleep(1000*60);
	}

	static void hello() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath*:dubbo-demo-consumer.xml" });
		context.start();

		HelloDubbo demoService = (HelloDubbo) context.getBean("helloDubbo"); // 获取远程服务代理
		String hello = demoService.helloTo("dinner"); // 执行远程方法

		System.out.println(hello); // 显示调用结果
	}
}