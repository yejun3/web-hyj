package ex2_charstream.exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		FileConverter converter = new FileConverter();
		
		converter.copy("wall.jpg","wall_copy2_");
		
		System.out.println("log.txt 파일을 확인");

	
	Scanner sc = new Scanner(System.in);
	File f = new File("test.txt");
	
	while(true) {
		System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.println("3. 종료");
        System.out.print("선택 >> ");

        int choice = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        // 1. 회원가입
        if (choice == 1) {

            System.out.print("아이디: ");
            String id = sc.nextLine();

            System.out.print("비밀번호: ");
            String pw = sc.nextLine();

            User user = new User(id, pw);

            FileOutputStream fos = null;

            try {
                fos = new FileOutputStream("users.txt", true);

                // User → byte[] → 파일 저장
                fos.write(user.toByteData());

                System.out.println("회원가입 완료!");

            } catch (IOException e) {
                e.printStackTrace();

            } finally {
                try {
                    if (fos != null) fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
     
        // 2. 로그인
        else if (choice == 2) {

            System.out.print("아이디: ");
            String inputId = sc.nextLine();

            System.out.print("비밀번호: ");
            String inputPw = sc.nextLine();

            boolean loginSuccess = false;

            FileInputStream fis = null;

            try {
                fis = new FileInputStream("users.txt");

                StringBuilder sb = new StringBuilder();
                int data;

                // 파일 전체 읽기
                while ((data = fis.read()) != -1) {
                    sb.append((char) data);
                }

                // 줄 단위 분리
                String[] users = sb.toString().split("\n");

                for (String u : users) {

                    if (u.trim().isEmpty()) continue;

                    String[] parts = u.split(" : ");

                    String id = parts[0];
                    String pw = parts[1];

                    if (id.equals(inputId) && pw.equals(inputPw)) {
                        loginSuccess = true;
                        break;
                    }
                }

                if (loginSuccess) {
                    System.out.println("로그인 성공!");
                } else {
                    System.out.println("로그인 실패!");
                }

            } catch (IOException e) {
                e.printStackTrace();

            } finally {
                try {
                    if (fis != null) fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 3. 종료

        else if (choice == 3) {
            System.out.println("종료합니다.");
            break;
        }
    }

    sc.close();
	}
}