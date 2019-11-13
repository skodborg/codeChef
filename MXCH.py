T = int(input())
for _ in range(T):
    N, K = map(int, input().split())
    line = list(range(1, N))
    line.insert(K, N)
    print(' '.join([str(x) for x in line]))
