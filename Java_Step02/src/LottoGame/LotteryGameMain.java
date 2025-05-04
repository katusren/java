package LottoGame;

import javax.swing.*;

// 프로그램 시작 클래스
public class LotteryGameMain {
    public static void main(String[] args) {
        // GUI 업데이트는 이벤트 디스패치 스레드에서 실행
        SwingUtilities.invokeLater(() -> {
            // 메인 프레임 생성
            JFrame frame = new JFrame("행운의 열쇠는 누구에게?");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(450, 600); // 창 크기 설정
            frame.setResizable(false); // 창 크기 조정 불가

            // 게임 패널 추가
            frame.add(new LotteryPanel());

            frame.setLocationRelativeTo(null); // 화면 중앙에 창 띄우기
            frame.setVisible(true); // 창 보이게 하기
        });
    }
}
