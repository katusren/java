package test;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.axis.NumberAxis;

import javax.swing.*;
import java.awt.*;

public class StyledChartExample extends JFrame {

    public StyledChartExample() {
        setTitle("Styled Chart");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 1. 데이터 생성
        XYSeries series = new XYSeries("달성도");
        series.add(0, 70);
        series.add(1, 60);
        series.add(2, 95);
        series.add(3, 80);
        series.add(4, 95);
        series.add(5, 50);
        series.add(6, 75);
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        // 2. 차트 생성
        JFreeChart chart = ChartFactory.createXYLineChart(
                "주간 투두리스트 달성도", // 제목
                "요일", // X축
                "달성률(%)", // Y축
                dataset // 데이터셋
        );

        // 3. 스타일 설정
        XYPlot plot = chart.getXYPlot();

        // 배경색 설정
        plot.setBackgroundPaint(Color.WHITE); // 플롯 내부
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY); // X축 그리드
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY); // Y축 그리드

        // 차트 전체 배경
        chart.setBackgroundPaint(new Color(240, 240, 240));

        // 제목 폰트 및 색상
        chart.getTitle().setPaint(new Color(30, 100, 180));
        chart.getTitle().setFont(new Font("맑은 고딕", Font.BOLD, 20));

        plot.getDomainAxis().setLabelFont(new Font("맑은 고딕", Font.PLAIN, 14));
        plot.getRangeAxis().setLabelFont(new Font("맑은 고딕", Font.PLAIN, 14));

        plot.getDomainAxis().setTickLabelFont(new Font("맑은 고딕", Font.PLAIN, 12));
        plot.getRangeAxis().setTickLabelFont(new Font("맑은 고딕", Font.PLAIN, 12));

        // 선 스타일
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, new Color(30, 100, 180)); // 선 색상
        renderer.setSeriesStroke(0, new BasicStroke(2.0f)); // 선 굵기
        plot.setRenderer(renderer);

        Font font = new Font("나눔고딕", Font.PLAIN, 12); // 또는 "맑은 고딕", "Malgun Gothic"
        chart.getTitle().setFont(new Font("나눔고딕", Font.BOLD, 16)); // 제목
        chart.getLegend().setItemFont(font); // 범례

        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);

        // 요일 라벨
        String[] days = { "월", "화", "수", "목", "금", "토", "일" };
        SymbolAxis domainAxis = new SymbolAxis("요일", days);
        domainAxis.setTickLabelsVisible(true);
        domainAxis.setGridBandsVisible(false);
        plot.setDomainAxis(domainAxis);

        // Y축 범위 고정 및 눈금 조절
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setRange(0.0, 100.0); // 달성률 0~100
        rangeAxis.setTickUnit(new NumberTickUnit(10)); // 10 단위 눈금

        // 차트 삽입
        ChartPanel chartPanel = new ChartPanel(chart);
        setContentPane(chartPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StyledChartExample example = new StyledChartExample();
            example.setVisible(true);
        });
    }
}
