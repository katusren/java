package LottoGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

// 전체 게임판을 관리하는 클래스
public class LotteryPanel extends JPanel {
    private LotteryCell[] cells = new LotteryCell[9]; // 9개의 셀
    private JButton startButton; // 게임 시작 버튼

    // 생성자 : 게임판 초기화
    public LotteryPanel() {
        setLayout(new BorderLayout()); // 전체 레이아웃 설정

        // 그리드(3x3) 패널 생성
        JPanel gridPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 바깥 여백

        // 9개의 셀 생성 후 그리드에 추가
        for (int i = 0; i < 9; i++) {
            cells[i] = new LotteryCell();
            gridPanel.add(cells[i]);
        }

        // 게임 시작 버튼 생성
        startButton = new JButton("게임시작");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startLottery(); // 버튼 클릭 시 추첨 실행
            }
        });

        // 구성 요소를 패널에 추가
        add(gridPanel, BorderLayout.CENTER); // 셀 그리드는 가운데
        JPanel bottomPanel = new JPanel(); // 버튼을 위한 패널
        bottomPanel.add(startButton);
        add(bottomPanel, BorderLayout.SOUTH); // 버튼은 아래
    }

    // 게임을 시작하는 메소드
    private void startLottery() {
        ArrayList<Integer> enteredIndexes = new ArrayList<>(); // 이름이 입력된 셀 인덱스 모음

        // 이름이 입력된 셀만 수집
        for (int i = 0; i < 9; i++) {
            String name = cells[i].getNameText();
            if (!name.isEmpty() && !name.equals("이름입력")) { // 빈칸과 기본 텍스트 제외
                enteredIndexes.add(i);
            }
        }

        // 입력된 이름이 하나도 없는 경우
        if (enteredIndexes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "이름을 하나 이상 입력하세요!");
            return;
        }

        // 랜덤으로 당첨자 선택
        Random rand = new Random();
        int winnerIndex = enteredIndexes.get(rand.nextInt(enteredIndexes.size())); // 무작위 선택

        // 각 셀 결과 설정
        for (int i = 0; i < 9; i++) {
            if (enteredIndexes.contains(i)) { // 이름 입력된 셀만
                if (i == winnerIndex) { // 당첨자
                    cells[i].setResult("당첨!", Color.YELLOW, 18);
                } else { // 꽝
                    cells[i].setResult("꽝", Color.LIGHT_GRAY, 16);
                }
            } else {
                cells[i].reset(); // 입력 안된 셀은 초기화
            }
        }
    }
}
