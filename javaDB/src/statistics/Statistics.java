package statistics;

import common.CommonStyle;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.BasicStroke;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class Statistics extends JPanel {

    public static final Font CHART_FONT = new Font("SansSerif", Font.PLAIN, 14);

    public Statistics() {
        setLayout(null);
        setBackground(CommonStyle.BACKGROUND_COLOR);

        JLabel titleLabel = CommonStyle.createTitleLabel();
        titleLabel.setBounds(250, 10, 300, 35);
        add(titleLabel);

        // 선그래프
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(80, "달성률", "월");
        dataset.addValue(60, "달성률", "화");
        dataset.addValue(20, "달성률", "수");
        dataset.addValue(70, "달성률", "목");
        dataset.addValue(50, "달성률", "금");
        dataset.addValue(40, "달성률", "토");
        dataset.addValue(85, "달성률", "일");

        JFreeChart lineChart = ChartFactory.createLineChart(
                "주간 투두리스트 달성도",
                "요일", "달성률(%)",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        lineChart.getTitle().setFont(CHART_FONT);
        lineChart.setBackgroundPaint(CommonStyle.BACKGROUND_COLOR);
        CategoryPlot plot = lineChart.getCategoryPlot();

        plot.getDomainAxis().setLabelFont(CHART_FONT);
        plot.getRangeAxis().setLabelFont(CHART_FONT);
        plot.getDomainAxis().setTickLabelFont(CHART_FONT);
        plot.getRangeAxis().setTickLabelFont(CHART_FONT);
        plot.getRangeAxis().setRange(0, 100);
        plot.setBackgroundPaint(CommonStyle.BACKGROUND_COLOR);

        // 기존 렌더러 가져와서 선 굵기만 변경
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        renderer.setSeriesStroke(0, new BasicStroke(3.5f));
        renderer.setSeriesShapesVisible(0, false); // 점 없이 선만 보이게

        plot.setRenderer(renderer);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setBounds(80, 55, 600, 300);
        add(chartPanel);

        // 복약 여부 박스 (작은 네모칸)
        JPanel medicationPanel = new JPanel(new GridLayout(2, 7));
        medicationPanel.setBounds(225, 375, 350, 65);
        for (int i = 0; i < 7; i++) {
            JLabel medStatus = new JLabel();
            medStatus.setOpaque(true);
            if (i % 2 == 0) {
                medStatus.setBackground(new Color(100, 255, 100)); // 예시로 복약했다는 표시
            } else {
                medStatus.setBackground(new Color(255, 64, 64));
            }
            if (i == 5 || i == 6) {
                medStatus.setBackground(Color.WHITE);
            }
            medStatus.setBorder(new LineBorder(Color.BLACK));
            medicationPanel.add(medStatus);
        }
        String[] days = { "월", "화", "수", "목", "금", "토", "일" };
        for (String day : days) {
            JLabel dayLabel = new JLabel(day, SwingConstants.CENTER);
            dayLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
            medicationPanel.add(dayLabel);
            medicationPanel.setBackground(Color.WHITE);
        }
        add(medicationPanel);

        // 총 투두리스트 달성도 표시
        JLabel todoRate = new JLabel("투두리스트 총 달성도: 80%", SwingConstants.LEFT);
        todoRate.setBounds(50, 450, 300, 30);
        todoRate.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(todoRate);

        // 총 복약률 달성도 표시
        JLabel medRate = new JLabel("복약률 총 달성도: 90%", SwingConstants.LEFT);
        medRate.setBounds(50, 490, 300, 30);
        medRate.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(medRate);

        // 나가기 버튼 (오른쪽 아래)
        JButton exitButton = new JButton("홈으로");
        exitButton.setBounds(650, 500, 80, 40);
        CommonStyle.stylePrimaryButton(exitButton);
        exitButton.addActionListener(e -> {
            // 메인 화면으로 전환 예: BaseFrame.showScreen(...)
            // 또는 프레임 종료시 dispose() 호출
        });
        add(exitButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("통계 테스트");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);

            Statistics panel = new Statistics();
            frame.setContentPane(panel);

            frame.setVisible(true);
        });
    }
}
