import datetime
import FinanceDataReader as fdr # pip install finance-datareader
import sys
import io   

sys.stdout = io.TextIOWrapper(sys.stdout.detach(), encoding = 'utf-8')
sys.stderr = io.TextIOWrapper(sys.stderr.detach(), encoding = 'utf-8')

# 조회 시작
start = datetime.datetime(2023,2,19)
# 조회 마감 날짜
end = datetime.datetime(2024,7,30)

# 구글 : google finance => https://www.google.com/finance/?h1=ko
# 한국 거래소 상장 목록 전체
df_krx = fdr.StockListing('KRX') # KRX : Korea Exchange 한국 거래소(KOSPI, KOSAQ, KONEX) 정보 요청
# 리스트 10개 출력
print(df_krx.head(10))

print(df_krx.index)

print(df_krx['Stocks'])

print(df_krx.iloc[0]) # 첫번째 종목의 정보 출력

print(df_krx.describe())

# 미국 거래소 상장종목 중 아마존 금융 정보
df_amz = fdr.DataReader('AMZN',start,end)
print(df_amz.iloc[0]) 

print(df_amz.loc['2024-07-16']) 

print(df_amz.head(10)) 

print(df_amz.describe()) 


