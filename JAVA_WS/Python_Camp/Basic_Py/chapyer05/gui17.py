import sys
from PyQt5.QtWidgets import QApplication, QWidget

class MyApp(QWidget):
    def __init__(self):
        super().__init__()
        self.initUi()
        
    def initUi(self):
        self.setWindowTitle('PyQt 기본 창') # 창 제목
        self.setGeometry(300,300,400,300) # 창 크기

# 메인
if __name__=='__main__':
    app=QApplication(sys.argv) # 어플 실행을 위한 객체 생성
    ex = MyApp() # MyApp 클래스 객체 생성
    ex.show()
    sys.exit(app.exec_()) # 루프 실행