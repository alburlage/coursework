#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Mar  9 17:12:30 2024

@author: Sriram Pemmaraju
"""

###############################################################################     
#
# Specification: This function takes a non-empty, sorted (in increasing
# alphabetical order) list of words called wordList and the word network of wordList
# represented as the corresponding list of neighbor lists. It also take a word
# called source and it performs a breadth first search of the word network starting from
# the word source. It returns a list containing two lists: (i) the parents of all words 
# reached by the search and (ii) the distances of these words from the source word.    
#
# Examples: 
# >>> L1 = ['added', 'aided', 'bided']
# >>> nL1 = makeNeighborLists(L1)
# >>> searchWordNetwork(L1, nL1, "aided")
# [['aided', '', 'aided'], [1, 0, 1]]
# >>> searchWordNetwork(L1, nL1, "added")
# [['', 'added', 'aided'], [0, 1, 2]]
#
# Notes: 
# (a) If the length of wordList is n, then the returned list contains two lists,
# each of length n.
# (b) If the returned list is [L1, L2] and a word w has index i in wordList, then
# the parent information of w is stored in L1[i] and the distance information of
# w is stored in L2[i].
# (c) The parent information of a word is "" if it is the source word or if it
# is not reachable from the source word.
# (d) The distance information for any word that is not reachable from the source
# word is -1.
#
# Two more examples: 
# >>> L2 = ["bided", "bides", "sided", "sides", "tided", "tides"]
# >>> nL2 = makeNeighborLists(L2)
# >>> searchWordNetwork(L2, nL2, "tides")
# [['bides', 'tides', 'sides', 'tides', 'tides', ''], [2, 1, 2, 1, 1, 0]]
#
###############################################################################
#functions from phase 1
def readWords():
    L= open ("words.txt","r")
    l=L.read().splitlines()
    return l
def areNeighbors(w1, w2):
    total=0 
    for L1,L2 in zip(w1,w2): 
        if L1!= L2:
            total+=1
    
    if total==1 :
        return True 
    else:
        return False 
    
def makeNeighborLists(wordList):
     neighList=[]
     for i in range(len(wordList)):
        neigh=[]
        for j in range(len(wordList)):
            if i != j and areNeighbors(wordList[i], wordList[j]):
                neigh.append(wordList[j])
        neighList.append(neigh)
     return neighList
def getNeighbors(wordList, nbrsList, w):
     indexW= wordList.index(w)
     return nbrsList[indexW]
def getIsolatedNodes(wordList, nbrsList):
    end=[]
    for i in wordList:
        if len(getNeighbors(wordList,nbrsList, i))==0 :
            end.append(i)
    return end 
def getIsolatedEdges(wordList, nbrsList):
    l = []
    for i in range(len(wordList)):
       current= getNeighbors(wordList,nbrsList,wordList[i])
       if len(current)==1:
           if (getNeighbors(wordList,nbrsList,current[0]))==1:
               word=[wordList[i],current[0]]
               word.sort()
               if word not in edge: 
                   l.append(word)
    return l
def sortByDegree(wordList, nbrsList):
    degrees = {} 
    for word in wordList:
        degrees[word] = len(nbrsList[wordList.index(word)])  
    for i in range(1, len(wordList)):
        current_word = wordList[i]
        current_degree = degrees[current_word]
        j = i - 1
        while j >= 0 and degrees[wordList[j]] > current_degree:
            wordList[j + 1] = wordList[j]
            j -= 1
        wordList[j + 1] = current_word

    return wordList
def degreeDistribution(wordList, nbrsList):
    D=[]
    for i in range(len(wordList)):
        D[wordList[i]]= len(nbrsList[i])
    max_degree= max(D.values())
    dist = [0]*(max_degree+1)
    for word in D:
        dist[D[word]]+=1
    return dist
###########################################################################################

def searchWordNetwork(wordList, nbrsList, source):
    parents = {word: "" for word in wordList}
    distances = {word:-1 for word in wordList}
    qu=[source]
    distances[source]=0 
    parents[source]=None
    nbrsDict = dict(zip(wordList,nbrsList))
    while qu:
        currentWord = qu.pop(0)
        for neighbor in nbrsDict[currentWord]:
            if distances[neighbor]==-1:
                distances[neighbor]= distances[currentWord]+1
                parents[neighbor]=currentWord if parents[currentWord]!= "" else currentWord
                qu.append(neighbor)
    parentList = ["" if word == source else parents[word] for word in wordList]
    distanceList = [distances[word] for word in wordList]
    return [parentList, distanceList]


###############################################################################     
#
# Specification: This function takes a non-empty, sorted (in increasing
# alphabetical order) list of words called wordList and the word network of wordList
# represented as the corresponding list of neighbor lists. It also take a word
# called source and a word called target. The function returns a shortest path
# from the source word to the target word, if there is a path between these two
# words. Otherwise, the function returns []. This function calls searchWordNetwork
# to compute the parent list and then follows the parent pointers from target 
# to source to compute a path; this path is then reversed and returned.
#
# Examples: 
# >>> L2 = ["bided", "bides", "sided", "sides", "tided", "tides"]
# >>> nL2 = makeNeighborLists(L2)
# >>> findPath(L2, nL2, "tides", "sided")
# ['tides', 'sides', 'sided']
# >>> L3 = ["curse", "curve", "nurse", "parse", "passe", "paste", "purse", "taste"]
# >>> nL3 = makeNeighborLists(L3)
# >>> findPath(L3, nL3, "curve", "taste")
# ['curve', 'curse', 'purse', 'parse', 'passe', 'paste', 'taste']
#
###############################################################################
def findPath(wordList, nbrsList, source, target):
    if source not in wordList or target not in wordList:
        return []
    parentList,distanceList = searchWordNetwork(wordList,nbrsList, source)
    if distanceList[wordList.index(target)] == -1:
        return []
    path = []
    currentWord= target
    while currentWord is not None:
        path= [currentWord]+path
        if currentWord == source: 
            break
        currentWord = parentList[wordList.index(currentWord)]
    
    return path 

###############################################################################     
#
# Specification:  This function takes a non-empty, sorted (in increasing
# alphabetical order) list of words called wordList and the word network of wordList
# represented as the corresponding list of neighbor lists. It returns the list of
# connected components in the word network.
#
# Definition: A connected component of a network is the set of all nodes that can
# be reached from each other via paths in the network.
#
# Examples: 
# >>> L3 = ["curse", "curve", "nurse", "parse", "passe", "paste", "purse", "taste"]
# >>> nL3 = makeNeighborLists(L3)
# >>> findComponents(L3, nL3)
# [['curse', 'curve', 'nurse', 'parse', 'passe', 'paste', 'purse', 'taste']]   
# >>> L4 = L3 +["sided", "tided", "bided"]
# >>> L4.sort()
# >>> nL4 = makeNeighborLists(L4)
# >>> findComponents(L4, nL4)
#  [['bided', 'sided', 'tided'],
#   ['curse', 'curve', 'nurse', 'parse', 'passe', 'paste', 'purse', 'taste']]
# >>> L5 = ["abhor"] + L4
# >>> nL5 = makeNeighborLists(L5)
# >>> findComponents(L5, nL5)
# [['abhor'],
#  ['bided', 'sided', 'tided'],
#  ['curse', 'curve', 'nurse', 'parse', 'passe', 'paste', 'purse', 'taste']]
#
# Notes: 
# (a) The nodes in each connected component should appear in the same order
# as they appear in wordList. 
# (b) The components themselves should be sorted by the first word in the component.
#
###############################################################################            
def findComponents(wordList, nbrsList):
    visited= set()
    components= []
    nbrsIndex={}
    for i in range(len(wordList)):
        nbrsIndex[wordList[i]]=i
    
    for word in wordList: 
        if word not in visited:
            s = [word]
            currentCom = []
            while s: 
                currentWord = s.pop()
                if currentWord not in visited:
                    visited.add (currentWord)
                    currentCom.append(currentWord)
                    for n in nbrsList[nbrsIndex[currentWord]]:
                        if n not in visited:
                            s.append(n)
            n= len(currentCom)
            for i in range(n):
                for j in range(0, n-i-1):
                    if wordList.index(currentCom[j])> wordList.index(currentCom[j+1]):
                        currentCom[j],currentCom[j+1]=currentCom[j+1], currentCom[j]
            components.append(currentCom)
            
    return components

############################################################################
def totalFunction():
    l= readWords()
    nL= makeNeighborLists(l)

#a:
    sourceWord="abode"
    parentList, distanceList= searchWordNetwork(l, nL, sourceWord)
    farthDistance = max(distanceList)
    print('a:', farthDistance)
#b: 
    farthWord= []
    for i in range(len(l)):
        if distanceList[i]== farthDistance:
            farthWord.append(l[i])
    print ('b:', farthWord)

    
#c:
    p1= findPath(l,nL,'abode','house')
    p2= findPath(l,nL, 'sweet','yucky')
    p3= findPath(l,nL, 'index','third')
    p4= findPath(l,nL, 'wheel','turns')
    p5= findPath(l,nL, 'lucky','break')
    q3final=[p1,p2,p3,p4,p5]
    print('c:',q3final)

#d:
    comp= findComponents(l,nL)
    numOfComp= len(comp)
    print('d:',numOfComp)
#e:
    largeCompSize= []
    for i in range(0, numOfComp-1):
        indicisualComp= comp[i]
        largeCompSize.append(len(indicisualComp))
        maxComp= max(largeCompSize)
    print('e:', maxComp)


#f: 
    firstTen=[]
    for i in comp:
        if len(i)== maxComp:
            firstTen.append(i[:10])

#g;
    size=[]
    for component in range(len(comp)):
        if len(comp[component]) == 8:
            size.append(comp[component])
    print ('g:', size)

print(totalFunction())
