package kr.project;

import java.util.ArrayList;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import kr.soldesk.BookDTO;

public class Project01A {
    public static void main(String[] args) {
        BookDTO dto = new BookDTO("JAVA", 21000, "에이콘", 600);

        Gson g = new Gson();
        String json = g.toJson(dto); // BookDTO의 데이터(객체)를 json으로 변환
        System.out.println("------------Object(BookDTO) -> JSON(String)--------------");
        System.out.println(json);

        System.out.println("------------JSON(String) - >Object(BookDTO) --------------");
        // JSON(String) -> Object(BookDTO)
        BookDTO dto1 = g.fromJson(json, BookDTO.class);
        System.out.println(dto1);
        System.out.println("도서제목 : " + dto.getTitle() + ", 가격 : " + dto.getPrice());

        List<BookDTO> lst = new ArrayList<BookDTO>();
        lst.add(new BookDTO("JSP", 28000, "솔데스크", 720));
        lst.add(new BookDTO("JSA", 32000, "솔데스크", 680));
        lst.add(new BookDTO("Spring", 54000, "솔데스크", 900));
        System.out.println("------------Object(List(BookDTO)) -> JSON(String)--------------");

        String lst_Json = g.toJson(lst);
        System.out.println(lst_Json);

        List<BookDTO> lst1 = g.fromJson(lst_Json, new TypeToken<List<BookDTO>>() {
        }.getType());

        // 확인
        for (BookDTO vo : lst1) {
            System.out.println(vo);
        }
    }
}
