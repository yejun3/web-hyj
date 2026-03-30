package ex3_access.package1;
// 같은 패키지의 다른 클래스
public class E {
 D d1 = new D(true);
 D d2 = new D(1);
 //D d3 = new D("헬로우"); _> 실행 안됨 실행 안됨 private는 다른 클래스에서는 불가
}
