
def signed():
    return(["jackbrand"])



def StateNames(line):
    pieces = line.split(",")
    return pieces[0] + pieces[1][:3]


def Coordinates(line):
    pieces = line.split(",")
    return [int(pieces[1].split("[")[1]), int(pieces[2].split("]")[0])]



def Population(line):
    pieces = line.split(",")
    return int(pieces[2].split("]")[1])



def loadData():
    f = open("miles.txt")
    
    
    cityDataDict = {}
    
    
    cityIndex = 0
    
    
    cityStateNamesList = []
    
    
    for line in f:
        
        
        if line[0].isalpha():
                            
            cityStateName = StateNames(line)
            coords = Coordinates(line)
            pop = Population(line)         
            cityDataDict[cityStateName] = [coords, pop, {}]            
            cityStateNamesList.append(cityStateName)
            index = -2
            cityIndex = cityIndex + 1
        
                   
        elif line[0].isdigit():
            distancesInThisLine = [int(x) for x in line.split()]
            
            for i in range(len(distancesInThisLine)):
                destinationCity = cityStateNamesList[index]
                index = index - 1
                cityDataDict[cityStateName][2][destinationCity] = distancesInThisLine[i]
                cityDataDict[destinationCity][2][cityStateName] = distancesInThisLine[i]
            
    
    return cityDataDict
            

def getCoordinates(cityDataDict, cityName):
    if cityName in cityDataDict:
        return cityDataDict[cityName][0]
    else:
        return None


def getPopulation(cityDataDict, cityName):
    if cityName in cityDataDict:
        return cityDataDict[cityName][1]  
    else:
        return None

   
def getDistance(cityDataDict, cityName1, cityName2):
    if (cityName1 in cityDataDict) and (cityName2 in cityDataDict):
        if (cityName1 != cityName2):
            return cityDataDict[cityName1][2][cityName2]
        else:
            return 0
    else:
        return None


def nearbyCities(cityDataDict, cityName, r):
    if cityName not in cityDataDict:
        return None
    
    nearbyCityList = [cityName]
    for city in cityDataDict:
        if (city != cityName) and (cityDataDict[cityName][2][city] <= r):
            nearbyCityList.append(city)

    return nearbyCityList



def find_unserved_cities(cityDataDict, served, c, r):
    unserved_cities = []
    for city in cityDataDict:
        if city not in served and getDistance(cityDataDict, c, city) <= r:
            unserved_cities.append(city)
    return unserved_cities

def greedyFacilitySet(cityDataDictionary, r):
    served = set()
    facility_set = []
    
    while len(served) < len(cityDataDictionary):
        max_unserved = 0
        best_city = None
        
        for city in sorted(cityDataDictionary.keys()):
            unserved_cities = find_unserved_cities(cityDataDictionary, served, city, r)
            if len(unserved_cities) > max_unserved:
                max_unserved = len(unserved_cities)
                best_city = city
        
        if best_city:
            facility_set.append(best_city)
            served.update(find_unserved_cities(cityDataDictionary, served, best_city, r))
    
    return facility_set


def is_valid_solution(cityDataDictionary, r, facility_set):
    served_set = set()
    for facility in facility_set:
        for city in cityDataDictionary:
            if getDistance(cityDataDictionary, facility, city) <= r:
                served_set.add(city)
    return len(served_set) == len(cityDataDictionary)

def get_combinations(cities, num_facilities, start_index=0, current_combination=[]):
    if len(current_combination) == num_facilities:
        yield current_combination
    else:
        for i in range(start_index, len(cities)):
            new_combination = current_combination + [cities[i]]
            yield from get_combinations(cities, num_facilities, i + 1, new_combination)

def optimalFacilitySet(cityDataDictionary, r, oneSolution):
    num_facilities_in_oneSolution = len(oneSolution)
    all_cities = list(cityDataDictionary.keys())

    for i in range(num_facilities_in_oneSolution - 1, 0, -1):
        for combo in get_combinations(all_cities, i):
            if is_valid_solution(cityDataDictionary, r, combo):
                return list(combo)

    return []

cityDataDictionary = loadData()

oneSolution = ['Ravenna OH', 'Red Bluff CA']
print(optimalFacilitySet(cityDataDictionary, 5000, oneSolution) == ['Youngstown OH'])
print(optimalFacilitySet(cityDataDictionary, 10, oneSolution) == [])
oneSolution = greedyFacilitySet(cityDataDictionary, 1000)
print(optimalFacilitySet(cityDataDictionary, 1000, oneSolution) == ['Youngstown OH', 'Yankton SD', 'Vicksburg MS', 'Stockton CA'])
oneSolution = greedyFacilitySet(cityDataDictionary, 1200)
print(optimalFacilitySet(cityDataDictionary, 1200, oneSolution) == ['Vincennes IN', 'Twin Falls ID'])
print(optimalFacilitySet(cityDataDictionary, 1200, ['Vincennes IN', 'Twin Falls ID']) == [])
oneSolution = greedyFacilitySet(cityDataDictionary, 900)
print(optimalFacilitySet(cityDataDictionary, 900, oneSolution) == ['Yankton SD', 'Winston-Salem NC', 'Wichita Falls TX', 'Weed CA'])
print(optimalFacilitySet(cityDataDictionary, 900, ['Yankton SD', 'Winston-Salem NC', 'Wichita Falls TX', 'Weed CA']) == [])







