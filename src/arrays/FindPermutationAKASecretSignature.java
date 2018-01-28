package arrays;

/**
 * source: https://leetcode.com/articles/find-permutation/
 *
 * for any possible comb. of D and I , where D is decrement and I is increment,
 * output a integer array following these rules in order.
 *
 * eg. DID --> [2,1,4,3]
 *
 */

public class FindPermutationAKASecretSignature {
    String pattern;
    public FindPermutationAKASecretSignature(String pattern) {
        this.pattern = pattern;
    }

    public Integer[] findSecretSignature() {
        return findSecretSignature(this.pattern);
    }

    public Integer[] findSecretSignature(String pattern) {
        Integer[] sig = new Integer[pattern.length()+1];
        for(int i=1;i<sig.length+1;i++)
            sig[i-1] = i;

        int start = 0, end = 0;
        boolean reverse = false;

        for (int i = 0; i < pattern.length(); i++) {
            if(pattern.charAt(i) == 'D')
            {
                if(!reverse)
                {
                    start = i;
                    reverse = true;
                }
            }
            else
            {
                if(reverse)
                {
                    end = i;
                    HelperFunctions.Utils.reverseArray(sig,start,end);
                    reverse = false;
                }
            }
        }

        if(reverse)
        {
            end = sig.length-1;
            HelperFunctions.Utils.reverseArray(sig,start,end);
        }

        return sig;
    }
}
