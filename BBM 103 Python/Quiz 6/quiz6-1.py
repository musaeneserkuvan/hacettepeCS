import sys
try:
    
    def func1(x):
        if x[-1] == x[0]:
            return func2(y)
        else:
            return print (  " "  *  ( ( c  - ( (2*x[-1])  - 1 ) ) // 2 )    +     ((2*x[-1])-1) * "*"   +    " "  *  ( ( c  - ( (2*x[-1]) - 1 ) ) // 2 )   ) , func1(x[:-1])


    def func2(y):
        if y[-1] == y[0]:
            return print (  " "  *  ( ( c  - ( (2*y[-1])  - 1 ) ) // 2 )    +     ((2*y[-1])-1) * "*"   +    " "  *  ( ( c  - ( (2*y[-1])- 1) ) // 2 )   )
        else:
            return print (  " "  *  ( ( c  - ( (2*y[-1])  - 1 ) ) // 2 )    +     ((2*y[-1])-1) * "*"   +    " "  *  ( ( c  - ( (2*y[-1])- 1) ) // 2 )   ) , func2(y[:-1])

    n=int(sys.argv[1])
    
    if len(sys.argv) > 2: raise IndexError
    else:
        c= (2*n) - 1
        x = list(reversed(range(1,n+1)))
        y=list(range(1,n+1))
        func1(x)

except Exception:
    print("Please enter a valid integer ( N = {1,2,3,...n})")