import customtkinter as CTK
from tkinter import Tk

root = Tk()
bar = CTK.CTkProgressBar(master=root, orientation="horizontal", mode="determinate")
bar.grid(row=10, column=0, pady=10, padx=20, sticky="n")
# Set default starting point to 0
bar.set(0)


def test():
    bar.start()
    for x in range(500):
        bar.set(x / 500)
        root.update_idletasks()
    bar.stop()


test()
