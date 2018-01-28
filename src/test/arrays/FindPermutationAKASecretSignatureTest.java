package test.arrays;

import arrays.FindPermutationAKASecretSignature;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FindPermutationAKASecretSignatureTest {

    @Test
    void findSecretSignature() {
        String pattern;
        FindPermutationAKASecretSignature ss;
        Integer expectedOutput[];
        Integer output[];

        //single length
        pattern = "I";
        ss = new FindPermutationAKASecretSignature(pattern);
        expectedOutput = new Integer[] {1,2};
        output = ss.findSecretSignature();
        assertTrue(Arrays.deepEquals(expectedOutput,output),"Single length pattern's secret sig is wrong."+
                " Output:"+Arrays.toString(output)+" Expected output : "+Arrays.toString(expectedOutput));

        //single length
        pattern = "D";
        ss = new FindPermutationAKASecretSignature(pattern);
        expectedOutput = new Integer[] {2,1};
        output = ss.findSecretSignature();
        assertTrue(Arrays.deepEquals(expectedOutput,output),"Single length pattern's secret sig is wrong"+
                " Output:"+Arrays.toString(output)+" Expected output : "+Arrays.toString(expectedOutput));

        pattern = "IIIIIIIIII";
        ss = new FindPermutationAKASecretSignature(pattern);
        expectedOutput = new Integer[] {1,2,3,4,5,6,7,8,9,10,11};
        output = ss.findSecretSignature();
        assertTrue(Arrays.deepEquals(expectedOutput,output),"Single length pattern's secret sig is wrong"+
                " Output:"+Arrays.toString(output)+" Expected output : "+Arrays.toString(expectedOutput));

        pattern = "DIDIDI";
        ss = new FindPermutationAKASecretSignature(pattern);
        expectedOutput = new Integer[] {2,1,4,3,6,5,7};
        output = ss.findSecretSignature();
        assertTrue(Arrays.deepEquals(expectedOutput,output),"Single length pattern's secret sig is wrong"+
                " Output:"+Arrays.toString(output)+" Expected output : "+Arrays.toString(expectedOutput));

        pattern = "DIDIDIII";
        ss = new FindPermutationAKASecretSignature(pattern);
        expectedOutput = new Integer[] {2,1,4,3,6,5,7,8,9};
        output = ss.findSecretSignature();
        assertTrue(Arrays.deepEquals(expectedOutput,output),"Single length pattern's secret sig is wrong"+
                " Output:"+Arrays.toString(output)+" Expected output : "+Arrays.toString(expectedOutput));

        pattern = "IIIDID";
        ss = new FindPermutationAKASecretSignature(pattern);
        expectedOutput = new Integer[] {1,2,3,5,4,7,6};
        output = ss.findSecretSignature();
        assertTrue(Arrays.deepEquals(expectedOutput,output),"Single length pattern's secret sig is wrong"+
                " Output:"+Arrays.toString(output)+" Expected output : "+Arrays.toString(expectedOutput));

    }
}