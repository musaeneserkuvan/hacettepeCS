prime = list(filter(lambda x:all(x % y !=0 for y in range(2,x)),range(1,50)))
prime.remove(1)
print(prime)