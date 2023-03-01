import sys 
list_of_number =sys.argv[1].split(",")
all_even_numbers = []
list_of_number = [int(a) for a in list_of_number]
list_of_number1 = [] 
for a in list_of_number:
  if a > 0:
    list_of_number1.append(a)

for b in list_of_number1:
  if b % 2 ==0:
    all_even_numbers.append(b)
all_even_numbers_sum=sum(all_even_numbers)
list_of_number1_sum=sum(list_of_number1)

print(all_even_numbers)
print(list_of_number1_sum)
