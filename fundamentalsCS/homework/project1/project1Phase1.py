#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Mar  9 17:12:30 2024

@author: Sriram Pemmaraju
"""

###############################################################################
#
# Specification: This function uses the binary search algorithm to search for 
# the given word w in the sublist L[first:last+1]. 
# It assumes that L is sorted in non-decreasing order. The function returns -1 if w is 
# not in L; otherwise it returns the index of w in L. If there are multiple occurances 
# of w in L, it just returns the index of an arbitrary occurance of w.
#
###############################################################################
def binarySearch(L, w, first, last):
    if (first > last):
        return -1
    
    mid = (first + last) // 2
    if (w == L[mid]):
        return mid
    elif (w < L[mid]):
        return binarySearch(L, w, first, mid-1)
    else:
        return binarySearch(L, w, mid+1, last)

###############################################################################
#
# Specification: This function searches for the given word w in the given list L by
# calling the binarySearch function. It assumes that L is sorted in non-decreasing order.
# The function returns -1 if w is not in L; otherwise it returns the index of w in
# L. If there are multiple occurances of w in L, it just returns the index of 
# an arbitrary w.
# 
###############################################################################
def getIndex(L, w):
    return binarySearch(L, w, 0, len(L)-1)

###############################################################################
#
# Specification: This function takes two nonempty, equal-length strings w1 and w2 and 
# returns True if w2 is obtained from w1 by replacing one character
# in w1 by another (different) character; otherwise the function returns False. 
#
# Note: The replacement character cannot be identical to the character being replaced.
#
# Examples:
# >>> areNeighbors("Hello", "cello")
# True
# >>> areNeighbors("Hello", "cells")
# False
# >>> areNeighbors("Hello", "hello")
# True
# >>> areNeighbors("Hello", "belto")
# False
# >>> areNeighbors("Hello", "Hello")
# False
#
################################
###############################################
def areNeighbors(w1, w2):
    total=0 
    for L1,L2 in zip(w1,w2): 
        if L1!= L2:
            total+=1
    
    if total==1 :
        return True 
    else:
        return False 

###############################################################################
#
# Specification: The function reads words from the file "words.txt" and creates and
# returns a list with these words. The words should in the same order in the list
# as they appear in the file. Each string in the list of words should be exactly
# 5 characters long.
#
# Examples:
# >>> L = readWords()
# >>> len(L)
# 5757
# >>> L[len(L)-1]
# 'zowie'
# >>> L[0:10]
# ['aargh',
#  'abaca',
#  'abaci',
#  'aback',
#  'abaft',
#  'abase',
#  'abash',
#  'abate',
#  'abbey',
#  'abbot']
# >>> L[1000]
# 'coney'
# >>> sorted(L)==L
# True
#
###############################################################################
def readWords():
    L= open ("words.txt","r")
    l=L.read().splitlines()
    return l

######################################################################


######################################################################
#
# Specification: You are given a list L of distinct, equal-length strings. We 
# define two distinct strings w1 and w2 to be neighbors if w2 can be obtained from 
# w1 by replacing one character in w1 by another (different) character. In other words, w1 and w2 
# are neighbors if areNeighbors(w1, w2) is True. The function is required to return 
# the list of neighbor lists of each word in L. 
#
# EXAMPLE 1
# L = ['added', 'aider', 'aides', 'ailed', 'aimed', 'aired', 'anded', 'bided', 
#      'sided', 'tided']
#
# makeNeighborLists(L) returns
#
# [['anded'],
# ['aides'],
# ['aider'],
# ['aimed', 'aired'],
# ['ailed', 'aired'],
# ['ailed', 'aimed'],
# ['added'],
# ['sided', 'tided'],
# ['bided', 'tided'],
# ['bided', 'sided']]
#
# In this example, "added" is the first word in L and it has one neighbor
# in L, which is "anded". So ["anded"] is the first item in the returned list.
# The 4th word in L is "ailed" and it has two neighbors "aimed" and "aired".
# So the 4th item in the returned list is ["aimed", "aired"].
#
# EXAMPLE 2
# L = ['joked', 'poked', 'toked', 'yokel', 'yokes', 'yodel', 
#      'yoked', 'cokes', 'jokes', 'pokes', 'tokes', 'yikes', 
#      'yores', 'folks', 'yolky', 'folky', 'yolks']
#
# makeNeighborLists(L) returns
#
# [['poked', 'toked', 'yoked', 'jokes'],
# ['joked', 'toked', 'yoked', 'pokes'],
# ['joked', 'poked', 'yoked', 'tokes'],
# ['yokes', 'yodel', 'yoked'],
# ['yokel', 'yoked', 'cokes', 'jokes', 'pokes', 'tokes', 'yikes', 'yores'],
# ['yokel'],
# ['joked', 'poked', 'toked', 'yokel', 'yokes'],
# ['yokes', 'jokes', 'pokes', 'tokes'],
# ['joked', 'yokes', 'cokes', 'pokes', 'tokes'],
# ['poked', 'yokes', 'cokes', 'jokes', 'tokes'],
# ['toked', 'yokes', 'cokes', 'jokes', 'pokes'],
# ['yokes'],
# ['yokes'],
# ['folky', 'yolks'],
# ['folky', 'yolks'],
# ['folks', 'yolky'],
# ['folks', 'yolky']]
#
#
# NOTES
# (i) The neighbor lists should appear in the order corresponding to words in L. In 
# other words if we call the returned list nbrList, then the list of neighbors of
# the word L[0] should appear as nbrList[0].
# (ii) Each list of neighbors should contain words in the same order as in L. For
# example, the neighbor list of "ailed" should be ["aimed", "aired"] rather than
# ["aired", "aimed"].
# (iii) The neighbor relationship is only defined for distinct words. So a word
# cannot be its own neighbor.
#
# ADDITIONAL EXAMPLES:
# >>> L1 = ['added', 'aided', 'bided']
# >>> makeNeighborLists(L1)
# [['aided'], ['added', 'bided'], ['aided']]
# >>> L2 = ['joked', 'jokes', 'yikes', 'yokel', 'yokes']
# >>> makeNeighborLists(L2)
# [['jokes'],
#  ['joked', 'yokes'],
#  ['yokes'],
#  ['yokes'],
#  ['jokes', 'yikes', 'yokel']]
# 
######################################################################
def makeNeighborLists(wordList):
     neighList=[]
     for i in range(len(wordList)):
        neigh=[]
        for j in range(len(wordList)):
            if i != j and areNeighbors(wordList[i], wordList[j]):
                neigh.append(wordList[j])
        neighList.append(neigh)
     return neighList



###############################################################################
#
# Specification: This function takes a non-empty, sorted (in increasing
# alphabetical order) list of words called wordList and the word network of wordList
# represented as the corresponding list of neighbor lists. In addition, it takes
# a word w in wordList and returns the list of neighbors of this word in wordList.
# The returned list of neighbors is sorted (in increasing alphabetical order). 
#
# EXAMPLES:
# >>> L1 = ['added', 'aided', 'bided']
# >>> nL1 = makeNeighborLists(L1)
# >>> getNeighbors(L1, nL1, 'aided')
# ['added', 'bided']
# >>> getNeighbors(L1, nL1, 'added')
# ['aided']
# >>> getNeighbors(L1, nL1, 'bided')
# ['aided']
# >>> L2 = ['joked', 'jokes', 'yikes', 'yokel', 'yokes']
# >>> nL2 = makeNeighborLists(L2)
# >>> getNeighbors(L2, nL2, 'yokes')
# ['jokes', 'yikes', 'yokel']
# >>> getNeighbors(L2, nL2, 'joked')
# ['jokes']
# >>> getNeighbors(L2, nL2, 'jokes')
# ['joked', 'yokes']
#
###############################################################################
def getNeighbors(wordList, nbrsList, w):
     indexW= wordList.index(w)
     return nbrsList[indexW]


###############################################################################
# 
# Specification: This function takes a non-empty, sorted (in increasing
# alphabetical order) list of words called wordList and the word network of wordList
# represented as the corresponding list of neighbor lists. It returns all words 
# with 0 neighbors, i.e., isolated nodes.
#
# EXAMPLES:
# >>> L = ['abbey', 'added', 'aided', 'audio', 'audit', 'bided', 'young']
# >>> nL = makeNeighborLists(L)
# >>> getIsolatedNodes(L, nL)
# ['abbey', 'young']    
# >>> L = ['aargh',
#          'abaft',
#          'abbey',
#          'abbot',
#          'abeam',
#          'abhor',
#          'absit',
#          'abuzz',
#          'abyss',
#          'achoo',
#          'acids',
#          'acrid',
#          'actin',
#          'actor',
#          'acute',
#          'adage',
#          'addle',
#          'adieu',
#          'adios',
#          'adlib']
# >>> nL = makeNeighborLists(L)
# >>> getIsolatedNodes(L, nL)
# ['aargh',
#  'abaft',
#  'abbey',
#  'abbot',
#  'abeam',
#  'abhor',
#  'absit',
#  'abuzz',
#  'abyss',
#  'achoo',
#  'acids',
#  'acrid',
#  'actin',
#  'actor',
#  'acute',
#  'adage',
#  'addle',
#  'adieu',
#  'adios',
#  'adlib']  
#
###############################################################################
def getIsolatedNodes(wordList, nbrsList):
    end=[]
    for i in wordList:
        if len(getNeighbors(wordList,nbrsList, i))==0 :
            end.append(i)
    return end 

###############################################################################
# 
# Specification: This function takes a non-empty, sorted (in increasing
# alphabetical order) list of words called wordList and the word network of wordList
# represented as the corresponding list of neighbor lists. It returns all pairs of 
# nodes that are connected to each other, but to no other node.
# 
# EXAMPLES:
# >>> L = ['abbey', 'added', 'aided', 'audio', 'audit', 'bided', 'young']
# >>> nL = makeNeighborLists(L)
# >>> getIsolatedEdges(L, nL)
# [['audio', 'audit']]
# >>> L.extend(['joked', 'jokes'])
# >>> L.sort()
# >>> nL = makeNeighborLists(L)
# >>> getIsolatedEdges(L, nL)
# [['audio', 'audit'], ['joked', 'jokes']]
# >>> L = ['aided', 'bided', 'sided', 'tided']
# >>> nL = makeNeighborLists(L)
# >>> getIsolatedEdges(L, nL)
# []
#
###############################################################################

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

###############################################################################
# 
# Specification: This function takes a non-empty, sorted (in increasing
# alphabetical order) list of words called wordList and the word network of wordList
# represented as the corresponding list of neighbor lists. It returns the list 
# of words in wordList but in non-decreasing order of degree. Remember that the 
# degree of a node in the network is the number of neighbors it has. Two words 
# with the same degree appear in alphabetical order.
#
# EXAMPLES:
# >>> L1 = ['added', 'aided', 'bided']
# >>> sortByDegree(L1, makeNeighborLists(L1))
# ['added', 'bided', 'aided']
# >>> L2 = ['joked', 'jokes', 'yikes', 'yokel', 'yokes']
# >>> sortByDegree(L2, makeNeighborLists(L2))
# ['joked', 'yikes', 'yokel', 'jokes', 'yokes']  
# >>> L3 = ['added', 'aider', 'aides', 'ailed', 'aimed', 'aired', 'anded', 'bided', 'sided', 'tided']
# >>> sortByDegree(L3, makeNeighborLists(L3))
# ['added',
#  'aider',
#  'aides',
#  'anded',
#  'ailed',
#  'aimed',
#  'aired',
#  'bided',
#  'sided',
#  'tided']
#
###############################################################################
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



###############################################################################
# 
# Specification: This function returns the distributions of the degrees of the nodes
# in the word network specified by wordList and nbrsList. wordList is a non-empty, 
# sorted (in increasing alphabetical order) list of words  and nbrsList is the word 
# network of wordList represented as the corresponding list of neighbor lists. The
# function returns a list of nonnegative integers, where the integer at index i is the
# number of nodes in the word network with degree i. The length of the returned list
# is 1 plus the maximum degree of the word network.
#
# EXAMPLES:
# >>> L1 = ['added', 'aided', 'bided']
# >>> degreeDistribution(L1, makeNeighborLists(L1))
# [0, 2, 1]
# >>> L2 = ['joked', 'jokes', 'yikes', 'yokel', 'yokes']
# >>> degreeDistribution(L2, makeNeighborLists(L2))
# [0, 3, 1, 1]
# >>> L3 = ['added', 'aider', 'aides', 'ailed', 'aimed', 'aired', 'anded', 'bided', 'sided', 'tided']
# >>> degreeDistribution(L3, makeNeighborLists(L3))
# [0, 4, 6]
#
###############################################################################
def degreeDistribution(wordList, nbrsList):
    D=[]
    for i in range(len(wordList)):
        D[wordList[i]]= len(nbrsList[i])
    max_degree= max(D.values())
    dist = [0]*(max_degree+1)
    for word in D:
        dist[D[word]]+=1
    return dist
    
#################################################################################


   

  


