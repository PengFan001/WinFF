package hanoi;

public class Tower {
    public static  int tower_one[] = new int[20], tower_two[] = new int[20], tower_three[] = new int[20];
    public static int tower[] = tower_one;
    public static int rectleft, rectright, rectmid, rectheight = 440, midtower_mid = 315;
    public static int layer_one = 0, layer_two = -1, layer_three = -1;
    public static int n, moveobject, movobjectto;
    public static boolean bool = true;
    //public static char str[] = new char[20];
}
