package org.imuniverse.twopointers;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        int[] colors = {0, 1, 0};


        //Arrays.sort(nums);
        System.out.println(Arrays.toString(sortColors(colors)));
    }

    private static int[] sortColors(int[] colors) {
        int red = 0, white = 0;
        int blue = colors.length - 1;

        for (int i = 0; i < colors.length; i++) {
            if(colors[white] == 0) {
                swap(colors, white, red);
                white++;
                red++;
            } else if(colors[white] == 1) {
                white++;
            } else {
                swap(colors, white, blue);
                blue--;
            }
        }
        return colors;
    }

    private static void swap(int[] colors, int from, int to) {
        int temp = colors[from];
        colors[from] = colors[to];
        colors[to] = temp;
    }
}
