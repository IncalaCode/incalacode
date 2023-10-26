import random
def main():
    print(":encrpt your anything:")
    name = input("what is your name ? :")
    encrpt(name)
def encrpt(name):
    no = (len(name) + 8/len(name)) * 10
    salt = random.randint(1,int(no))
    print(salt,end="")
    for i in range(len(name)):
        print(chr(ord(name[i]) + salt),end="")
        
         
if __name__ == "__main__":
    main()


