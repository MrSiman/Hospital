package laba.service;

public class StringManip{

    public static String setCorrectCaseForFIO(String FIO) {
        String rightFIO = "";
        rightFIO += FIO.substring(0,1).toUpperCase();
        for (int i = 1; i < FIO.length(); i++) {
            if (" ".equals(FIO.substring(i-1, i))) {
                rightFIO += FIO.substring(i,i+1).toUpperCase();
            }
            else {
                rightFIO += rightFIO + FIO.substring(i,i+1).toLowerCase();
            }
        }
        return rightFIO;
    }

    public static String setCorrectCaseForOtherWords(String word) {
        String rightWord = "";
        rightWord +=word.substring(0,1).toUpperCase();
        rightWord +=word.substring(1).toLowerCase();
        return rightWord;
    }
}