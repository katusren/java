package chapter14.vector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class VectorBoardMain_02 {

    public static void main(String[] args) {

        // List<Board> list = new Vector<>();
        List<Board> syncList = Collections.synchronizedList(new ArrayList<>());

        Board b = new Board("제목1", "내용1", "글쓴이1");

        syncList.add(b);
        syncList.add(new Board("제목2", "내용2", "글쓴이2"));
        syncList.add(new Board("제목3", "내용3", "글쓴이3"));
        syncList.add(new Board("제목4", "내용4", "글쓴이4"));
        syncList.add(new Board("제목5", "내용5", "글쓴이5"));

        for (int i = 0; i < syncList.size(); i++) {
            Board board = syncList.get(i);
            System.out.println(board.subject + "\t" + board.content + "\t" + board.writer);
        }

        // 내용 삭제
        syncList.remove(2);
        System.out.println();

        // 작업자A가 악성글 삭제
        for (

                int i = 0; i < syncList.size(); i++) {
            Board board = syncList.get(i);
            System.out.println(board.subject + "\t" + board.content + "\t" + board.writer);
        }
    }
}
