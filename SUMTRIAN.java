import java.io.*;
import java.util.*;

public class SUMTRIAN2 {

    private BufferedReader br;
    private PrintWriter pr;
    
    public SUMTRIAN2() {

	// br = new BufferedReader(new InputStreamReader(System.in));
	// pr = new PrintWriter(System.out);
	try {
	    br = new BufferedReader(new InputStreamReader(new FileInputStream("testinput.txt")));
	} catch (FileNotFoundException e) {
	    System.out.println("FNFex: " + e.getMessage());
	}
    }

    public void solve() throws Exception {
	int testCases = Integer.parseInt(br.readLine());

	for (int i = 0; i < testCases; i++) {
	    int treeHeight = Integer.parseInt(br.readLine());

	    // the size of the tree with height n is at most n(n + 1) / 2
	    // so an array of this size will hold the triangle tree
	    int arraySize = (treeHeight * (treeHeight + 1)) / 2;
	    int[] tree = new int[arraySize];
	    int arrayIndex = 0;

	    Scanner sc;
	    for (int j = 0; j < treeHeight; j++) {
		sc = new Scanner(br.readLine());
		while (sc.hasNextInt()) {
		    int inputValue = sc.nextInt();
		    tree[arrayIndex] = inputValue;
		    arrayIndex++;
		}
	    }

	    // Creating a new sumTree to hold the sums as we proceed
	    // through the input tree
	    int[] sumTree = new int[arraySize];

	    // Start by filling out the leaves as their max sum
	    // is equal to their value
	    int indexOfFirstLeaf = tree.length - treeHeight;
	    for (int j = indexOfFirstLeaf; j < tree.length; j++) {
		sumTree[j] = tree[j];
	    }

	    // Run backwards through the sumTriangle, starting at index
	    // indexOfFirstLeaf-1 (the last node before the leaves)
	    // and insert the greatest sum possible for each nodes subtree
	    int currentLevelOfSumTree = treeHeight - 1;
	    int numbersLeftToUpdateAtThisLevel = currentLevelOfSumTree;
	    for (int j = indexOfFirstLeaf - 1; j >= 0; j--) {
		// the child-nodes of the node i can be found by
		// (ownIndex + currentLevelOfSumTree) and
		// (ownIndex + currentLevelOfSumTree + 1)
		int child1Index = (j + currentLevelOfSumTree);
		int child2Index = (j + currentLevelOfSumTree + 1);
		sumTree[j] = Math.max(tree[j] + sumTree[child1Index],
				      tree[j] + sumTree[child2Index]);
		numbersLeftToUpdateAtThisLevel--;
		if (numbersLeftToUpdateAtThisLevel == 0) {
		    currentLevelOfSumTree--;
		    numbersLeftToUpdateAtThisLevel = currentLevelOfSumTree;
		}
	    }
	    
	    // prints the root of the tree, which is the larges sum possible
	    pr.println(sumTree[0]);
	}
    }

    public static void main(String[] args) {
	SUMTRIAN2 test = new SUMTRIAN2();
	try {
	    test.solve();
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }
    
}