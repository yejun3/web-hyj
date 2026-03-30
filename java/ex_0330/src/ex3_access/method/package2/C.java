package ex3_access.method.package2;

import ex3_access.method.package1.A;

public class C {
	public void method() {
		A a = new A();
		a.field1= 1;
		//a.field2= 2;
		//a.field3= 3;
		a.method1();
		//a.method2();
		//a.method3();
	}

}
