package LottoGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 하나의 셀(패널)을 담당하는 클래스
public class LotteryCell extends JPanel {
    private JTextField nameField; // 이름 입력 필드
    private JLabel resultLabel; // 결과(당첨/꽝) 표시 라벨

    // 생성자 : 셀을 초기화
    public LotteryCell() {
        setLayout(new BorderLayout(5, 5)); // 레이아웃을 위아래로 배치
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // 셀 테두리 설정
        setPreferredSize(new Dimension(120, 120)); // 셀 크기 고정

        // 결과 표시 라벨 설정
        resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setVerticalAlignment(SwingConstants.CENTER);

        // 이름 입력 필드 설정
        nameField = new JTextField("이름입력"); // 기본 텍스트
        nameField.setHorizontalAlignment(JTextField.CENTER); // 텍스트 가운데 정렬
        nameField.setForeground(Color.GRAY); // 기본 안내문구처럼 연한 색 설정

        // placeholder처럼 동작하도록 포커스 이벤트 추가
        nameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                // 클릭했을 때 기본 텍스트가 보이면 지운다
                if (nameField.getText().equals("이름입력")) {
                    nameField.setText("");
                    nameField.setForeground(Color.BLACK); // 입력 색상으로 변경
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // 커서가 빠져나갔는데 아무것도 없으면 다시 기본 텍스트로
                if (nameField.getText().isEmpty()) {
                    nameField.setText("이름입력");
                    nameField.setForeground(Color.GRAY); // 연한 회색
                }
            }
        });

        // 패널에 컴포넌트 추가
        add(resultLabel, BorderLayout.CENTER); // 결과 라벨은 가운데
        add(nameField, BorderLayout.SOUTH); // 이름 입력은 아래쪽
    }

    // 현재 입력된 이름을 가져오는 메소드
    public String getNameText() {
        return nameField.getText().trim(); // 앞뒤 공백 제거 후 반환
    }

    // 당첨 결과를 설정하는 메소드
    public void setResult(String text, Color bgColor, int fontSize) {
        resultLabel.setText(text); // 결과 텍스트 설정
        resultLabel.setFont(new Font("맑은 고딕", Font.BOLD, fontSize)); // 폰트 크기 설정
        setBackground(bgColor); // 배경색 설정
    }

    // 셀을 초기화하는 메소드 (결과와 배경 제거)
    public void reset() {
        resultLabel.setText(""); // 결과 라벨 초기화
        setBackground(null); // 배경색 초기화
    }
}
