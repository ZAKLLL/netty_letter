import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-04 11:06
 **/

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String g = null;
        int a = Integer.parseInt(in.nextLine());
        int b=0;
        while (in.hasNextLine()) {
            g=in.next();

            b++;
            if (b==1) {
                break;
            }
        }
        int[] ints = new int[g.length()];

        for (int p = 0; p < ints.length; p++) {
            ints[p] = Integer.parseInt(String.valueOf(g.charAt(p)));
        }

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[1]);
        }
        int len = 0;
        List<Integer> push = new ArrayList<>();
        List<Integer> subscript = new LinkedList<>();
        for (int j = 0; j < ints.length; j++) {
            if (ints[j] == 0 || ints[j] == 1) {
                if (push.size() != 0) {
                    if (push.get(push.size() - 1) != ints[j] && subscript.get(push.size() - 1) == j - 1) {
                        push.remove(push.size() - 1);
                        subscript.remove(push.size() - 1);
                        len += 2;
                    } else {
                        push.add(ints[j]);
                        subscript.add(j);
                    }
                } else {
                    push.add(ints[j]);
                    subscript.add(j);
                }
            }
        }
        System.out.println(ints.length - len);

    }
}