import sys
try:
    n=int(sys.argv[1])
    
    if len(sys.argv) > 2: raise IndexError
    else:
        c= (2*n) - 1
        if n  < 1: raise IndexError
        else:   
            a =[ print( " "  *  ( ( c  - ( (2*i)  - 1 ) ) // 2 )   +     ((2*i)-1) * "*"  +   " "  *  ( ( c  - ( (2*i)  - 1 ) ) // 2 )  ) for i in list(range(1,n+1)) ]
            b = [ print( " "  *  ( ( c  - ( (2*i)  - 1 ) ) // 2 )   +     ((2*i)-1) * "*"  +   " "  *  ( ( c  - ( (2*i)  - 1 ) ) // 2 ) ) for i in list(reversed(range(1,n))) ]

except Exception:
    print("Please enter a valid integer ( N = {1,2,3,...n})")