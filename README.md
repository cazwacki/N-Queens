This demonstrates a series-based algorithmic solution to the N-Queens problem.

The N-Queens problem is a puzzle where 'N' queens must be placed on an 'N'x'N' chessboard such that no queen can attack any other queen on the board. As the board grows in size, the number of possible arrangements of queens increases at a multiplicative rate; hence a brute force method for determining the number of valid unique or distinct solutions becomes less viable as the size of the board increases. Consequently, researchers interested in combinatorics, algorithm development, and artificial intelligence have developed many approaches to the N-Queens problem. Here is a comparison of various interesting approaches to solving the N-Queens problem.

The following algorithm has been adapted to handle any board size greater than 7:

[A New Approach to Solve N-Queens Problem Based on Series](https://www.researchgate.net/publication/321192822_A_new_approach_to_solve_n-queens_problem_based_on_series):
Vishal Kesri and Manoj Kumar Mishra of KIIT University propose an algorithm that is composed of two rules and eight series (listed in the document). The solution calculation is based on the following flowchart:

1) Intake the dimension of the board ('v' x 'v') and the number of queens that need to be placed.
2) Determine under which series the value v falls under:
  - Series 1: f(x) = 6x,        x > 1, x ∈ Z (the set of integers) 
  - Series 2: f(x) = 6x + 1,    x > 1, x ∈ Z
  - Series 3: f(x) = 6x + 4,    x ≥ 1, x ∈ Z
  - Series 4: f(x) = 6x + 5,    x ≥ 1, x ∈ Z 
  - Series 5: f(x) = 12x + 8,   x ≥ 0, x ∈ Z 
  - Series 6: f(x) = 12x + 9,   x ≥ 0, x ∈ Z 
  - Series 7: f(x) = 12x + 14,  x ≥ 0, x ∈ Z 
  - Series 8: f(x) = 12x + 15,  x ≥ 0, x ∈ Z
3) Perform the commands reference in the document (a set of MV's and possible application of rule 1 or rule 2 specified in the document).
