import sys
with open(sys.argv[1]) as inputtxt:
    
    List_of_Indexes_of_Adjoining_Balls=[]
    List_of_Indexes_of_Adjoining_Balls_noDUP = []
    loop=True
    how_many_balls_can_pop=[]
    score_points={"B":9,"G":8,"W":7,"Y":6,"R":5,"P":4,"O":3,"D":2,"F":1}
    total_points=0
    deleted_balls=[]

    def find_Neighbours_Below(row,col):  
        try:
            if (row+1,col) in List_of_Indexes_of_Adjoining_Balls:
                return None            
            
            else:
                if Matrix[row+1][col] != Matrix[row][col]:
                    return None
                else:
                    return List_of_Indexes_of_Adjoining_Balls.append((row+1,col)),find_Adjoining_Balls(row+1,col)
        except IndexError:
            pass
    def find_Neighbours_Above(row,col):
        try:
            if (row-1) < 0:
                return None
            else:
                if (row-1,col) in List_of_Indexes_of_Adjoining_Balls:
                    return None
                else:
                    if Matrix[row-1][col] != Matrix[row][col]:
                        return None
                    else:
                        return List_of_Indexes_of_Adjoining_Balls.append((row-1,col)),find_Adjoining_Balls(row-1,col)
        except IndexError:
            pass
    def find_Neighbours_Right(row,col):
        try:
            if (row,col+1) in List_of_Indexes_of_Adjoining_Balls:
                return None
            else:    
                if Matrix[row][col+1] != Matrix[row][col]:
                    return None
                else:
                    return List_of_Indexes_of_Adjoining_Balls.append((row,col+1)),find_Adjoining_Balls(row,col+1)
        except IndexError:
            pass
    def find_Neighbours_Left(row,col):
        try:
            if (col-1) < 0: 
                return None
            else:    
                if (row,col-1) in List_of_Indexes_of_Adjoining_Balls:
                    return None
                else:    
                    if Matrix[row][col-1] != Matrix[row][col]:
                        return None
                    else:
                        return List_of_Indexes_of_Adjoining_Balls.append((row,col-1)),find_Adjoining_Balls(row,col-1)
        except IndexError:
            pass
    def Delete_Dups_List_of_Indexes_of_Adjoining_Balls():
        for i in List_of_Indexes_of_Adjoining_Balls:
            if i != " ":   
                if not i in List_of_Indexes_of_Adjoining_Balls_noDUP:
                    List_of_Indexes_of_Adjoining_Balls_noDUP.append(i)
    def find_Adjoining_Balls(row,col): 
        if Matrix[row][col]== "X":
            find_BOMB(row,col)
            Delete_Dups_List_of_Indexes_of_Adjoining_Balls()
        else:  
            List_of_Indexes_of_Adjoining_Balls.append((row,col))
            find_Neighbours_Below(row,col)
            find_Neighbours_Above(row,col)
            find_Neighbours_Right(row,col)
            find_Neighbours_Left(row,col)
            Delete_Dups_List_of_Indexes_of_Adjoining_Balls()
    def remove_Adjoining_Balls(row,col):    
        if len(List_of_Indexes_of_Adjoining_Balls_noDUP)==1:
            pass
        else: 
            for i in List_of_Indexes_of_Adjoining_Balls_noDUP:
                Matrix[i[0]][i[1]]=" "                  
    def balls_fall_down():
        for r in range(len(Matrix)):
            for c in range(len(Matrix[r])):
                try:
                    if Matrix[r+1][c] == " ":
                        Matrix[r+1][c] = Matrix[r][c]
                        Matrix[r][c] = " "
                    else:
                        pass
                except IndexError:
                    pass
        for r in range(len(Matrix)):
            for c in range(len(Matrix[r])):
                    try:
                        if Matrix[r+1][c] == " " and Matrix[r][c] != " ": 
                            balls_fall_down()   
                    except IndexError:
                        pass     
    def del_empty_rows():
        try:
            for i in range(len(Matrix)):
                if Matrix[i].count(" ")==len(Matrix[i]) :
                    del Matrix[i]
                    del_empty_rows()
                    break
                else:
                    pass
        except IndexError:
            pass     
    def del_empty_columns(): 
        try:
            if len(Matrix)==0:
                pass
            else:    
                for i in range(len(Matrix[0])):
                    c=[]
                    for j in range(len(Matrix)):
                        c.append(Matrix[j][i])
                    if c.count(" ")==len(Matrix):
                        for y in range(len(Matrix)):
                            del Matrix[y][i]
                        del_empty_columns()
                        break
                    else:
                        pass
                    c.clear()
        except IndexError:
            pass
    def count_score():
        global total_points
        try:    
            if len(List_of_Indexes_of_Adjoining_Balls_noDUP) == 1:
                total_points
            else:
                total_points= 0
                for i in List_of_Indexes_of_Adjoining_Balls_noDUP:
                        deleted_balls.append( Matrix[i[0]][i[1]] )
                for i in score_points:
                    total_points+=deleted_balls.count(i)*score_points[i]
        except IndexError:
            pass
    def check_if_game_countinues():
        global loop
        if len(Matrix)== 0:
            loop = False
        else:
            for i in range(len(Matrix)):
                for x in range(len(Matrix[0])):
                    if Matrix[i][x] == "X":
                        loop = True
                    elif Matrix[i][x] == " ":
                            pass
                    else:
                        find_Adjoining_Balls(i,x)
                        how_many_balls_can_pop.append(len(List_of_Indexes_of_Adjoining_Balls_noDUP))
                        List_of_Indexes_of_Adjoining_Balls.clear()
                        List_of_Indexes_of_Adjoining_Balls_noDUP.clear()
                        if how_many_balls_can_pop.count(1)==len(how_many_balls_can_pop):
                            loop = False
    def find_BOMB(row,col):
        Matrix[row][col]=" "
        for i in range(len(Matrix)):
            if Matrix[i][col]=="X":
                find_BOMB(i,col)
            else:
                List_of_Indexes_of_Adjoining_Balls.append((i,col))
        for i in range(len(Matrix[0])):
            if Matrix[row][i]=="X":
                find_BOMB(row,i)
            else:
                List_of_Indexes_of_Adjoining_Balls.append((row,i))

    list1=inputtxt.read().splitlines()                
    Matrix=[ i.strip().split() for i in list1]
    [print(*i) for i in Matrix] ,print(),print("Your score is:",total_points),print()       
    
    while loop==True :
        try:    
            input1=input("Please enter a row and column number: ")
            input1=input1.split()
            row,col=int(input1[0]),int(input1[1]) 
            if len(input1)>2: raise IndexError
            if Matrix[row][col] == " ": raise IndexError 
            else:
                find_Adjoining_Balls(row,col)
                count_score()
                remove_Adjoining_Balls(row,col)
                balls_fall_down()
                del_empty_rows()
                del_empty_columns()
                List_of_Indexes_of_Adjoining_Balls.clear()
                List_of_Indexes_of_Adjoining_Balls_noDUP.clear()
                check_if_game_countinues()
                how_many_balls_can_pop.clear()
            print(), [print(*i) for i in Matrix] ,print(),print("Your score is:",total_points),print()
            if loop == False:
                print("Game over!")

                
        except Exception:
            print(),print("Please enter a valid size!"),print()