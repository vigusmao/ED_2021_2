from math import log, sqrt, ceil

def exponential(n):
    return 2**n / 10

def cubic(n):
    return n**3 / 5
    
def quadratic(n):
    return 5 * n**2 +  2*n + 476
    
def nlogn(n):
    return 10 * n*ceil(log(n, 2)) + 60*n + 60

def linear(n):
    return 20 * n + 76
    
def sqrtn(n):
    return 30 * ceil(sqrt(n)) + 324
    
def logn(n):
    return 100 * ceil(log(n, 2)) 
    
def constant(n):
    return 1

def identity(n):
    return n

# maps each function to its Big-Oh notation  
functions = [
    (identity, "n"),
    (exponential, "O(2^n)"),
    (cubic, "O(n^3)"),
    (quadratic, "O(n^2)"),
    (nlogn, "O(n log n)"),
    (linear, "O(n)"),
    (sqrtn, "O(sqrt n)"),
    (logn, "O(log n)"),
  #  (constant, "O(1)"),
    ]

while True:
    
    input_values = eval(input("Input values (iterable): "))
    if input_values == 0:
        print("\nCiao!")
        break
    
    # computes the images of each input value
    results = []
    for n in input_values:
        results.append([f[0](n) for f in functions])  

    # computes the maximum length on each column
    lengths = []
    for column in range(len(functions)):
        lengths.append(max((len("%d" % row[column]) for row in results)))    

    msg_format = "".join(["%%%d" % max(11, length + 2) + "s" for length in lengths])

    # prints the header
    print("\n" + msg_format % tuple([f[1] for f in functions]))  

    # prints each results row
    for row in results:
        print(msg_format % tuple(row))

    print("\n")


