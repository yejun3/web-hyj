package exam;

public class TextService {

 public String processText(String text, StringProcessor processor) {
	 return processor.process(text);
//매개변수 text에 받아온 값을 넣어 호출
 }

}
//processor는 StringProcessor타입 객체를 받음
// 객체변수 processor = text, str -> str.toUpperCase()
/*StringProcessor processor = new StringProcessor() {
    @Override
    public String process(String str) {
        return str.toUpperCase();
    //str은 text를 받아올 매개변수
    }
};의 축약형*/