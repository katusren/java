package LottoGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

// 메인 게임 패널 클래스
public class LotteryPanel extends JPanel {
    private ArrayList<LotteryCell> cells; // 9개의 셀을 담을 리스트
    private JButton startButton; // 게임 시작 버튼

    // 생성자
    public LotteryPanel() {
        setLayout(new BorderLayout(10, 10)); // 전체 레이아웃 설정
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백 추가

        // 셀들을 담을 패널 (3x3 그리드)
        JPanel gridPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        cells = new ArrayList<>();

        // 9개의 셀을 생성하여 그리드에 추가
        for (int i = 0; i < 9; i++) {
            LotteryCell cell = new LotteryCell();
            cells.add(cell);
            gridPanel.add(cell);
        }

        add(gridPanel, BorderLayout.CENTER); // 그리드 패널은 중앙에 배치

        // ====== 아래쪽 버튼 영역 ======
        startButton = new JButton("게임시작"); // 시작 버튼 생성

        // 시작 버튼 클릭 시 실행될 이벤트
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startLottery(); // 추첨 시작
            }
        });

        // 종료 버튼 생성
        JButton exitButton = new JButton("종료");

        // 종료 버튼 클릭 시 프로그램 종료
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // 종료 명령
            }
        });

        // 버튼들을 담을 패널
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(startButton); // 게임시작 버튼 추가
        bottomPanel.add(exitButton); // 종료 버튼 추가
        add(bottomPanel, BorderLayout.SOUTH); // 버튼 패널은 아래쪽에 배치
    }

    // 추첨 실행 메소드
    private void startLottery() {
        // 입력된 이름들을 모아 저장
        ArrayList<LotteryCell> validCells = new ArrayList<>();

        for (LotteryCell cell : cells) {
            String name = cell.getNameText();
            // "이름입력" 상태이거나 빈칸은 무시
            if (!name.isEmpty() && !name.equals("이름입력")) {
                validCells.add(cell);
            }
        }

        // 이름이 2명 이상일 때만 실행
        if (validCells.size() < 2) {
            JOptionPane.showMessageDialog(this, "최소 2명 이상 이름을 입력해주세요!");
            return;
        }

        // 모든 셀 초기화 (이전 결과 제거)
        for (LotteryCell cell : cells) {
            cell.reset();
        }

        // 당첨자를 무작위로 1명 선정
        Collections.shuffle(validCells);
        LotteryCell winner = validCells.get(0);

        // 당첨자 표시
        //winner.setResult("당첨!", Color.YELLOW, 25);
        winner.setResult("당첨!", Color.YELLOW, 25, "chest.png");

        // 나머지는 꽝 처리
        for (int i = 1; i < validCells.size(); i++) {
            //validCells.get(i).setResult("꽝", Color.LIGHT_GRAY, 14);
            validCells.get(i).setResult("꽝", Color.LIGHT_GRAY, 14, "skull.png");
        }
    }
}
