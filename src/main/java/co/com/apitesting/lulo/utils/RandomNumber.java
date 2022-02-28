package co.com.apitesting.lulo.utils;

public class RandomNumber {
    public static int getRandomNumber(int min, int max) {
        return (int) Math.floor(Math.random()*(max-min)+min);
    }
}
