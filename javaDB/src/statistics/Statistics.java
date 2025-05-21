package statistics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import common.Session;
import config.BaseFrame;
import config.ScreenType;
import common.CommonStyle;

/**
 * 생성자 : 문원주
 * 생성일 : 25.05.19
 * 파일명 : Statistics.java
 * 수정자 :
 * 수정일 :
 * 설명 : 통계 패널들을 구성하여 화면에 띄우는 파일
 */

// 전체 통계 화면을 구성하는 메인 클래스
public class Statistics extends JPanel {

    public Statistics() {

        // 전체 패널 레이아웃을 BorderLayout으로 설정
        this.setLayout(new BorderLayout());
        this.setBackground(CommonStyle.BACKGROUND_COLOR);

        // NORTH: 상단 타이틀 + 콤보박스 추가
        JLabel titleLabel = CommonStyle.createTitleLabel(); // 타이틀 라벨 생성

        // 타이틀을 감싸는 패널 (가운데 정렬)
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(CommonStyle.BACKGROUND_COLOR);
        titlePanel.add(titleLabel);

        // 콤보박스를 감싸는 패널 (오른쪽 정렬)
        String[] weekOptions = { "이번 주", "지난 주", "2주 전", "3주전" };
        JComboBox<String> weekSelector = new JComboBox<>(weekOptions);
        weekSelector.setPreferredSize(new Dimension(100, 25));

        JPanel comboPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        comboPanel.setBackground(CommonStyle.BACKGROUND_COLOR);
        comboPanel.add(weekSelector);

        // 상단 전체를 감싸는 패널 (수직 정렬)
        JPanel panelTop = new JPanel();
        panelTop.setLayout(new BoxLayout(panelTop, BoxLayout.Y_AXIS));
        panelTop.setBackground(CommonStyle.BACKGROUND_COLOR);
        panelTop.setBorder(BorderFactory.createEmptyBorder(-30, 0, 0, 0)); // 필요시 조정
        panelTop.add(titlePanel); // 첫 줄: 가운데 타이틀
        panelTop.add(comboPanel); // 두 번째 줄: 오른쪽 콤보박스

        // NORTH에 추가
        this.add(panelTop, BorderLayout.NORTH);

        // 중앙 컨테이너 패널 (Y축 정렬)
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(CommonStyle.BACKGROUND_COLOR);

        // 1. 투두리스트 차트 → 중앙 정렬
        TodoChartPanel todoChart = new TodoChartPanel(Session.getUserId(), LocalDate.now());
        todoChart.setPreferredSize(new Dimension(700, 300));
        JPanel chartWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        chartWrapper.setBackground(CommonStyle.BACKGROUND_COLOR);
        chartWrapper.add(todoChart);

        JPanel chartTopPanel = new JPanel();
        chartTopPanel.setLayout(new BorderLayout());
        chartTopPanel.setBackground(CommonStyle.BACKGROUND_COLOR);
        chartTopPanel.add(comboPanel, BorderLayout.NORTH);
        chartTopPanel.add(chartWrapper, BorderLayout.CENTER);

        centerPanel.add(chartTopPanel);

        // 2. 복약 체크 → 중앙 정렬
        PillCheckPanel pillCheck = new PillCheckPanel(Session.getUserId(), LocalDate.now());
        pillCheck.setPreferredSize(new Dimension(400, 48));
        JPanel pillWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pillWrapper.setBorder(BorderFactory.createEmptyBorder(0, 0, -10, 0));
        pillWrapper.setBackground(CommonStyle.BACKGROUND_COLOR);
        pillWrapper.add(pillCheck);

        centerPanel.add(pillWrapper);

        // 3. 총 달성도 → 왼쪽 정렬
        TotalStatisticsPanel totalPanel = new TotalStatisticsPanel(Session.getUserId(), LocalDate.now());
        JPanel totalWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT)); // 왼쪽 정렬
        totalWrapper.setBorder(BorderFactory.createEmptyBorder(0, 0, -10, 0));
        totalWrapper.setBackground(CommonStyle.BACKGROUND_COLOR);
        totalWrapper.add(totalPanel);
        centerPanel.add(totalWrapper);

        // 전체 CENTER 영역에 추가
        this.add(centerPanel, BorderLayout.CENTER);

        // 콤보박스 항목 선택 시 이벤트 처리
        weekSelector.addActionListener(e -> {
            // 선택된 항목 문자열을 가져옴 (예: "이번 주", "1주 전", "2주 전")
            String selected = (String) weekSelector.getSelectedItem();

            // 기준일(baseDate)을 LocalDate.now()에서 시작하여 주차를 조정함
            LocalDate baseDate = LocalDate.now();

            // 콤보박스에서 선택한 항목에 따라 기준일을 조정 (n주 전)
            if (selected.equals("지난 주")) {
                baseDate = baseDate.minusWeeks(1); // 1주 전으로 이동
            } else if (selected.equals("2주 전")) {
                baseDate = baseDate.minusWeeks(2); // 2주 전으로 이동
            } else if (selected.equals("3주 전")) {
                baseDate = baseDate.minusWeeks(3); // 3주 전으로 이동
            }
            // "이번 주" 선택 시는 변경 없음 (기본값 유지)

            // centerPanel에서 기존 컴포넌트 제거
            centerPanel.removeAll();

            // 새 기준 날짜로 다시 패널 구성
            TodoChartPanel newTodoChart = new TodoChartPanel(Session.getUserId(), baseDate);
            newTodoChart.setPreferredSize(new Dimension(700, 300));
            newTodoChart.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
            JPanel chartWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
            chartWrapper.setBackground(CommonStyle.BACKGROUND_COLOR);
            chartWrapper.add(newTodoChart);
            centerPanel.add(chartWrapper);

            // 복약 체크 패널도 새로 갱신 (예: 기준 주간에 맞춰 표시)
            PillCheckPanel newPillPanel = new PillCheckPanel(Session.getUserId(), baseDate);
            newPillPanel.setPreferredSize(new Dimension(400, 48));
            JPanel pillWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
            pillWrapper.setBackground(CommonStyle.BACKGROUND_COLOR);
            pillWrapper.add(newPillPanel);
            centerPanel.add(pillWrapper);

            // 총 달성도 패널도 새로 갱신
            TotalStatisticsPanel newTotalPanel = new TotalStatisticsPanel(Session.getUserId(), baseDate);
            JPanel totalWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT));
            totalWrapper.setBackground(CommonStyle.BACKGROUND_COLOR);
            totalWrapper.add(newTotalPanel);
            centerPanel.add(totalWrapper);

            // 패널 업데이트 및 다시 그리기
            centerPanel.revalidate(); // 레이아웃 재계산
            centerPanel.repaint(); // 화면 다시 그림
        });

        // 하단 버튼 패널 추가 및 이벤트 연결
        CommonStyle.BottomPanelComponents bottom = CommonStyle.createBottomPanel();

        // 오늘 할일 상세보기 버튼 클릭 시 이벤트 처리
        bottom.todoDetail.addActionListener(e -> {
            BaseFrame frame = (BaseFrame) SwingUtilities.getWindowAncestor(this); // 투두리스트창으로 이동
            frame.showScreen(ScreenType.TODOLIST);
        });

        // 영양제 정보 버튼 클릭 시 이벤트 처리
        bottom.pillDetail.addActionListener(e -> {
            BaseFrame frame = (BaseFrame) SwingUtilities.getWindowAncestor(this); // 영양제창으로 이동
            frame.showScreen(ScreenType.PILL);
        });

        bottom.returnPage.addActionListener(e -> {
            BaseFrame frame = (BaseFrame) SwingUtilities.getWindowAncestor(this); // 투두리스트창으로 이동
            frame.showScreen(ScreenType.TODOLIST);
        });

        // 버튼 상태 설정
        bottom.returnPage.setVisible(true); // 돌아가기 버튼 활성화
        bottom.statistics.setVisible(false); // 현재 페이지 버튼 비활성화

        // 하단 버튼 패널을 SOUTH에 추가
        this.add(bottom.panel, BorderLayout.SOUTH);
    }
}
