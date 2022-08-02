public class Main {
    public static void main(String[] args) {
        ScoreRecord scoreRecord = new ScoreRecord();
        DataSheetView dataSheetView3 = new DataSheetView(scoreRecord, 3);
        DataSheetView dataSheetView5 = new DataSheetView(scoreRecord, 5);
        MinMaxView minMaxView = new MinMaxView(scoreRecord);

        scoreRecord.attach(dataSheetView3);
        scoreRecord.attach(dataSheetView5);
        scoreRecord.attach(minMaxView);

        System.out.println("---3개 목록, 5개 목록, MinMax 관찰자 추가---");

        for (int index = 1; index <= 5; index++) {
            int score = index * 10;
            System.out.println("Adding "+score);
            scoreRecord.addScore(score);
        }

        scoreRecord.detach(dataSheetView3);

        System.out.println();
        System.out.println("---3개 목록 관찰자 삭제 후 합/평균 관찰자 추가---");

        StatisticsView statisticsView = new StatisticsView(scoreRecord);
        scoreRecord.attach(statisticsView);

        for (int index = 1; index <= 5; index++) {
            int score = index * 10;
            System.out.println("Adding "+score);
            scoreRecord.addScore(score);
        }
    }
}