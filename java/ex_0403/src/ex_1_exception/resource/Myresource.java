package ex_1_exception.resource;

public class Myresource implements AutoCloseable {
 
	private String name;
	
	
	public Myresource(String name) {
		this.name=name;
		System.out.println("[myResource("+ name +") 열기]");
	}
		public String read1() {
		System.out.println("[myResource("+ name +") 읽기]");
		return "100";
		}
	
		public String read2() {
			System.out.println("[myResource("+name+") 닫기]");
			return "abc";
			}
		
		@Override
		public void close() throws Exception {
			System.out.println("[MyResource(" + name + ") 닫기]");
		}
	
}
