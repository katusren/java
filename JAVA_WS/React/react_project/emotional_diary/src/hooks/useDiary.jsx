import { useContext, useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { DiaryStateContext } from "../Context";

// 커스텀 훅: 특정 id에 해당하는 일기 데이터를 찾아 반환하는 로직
/*
1. id를 전달받음
2. DiaryStateContext에서 전체 일기 목록을 불러옴
3. 해당 id에 일기를 찾아서 반환
4. 일기가 없으면 경고창을 띄우고 /로 이동
*/

const useDiary = (id) => {
  const data = useContext(DiaryStateContext); // 전체 일기 배열
  // [현재 id에 해당하는 일기, 나중에 해당 일기 설정]
  const [curDiaryItem, setCurDiaryItem] = useState(); // if
  const nav = useNavigate(); // 받은 페이지로 이동

  useEffect(() => {
    // id에 해당하는 일기를 data에서 find()로 검색
    const currentDiaryItem = data.find(
      (item) => String(item.id) === String(id)
    );

    if (!currentDiaryItem) {
      window.alert("존재하지 않는 일기입니다.");
      nav("/", { replace: true });
    }

    // 일기를 찾은 경우 상태를 리턴
    setCurDiaryItem(currentDiaryItem);
  }, [id, data, nav]); // 일기, id, 전체목록이 바뀌거나 페이지가 이동될 때 자동으로 실행

  return curDiaryItem;
};

export default useDiary;
