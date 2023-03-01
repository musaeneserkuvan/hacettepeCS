import sys

def func(listx):
    for i in listx:
        if i <= len(listx):
            if i in listx:
                if i == 1:
                    i =2
                    del listx[(i-1)::i]
                elif i !=1:
                    del listx[(i-1)::i]
    y=[str(i) for i in listx]
    z=" ".join(y)
    return z


x=str(sys.argv[1])
listx = [int(k) for k in x.split(",")]

print(func(listx))