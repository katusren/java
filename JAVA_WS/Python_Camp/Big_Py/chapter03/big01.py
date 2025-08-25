# 직렬화 : 데이터나 객체를 바이트 스트림으로 변화
# 역직렬화 : 바이트 스트림을 원래의 데이터 구조나 객체로 반환해줌

import pickle # 직렬화, 역직렬화
import sys
import io

sys.stdout = io.TextIOWrapper(sys.stdout.detach(), encoding = 'utf-8')
sys.stderr = io.TextIOWrapper(sys.stderr.detach(), encoding = 'utf-8')

bfilename = "C:/Users/soldesk/Downloads/JAVA/data/test.bin" # 직렬화
tfilename = "C:/Users/soldesk/Downloads/JAVA/data/test.txt" # 역직렬화

data1 = 2025
data2 = "Hello, World"
data3 = ["car", "animal", "house"]

# 바이너리 쓰기(객체 직렬화)
with open(bfilename,"wb") as f:
    pickle.dump(data1,f)
    pickle.dump(data2,f)
    pickle.dump(data3,f)

# 텍스트 쓰기(객체 역직렬화)
with open(tfilename,"wt") as f:
    f.write(str(data1))
    f.write('\n')
    f.write(data2)
    f.write('\n')
    #f.write(data3) # 리스트이므로 ERROR
    f.writelines('\n'.join(data3))
    
# 바이너리 읽기
with open(bfilename,"rb") as f:
    b = pickle.load(f) # load(문자열 => 역직렬화)
    print(type(b),'Binary Read1 | ',b)
    b = pickle.load(f) # load(문자열 => 역직렬화)
    print(type(b),'Binary Read2 | ',b)
    b = pickle.load(f) # load(문자열 => 역직렬화)
    print(type(b),'Binary Read3 | ',b)
    
# 텍스트 읽기
with open(tfilename,"rt") as f:
    for i, line in enumerate(f,1):
        print(type(line), ' Text Read'+str(i)+' | ',line,end='')