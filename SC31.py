T = int(input())
for _ in range(T):
    N = int(input())
    S = []
    for i in range(N):
        S.append(input())
    weapons = 0
    S_T = [[] for _ in range(10)]
    for i in range(10):
        for s in S:
            S_T[i].append(int(s[i]))

    for s_t in S_T:
        if (sum(s_t) % 2 == 1):
            weapons += 1

    print(weapons)
