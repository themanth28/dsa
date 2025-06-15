package ArrayProblem;

import java.util.HashSet;
import java.util.Set;

public class Union {
    public static void main(String[] args) {
        int[] a = {178, 968, 724, 752, 464, 884, 831, 618, 388, 378, 469, 518, 972, 721, 945, 446, 215, 957, 144, 68, 833, 722, 796, 421, 406, 896, 79, 592, 274, 23, 614, 667, 121, 645, 315, 576};
        int[] b = {346, 494, 616, 220, 817, 147, 49, 969, 278, 550, 401, 684, 872, 933, 735, 505, 405, 605, 355, 621, 814, 80, 660, 757, 47, 466, 396, 869, 517, 201, 302, 884, 155, 675, 574, 190, 246, 517, 794, 873, 528, 241, 776, 868, 346, 951, 712, 485, 741, 487, 51, 162, 946, 253, 260, 683, 552, 358, 669, 630, 143, 587, 485, 770, 403, 692, 714, 160, 363, 615, 122, 246, 634, 337, 22, 798, 894, 131, 64, 368, 415, 761, 204, 435, 586, 327, 565, 33, 759, 60, 386, 588, 735, 932, 441, 859};
        System.out.println(findUnion(a,b));
    }
    public static int findUnion(int[] a, int[] b) {
        Set<Integer> integerSet = new HashSet<>();
        for(int i : a){
            integerSet.add(i);
        }
        for (int j : b) {
            integerSet.add(j);
        }
        return integerSet.size();
    }
}
