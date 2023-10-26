from customtkinter import *
import customtkinter as CTK
from tkinter import Tk
import googletrans


def atoz(a_z="", resualt=""):
    for i in range(len(a_z)):
        if i == -1:
            if 96 < ord(a_z[i]) < 122:
                resualt += chr(ord(a_z[i]) - 32)
        elif 64 < ord(a_z[i]) < 91:
            resualt += chr(ord(a_z[i]) + 32)
        else:
            resualt += a_z[i]
    return resualt


def what():
    translator = googletrans.Translator()
    unlike = 0
    per = 0
    path = put.get()
    lang = a_z(path)
    for l in range(ord("a"), ord("z") + 1):
        bar.start()
        i = 0
        storage = []
        with open("sample.txt", "r", encoding="utf-8") as file:
            for line in file:
                storage.append(line.rstrip())
                sub_storage = storage[i].split(":")
                try:
                    translted = translator.translate(sub_storage[0], dest=lang)
                    tanslater_sto = translator.translate(translted.text, dest="en")
                    check = translator.translate(tanslater_sto.text, dest=lang)
                    Value = translted.text
                    if atoz(sub_storage[0]) == atoz(tanslater_sto.text):
                        storage[i] += ":" + Value + "\n"
                    else:
                        unlike += 1
                        storage[i] += ":" + Value + "\n"
                        value_2 = check.text
                        storage[i] += atoz(tanslater_sto.text) + ":" + value_2 + "\n"

                    i += 1
                except:
                    print(f"network is not working and {chr(l)} is not translated")

        with open("sample.txt", "w", encoding="utf-8") as f:
            f.write("".join(storage))
        print(f"{chr(l)} is translated")
        per = ((l - 96) * 100) / 26
        print(f"{per} %")
        bar.set(per)
        app.update_idletasks()
    bar.stop()


def a_z(a_z="", resualt=""):
    for i in range(len(a_z)):
        if 64 < ord(a_z[i]) < 91:
            resualt += chr(ord(a_z[i]) + 32)
        if i == 2:
            return resualt
        resualt += a_z[i]


app = CTk()

app.geometry("600 * 320")
app.title("LANGUAGE")

CTkLabel(app, text="language", font=("Inter-semiBold", 18)).place(
    relx=0.5, rely=0.2, anchor=CENTER
)

put = CTkEntry(
    app,
    width=200,
    corner_radius=18,
    border_width=18,
    bg_color="white",
    fg_color="black",
    text_color="white",
    placeholder_text_color="white",
    placeholder_text="enter a language:",
)
put.place(relx=0.5, rely=0.4, anchor=CENTER)

bar = CTK.CTkProgressBar(master=app, orientation="horizontal", mode="determinate")
bar.grid(row=10, column=0, pady=10, padx=20, sticky="n")
bar.set(0)
bar.place(relx=0.5, rely=0.6, anchor=CENTER)

org_btn = CTkButton(
    app,
    text="start",
    font=("Inter-semiBold", 35),
    width=200,
    height=20,
    command=what,
).place(relx=0.5, rely=0.8, anchor=CENTER)
app.mainloop()
