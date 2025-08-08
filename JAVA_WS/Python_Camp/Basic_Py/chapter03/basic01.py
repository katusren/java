import pickle
# pickle 모듈은 파이썬 객체를 파일로 저장하고 읽어들이도록 함
# 객체를 저장한 상태에서 프로그램이 종료되면 객체는 메모리에서 자동 소멸
'''
f = open('setting.txt','wb')
setting = [{'title':'python program'},{'author':'sol'}]
pickle.dump(setting,f)
f.close()
'''

f = open('setting2.txt','wb')
try:
    setting = [{'title':'python program'},{'author':'sol'}]
    pickle.dump(setting,f)
except Exception as e:
    print(e)
finally:
    f.close()