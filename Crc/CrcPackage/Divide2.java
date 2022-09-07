package CrcPackage;

public class Divide2 {

    int xor(int a,int b){
        if(a==b)
            return 0;
        return 1;
    }

    public int[] divide(int[] data,int[] deviceCode,int lenOfData,int lenOfDevice){
       int[] remainder = new int [lenOfDevice+1];
       for(int i=0;i<lenOfDevice;i++){
            remainder[i] = data[i];
        }

        for(int i=0;i<lenOfData;i++){
            if(remainder[0]==1){
                for(int j=1;j<lenOfDevice;j++){
                    remainder[j-1]=xor(remainder[j], deviceCode[j]);
                }
            }
            else{
                for(int j=1;j<lenOfDevice;j++){
                    remainder[j-1]=xor(remainder[j], 0);
                }
            }
            remainder[lenOfDevice-1] = data[i+lenOfDevice];
        } 
       return remainder ;
    }
}
