/**************************************************************************************************************************

Sergio Garcia

COMP 282 Vasikarla S.

09/30/2023

What is a 234 Tree?
A 2-3-4 tree is a type of self-balancing search tree that is commonly used in computer science for organizing and searching data. 
It is a form of a B-tree, which is a balanced tree data structure. 
The name "2-3-4" comes from the possible number of children each internal node can have:

2-Node: A 2-node has one key and two children.
3-Node: A 3-node has two keys and three children.
4-Node: A 4-node has three keys and four children.

In a 2-3-4 tree, each leaf node contains one key, and each internal node can have up to three keys. 
The keys are stored in sorted order within each node. The tree maintains the following properties to ensure balance:

All leaves are at the same level.
Every internal node with k keys has k+1 children.
All leaves contain one key and no children.

Insertions and deletions in a 2-3-4 tree involve restructuring the tree to maintain its balance. 
When a 4-node is encountered during an insertion, the tree splits the node into two 2-nodes. 
Similarly, a deletion might involve merging nodes to maintain the balance.
The balanced structure of 2-3-4 trees ensures efficient searching, insertion, and deletion operations, 
  making them suitable for various applications in database systems and file systems. 
However, due to their complexity, other self-balancing tree structures like red-black trees are often preferred in practice.

TASK
- Create a 2_3_4 Tree with insertion, deletion, search, and display/show operations
- Starting with an empty tree, perform the following tests.
insert: 17, 15, 49, 34, 76, 59, 97, 69, 46, 86, 20, 99, 22, 52, 89, 57, 10, 41, 75, 37.
then... 
delete: 99, 22, 69, 15, 10, 75

**************************************************************************************/
