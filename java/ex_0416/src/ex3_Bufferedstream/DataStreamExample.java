package ex3_Bufferedstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataStreamExample {
	public static void main(String[] args) {
		//DataInputStream
		//DataOutputStream
		//기본 자료형 단위로 읽고 쓸 수있게 해준다.
		//int,double,boolean,char같은 값들을 바이트로 직접 변환하지 않고 
		//메서드로 편하게 다룰 수 있다.
		
		//.dat : 데이터가 들어있는 파일이다 알려주는 확장자
		
        // 1. 데이터 쓰기
        try (DataOutputStream dos =
                     new DataOutputStream(new FileOutputStream("data.dat"))) {

            dos.writeInt(100);
            dos.writeDouble(3.14);
            dos.writeBoolean(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2. 데이터 읽기
        try (DataInputStream dis =
                     new DataInputStream(new FileInputStream("data.dat"))) {

            int a = dis.readInt();
            double b = dis.readDouble();
            boolean c = dis.readBoolean();

            System.out.println(a);
            System.out.println(b);
            System.out.println(c);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
