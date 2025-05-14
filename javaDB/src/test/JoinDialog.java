package test;

import javax.swing.*;
import java.awt.*;

public class JoinDialog extends JDialog {

    public JoinDialog(JFrame parent) {
        super(parent, "회원가입", true);
        setSize(420, 300);
        setLocationRelativeTo(parent);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // 폰트
        Font font = new Font("SansSerif", Font.PLAIN, 13);

        // 아이디
        JLabel idLabel = new JLabel("아이디");
        idLabel.setFont(font);
        JTextField idField = new JTextField(12);
        idField.setFont(font);

        JLabel idCheckLabel = new JLabel("중복확인");
        idCheckLabel.setFont(font);
        idCheckLabel.setForeground(Color.WHITE);
        idCheckLabel.setOpaque(true);
        idCheckLabel.setBackground(new Color(30, 100, 180));
        idCheckLabel.setHorizontalAlignment(SwingConstants.CENTER);
        idCheckLabel.setPreferredSize(new Dimension(80, 25));
        idCheckLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // 비밀번호
        JLabel pwLabel = new JLabel("비밀번호");
        pwLabel.setFont(font);
        JPasswordField pwField = new JPasswordField(12);
        pwField.setFont(font);

        // 이름
        JLabel nameLabel = new JLabel("이름");
        nameLabel.setFont(font);
        JTextField nameField = new JTextField(12);
        nameField.setFont(font);

        // 버튼
        JButton joinBtn = new JButton("회원가입");
        JButton backBtn = new JButton("뒤로가기");

        joinBtn.setBackground(new Color(30, 100, 180));
        joinBtn.setForeground(Color.WHITE);
        backBtn.setBackground(new Color(30, 100, 180));
        backBtn.setForeground(Color.WHITE);

        joinBtn.setFocusPainted(false);
        backBtn.setFocusPainted(false);
        joinBtn.setFont(font);
        backBtn.setFont(font);

        // 아이디 row
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(idLabel, gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(idField, gbc);
        gbc.gridx = 2;
        add(idCheckLabel, gbc);

        // 비밀번호 row
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(pwLabel, gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridwidth = 2;
        add(pwField, gbc);

        // 이름 row
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(nameLabel, gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridwidth = 2;
        add(nameField, gbc);

        // 버튼 row
        gbc.gridy = 3;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        add(joinBtn, gbc);
        gbc.gridx = 2;
        add(backBtn, gbc);

        // 뒤로가기 동작
        backBtn.addActionListener(e -> dispose());

        // 중복확인 라벨 클릭 이벤트
        idCheckLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JOptionPane.showMessageDialog(JoinDialog.this, "중복확인 눌림");
            }
        });

        setVisible(true);
    }
}
