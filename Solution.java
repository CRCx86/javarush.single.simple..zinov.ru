

public class Solution {

    public static void main(String[] args) throws Exception {

        Integer[][] test1 = {{4, 5, 4},
                             {3, 1, 5},
                             {5, 4, 1}};

        Integer[][] test2 = {{5, 3, 4, 5},
                             {6, 2, 1, 4},
                             {3, 1, 1, 4},
                             {8, 5, 4, 3}};

        Integer[][] test3 = {{2, 2, 2},
                             {2, 1, 2},
                             {2, 1, 2},
                             {2, 1, 2}};

        Integer[][] test4 = {{5, 3, 4, 5, 6},
                             {6, 2, 1, 4, 6},
                             {3, 1, 6, 6, 6},
                             {8, 5, 6, 1, 6},
                             {8, 5, 4, 6, 5}};

        TropicalIsland tropicalIsland = new TropicalIsland();
        System.out.println(tropicalIsland.getWaterVolume(test1));

        tropicalIsland = new TropicalIsland();
        System.out.println(tropicalIsland.getWaterVolume(test2));

        tropicalIsland = new TropicalIsland();
        System.out.println(tropicalIsland.getWaterVolume(test3));

        tropicalIsland = new TropicalIsland();
        System.out.println(tropicalIsland.getWaterVolume(test4));
    }


}
