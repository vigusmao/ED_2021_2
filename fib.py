# fib(n) ->    1, 1, 2, 3, 5, 8, 13, 21, ...
#  n ->        0, 1, 2, 3, 4, 5,  6,  7


import sys
sys.setrecursionlimit(3000)

# MEMOIZATION (MEMOIZAÇÃO)
memo = {}


def fib(n):
    result_from_memo = memo.get(n)       # O(1)
    if result_from_memo is not None:     # O(1)
        return result_from_memo          # O(1)

    if n <= 1:
        return 1

    result = fib(n-1) + fib(n-2)

    memo[n] = result    # anota no memo o resultado para este valor de n

    return result


for i in range(2001):
    print i, "-->", fib(i)

#   fib(40)
#   quantas vezes fib(40)  ?   1 = fib(0)
#   quantas vezes fib(39)  ?   1 = fib(1)
#   quantas vezes fib(38)  ?   2 = fib(2)
#   quantas vezes fib(37)  ?   3 = fib(3)
#   quantas vezes fib(36)  ?   5 = fib(4)
#   quantas vezes fib(35)  ?   8 = fib(5)
#   ....
#   quantas vezes fib(1)   ?   fib(39) vezes!!!!   


######
#
#                                          40
#                                      /      \ 
#                                   39         38*
#                                 /   \              
#                               38      37*              
#                             /   \           
#                           37    36*      
#                         /  \                 
#                       36   35*
#                      /  \
#                    35   34*
#
#


