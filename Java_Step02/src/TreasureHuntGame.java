import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class TreasureHuntGame {
    private static String[] results = { "꽝", "꽝", "꽝", "꽝", "꽝", "꽝", "꽝", "꽝", "당첨!" };
    private static Random random = new Random();
    private static JButton[] buttons = new JButton[9];

    public static void main(String[] args) {
        JFrame frame = new JFrame("보물찾기 게임");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // 이름 입력 필드
        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("이름 입력: ");
        JTextField nameField = new JTextField(10);
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        // 보물상자 이미지 로드 및 크기 조정
        ImageIcon treasureImage = new ImageIcon("treasure_box.png"); // 보물상자 이미지 경로
        Image scaledImage = treasureImage.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

        // 보물상자 이미지 배경
        JLabel imageLabel = new JLabel(scaledImageIcon);
        imageLabel.setBounds(0, 0, 400, 400); // 이미지 크기 맞추기

        // 버튼 패널 (3x3 버튼)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3)); // 3x3 그리드로 버튼 배치

        // 버튼 배열
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("이름 입력");
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 12));
            buttons[i].setBackground(Color.WHITE);
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton clickedButton = (JButton) e.getSource();
                    String playerName = nameField.getText();

                    // 이름 입력 없이 클릭 시 알림
                    if (playerName.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "이름을 입력해 주세요.");
                    } else {
                        clickedButton.setText(playerName); // 이름을 버튼에 표시
                        // 결과 출력
                        int randomIndex = random.nextInt(results.length);
                        clickedButton.setText(results[randomIndex]); // 버튼에 결과 표시
                    }
                }
            });
            buttonPanel.add(buttons[i]);
        }

        // 게임 시작 버튼 (당첨 위치 설정)
        JButton startButton = new JButton("게임 시작!");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 게임 시작 시 버튼 상태 초기화
                for (JButton button : buttons) {
                    button.setText("이름 입력");
                    button.setBackground(Color.WHITE);
                }

                // 당첨 위치 랜덤하게 선택 (1곳은 당첨, 나머지는 꽝)
                results[random.nextInt(9)] = "당첨!";
            }
        });

        // UI에 추가
        frame.add(namePanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(startButton, BorderLayout.SOUTH);

        // 보물상자 이미지를 배경으로 설정
        frame.add(imageLabel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
