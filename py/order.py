import os

old_storage = []
i = 0
storage = []
last = "a"
with open("words_alpha.txt", "r+") as file:
    for line in file:
        if line[0] != last or line == "cala12-end":
            if last + ".txt" is not None and os.path.isfile(last + ".txt"):
                with open(last + ".txt", "r") as file2:
                    for line2 in file2:
                        old_storage.append(line2.rstrip())
            file1 = open(last + ".txt", "w")
            stor = "\n".join(sorted(storage + old_storage))
            file1.write(stor)
            storage.clear()
            old_storage.clear()
            i += 1
            print(f"{last}{i}is is complted")
            last = line[0]
            storage.append(line.rstrip())
        else:
            storage.append(line.rstrip())
