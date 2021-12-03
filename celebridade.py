from random import random
from time import time

def printarMatriz(matriz):
    n = len(matriz)
    for i in range(n):
        print(matriz[i])


def criarFesta(n, celebridade):
    A = [None] * n
    for i in range(n):
        linha = [False] * n
##        for j in range(n):
##            if random() < 0.5:
##                linha[j] = True
        A[i] = linha

    if celebridade is not None:
        for x in range(n):
            A[celebridade][x] = False
            A[x][celebridade] = True

    return A
    

def encontrarCelebridadeQuadratico(matrizRelacionamentos):

    n = len(matrizRelacionamentos)

    for i in range(n):  # O(n) iterações

        podeSerCelebridade = True

        # percorremos a i-ésima linha
        for j in range(n):                 # O(n) iterações

                                                # -----------------
            # não importa se a pessoa conhece a si própria!    
            if j == i:
                continue 
 
            # i conhece j?         
            if matrizRelacionamentos[i][j]:                   
                # i não é celebridade
                podeSerCelebridade = False
                break                           # ----------------- O(1)

        if not podeSerCelebridade:
            continue  # passando diretamente para outro candidato a celebridade (i)

        # percorremos a i-ésima coluna
        for j in range(n):

            # não importa se a pessoa conhece a si própria!
            if j == i:
                continue

            # j conhece i?
            if not matrizRelacionamentos[j][i]:
                # i não é celebridade
                podeSerCelebridade = False
                break

        if podeSerCelebridade:
            # Opa! Encontramos!
            return i
        
    return None


def encontrarCelebridadeLinear(matrizRelacionamentos):

    candidato = 0

    # PRIMEIRA FASE: vou eliminar n-1 candidatos rapidamente
    for x in range(n):          # O(n) iterações
        if x == candidato:      # -------------
            continue

        # vou eliminar alguém!!
        if matrizRelacionamentos[candidato][x]:
            candidato = x       # ----------  O(1)
    

    # SEGUNDA FASE:agora que temos apenas um candidato, vamos ao interrogatório

    # percorremos a linha do candidato
    for j in range(n):              # O(n) iterações

                                            # -----------------
        # não importa se a pessoa conhece a si própria!    
        if j == candidato:
            continue 

        # candidato conhece j?         
        if matrizRelacionamentos[candidato][j]:                   
            return None                     # ----------  O(1)

    # percorremos a coluna do candidato
    for i in range(n):              # O(n) iterações

                                            # -----------------
        # não importa se a pessoa conhece a si própria!    
        if i == candidato:
            continue 

        # i conhece o candidato?         
        if not matrizRelacionamentos[i][candidato]:                   
            return None                     # ----------  O(1)

    # sobreviveu até aqui, então é celebridade
    return candidato

    

###     Análise do quadrático
###     O(n) * [O(1) + O(n) + O(1) + O(n) + O(1)]  =
###     O(n) * O(n) =
###     O(n^2)

###     Análise do linear
###     O(n) + O(n) + O(n) =
###     O(3n) =
###     O(n)



###    0 0 0 0 0 0 0 0
###    0 0 0 0 0 0 0 0
###    0 0 0 0 0 0 0 0
###    0 0 0 0 0 0 0 0
###    0 0 0 0 0 0 0 0
###    0 0 0 0 0 0 0 0
###    0 0 0 0 0 0 0 0
###    0 0 0 0 0 0 0 0


while True:
    n = int(input("Quantos convidados? "))
    if n < 0:
        break

    print("Criando matriz...")
    inicio = time()
    matriz = criarFesta(n, n-1)
    duracao = time() - inicio
    print("Matriz criada em %.6fs" % duracao)    
    
    inicio = time()
    celeb = encontrarCelebridadeLinear(matriz)
    duracao = time() - inicio

    print("Celebridade: %d (tempo: %.6fs)\n\n" % (celeb, duracao))
    




 
