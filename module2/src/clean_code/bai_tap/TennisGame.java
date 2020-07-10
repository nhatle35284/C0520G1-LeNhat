package clean_code.bai_tap;

public class TennisGame {

    public static final String ADVANTAGE_PLAYER_1 = "Advantage player1";
    public static final String ADVANTAGE_PLAYER_2 = "Advantage player2";
    public static final String WIN_FOR_PLAYER_1 = "Win for player1";
    public static final String WIN_FOR_PLAYER_2 = "Win for player2";

    public static String getScore(String player1Name, String player2Name, int scorePlayer1, int socrePlayer2) {
        String score = "";
        int tempScore=0;

        if (scorePlayer1 == socrePlayer2)
        {
            score = startGame(scorePlayer1);
        }
        else if (scorePlayer1 >=4 || socrePlayer2 >=4)
        {
            score = startGame(scorePlayer1, socrePlayer2);
        }
        else
        {
            score = startGame(scorePlayer1, socrePlayer2, score);
        }
        return score;
    }



    private static String startGame(int socrePlayer1, int socrePlayer2, String score) {
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



    private static String startGame(int socrePlayer1, int socrePlayer2) {
        String score;
        int minusResult = socrePlayer1-socrePlayer2;
        if (minusResult==1) score = ADVANTAGE_PLAYER_1;
        else if (minusResult ==-1) score = ADVANTAGE_PLAYER_2;
        else if (minusResult>=2) score = WIN_FOR_PLAYER_1;
        else score = WIN_FOR_PLAYER_2;
        return score;
    }



    private static String startGame(int socrePlayer1) {
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