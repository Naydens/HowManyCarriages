package oop.HowManyCarriages;

public class Main {
    public static void main(String[] args) {
        Train train = new Train();
        int count = countCarriage(train);
        if (count == train.size()) {
            System.out.println("все верно! размер=" + train.size() + "\n count=" + count);
        } else {
            System.out.println("error count =" + count + "\n size " + train.size());
        }
    }

    public static int countCarriage(Train train) {
        int count = 0;
        Carriage current = train.next();
        if (!current.isLight()) {
            current.setLight(true);
            count++;
        } else {
            count++;
        }
        while (true) {
            current = train.next();
            if (!current.isLight()) {
                count++;
            } else {
                current.setLight(false);
                for (int i = 0; i < count + 1; i++) {
                    current = train.previous();
                }
                if (!current.isLight()) {
                    return count;
                } else {
                    train.next();
                    count = 1;
                }
            }

        }
    }
}