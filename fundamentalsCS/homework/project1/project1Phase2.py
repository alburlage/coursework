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