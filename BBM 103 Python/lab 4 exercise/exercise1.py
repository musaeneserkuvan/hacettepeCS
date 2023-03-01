#exercise 1
x=int(input  ("Lets find a leap year ! "))  # YEAR input

if x%4 == 0 and x > 0:
  if x%100 == 0:
    if x%400 == 0:
      print("Woahh you find a leap year :)")
    else:
      print("sorry its not but nice try")
  else:
    print("Woahh you find a leap year :)")
else:
  print("sorry its not but nice try")
