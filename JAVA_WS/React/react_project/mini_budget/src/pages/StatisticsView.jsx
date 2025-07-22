// src/pages/StatisticsView.jsx

import React, { useState } from "react";
import {
  format,
  parseISO,
  addMonths,
  subMonths,
  eachDayOfInterval,
  startOfMonth,
  endOfMonth,
} from "date-fns";
import { ko } from "date-fns/locale"; // 한국어 로케일 임포트
import {
  PieChart,
  Pie,
  Cell,
  ResponsiveContainer,
  Tooltip,
  Legend,
  LineChart,
  Line,
  XAxis,
  YAxis,
  CartesianGrid,
} from "recharts";

// AppContext 임포트 (전역 상태 관리를 위해)
import { useAppContext } from "../contexts/AppContext";

// StatisticsView 페이지 전용 CSS 파일 임포트
import "./StatisticsView.css";

/**
 * 통계 페이지 컴포넌트입니다.
 * 월별 예산 현황, 카테고리별 지출 원 그래프, 일별 지출 선 그래프를 표시합니다.
 */
const StatisticsView = () => {
  // 전역 상태(monthlyBudget, expenses)를 AppContext에서 가져옵니다.
  const { monthlyBudget, expenses } = useAppContext();

  // 현재 보고 있는 월을 관리하는 상태. 초기값은 현재 월입니다.
  const [displayMonth, setDisplayMonth] = useState(new Date());

  // 현재 보고 있는 월의 첫 날과 마지막 날을 계산합니다.
  const startOfCurrentDisplayMonth = startOfMonth(displayMonth);
  const endOfCurrentDisplayMonth = endOfMonth(displayMonth);

  // 현재 보고 있는 월의 지출 내역만 필터링합니다.
  const monthlyExpenses = expenses.filter((exp) => {
    const expenseDate = parseISO(exp.date);
    return (
      expenseDate >= startOfCurrentDisplayMonth &&
      expenseDate <= endOfCurrentDisplayMonth
    );
  });

  // 현재 보고 있는 월의 총 지출을 계산합니다.
  const totalSpent = monthlyExpenses.reduce(
    (sum, exp) => sum + parseFloat(exp.amount),
    0
  );

  // 남은 예산 계산
  const remainingBudget = monthlyBudget - totalSpent;

  // --- 차트 데이터 준비 ---

  // 1. 원 그래프 (Pie Chart) 데이터: 카테고리별 지출 합계
  const categoryData = monthlyExpenses.reduce((acc, expense) => {
    acc[expense.category] = (acc[expense.category] || 0) + expense.amount;
    return acc;
  }, {});

  const pieChartData = Object.keys(categoryData).map((category) => ({
    name: category,
    value: categoryData[category],
  }));

  // 원 그래프 색상 팔레트
  const PIE_COLORS = [
    "#0088FE",
    "#00C49F",
    "#FFBB28",
    "#FF8042",
    "#8884d8",
    "#82ca9d",
    "#ffc658",
    "#d0ed57",
    "#a4de6c",
    "#f7b731",
  ];

  // 2. 선 그래프 (Line Chart) 데이터: 일별 지출 합계
  const dailyDataMap = new Map();
  eachDayOfInterval({
    start: startOfCurrentDisplayMonth,
    end: endOfCurrentDisplayMonth,
  }).forEach((day) => {
    dailyDataMap.set(format(day, "yyyy-MM-dd"), {
      date: format(day, "MM/dd", { locale: ko }),
      amount: 0,
    });
  });

  monthlyExpenses.forEach((expense) => {
    const expenseDateFormatted = format(parseISO(expense.date), "yyyy-MM-dd");
    if (dailyDataMap.has(expenseDateFormatted)) {
      const current = dailyDataMap.get(expenseDateFormatted);
      dailyDataMap.set(expenseDateFormatted, {
        ...current,
        amount: current.amount + parseFloat(expense.amount),
      });
    }
  });

  const lineChartData = Array.from(dailyDataMap.values()).sort((a, b) => {
    const dateA = parseISO(
      format(new Date().getFullYear(), "yyyy") + "-" + a.date.replace("/", "-")
    );
    const dateB = parseISO(
      format(new Date().getFullYear(), "yyyy") + "-" + b.date.replace("/", "-")
    );
    return dateA.getTime() - dateB.getTime();
  });

  // --- 월 이동 핸들러 ---
  const handlePrevMonth = () => {
    setDisplayMonth((prevMonth) => subMonths(prevMonth, 1));
  };

  const handleNextMonth = () => {
    setDisplayMonth((prevMonth) => addMonths(prevMonth, 1));
  };

  return (
    <div className="statistics-container">
      {/* 월 이동 네비게이션 */}
      <div className="month-navigation">
        <button onClick={handlePrevMonth} className="nav-button">
          ◀
        </button>
        <h2 className="month-display">
          {format(displayMonth, "yyyy년 MM월", { locale: ko })}
        </h2>
        <button onClick={handleNextMonth} className="nav-button">
          ▶
        </button>
      </div>

      {/* 월별 요약 섹션 */}
      <div className="summary-card">
        <div className="budget-info">
          <div className="budget-item">
            <span className="budget-label">총 예산:</span>
            <span className="budget-value">
              ₩{monthlyBudget.toLocaleString()}
            </span>
          </div>
          <div className="budget-item">
            <span className="budget-label">총 지출:</span>
            <span className="spent-value">₩{totalSpent.toLocaleString()}</span>
          </div>
          <div className="budget-item">
            <span className="budget-label">남은 예산:</span>
            <span
              className={`remaining-value ${
                remainingBudget < 0 ? "negative" : ""
              }`}
            >
              ₩{remainingBudget.toLocaleString()}
            </span>
          </div>
        </div>
      </div>

      {/* 카테고리별 지출 원 그래프 */}
      <div className="chart-card">
        <h3 className="chart-title">🍩 카테고리별 지출 비율</h3>
        {pieChartData.length > 0 ? (
          <ResponsiveContainer width="100%" height={300}>
            <PieChart>
              <Pie
                data={pieChartData}
                cx="50%"
                cy="50%"
                innerRadius={60}
                outerRadius={90}
                fill="#8884d8"
                paddingAngle={5}
                dataKey="value"
                label={({ name, percent }) =>
                  `${name} ${(percent * 100).toFixed(0)}%`
                }
                labelLine={false}
              >
                {pieChartData.map((entry, index) => (
                  <Cell
                    key={`cell-${index}`}
                    fill={PIE_COLORS[index % PIE_COLORS.length]}
                  />
                ))}
              </Pie>
              <Tooltip formatter={(value) => `₩${value.toLocaleString()}`} />
              <Legend />
            </PieChart>
          </ResponsiveContainer>
        ) : (
          <p className="no-chart-data">
            이달의 지출 내역이 없어 카테고리별 차트를 표시할 수 없습니다.
          </p>
        )}
      </div>

      {/* 일별 지출 선 그래프 */}
      <div className="chart-card">
        <h3 className="chart-title">📈 일별 지출 추이</h3>
        {lineChartData.some((item) => item.amount > 0) ? ( // 지출이 있는 경우에만 차트 표시
          <ResponsiveContainer width="100%" height={300}>
            <LineChart
              data={lineChartData}
              margin={{ top: 5, right: 30, left: 20, bottom: 5 }}
            >
              <CartesianGrid strokeDasharray="3 3" />
              <XAxis dataKey="date" />
              <YAxis formatter={(value) => `₩${value.toLocaleString()}`} />
              <Tooltip formatter={(value) => `₩${value.toLocaleString()}`} />
              <Legend />
              <Line
                type="monotone"
                dataKey="amount"
                stroke="#8884d8"
                activeDot={{ r: 8 }}
                name="지출 금액"
              />
            </LineChart>
          </ResponsiveContainer>
        ) : (
          <p className="no-chart-data">
            이달의 지출 내역이 없어 일별 차트를 표시할 수 없습니다.
          </p>
        )}
      </div>
    </div>
  );
};

export default StatisticsView;
