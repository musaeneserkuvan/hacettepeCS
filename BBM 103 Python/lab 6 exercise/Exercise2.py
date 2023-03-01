def find_element(X,Y):
    Y.sort()
    return Y[-X]
listofnumbers = input('Please enter a list: ')
listofnumbers = listofnumbers.split(',')
Z = int(input())
print(find_element(Z,listofnumbers))