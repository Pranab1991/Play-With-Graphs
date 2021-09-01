# PlayWithGraphs

## Introduction:

<p> **Graphs** are a fundamental data structure in the world of programming, one that consists of a finite set of
_vertices_, together with a set of undirected or directed _edges_.
Graphs are very important in the field of computer science. They are used to model real-world systems such as _Internet_,_Maps_,_Social Networks_ _, etc._<br> **Playwithgraph** is a java library to create graph objects with customer data and analyze the data through the _APIs_ provided. This project in its entirety is augmented with _Junit test cases_ modeling real-world scenarios through the library and _Javadocs_ detailing out the intent of the _exposed APIs_</p>

## Getting Started:
<p>PlayWithGraphs has segregated the graphs into _Four_ different types, on the basis of the relationship(_Edge_) between two _Nodes/Vertices.<br>
- **Directed Graph** : A graph where the set of objects (called vertices or nodes) are connected together with edges directed from one vertex to another
- **Undirected Graph** : A graph where the set of objects (called vertices or nodes) are connected together with bidirectional edges.
- **Directed Weighted Graph ** : Is a Directed Graph with edges that have varying strengths or lengths.
-**Undirected Weighted Graph ** : Is an Undirected Graph with edges that have varying strengths or lengths.

All four variants support CRUD operations, however, each of them exposes different querying APIs feasible for the underlying structure. There are numerous blazingly fast algorithms that can be executed on graphs resulting in desirable outcomes, however, for the current iteration/beta release few of them are implemented and are exposed through APIs.

#### Example :
Let's create a **Friendship Graph ** where each person is considered as a *Vertex/Node* of the graph and are connected to each other via *Friend Of* relationship i.e. we create an *Edge* between two-person if they are friends of each other. The below diagram depicts a simple friendship graph.
**Note: ** Edges are bidirectional

|John Doe| <--> |Jane Doe| <--> |Jack Doe|

Below code snippet depicts realization of above graph using AdjencyListUnDirectedGraph(PlayWithGraph's API to design Undirected Graph):
'''java:
private static Graph<String, String> graph = new AdjencyListUnDirectedGraph<>(); // graph created with String key and Strung Value
graph.createNode("john", "John Doe"); //creation of node
graph.createNode("jane", "Jane Doe");'
graph.createNode("jack", "Jack Doe");'
graph.createEdge("john","jane"); //creation of edge between node "John Doe" and "Jane Doe"
graph.createEdge("jane","jack");
'''
</p>

## Documentation:
Extensive Java Docs to give an insight into the functionality of each and every API. The Documentation is not hosted on a public domain, to view download the project and move into the doc folder, and open index.html.

The Project also ships with an ample amount of test cases to give an insight into exposed APIs use cases.

### Thanks
Please feel free to fork/ download the project. There are a lot of areas to improve on, including extensive testing. Help is always appreciated

Connect me on linked in : **[https://www.linkedin.com/in/pranab-bharadwaj-237887176/](https://www.linkedin.com/in/pranab-bharadwaj-237887176/)**

Regards
Pranab Bharadwaj
pranabharadwaj@gmail.com,
pranabbharadwaj@gmail.com