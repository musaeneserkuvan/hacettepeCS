from os import error
import sys
try:
    open(sys.argv[2])
except IndexError:
    print("IndexError: number of input files less than expected.\n")
except IOError:
    print("IOError: cannot open {}".format(sys.argv[2]))
else:
    with open(sys.argv[1]) as inputtext, open(sys.argv[2]) as compare:
        f3=compare.read().splitlines()
        
        f4=[]
        for i in f3:
            i=i.strip()
            i=i.split()
            f4.append(i)

        f1=inputtext.read().splitlines()

        f2=[]
        for i in f1:
            i=i.strip()
            i=i.split()
            f2.append(i)
        
        l = -1
        for i in f2:
            try:
                i=list(map(float,i))
                i=list(map(round,i))
            except ValueError:
                print("------------\nValueError: only numeric input is accepted.\nGiven input:",*i)
                l += 1
                continue
            l += 1
            try:   
                if len(i) >= 4:
                    range1=list(range(i[2],i[3]+1))
                    result=[]
                    try:
                        for j in range1:
                            if (j % i[0]) == 0 and (j % i[1]) != 0:
                                result.append(j)

                        result = [str(i) for i in result]
                        if (result==f4[l]):
                            print("------------\nMy results:                ",*result,"\nResults to compare:        ",*f4[l],"\nGoool!!!")
                        else:
                            print("------------\nMy results:                ",*result,"\nResults to compare:        ",*f4[l],"\nAssertionError: results don’t match.")
                    except ZeroDivisionError:
                        print("------------\nZeroDivisionError: You can’t divide by 0.","\nGiven input:",*i)
                else:
                    raise IndexError
            except IndexError:
                print("------------\nIndexError: number of operands less than expected.","\nGiven input:",*i)
            except:
                print("kaBOOM: run for your life!")

finally:
    print("\n- Game Over -")