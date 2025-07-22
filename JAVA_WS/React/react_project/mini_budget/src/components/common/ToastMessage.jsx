/* src/components/common/ToastMessage.jsx */

import { useEffect } from "react";
import "./ToastMessage.css";

/**
 * 화면 하단에 표시될 재사용 가능한 토스트 메시지 컴포넌트 입니다.
 * @param {{
 * message: string,
 * type: "success" | "error",
 * onClose: () => void
 * }} props
 */
const ToastMessage = ({ message, type, onClose }) => {
  useEffect(() => {
    let timer;
    if (message) {
      // 메시지가 있을 때만 타이머 설정 로직 실행
      timer = setTimeout(() => {
        onClose();
      }, 3000); // 3초 후 메시지 사라짐
    }

    // 컴포넌트 언마운트 시 또는 메시지가 변경될 때 타이머 정리
    return () => {
      if (timer) {
        // 타이머가 설정된 경우에만 클리어
        clearTimeout(timer);
      }
    };
  }, [message, onClose]); // message 또는 onClose가 변경될 때마다 효과 재실행

  // 메시지가 없으면 아무것도 렌더링하지 않음
  if (!message) return null;

  return (
    // 'toast-message' 클래스와 타입에 따른 추가 클래스 적용
    <div className={`toast-message ${type}`}>{message}</div>
  );
};

export default ToastMessage;
