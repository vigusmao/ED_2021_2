import sys


def fatorial(n):
    if n <= 1:
        return 1

    return n * fatorial(n-1)


sys.setrecursionlimit(2000)

for i in range(1001):
    print i, "-->", fatorial(i)


