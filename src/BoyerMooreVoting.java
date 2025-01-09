public class BoyerMooreVoting {

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 3, 4 };
        int majority = findMajority(arr);
        System.out.println(" The majority element is : "
                + majority);
    }

    private static int findMajority(int[] arr) {

        int val = -1;
        int len  = 0;

        for(int x: arr)
        {
            if(x  == val)
            {
                len++;
            }
            else
            {
                if(len  == 0)
                {
                    len = 1;
                    val = x;
                }
                else {
                    len--;
                }
            }
        }

        return val;
    }
}
