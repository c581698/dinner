package com.hd.helloworld.patterns.test.composite;

import org.junit.Test;
import static org.junit.Assert.*;
import com.hd.helloworld.patterns.composite.Employee;

public class TestComposite {
	@Test
	public void test() {
		Employee CEO = new Employee("John", "CEO", 30000);

		Employee headSales = new Employee("Robert", "Head Sales", 20000);

		Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);

		Employee clerk1 = new Employee("Laura", "Marketing", 10000);
		Employee clerk2 = new Employee("Bob", "Marketing", 10000);

		Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
		Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);

		CEO.addEmp(headSales);
		CEO.addEmp(headMarketing);

		headSales.addEmp(salesExecutive1);
		headSales.addEmp(salesExecutive2);

		headMarketing.addEmp(clerk1);
		headMarketing.addEmp(clerk2);

		System.out.println(CEO);
		
		int count = 1;
		
		for (Employee headEmployee : CEO.getSubs()) {
			System.out.println(headEmployee);
			++count;
			for (Employee employee : headEmployee.getSubs()) {
				System.out.println(employee);
				++count;
			}
		}
		
		assertEquals(count, 7);
	}
}
