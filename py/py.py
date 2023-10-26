def function(n):
    name = {"kaleb":"adem",}
    if(n > 0):
        for _ in range(n):
            print(name["kaleb"],end= ",")
    else:
        print(" the number you input is less than 0 [ try agin]")
        main()
 
def main():
    try:
        n = int(input("enter a number :"))
        function(n)
    except ValueError:
        print("not it" * 3 ,end=" ")            
    
    print(f"{n}not integer")

if __name__ == "__main__":
    main()