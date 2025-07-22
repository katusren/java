import "./EmotionItem.css";
import { getEmotionImage } from "../util/get-emotion-image";

// 일기 작성시 감정을 선택하는 버튼을 구현한 UI 컴포넌트
const EmotionItem = ({ emotionId, emotionName, isSelected, onClick }) => {
  return (
    <div
      onClick={onClick}
      className={`EmotionItem ${
        isSelected ? `EmotionItem_on_${emotionId}` : ""
      }`}
    >
      {/* 감정에 맞는 이미지 불러옴 */}
      <img className="emotion_img" src={getEmotionImage(emotionId)} />
      <div className="emotion_name">{emotionName}</div>
    </div>
  );
};

export default EmotionItem;
