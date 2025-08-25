import sys
import io
import requests, json 

sys.stdout = io.TextIOWrapper(sys.stdout.detach(), encoding = 'utf-8')
sys.stderr = io.TextIOWrapper(sys.stderr.detach(), encoding = 'utf-8')


#세션 시작 
with requests.Session() as s:
    #Get으로 스트리밍 요청
    r = s.get('http://httpbin.org/stream/20', stream=True)
    if r.status_code == 200:
    #스트리밍된 응답의 각 라인을 반복하여 로드함
        for line in r.iter_lines():
            #라인을 디코드하고 출렬
            if line:
                # JSON 으로 파싱하여 사용자의 편이성 제공
                data=json.loads(line.decode('utf-8'))
                print(data)
    else:
        print(f'요청을 실패하였습니다. 상태코드: {r.status_code}')  
        
