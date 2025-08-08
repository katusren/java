import tkinter as tk

# 윈도우 생성
window = tk.Tk()
window.title("tkinter 위젯 예제")
window.geometry("400x400")

# 레이블
label = tk.Label(window, text="Hello, tkinter!", font=("Arial", 14))
label.pack(pady=10)

# 입력창 (Entry)
entry = tk.Entry(window)
entry.pack(pady=10)

# 리스트 박스
listbox = tk.Listbox(window)
listbox.pack(pady=10)

# 버튼 클릭 이벤트 함수
def on_click():
    text = entry.get() # 입력창에서 내용 가져오기
    if text:
        listbox.insert(tk.END,text) # 리스트박스에 추가
        entry.delete(0,tk.END) # 입력창 비우기
        label.config(text = f" '{text}' cnrkehla!") # 레이블 업데이트

# 버튼
button = tk.Button(window,text="수강 신청", command=on_click)
button.pack(pady=10)

# 체크 박스
check_var = tk.IntVar()
checkbox = tk.Checkbutton(window, text="강의 등록 확인",variable=check_var)
checkbox.pack(pady=10)

# 실행
window.mainloop()

