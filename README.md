# INFO6205_05 : Team 05 
Traveling Salesman Problem solved with Genetic Algorithm 

Presentation link : https://prezi.com/view/4ZR3MRhKlw1XKs5HlUqf/ (Open in Chrom Browser ) .

Solution :  
1.Gene and Chromosome  
1.1For the TSP we have considered the following properties for a city .  
	1.2Each city have a name , x coordinate , y coordinate
	1.3Consider we have a list of 5 cities with properties as city1|0|100  , city2|0|200 etc   
	1.4So these cities are the genes for our problem and the traits are name and coordinates .  
	1.5These genes will be creating a chromosome and for our problem the chromosome represents the route the salesman will be following .  
	eg route 1 : city1 -->city2-->city3-->city4-->city5  
	
2.Initial Population Generation  
	2.1We have a configuration.java file which stores all the global parameter needed for our code .  
	2.2We are randomly generating the cities with random x and y coordinates .  
	2.3All the cities are unique .  
	2.4After generation of a city we add it to a arraylist and generate an initial route .  
	2.5We randomly shuffle the initial route to get a new route .  
	2.5We then add our new route to the initial population .  
	2.7The count for our initial population equals to the count in our configuration file for number of population .  

3.Generation of new population with a selection criteria   	
	3.1We generate a temporary population of 5 routes which is a subset of the initial population .  
	3.2To get the subset we randomly generate file numbers which are in the range of our total population .  
	3.3Then we find the top two fittest route from our subset .  
	3.4The fitness function is the inverse of the total distance of the route .  
	3.5We send these two fittest route for the crossover .  

4.Crossover  
	4.1We choose two random value in the range of number of cities (0,4 as we have 5 cities) .  
	eg : 1 and 4 are chosen random number   
	4.2Then we take the genes between these range for our Child chromosome and the rest of the gene are choosen from chromosome 2 .  
5.Mutation  
	5.1We do the mutation based on the mutation factor (0.001) .  
	5.2We generate a random number and if it is less than the mutation factor we do the mutation .  
	5.3In mutation we randomly take 2 cities and swap them .  
6.Evolution  
	6.1Add the newly generated chromosome into a new population list .  
	6.2We also add the fittest parent to our new population .  
	6.3Generate the new routes till the time we have the same number as in the initial population .  
	6.4Now Evolve the generated population again for N times .  
	6.5Now the initial population becomes the new population that we generated .  
	6.6After generation of N runs , find the fittest route from the last evolved population .   
	
Unit Test :  
Validate Distance calculation  
Validate Fitness Function  
Validate Fitest route   
Validate number of cites from fitest route  
Validate for Null Values  
Random validation after Mutation  

Logs :  
Log4J   
a log.out file is generated in the folder   
It contains  :  
Initial population  
Initial route   
Initial Fittest number   
Initial Distance   
Fittest Route  
Fittest number  
Fittest Distance   
Number of city , population and evolution .  
Errors and Exceptions  

Parallel Execution Process :  

1.For Parallel execution we have used Java 8 Futures .  
2.We are generating our Child's in parallel .  
3.The number of Child's generated per future depends on the fraction (Number of population / Number of City).  
4.The number of future depends on the fraction (number of population /(Number of population / Number of City)).  
5.After that we are combining each of the generated sub population into the evolved population .  
6.Code is located in a separate folder :INFO6205_Team05_parallel  

How to Execute ?  
1.Download the repository   
2.It has two folders INFO6205_Team05_parallel and INFO6205_Team05  
3.INFO6205_Team05 is the non parallel version   
4.To change the parameters go to the Configuration.java where you can change the value for number of city,number of population ,number of evolution , mutation rate .  
5.Go to the test package : Team05Test and run the test , the output will be in the console .  
6.A log file with the name log.out will be generated in the project folder .  
7.To see a graphical representation , run the file Team5GA.java which is in the team05ga folder .  
8.Two graphs will be generated , one for the initial route and the other for the final route .  
