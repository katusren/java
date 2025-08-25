import pandas as pd
import numpy as np
import openpyxl

# 랜덤으로 DataFrame 생성
df1 = pd.DataFrame(np.random.randint(0,100,size=(100,4)),columns=['ONE','TWO','THREE','FOUR'])

print(df1)

df2 = pd.DataFrame(np.random.randn(10,2),columns=list('AB'))
print(df2)

df1.to_csv('C:/Users/soldesk/Downloads/JAVA/data/result2.csv',index=False)
df2.to_excel('C:/Users/soldesk/Downloads/JAVA/data/result.xlsx',header=True,index=None)
print("완료")