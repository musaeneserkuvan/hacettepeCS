X = int(input())

dictionary = {i: "*" * i for i in range(1,X+1)}
for Y in range(1,X+1):
    print(dictionary[Y])