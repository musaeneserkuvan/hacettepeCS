import sys

with open(sys.argv[1]) as smntxt:

    # reading smn.txt and making a list of it   
    list1=smntxt.read().splitlines()

    # editing list and getting values as a string into a new list
    list2=[]
    for i in list1:
        i=i.replace(":"," ")
        i=i.split()
        list2.append(i)
    
    # making a dictionary of smn.txt file
    dict1={}
    for i in list2:
        key1,val1=i[0],i[1:]
        dict1[key1]=val1

with open("output.txt","w") as outputtxt:
    
    outputtxt.write("Welcome to Assignment 3\n")
    outputtxt.write("-------------------------------\n")

# func 1   
    def ANU(name1):
      
        if name1 in dict1:
            
            outputtxt.write("ERROR: Wrong input type! for 'ANU'!--This user already exists!!\n")
        
        else:
            
            # creating a new key value pair in a dict1 for new user
            dict1[name1] =[]
            outputtxt.write("User '{}' has been added to the social network successfully\n".format(name1))

# func 2    
    def DEU(name):
        
        if name in dict1: # deleting user from keys of dict1
            dict1.pop(name, None) 
    
            for i in dict1: # deleting user from values of dict1
                if name in dict1[i]:  
                    dict1[i].remove(name)
            
            outputtxt.write("User '{}' and his/her all relations have been deleted successfully\n".format(name))
        
        else:
            
            outputtxt.write("ERROR: Wrong input type! for 'DEU'!--There is no user named '{}'!!\n".format(name))

# func 3
    def ANF(name1,name2):
        
        if not name1 in dict1 and not name2 in dict1: # when both users not in dict1
            outputtxt.write("ERROR: Wrong input type! for 'ANF'!--No user named '{}' and '{}' found!!\n".format(name1,name2))
        
        elif not name2 in dict1 and name1 in dict1: # when name1 in dict1 but not name2
            outputtxt.write("ERROR: Wrong input type! for 'ANF'!--No user named '{}' found!!\n".format(name2))
        
        elif not name1 in dict1 and  name2 in dict1: # when name2 in dict1 but not name1
            outputtxt.write("ERROR: Wrong input type! for 'ANF'!--No user named '{}' found!!\n".format(name1))
        
        elif name1 in dict1[name2] and name2 in dict1[name1]: # when name1 and name2 are already friends
            outputtxt.write("ERROR: A relation between '{}' and '{}' already exists!!\n".format(name1,name2))
        
        else:  # adding new friends to eachother of name1 and name2
            dict1[name1].append(name2)
            dict1[name2].append(name1)
            outputtxt.write("Relation between '{}' and '{}' has been added successfully\n".format(name1,name2))

# func 4
    def DEF(name1,name2):

        if not name1 in dict1 and not name2 in dict1: # when both users not in dict1
            outputtxt.write("ERROR: Wrong input type! for 'DEF'!--No user named '{}' and '{}' found!\n".format(name1,name2))
        
        elif not name2 in dict1 and name1 in dict1: # when name1 in dict1 but not name2
            outputtxt.write("ERROR: Wrong input type! for 'DEF'!--No user named '{}' found!!\n".format(name2))
        
        elif not name1 in dict1 and  name2 in dict1: # when name2 in dict1 but not name1
            outputtxt.write("ERROR: Wrong input type! for 'DEF'!--No user named '{}' found!!\n".format(name1))
        
        elif name1 in dict1[name2] and name2 in dict1[name1]: # when both of them are friends , we are deleting friends values from them
            dict1[name1].remove(name2)
            dict1[name2].remove(name1)
            outputtxt.write("Relation between '{}' and '{}' has been deleted successfully\n".format(name1,name2))
        
        else:
            outputtxt.write("ERROR: No relation between '{}' and '{}' found!!\n".format(name1,name2))

# func 5
    def CF(name):
        
        if not name in dict1:
            outputtxt.write("ERROR: Wrong input type! for 'CF'!--No user named '{}' found!\n".format(name))
        
        else: #showing how many friends the user have by using len function
            outputtxt.write("User '{}' has {} friends\n".format(name,len(dict1[name])))

