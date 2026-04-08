package ex_3_generic;
//클래스명 뒤에 제네릭 
public class Sample <T> implements ISample<T>{
	private T[] array;
	
	public Sample(){
		array = (T[]) new Object[10];
	}
@Override
public void addElement(T t, int index) {
	array[index]=t;
	

}
@Override
public T getElement(int index) {
	return array[index];
}
}
