//为了深入了解这些生物群体的生态特征，你们进行了大量的实地观察和数据采集。
// 数组 arrayA 记录了各个生物群体数量数据，其中 arrayA[i] 表示第 i 个生物群体的数量。
// 请返回一个数组 arrayB，该数组为基于数组 arrayA 中的数据计算得出的结果，
// 其中 arrayB[i] 表示将第 i 个生物群体的数量从总体中排除后的其他数量的乘积。

//不能使用除法

class Solution {
    public int[] statisticalResult(int[] arrayA) {
        int n=arrayA.length;
        if(n == 0) return new int[0];
        int[]arrayB=new int[n];
        arrayB[0]=1;
        int tmp=1;
        for (int i = 1; i <n ; i++) {
            tmp*=arrayA[i-1];
            arrayB[i]=tmp;
        }
        tmp=1;
        for (int i = n-2; i >=0 ; i--) {
            tmp*=arrayA[i+1];
            arrayB[i]*=tmp;
        }
        return arrayB;
    }
}