list1=[1,2,3,45,43,55,777,88,99,111]


def maxN(list1):
    if len(list1) == 1:
        return max(list1)
    else:
        return max(list1[len(list1)-1],maxN(list1[:-1]))


def minN(list1):
    if len(list1) == 1:
        return min(list1)
    else:
        return min(list1[len(list1)-1],minN(list1[:-1]))

def sumN(list1):
    if len(list1) == 1:
        return list1[0]
    else:
        return list1[len(list1)-1]+sumN(list1[:-1])


print("The highest number is {}".format(maxN(list1)))
print("The lowest number is {}".format(minN(list1)))
print("The average number is {}".format(sumN(list1)/len(list1)))