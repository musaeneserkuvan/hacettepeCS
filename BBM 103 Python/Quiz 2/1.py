import sys
a = float(sys.argv[1])
b = float(sys.argv[2])
c = float(sys.argv[3])

delta=b*b-4*a*c
if delta > 0:
    x1= (-b+delta**(1/2))/ 2*a
    x2= (b+delta**(1/2))/ 2*a
    print(x1,x2)
    print("the quadratic has two distinct real number solutions")
elif delta == 0:
    x1=(-b+delta**(1/2))/2*a
    x2=(b+delta**(1/2))/2*a
    print(x1,x2)
    print("the quadratic has a repeated real number solutions")
else:
    print("There is no real solutions")