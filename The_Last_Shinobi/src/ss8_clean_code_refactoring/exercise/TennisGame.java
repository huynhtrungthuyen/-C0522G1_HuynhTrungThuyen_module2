package ss8_clean_code_refactoring.exercise;

public class TennisGame {
    public static String getScore(String firstPlayerName, String secondPlayerName, int firstPlayerScore, int secondPlayerScore) {
        String score = "";
        int tempScore = 0;
        if (firstPlayerScore == secondPlayerScore) {
            return result(firstPlayerScore);
        }

        if (firstPlayerScore >= 4 || secondPlayerScore >= 4) {
            return win(firstPlayerScore, secondPlayerScore);
        }

        return currentScore(firstPlayerScore, secondPlayerScore, score);
    }

    /**
     *
     * @param firstPlayerScore: điểm số của người chơi thứ nhất (trả về kết quả khi 2 người chơi bằng điểm nhau)
     * @return điểm số của người chơi thứ nhất theo cách gọi trong Tennis
     */
    public static String result(int firstPlayerScore) {
        switch (firstPlayerScore) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    /**
     *
     * @param firstPlayerScore:  điểm số của người chơi thứ nhất
     * @param secondPlayerScore: điểm số của người chơi thứ hai
     * @return kết quả là lợi thế hoặc chiến thắng cho 1 trong 2 người chơi trong game đấu đó
     */
    public static String win(int firstPlayerScore, int secondPlayerScore) {
        int minusResult = firstPlayerScore - secondPlayerScore;
        if (minusResult == 1) {
            return "Advantage player1";
        }

        if (minusResult == -1) {
            return "Advantage player2";
        }

        if (minusResult >= 2) {
            return "Win for player1";
        }

        return "Win for player2";
    }

    /**
     *
     * @param firstPlayerScore: điểm số của người chơi thứ nhất
     * @param secondPlayerScore: điểm số của người chơi thứ hai
     * @param score: điểm ghi được hiên tại
     * @return điểm ghi được hiên tại
     */
    public static String currentScore(int firstPlayerScore, int secondPlayerScore, String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = firstPlayerScore;
            else {
                score += "-";
                tempScore = secondPlayerScore;
            }
            switch (tempScore) {
                case 0:
                    score += "Love";
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
}
