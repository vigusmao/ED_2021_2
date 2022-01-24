import sys


def fatorial(n):
    if n <= 1:
        return 1

    return n * fatorial(n-1)


def fatorial_nao_recursivo(n):
    result = 1
    while n > 1:
        result *= n
        n -= 1
    return result



sys.setrecursionlimit(2000)

for i in range(1001):
    print i, "-->", fatorial(i), fatorial_nao_recursivo(i)
   



