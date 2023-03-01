import sys

def getSum(Z):
    c=len(str(Z))
    while(c!=1):
        sum = 0
        for i in str(Z):
            sum+=int(i)
        Z=sum
        c=len(str(Z))
    return Z
x=int(sys.argv[1])
n=int(sys.argv[2])
Z=x**n
print(getSum(Z))