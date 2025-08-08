from tkinter import *
import tkinter.messagebox
from tkinter.filedialog import *

def func_open():
    filename=askopenfilename(parent=window, filetypes=(("GIF 파일", "*.gif"),("모든 파일","*.*")))
    photo = PhotoImage(file=filename)
    pLabel.configure(image=photo)
    pLabel.image = photo
    
def func_exit():
    window.quit()
    window.destroy()

window = Tk()
window.geometry("400x100")
window.title("명화 감상하기")

# 이미지 객체 생성
photo = PhotoImage()
pLabel = Label(window,image=photo) 
pLabel.pack(expand=1,anchor=CENTER)

# 메뉴 객체 생성
mainMenu = Menu(window)
window.config(menu=mainMenu)

fileMenu=Menu(mainMenu) #mainMenu에 삽입될 객체 
mainMenu.add_cascade(label="File", menu=fileMenu)
fileMenu.add_command(label="열기", command=func_open)

fileMenu.add_separator()
fileMenu.add_command(label="종료", command=func_exit)

window.mainloop()