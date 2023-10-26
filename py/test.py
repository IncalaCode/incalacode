import customtkinter
from customtkinter import *
customtkinter.set_appearance_mode("black")
app = customtkinter.CTk()
app.title("test")
app.geometry("500*300")



ENTRY =  customtkinter.CTkEntry(app, width=140, height=28, corner_radius=180,
                 border_width=18, bg_color="black", fg_color="black",
                 border_color="black", text_color="white", placeholder_text_color="white",
                 placeholder_text="enter a dir:")
ENTRY.place(x = 23,y=23)
app.mainloop()
