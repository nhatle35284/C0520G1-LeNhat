package clean_code.bai_tap;

public class TennisGame {

    public static String getScore(String player1Name, String player2Name, int scorePlayer1, int socreplayer2) {
        String score = "";
        int tempScore=0;

        if (scorePlayer1 == socreplayer2)
        {
            score = getString(scorePlayer1);
        }
        else if (scorePlayer1 >=4 || socreplayer2 >=4)
        {
            score = getString(scorePlayer1, socreplayer2);
        }
        else
        {
            score = getString(scorePlayer1, socreplayer2, score);
        }
        return score;
    }



    private static String getString(int socrePlayer1, int socrePlayer2, String score) {
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = socrePlayer1;
            else { score+="-"; tempScore = socrePlayer2;}
            switch(tempScore)
            {
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }



    private static String getString(int socrePlayer1, int socrePlayer2) {
        String score;
        int minusResult = socrePlayer1-socrePlayer2;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }



    private static String getString(int socrePlayer1) {
        String score;
        switch (socrePlayer1)
        {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }
}