# fib(n) ->    1, 1, 2, 3, 5, 8, 13, 21, ...
#  n ->        0, 1, 2, 3, 4, 5,  6,  7



def fib(n):

    if n <= 1:
        return 1

    return fib(n-1) + fib(n-2)


for i in range(61):
    print i, "-->", fib(i)

#   fib(40)
#   quantas vezes fib(40)  ?   1
#   quantas vezes fib(39)  ?   1
#   quantas vezes fib(38)  ?   2
#   quantas vezes fib(37)  ?   3
#   quantas vezes fib(36)  ?   5
#   quantas vezes fib(35)  ?   8
#   quantas vezes fib(1)   ?   fib(39) vezes!!!!   




