package serrvice;
import member.Member;
public class Memberservice {
	public void rsgister(Member member) {
		System.out.println("회원 등록을 시작합니다.");
        System.out.println("회원 이름 : " + member.getName());
        System.out.println("회원 나이 : " + member.getAge());
        System.out.println("회원 등록이 완료되었습니다.");
        }

	
	public void checkAdult(Member member) {
		if(member.age>20) {
			System.out.println("성인 회원입니다.");
		}else {
			System.out.println("미성년입니다.");
		}
	}
}
