// src/components/common/ConfirmModal.jsx

import React from "react";
import "./ConfirmModal.css"; // ConfirmModal 컴포넌트 전용 CSS 파일 임포트

/**
 * 사용자에게 특정 작업(예: 삭제)에 대한 확인을 요청하는 모달 컴포넌트
 * @param {{
 * isOpen: boolean, // 모달의 열림/닫힘 상태
 * message: string, // 모달에 표시할 메시지
 * onConfirm: () => void, // '확인' 버튼 클릭 시 호출될 함수
 * onCancel: () => void // '취소' 버튼 클릭 시 호출될 함수
 * }} props
 */
const ConfirmModal = ({ isOpen, message, onConfirm, onCancel }) => {
  return (
    <div className={`modal-overlay ${isOpen ? "open" : ""}`} onClick={onCancel}>
      {/* 모달 내용 컨테이너: 클릭 이벤트 전파 방지 */}
      <div className="modal-content" onClick={(e) => e.stopPropagation()}>
        <p className="modal-message">{message}</p>
        <div className="modal-actions">
          <button onClick={onCancel} className="modal-button cancel">
            취소
          </button>
          <button onClick={onConfirm} className="modal-button confirm">
            확인
          </button>
        </div>
      </div>
    </div>
  );
};

export default ConfirmModal;
