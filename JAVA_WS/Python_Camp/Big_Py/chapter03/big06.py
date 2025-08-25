import pandas as pd
import sys
import io

sys.stdout = io.TextIOWrapper(sys.stdout.detach(), encoding = 'utf-8')
sys.stderr = io.TextIOWrapper(sys.stderr.detach(), encoding = 'utf-8')


# 2
df2 = pd.read_csv('C:/Users/soldesk/Downloads/JAVA/data/csv_s2.csv', sep=';',skiprows=[0],header=None, names=["First name",'Test1','Test2','Test3','Final','Grade'])
print("-"*60)


df2['Sum']=df2[['Test1','Test2','Test3','Final']].sum(axis=1) # axis = 1 행단위
df2['Avg']=df2[['Test1','Test2','Test3','Final']].mean(axis=1)
print(df2)

# CSV 저장
df2.to_csv(":/Users/soldesk/Downloads/JAVA/data/result.csv",index=False)
print("저장완료")