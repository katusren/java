package LottoGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class LotteryGame extends JFrame {
    private JPanel[] cellPanels = new JPanel[9];
    private JTextField[] nameFields = new JTextField[9];
    private JLabel[] resultLabels = new JLabel[9];
    private JButton startButton = new JButton("게임시작");

    public LotteryGame() {
        setTitle("이름 추첨 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 600); // 창의 기본 사이즈
        setResizable(false); // 창 크기 고정
        setLayout(new BorderLayout());

        // 3x3 네모판
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(3, 3, 10, 10));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < 9; i++) {
            // 각 셀 패널 설정
            cellPanels[i] = new JPanel();
            cellPanels[i].setLayout(new BorderLayout(5, 5));
            cellPanels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            cellPanels[i].setPreferredSize(new Dimension(120, 120)); // 크기 고정

            // 결과 표시용 라벨
            resultLabels[i] = new JLabel("", SwingConstants.CENTER);
            resultLabels[i].setFont(new Font("맑은 고딕", Font.BOLD, 16)); // 큼직하게
            resultLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            resultLabels[i].setVerticalAlignment(SwingConstants.CENTER);

            // 이름 입력 필드
            nameFields[i] = new JTextField("이름입력");
            nameFields[i].setHorizontalAlignment(JTextField.CENTER);

            // 셀 패널에 컴포넌트 배치
            cellPanels[i].add(resultLabels[i], BorderLayout.CENTER); // 중앙에 결과
            cellPanels[i].add(nameFields[i], BorderLayout.SOUTH); // 아래에 이름

            // 셀을 그리드에 추가
            gridPanel.add(cellPanels[i]);
        }

        add(gridPanel, BorderLayout.CENTER);

        // 게임 시작 버튼
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(startButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // 버튼 클릭 이벤트 처리
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        setLocationRelativeTo(null); // 창이 정중앙에 뜨게 처리
        setVisible(true);
    }

    private void startGame() {
        ArrayList<Integer> enteredIndexes = new ArrayList<>();

        // 이름이 입력된 칸만 수집
        for (int i = 0; i < 9; i++) {
            String name = nameFields[i].getText().trim();
            if (!name.isEmpty() && !name.equals("이름입력")) {
                enteredIndexes.add(i);
            }
        }

        // 입력된 사람이 없을 경우 경고
        if (enteredIndexes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "이름을 하나 이상 입력하세요!");
            return;
        }

        // 랜덤으로 당첨자 한 명 선택
        Random rand = new Random();
        int winnerIndex = enteredIndexes.get(rand.nextInt(enteredIndexes.size()));

        // 결과 처리
        for (int i = 0; i < 9; i++) {
            if (enteredIndexes.contains(i)) {
                if (i == winnerIndex) {
                    resultLabels[i].setText("당첨!");
                    resultLabels[i].setFont(new Font("맑은 고딕", Font.BOLD, 18));
                    cellPanels[i].setBackground(Color.YELLOW);
                } else {
                    resultLabels[i].setText("꽝");
                    cellPanels[i].setBackground(Color.LIGHT_GRAY);
                }
            } else {
                resultLabels[i].setText("");
                cellPanels[i].setBackground(null);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LotteryGame());
    }
}
