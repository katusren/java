import pandas as pd
import xlrd
import openpyxl
import sys
import io

sys.stdout = io.TextIOWrapper(sys.stdout.detach(), encoding = 'utf-8')
sys.stderr = io.TextIOWrapper(sys.stderr.detach(), encoding = 'utf-8')

# 기본 읽기
df1 = pd.read_excel('C:/Users/soldesk/Downloads/JAVA/data/excel_s1.xlsx',header=0)
# ^Unnamed: Unnamed 시작하는 열
df1 = df1.loc[:, ~df1.columns.str.contains('^Unnamed')]
# print(df1)

# print(df1['State'])
df1['State'] = df1['State'].str.replace(' ','|')
print(df1['State'])

# 평균 컬럼 추가 axis = 1
df1['Avg'] = df1[['2018','2019','2020']].mean(axis=1).round(2)
print(df1)
# 합계
df1['Sum'] = df1[['2018','2019','2020']].sum(axis=1)
print(df1)

# 최대값 컬럼 추가
max_values = df1[['2018','2019','2020']].max(axis=0)
# 최대값 열단위 출력
print(max_values)

# 최소값 열단위 출력
min_values = df1[['2018','2019','2020']].min(axis=0)
print(min_values)

# 상세 분석 정보 출력
print(df1.describe())

# 엑셀 쓰기
df1.to_excel('C:/Users/soldesk/Downloads/JAVA/data/excel_s1.xlsx',index=False)

# 컬럼 연산 추가
df2=pd.read_excel("C:/Users/soldesk/Downloads/JAVA/data/excel_s2.xlsx", header=0)
df2[['Units', 'UnitCost']]=df2[['Units', 'UnitCost']].astype(int)
df2['Custom1']=df2['Units']*df2['UnitCost']
df2['Custom2']=df2['Total']*10
print(df2)

# 엑셀 쓰기
df2.to_excel("C:/Users/soldesk/Downloads/JAVA/data/excel_s22.xlsx", index=None)
print('commit')