# func 6
    def FPF(name,d):
        
        if not name in dict1:
            outputtxt.write("ERROR: Wrong input type! for 'FPF'!--No user named '{}' found!\n".format(name))
        
        else:    
            
            index1=["1","2","3"] # created a index list , pulling values by string we wanted to make sure that its exact same input
            
            if not d in index1:
                outputtxt.write("ERROR: Maximum distance is out of range!!\n")
            
            else:    
                
                #dist 1    friends list of the user
                list4=[]
                list4+=list(dict1[name])
                
                #dist 2     friends list of the user + friends of (friends list of the user)
                list5=[]
                for i in list4:
                    for x in dict1[i]:
                        list5.append(x)
                        list5.append(i)   
                
                #dist3      friends list of the user + friends of (friends list of the user) + friends of (friends of (friends list of the user))
                list6=[]
                for i in list5:
                    for x in dict1[i]:
                        list6.append(x)
                
                for i in list5: # removing user himself from the list
                    if i == name:
                        list5.remove(i)
                
                for i in list6: # removing user himself from the list
                    if i == name:
                        list6.remove(i)
                
                # getting values as lists
                list4 = list(dict.fromkeys(list4))
                list5 = list(dict.fromkeys(list5))
                list6 = list(dict.fromkeys(list6))
                
                # sorting our lists
                list4.sort()
                list5.sort() 
                list6.sort()
                
                # determining the max distance of the lists
                md1=len(list4)
                md2=len(list5)
                md3=len(list6)
                
                if d=="1":
                    outputtxt.write("User '{}' has {} possible friends when maximum distance is 1\n".format(name,md1))
                    outputtxt.write(f"These possible friends: {{{str(list4)[1:-1]}}}\n") 
                
                elif d=="2":
                    outputtxt.write("User '{}' has {} possible friends when maximum distance is 2\n".format(name,md2))
                    outputtxt.write(f"These possible friends: {{{str(list5)[1:-1]}}}\n")
                
                elif d=="3":
                    outputtxt.write("User '{}' has {} possible friends when maximum distance is 3\n".format(name,md3))
                    outputtxt.write(f"These possible friends: {{{str(list6)[1:-1]}}}\n")                      

# func 7  
    def SF(name,d):
        
        if not name in dict1:
            outputtxt.write("ERROR: Wrong input type! for 'SF'!--No user named '{}' found!\n".format(name))
        
        else:    
            
            index2=["2","3"]
            
            if not d in index2:
                outputtxt.write("Error: Mutually Degree cannot be less than 1 or greater than 4\n")
            
            else:    
                
                # friends of USER
                list7=[]
                list7+=list(dict1[name]) 
                
                # we combine the list of friends of friends of USER
                list8=[] 
                for i in list7:
                   for x in dict1[i]:
                        if x != name:
                            if not x in list7:
                                list8.append(x)
                            
                # making a dictionary so we can see how many times they repeat
                dict2={} 
                for i in list8:
                    dict2[i]=list8.count(i)
                
                #making a list of mutual friends
                list9=[] 
                list10=[]
                
                for i in dict2:
                    if dict2[i]==3:
                        list10.append(i)
                    elif dict2[i]==2:
                        list9.append(i)  
                list9.sort()
                list10.sort()
                
                list11=list9+list10
                list11.sort()

                # suggesting friends
                if d=="2":
                    outputtxt.write("Suggestion List for '{}' (when MD is 2):\n".format(name))
                    
                    for i in list9:
                        outputtxt.write("'{}' has 2 mutual friends with '{}'\n".format(name,i))
                    
                    for i in list10:
                        outputtxt.write("'{}' has 3 mutual friends with '{}'\n".format(name,i))
                    
                    outputtxt.write(f"The suggested friends for '{name}':{str(list11)[1:-1]}\n")
                
                elif d=="3":
                    outputtxt.write("Suggestion List for '{}' (when MD is 3):\n".format(name))
                    
                    for i in list10:
                        outputtxt.write("'{}' has 3 mutual friends with '{}'\n".format(name,i))
                    
                    outputtxt.write(f"The suggested friends for '{name}':{str(list10)[1:-1]}\n")
                    
    with open(sys.argv[2]) as commandstxt:
            
        list12=commandstxt.read().splitlines() #reading and making a list of commands

        list13=[]

        for i in list12: # editing the commands list
            i=i.split()
            list13.append(i)

        for i in list13: # taking inputs and commands by commands txt and calling functions
            
            if i[0]=="ANU":
                ANU(i[1])
            
            elif i[0]=="DEU":
                DEU(i[1])
           
            elif i[0]=="ANF":
                ANF(i[1],i[2])
            
            elif i[0]=="DEF":
                DEF(i[1],i[2])
            
            elif i[0]=="CF":
                CF(i[1])
            
            elif i[0]=="FPF":
                FPF(i[1],i[2])
            
            elif i[0]=="SF":
                SF(i[1],i[2])
            
            else:
                outputtxt.write("There's no such as command!! Please enter a valid command!\n")