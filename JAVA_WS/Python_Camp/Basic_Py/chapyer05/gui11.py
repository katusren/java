from tkinter import *
import tkinter.messagebox

def func_open():
    tkinter.messagebox.showinfo("메뉴 선택", "열기 메뉴를 선택함")
    
def func_exit():
    window.quit()
    window.destory()
    
# 메인
window = Tk()
mainMenu = Menu(window)
window.config(menu=mainMenu)

fileMenu = Menu(mainMenu)
mainMenu.add_cascade(label="File", menu=fileMenu)
mainMenu.add_command(label="Open",command=func_open)
fileMenu.add_separator()
fileMenu.add_command(label="Exit",command=func_exit)

window.mainloop()