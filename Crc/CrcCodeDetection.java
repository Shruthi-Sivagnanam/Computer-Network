import java.util.Scanner;

import CrcPackage.Divide2;

public class CrcCodeDetection {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int lenOfData,lenOfDevice;

        System.out.print("Enter the length of the data : ");
        lenOfData= reader.nextInt();
        System.out.print("Enter the length of the device code : ");
        lenOfDevice = reader.nextInt();
        Divide2 ob = new Divide2();

        int[] data = new int[lenOfData+lenOfDevice ];
        System.out.print("Enter the value of the data : ");
        for(int i=0;i<lenOfData;i++){
            data[i] = reader.nextInt();
        }
        
        int[] deviceCode = new int[lenOfDevice];
        System.out.print("Enter the device code : ");
        for(int i=0;i<lenOfDevice;i++){
            deviceCode[i]= reader.nextInt();
        } 

        int[] remainder = ob.divide(data, deviceCode, lenOfData, lenOfDevice); 
        int c=0;
        for(int i=0;i<remainder.length;i++){
            if(remainder[i]!=0){
                c=1;
                break;
            }
        }
        if(c==1){
            System.out.println("The received code is not correct");
        }
        else
            System.out.println("The code is correct");
        reader.close();
    }
}
