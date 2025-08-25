import yt_dlp

# 다운로드할 동영상 URL
url = "https://www.youtube.com/watch?v=WJRQgGI83zU&t"

# 다운로드 옵션 설정
ydl_opts = {
    'outtmpl': 'C:/Users/soldesk/Downloads/JAVA/Py_Scrap/%(title)s.%(ext)s', # 파일 저장 경로 설정
}

# yt_dlp 객체 생성 및 다운로드 실행
with yt_dlp.YoutubeDL(ydl_opts) as ydl:
    ydl.download([url])
    
print('동영상 다운로드 완료!')