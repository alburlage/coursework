#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Apr 14 16:43:51 2024

@author: sriram
"""

# CS1210: Project 2 Phase 1 [5 functions to complete]
###############################################################################
# Complete the signed() function, certifying that:
# 1) the code below is entirely your work, and
# 2) it has not been shared with anyone outside the instructional team.
#
# ToDo: Change the words "hawkid" between the two double quote marks
# to match your own hawkid. Your hawkid is the "login identifier" you use
# to login to all University services, like `https://myUI.uiowa.edu/'
#
#
# Note: we are not asking for your password, just the login
# identifiers: for example, mine is "sriram".
#
###############################################################################
def signed():
    return(["alburlage"])

###############################################################################
#
# Specification: Reads information from the files "miles.txt" and loads all the 
# data from the file into a giant dictionary and returns this dictionary. The 
# organization of this dictionary has been specified in detail in the Project 2 handout. 
# If, for some reason, "miles.txt" is missing, your function should gracefully
# finish, returning the empty dictionary {}.
# 
###############################################################################
def loadData():
    try:
        with open("miles.txt", "r") as file:
            cityDataDict={}
            for line in file:
                comp= line.strip().split('[')
                if len(comp)<2:
                    continue 
                cityName, rest= comp[0].strip().rsplit(',',1)
                stateCode = rest.strip()[-2:] 
                cityName= cityName.strip()+" "+ stateCode

                coordinates =  [int(coord.strip()) for coord in comp[1].split(']')[0].split(',')]


                population = None
                if len(comp)>1:
                    restComp= comp[1].split(']')
                    if len(restComp)>1:
                        population= int(restComp[1].strip())
                
                distances= {}
                if len(comp)>3:
                    distancesInfo = comp[3].split()
                    for i, distance in enumerate(distancesInfo):
                        cityKey= list(cityDataDict.keys())[i]
                        distances[cityKey]= int(distance)
                
                cityDataDict[cityName]= [coordinates, population, distances]

    

    except FileNotFoundError:
        return ()
    return cityDataDict

print(loadData())
###############################################################################
#
# Specification: takes the dictionary that contains all the information associated 
# with the cities and a particular city name and returns the coordinates (which is a 
# list of 2 integers) of the given city. If, for some reason, cityName is not a key
# in cityDataDict, it returns None.
#
###############################################################################
def getCoordinates(cityDataDict, cityName):
    pass

###############################################################################
#
# Specification: takes the dictionary that contains all the information associated 
# with the cities and a particular city name and returns the population (which is a 
# positive integer) of the given city. If, for some reason, cityName is not a key
# in cityDataDict, it returns None.
#
###############################################################################
def getPopulation(cityDataDict, cityName):
    pass

###############################################################################
#
# Specification: takes the dictionary that contains all the information associated 
# with the cities and two city names and returns the distance (an integer) 
# between cities cityName1 and cityName2. If cityName1 and cityName2 are identical, 
# it returns 0. If either cityName1 or cityName2 are not in cityDataDict, it returns
# None.
#
###############################################################################    
def getDistance(cityDataDict, cityName1, cityName2):
    pass

###############################################################################
#
# Specification: The function takes 3 paramaters:
#    
# cityDataDict: the dictionary that contains all the information associated 
# with the cities
# 
# cityName: is a name of a city
#
# r: is a non-negative floating point number
#
# The function returns a list of cities at distance at most r from the given city,
# cityName. This list can contain the names of cities in any order. If cityName is
# not a key in cityDataDict, the function should return None.
#
###############################################################################
def nearbyCities(cityDataDict, cityName, r):
    pass
