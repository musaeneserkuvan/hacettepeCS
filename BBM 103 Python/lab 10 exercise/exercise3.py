list1=[1,2,3,4,5,6,7,8,9]
list2=[2,3,5,6,8]
output=[i*i for i in list1 if not i in list2]
print(output)