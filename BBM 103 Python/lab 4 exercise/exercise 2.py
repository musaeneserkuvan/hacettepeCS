#exercise 2
# calculate of the roots of the function given
a = 1
b = float(input("Enter a 'b' value: "))
c = float(input("Enter a 'c' value: "))

delta = b**2 -4*a*c
if delta < 0:
  print("You entered a function which has irrational roots.")
else:
  x1 = (-b +(delta**(1/2))) /2
  x2 = (-b -(delta**(1/2))) /2
  print("First root of function given is",x1)
  print("Second root of function given is",x2)
  
