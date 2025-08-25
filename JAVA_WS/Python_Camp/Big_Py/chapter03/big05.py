import pandas as pd

# 기본 읽기
df = pd.read_csv('C:/Users/soldesk/Downloads/JAVA/data/csv_s1.csv')
# print(df)

# 0 번째 행 스킵
df = pd.read_csv('C:/Users/soldesk/Downloads/JAVA/data/csv_s1.csv', skiprows=[0])
# print(df)

# 0 번째 행 스킵, Header 생략
df = pd.read_csv('C:/Users/soldesk/Downloads/JAVA/data/csv_s1.csv', skiprows=[0], header=None)
# print(df)

# 0 번째 행 스킵, Header 선언
df = pd.read_csv('C:/Users/soldesk/Downloads/JAVA/data/csv_s1.csv', skiprows=[0], header=None, names=["Month",2023,2024,2025])
# print(df)

# 0 번째 행 스킵, Header 선언, 인덱스 지정
df = pd.read_csv('C:/Users/soldesk/Downloads/JAVA/data/csv_s1.csv', skiprows=[0], header=None, names=["Month",2023,2024,2025],index_col=[0])
# print(df)

# 2
df2 = pd.read_csv('C:/Users/soldesk/Downloads/JAVA/data/csv_s2.csv', sep=';',skiprows=[0],header=None, names=["First name",'Test1','Test2','Test3','Final','Grade'])
print(df)
print("-"*60)

# 합계
df2['Sum']=df2[['Test1','Test2','Test3','Final']].sum(axis=1) # axis = 1 행단위
print(df2)
print("\n\n")

# 평균
df2['Avg']=df2[['Test1','Test2','Test3','Final']].mean(axis=1)
print(df2)
