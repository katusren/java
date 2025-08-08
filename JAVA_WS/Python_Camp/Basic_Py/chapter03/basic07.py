import pandas as pd 

# 시리즈 객체
numbers = pd.Series([100,200,300])
print(numbers)

# 인덱스 지정
score = pd.Series([90,88,40], index=['재준','세영','세종'])
print(score)
print(score.index)
print(score.values)

print(score.index[2],score.values[2])