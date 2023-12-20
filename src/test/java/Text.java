public class Text {
    public static void main(String[] args) {

        int[] arrays = new int[2<<20];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = i;
        }
        int a = 0 ;
        long l = System.currentTimeMillis();

        System.out.println(System.currentTimeMillis()-l+"开始时间");
//        for (int i = 0; i < 2<<10; i++) {
//
//            for (int j = 0; j < arrays.length; j++) {
//                a = arrays[arrays.length-1-j];
//            }
//        }
        System.out.println(System.currentTimeMillis()-l+"结束时间sun"+a);


        for (int i = 0; i < 2<<10; i++) {

            for (int j = 0; j < arrays.length; j++) {
                a = arrays[j];
            }
        }
        System.out.println(System.currentTimeMillis()-l+"结束时间fan"+a);


    }
}
