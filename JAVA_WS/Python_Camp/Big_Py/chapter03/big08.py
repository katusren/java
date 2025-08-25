import pandas as pd
import xlrd
import openpyxl

# 첫번째 시트 읽어오기
df = pd.read_excel('C:/Users/soldesk/Downloads/JAVA/data/excel_s1.xlsx',sheet_name=0,engine='openpyxl')
# print(df)
# print(df.head()) # 상위 5개
# print(df.tail()) # 하위 5개

# 행의 첫번째 데이터 제외
df = pd.read_excel('C:/Users/soldesk/Downloads/JAVA/data/excel_s1.xlsx', skiprows=[1])
# print(df.head())
# 파일의 끝에서 5개 데이터 제외
df = pd.read_excel('C:/Users/soldesk/Downloads/JAVA/data/excel_s1.xlsx', skiprows=[1], skipfooter=5)
# print(df.tail())

# 헤더
# header = 0 => 첫번째 줄을 헤더로 사용하므로 원본 그대로 출력
df = pd.read_excel('C:/Users/soldesk/Downloads/JAVA/data/excel_s1.xlsx', header=0)
print(df.head())
print(list(df)) # 헤더만 리스트로 출력
print(list(df.columns.values)) # 헤더만 리스트로 출력

# 전처리
# ^Unnamed: Unnamed 시작하는 열
df = df.loc[:, ~df.columns.str.contains('^Unnamed')]
df = pd.read_excel('C:/Users/soldesk/Downloads/JAVA/data/excel_s1.xlsx', header=0, na_values='...', converters={"2019":lambda w: w if w>60000 else None})
# print(df.head())

print(list(df.rename(index=lambda x: x+1).index))
