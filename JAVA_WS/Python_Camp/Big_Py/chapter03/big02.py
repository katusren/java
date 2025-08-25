from bs4 import BeautifulSoup
import urllib.request as req
import os.path
import sys
import io
import simplejson as json

sys.stdout = io.TextIOWrapper(sys.stdout.detach(), encoding = 'utf-8')
sys.stderr = io.TextIOWrapper(sys.stderr.detach(), encoding = 'utf-8')

#데이터 수집 (https://www.weather.go.kr/w/pop/rss-guide.do)
def create_sample_xml(save_path):
    xml_data = '''<?xml version="1.0" encoding="UTF-8"?>
<rss version="2.0">
<channel>
<title>기상청 1개월 전망</title>
<item>
<description>
<weather_forecast>
<week>
<week1_period>09.02.~09.08.</week1_period>
<week1_weather_review>고기압 영향으로 맑고 더움</week1_weather_review>
</week>
<week>
<week2_period>09.09.~09.15.</week2_period>
<week2_weather_review>고기압과 저기압 교대 영향</week2_weather_review>
</week>
<week>
<week3_period>09.16.~09.22.</week3_period>
<week3_weather_review>가을철 날씨로 변화</week3_weather_review>
</week>
<week>
<week4_period>09.23.~09.29.</week4_period>
<week4_weather_review>평년 수준의 기온과 강수량</week4_weather_review>
</week>
</weather_forecast>
</description>
</item>
</channel>
</rss>'''
    
    with open(save_path, 'w', encoding='utf-8') as f:
        f.write(xml_data)
def main():
    url = "https://www.kma.go.kr/repositary/xml/fct/mon/img/fct_mon1rss_108_20250814.xml"
    save_path  = "C:/Users/soldesk/Downloads/JAVA/data/weather.xml"
    
    # 디렉토리 생성
    if not os.path.exists("C:/Users/soldesk/Downloads/JAVA/data"):
        os.makedirs("C:/Users/soldesk/Downloads/JAVA/data")
        
    # 샘플 XML 생성 (URL이 HTML 반환하므로)
    create_sample_xml(save_path)
    
    # XML 파싱
    with open(save_path,'r',encoding='utf-8') as f:
        xml_content = f.read()
        
    soup = BeautifulSoup(xml_content,'html.parser')
    
    # 분석 시작
    # 제목 출력
    title = soup.find("title").get_text()
    print(f"제목: {title}")
    print("-"*40)
    
    # 주차별 기간과 날씨 추출
    weeks = soup.find_all("week")
    weather_data = []
    json_data = []
    for i, week in enumerate(weeks,1):
        period = week.find(f"week{i}_period").get_text()
        weather = week.find(f"week{i}_weather_review").get_text()
        
        print(f"{i}주차: {period}")
        print(f"날씨: {weather}")
        print()
        
        weather_data.append(f"{i}주차: {period}\n날씨: {weather}\n")
        
        json_data["weeks"].append({
            "week":i,
            "period":period,
            "weather":weather
        })
        
        # 파일로 저장
        output_file = "C:/Users/soldesk/Downloads/JAVA/data/weather_report.txt"
        with open(output_file, 'w', encoding="utf-8") as f:
            f.write(f"{title}\n")
            f.write("="*40 + "\n\n")
            for data in weather_data:
                f.write(data + "\n")
        print(f"날씨 정보가 '{output_file}' 파일로 저장되었습니다")
                
        # json파일로 저장
        json_file = "C:/Users/soldesk/Downloads/JAVA/data/weather_report.json"
        with open(json_file, 'w', encoding="utf-8") as f:
            json.dump(weather_data,f,ensure_ascii=False, indent=2)
        
        print(f"날씨 정보가 '{json_file}' 파일로 저장되었습니다")
        
if __name__ == "__main__":
    main()
