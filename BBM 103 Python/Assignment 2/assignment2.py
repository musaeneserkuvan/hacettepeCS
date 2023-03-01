rules="1. BRUSH DOWN\n2. BRUSH UP\n3. VEHICLE ROTATES RIGHT\n4. VEHICLE ROTATES LEFT\n" \
      "5. MOVE UP TO X\n6. JUMP\n7. REVERSE DIRECTION\n8. VIEW THE MATRIX\n0. EXIT"
print(rules)
tasks = input("Please enter the commands with a plus sign (+) between them.\n")
tasks = tasks.split("+")
n = int(tasks[0])
tasks = tasks[1::]

while not("0" in tasks and "8" in tasks):
    tasks=input("you entered an incorrect command.Please try again\n")
    tasks = tasks.split("+")
    n = int(tasks[0])
    tasks = tasks[1::]

M = [[" " for i in range(n + 2)] for j in range(n + 2)]

for i in range(len(M)):
    M[i][0] = "+"
    M[i][-1] = "+"
    M[-1][i] = "+"
    M[0][i] = "+"

curr_x = 1
curr_y = 1

brush = False

directions = {"right": (0, 1), "left": (0, -1), "down": (1, 0), "up": (-1, 0)}

direction = "right"


def move(curr_x, curr_y, step_x, step_y,step, M):
    for k in range(step):
        curr_x+=step_x
        curr_x = (curr_x - 1) % n + 1
        curr_y+=step_y
        curr_y = (curr_y - 1) % n + 1
        M[curr_x][curr_y] = "*"
    return M


for task in tasks:
    if task == "1":
        brush = True
        M[curr_x][curr_y] = "*"
    elif task == "2":
        brush = False
    elif task == "3":
        if direction == "right":
            direction = "down"
        elif direction == "down":
            direction = "left"
        elif direction == "left":
            direction = "up"
        else:
            direction = "right"
    elif task == "4":
        if direction == "right":
            direction = "up"
        elif direction == "down":
            direction = "right"
        elif direction == "left":
            direction = "down"
        else:
            direction = "left"
    elif task == "6":
        step_x= 3 * directions[direction][0]
        step_y = 3 * directions[direction][1]
        curr_x += step_x
        curr_x = (curr_x - 1) % n + 1
        curr_y += step_y
        curr_y = (curr_y - 1) % n + 1
        brush = False
    elif task == "7":
        if direction == "right":
            direction = "left"
        elif direction == "down":
            direction = "up"
        elif direction == "left":
            direction = "right"
        else:
            direction = "down"
    elif task == "8":
        for i in range(len(M)):
            M[i][0] = "+"
            M[i][-1] = "+"
            M[-1][i] = "+"
            M[0][i] = "+"
        for row in M:
            print(*row)
    elif task == "0":
        break
    else:
        step = int(task.split('_')[1])
        step_y=directions[direction][1]
        step_x = directions[direction][0]
        if brush:
            M = move(curr_x, curr_y, step_x, step_y,step, M)
        curr_x += step*step_x
        curr_x = (curr_x - 1) % n + 1
        curr_y += step*step_y
        curr_y = (curr_y - 1) % n + 1