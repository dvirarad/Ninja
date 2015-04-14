# Ninja
## Algorithms for 3D printing of graphs
####*Jeremie Gabay, Dvir Arad*

>Main goal of the project is to print electrical panels in any form. [pdf read me](doc/Report1-Eng.docx.pdf)

##### Summary
>3D printing is rapidly becoming a standard in high scale manufacture. From car parts to prosthetics, this technology is very promising and will without a doubt play a central role in the future of mankind.
	Our project is to implement a set of algorithms that will make possible the printing of complex graphs under specific conditions and restrictions. For example, a graph without any edge crossing.
	This kind of technology might come in handy in the electric engineering field (printing of full-featured printed circuits under restrictions of size or volume) or in the medical field (printing of nervous implants, blood vessels or even grey matter) and probably in countless other fields, where manufacturing product may be seen as a graph-like objects.

##### Motivation
>Prof. Vadim E. Levit, our Algorithms teacher and Head of the Department of Computer Science and Mathematics at Ariel University, suggested Graph Theory as a research subject, particularly the 3D printing of graphs.
	Since 3D printing is a vast, interesting area of research and discoveries yet to be made, we agreed to board on this research/journey with our well-appreciated teacher.
	Needless to say that all the possible applications such a technology might close a little more the gap to are also a very strong source of motivation.

##### Proof
As mentioned in our first report, we must, first and foremost, [prove](doc/proof .pdf) that any given graph can be embedded in 3-dimensional space without any edge-crossing (intersections between edges).


##### Diagrams and general behaviour of the Algorithm
Our Algorithm mainly consists of 3 modules:

  1. Parsing in the .txt file
  2. Running the computing algorithm
  3. Parsing out to VRML format
  
```  
PARSING IN
a. receives preformatted text file
b. prepares it for the computing main algorithm
c. outputs range, condition & adjacency matrix
END PARSING IN
```
```
MAIN ALGORITHM -> call Get3DEmbedding(...)
METHOD Get3DEmbedding(vSize, condition, range)
vSize - the amount of vertex
	condition - spacial limits
	range - distance between vertices
	vertices - array of vertex
	
	numberOfPlanes <- getNumberOfPlanes(vSize)
	surfaces <- arrays of surface equations with size numberOfPlanes
	FOR i <- 0 to vSize
		DO temp <- random vertex according to condition & range
		WHILE (belongsToSurface(temp))
			
		addPlanes(temp)
		vertices <- temp
	END FOR
END METHOD
METHOD int getNumberOfPlanes(int size)
	numberOfPlanes <- 1
	FOR i <- 3 to size
		n <- n+(size*(size-1))/2
	END FOR	
	
	return numberOfPlanes
END METHOD
METHOD addPlanes(vertex ver)
	IF vertices.size >= 2
	THEN FOR  i <- 0 to vertices.size
			FOR  j <- i+1 to vertices.size
			add new surface(vertex.get(i), vertex.get(j), ver)) to surfaces
			END FOR
		END FOR
	END IF 
END METHOD	
METHOD boolean belongsToSurface(vertex vertex)
	FOR EACH surface in surfaces 
		IF vertex is on surface 
		THEN
			return true
		END IF
	END FOR	
	return FALSE
END METHOD
END MAIN ALGORITHM
```
```
PARSING OUT
a. converts vertices & adj. matrix to VRML-formatted text
b. output generated text to a .vrml file
END PARSING OUT
```


[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/dvirarad/ninja/trend.png)](https://bitdeli.com/free "Bitdeli Badge")

