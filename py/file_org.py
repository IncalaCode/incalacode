import os
import shutil
from customtkinter import *

app = CTk()
app.geometry("600 * 320")
app.title("file_org")


CTkLabel(
    app,text="file_org",font=("Inter-semiBold",18)
).place(relx = 0.5 ,rely =0.2,anchor = CENTER)

put = CTkEntry(app,width=200, corner_radius=18,
                 border_width=18, bg_color="white", fg_color="black",
                 border_color="black", text_color="white", placeholder_text_color="white",
                 placeholder_text="enter a dir:")
put.place(relx = 0.5,rely = 0.47,anchor = CENTER)

def org():
    path = put.get()
    files = os.listdir(path)
    for files in files:
        name,order = os.path.splitext(files)
        order = order[1:]
        if os.path.exists(path +"/"+order):
            shutil.move(path + "/" + files, path + "/"+ order +"/"+ files )
        else:
            
            os.makedirs(path +"/"+order)
            shutil.move(path + "/" + files, path + "/"+ order +"/"+ files )


org_btn =CTkButton(
    app,
    text="org...",
    font=("Inter-semiBold",35),
    width=200,
    height = 20,
    command=org,
).place(relx = 0.5 ,rely =0.8,anchor = CENTER)


app.mainloop()