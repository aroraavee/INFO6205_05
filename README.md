# INFO6205_05
Problem : Travelling Saleseperson Problem solve via Genetic Algorithm 

Steps :
1. Random Generation of Cities with its properites like x coordinate , y coordinate and name . All the generated cities are unique and the number of cities depend on the variable mentioned in the Configuration.java file .

2.Adding the above generated cities to a inital Route .

3.Generate the population based on the number mentioned in the configuration file . To generate each route in the population shuffle the inital route .

4.Evolve the initial population and generate the same number of routes as their were in the initial population .

  4.1 Randomly take 5 routes from the inital population and add it to a temporary population . Choose the top 2 routes which are fitest .
  
  4.2 Do a crossover for these 2 routes .
  
  4.3 Do a mutation for the generated child .
  
  4.4 Add the generated child to the new population .
  
  4.5 Repeat step 4.1 to 4.4 till the original population is achived .

5. Evolve the new generated population for the number of times mentioned in the configuration file .

6. Get the fittest route from the last evolved population .
  
