import java.io.*;
import java.util.*;

public class TLG {

    private BufferedReader br;
    private PrintWriter pr;
    private Scanner sc;
    
    public TLG() {

	//br = new BufferedReader(new InputStreamReader(System.in));
	sc = new Scanner(System.in);
	pr = new PrintWriter(System.out, true);

	/*
	try {
	    br = new BufferedReader(new InputStreamReader(new FileInputStream("testinput.txt")));
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
	*/	
	
    }

    public void solve() throws Exception {

	int numberOfRounds = sc.nextInt();
	int firstPlayerPoints = 0;
	int secondPlayerPoints = 0;
	int highscoreLead = 0;
	int playerNumber = 0;

	// running through all the games
	for (int i = 0; i < numberOfRounds; i++) {
	    // adding the players points for the current round to their totals
	    firstPlayerPoints += sc.nextInt();
	    secondPlayerPoints += sc.nextInt();

	    // calculating the lead for this current round
	    int leadPointDiff = firstPlayerPoints - secondPlayerPoints;
	    int leadPointDiffAbsolute = leadPointDiff < 0 ? -leadPointDiff : leadPointDiff;

	    // check if currentLead is higher than the highscoreLead
	    if (leadPointDiffAbsolute > highscoreLead) {
		highscoreLead = leadPointDiffAbsolute;
		// we need to update the leading player
		if (leadPointDiff > 0) {
		    playerNumber = 1;
		} else {
		    playerNumber = 2;
		}
	    }
	}

	pr.println(playerNumber + " " + highscoreLead);
	pr.close();

    }

    public static void main(String[] args) {
	TLG test = new TLG();
	try {
	    test.solve();
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }
    
}