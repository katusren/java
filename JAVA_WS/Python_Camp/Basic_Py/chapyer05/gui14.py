from tkinter import *
from tkinter.filedialog import *

window = Tk()
window.geometry("400x100")

label1 = Label(window, text="입력된 값")
label1.pack()

saveFp=askopenfilename(parent=window, mode="w",defaultextension=".jpg", filetypes=(("GIF 파일", "*.gif"),("모든 파일","*.*")))
label1.configure(text=str(saveFp))

saveFp.close()

window.mainloop()