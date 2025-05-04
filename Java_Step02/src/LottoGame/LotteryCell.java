package LottoGame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

// 하나의 셀(패널)을 담당하는 클래스
public class LotteryCell extends JPanel {
    private JTextField nameField; // 이름 입력 필드
    private JLabel resultLabel;   // 결과(당첨/꽝) 표시 라벨
    private JLabel iconLabel;     // 보물상자/해골 이미지를 표시할 라벨

    // 생성자 : 셀을 초기화
    public LotteryCell() {
        setLayout(new BorderLayout(5, 5)); // 레이아웃을 위아래로 배치
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // 셀 테두리 설정
        setPreferredSize(new Dimension(120, 120)); // 셀 크기 고정

        // === 위쪽쪽에 이미지(보물상자, 해골 등)를 표시할 라벨 ===
        iconLabel = new JLabel("", SwingConstants.CENTER); // 가운데 정렬
        iconLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // 위쪽 여백 추가
        add(iconLabel, BorderLayout.NORTH); // 위쪽쪽에 배치

        // === 결과 텍스트 라벨 ===
        resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        resultLabel.setOpaque(false); // 배경 투명
        add(resultLabel, BorderLayout.CENTER); // 이미지 아래에 텍스트 표시

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

        add(nameField, BorderLayout.SOUTH); // 이름 입력은 아래쪽
    }

    // 현재 입력된 이름을 가져오는 메소드
    public String getNameText() {
        return nameField.getText().trim(); // 앞뒤 공백 제거 후 반환
    }

    // 당첨 결과를 설정하는 메소드 (텍스트 + 이미지 포함)
    public void setResult(String text, Color bgColor, int fontSize, String imageName) {
        resultLabel.setText(text); // 결과 텍스트 설정
        resultLabel.setFont(new Font("맑은 고딕", Font.BOLD, fontSize)); // 폰트 크기 설정
        setBackground(bgColor); // 배경색 설정

        if (text.contains("당첨")) { // 당첨과 꽝에 대한 글자색 변경
            resultLabel.setForeground(new Color(170, 0, 0)); // 진한 빨강
        } else {
            resultLabel.setForeground(new Color(30, 30, 120)); // 짙은 네이비
        }

        // 이미지 아이콘 로드
        ImageIcon icon = loadImageIcon("images/" + imageName); // images 폴더에서 이미지 파일 읽기
        if (icon != null) {
            // 크기 조절
            Image scaled = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            iconLabel.setIcon(new ImageIcon(scaled)); // 조정된 아이콘 설정
        } else {
            iconLabel.setIcon(null); // 이미지가 없으면 null 처리
        }

        // === ✨ 텍스트 확대/축소 애니메이션 효과 추가 ===

        Timer timer = new Timer(30, null); // 확대용 타이머 (30ms 간격)
        final int[] size = {fontSize};     // 글자 크기 저장용 (람다 캡처 위해 배열 사용)
        final int maxSize = fontSize + 6;  // 확대할 최대 글자 크기

        timer.addActionListener(e -> {
            if (size[0] < maxSize) {
                size[0]++; // 글자 크기 1 증가
                resultLabel.setFont(new Font("맑은 고딕", Font.BOLD, size[0]));
            } else {
                timer.stop(); // 최대 크기 도달 시 확대 종료

                Timer shrinkTimer = new Timer(30, null); // 축소용 타이머
                shrinkTimer.addActionListener(ev -> {
                    if (size[0] > fontSize) {
                        size[0]--; // 글자 크기 1 감소
                        resultLabel.setFont(new Font("맑은 고딕", Font.BOLD, size[0]));
                    } else {
                        shrinkTimer.stop(); // 원래 크기 되면 축소 종료
                    }
                });
                shrinkTimer.start(); // 축소 타이머 시작
            }
        });

        timer.start(); // 확대 타이머 시작

        // === ✨ 애니메이션 끝 ===
    }

    // 셀을 초기화하는 메소드 (결과와 배경 제거)
    public void reset() {
        resultLabel.setText(""); // 결과 라벨 초기화
        iconLabel.setIcon(null); // 이미지 지우기
        setBackground(null);     // 배경색 초기화
    }

    // 이미지 로딩을 위한 내부 메서드
    private ImageIcon loadImageIcon(String path) {
        File file = new File(path); // 이미지 파일 경로 객체 생성
        if (file.exists()) { // 해당 이미지 파일이 존재하는지 확인
            ImageIcon icon = new ImageIcon(path); // 아이콘 객체 생성
            // 아이콘 크기 조정 (50x50 픽셀로 부드럽게 리사이징)
            Image scaled = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            return new ImageIcon(scaled); // 조정된 아이콘 반환
        } else {
            // 이미지가 없을 경우 경고 메시지 출력
            System.err.println("이미지를 찾을 수 없습니다: " + path);
            return null;
        }
    }
}
