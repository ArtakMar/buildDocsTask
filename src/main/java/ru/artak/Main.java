package ru.artak;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Please define required configuration variables");
        }
        if (Integer.parseInt(args[0]) <= 0 || Integer.parseInt(args[1]) <= 0) {
            throw new IllegalArgumentException("Incorrect data");
        }
        int height = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);

        Main.printDiamond(height, width);
    }


    private static void printDiamond(int height, int width) {
        int left = width / 2;
        int right = width / 2;

        for (int i = 0; i < height; i++) {
            //не выпускаем за границу по левой стороне
            if (left < 0) {
                left = 0;
            }
            //не выпускаем за границу по правой стороне
            if (right == width) {
                right--;
            }
            for (int j = 0; j < width; j++) {
                if (j == left || j == right) {
                    if (i == height - 1) { // последний ряд
                        System.out.println("#");
                        break;
                    }
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }

            if (i < height / 2) {//первая половина ромба
                left--;
                right++;
            } else {             //вторая половина ромба
                left++;
                right--;
            }
            // на случай раннего сближения
            if (left == right) {
                right++;
            }

            System.out.println();
        }
    }
}
