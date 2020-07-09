package clean_code.bai_tap;

public class TennisGame {

    public static String getScore(String player1Name, String player2Name, int m_score1, int m_score2) {
        String score = "";
        int tempScore=0;
        final int scoreplayer1 = m_score1;
        final int soceplayer2 = m_score2;
        if (scoreplayer1 == soceplayer2)
        {
            score = getString(scoreplayer1);
        }
        else if (scoreplayer1 >=4 || soceplayer2 >=4)
        {
            score = getString(scoreplayer1, soceplayer2);
        }
        else
        {
            score = getString(scoreplayer1, soceplayer2, score);
        }
        return score;
    }



    private static String getString(int m_score1, int m_score2, String score) {
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = m_score1;
            else { score+="-"; tempScore = m_score2;}
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



    private static String getString(int m_score1, int m_score2) {
        String score;
        int minusResult = m_score1-m_score2;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }



    private static String getString(int m_score1) {
        String score;
        switch (m_score1)
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