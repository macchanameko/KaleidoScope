paper = {}
counter = 0
i = 0
for i in range(10):
	for j in range(10):
		paper.update({(i,j):0})
while i < 50:
	try:
		x, y, s = list(map(int,input().split(",")))
	except:
		break
	if s == 3:
		paper[(x+2,y)] += 1
		paper[(x-2,y)] += 1
		paper[(x,y+2)] += 1
		paper[(x,y-2)] += 1
	if s >= 2:
		paper[(x+1,y+1)] += 1
		paper[(x+1,y-1)] += 1
		paper[(x-1,y+1)] += 1
		paper[(x-1,y-1)] += 1
	paper[(x,y)] += 1
	paper[(x,y-1)] += 1
	paper[(x,y+1)] += 1
	paper[(x+1,y)] += 1
	paper[(x-1,y)] += 1
	i += 1

for i in range(10):
	for j in range(10):
		if paper[(i,j)] == 0:
			counter += 1
print(counter)
print(max(paper.values()))