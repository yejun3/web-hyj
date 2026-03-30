package ex3_access.package2;

import ex3_access.package1.D;
//다른 패키지의 다른 클래스
public class F {
	D d1 = new D(true);
	 //D d2 = new D(1); -> 실행 안됨 default는 같은 패키지에서만 사용가능 다른 패키지에서는 불가
	 //D d3 = new D("헬로우"); -> 실행 안됨 private는 다른 클래스에서는 불가
}
