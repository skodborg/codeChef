T = int(input())
for _ in range(T):
    N, H, Y1, Y2, L = [int(i) for i in input().split()]
    barriers = [[int(i) for i in input().split()] for j in range(N)]
    passed = 0
    lowest = H - Y1
    for barrier in barriers:
        ti, Xi = barrier
        if ti == 1:
            if lowest > Xi:
                L -= 1
        else:
            if Y2 < Xi:
                L -= 1
        if L == 0:
            break
        passed += 1
    print(passed)
