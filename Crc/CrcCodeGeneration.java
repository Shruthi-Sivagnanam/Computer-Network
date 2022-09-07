import java.util.Scanner;

import CrcPackage.Divide2;

public class CrcCodeGeneration{

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
        

        System.out.println("Generated code :");
        for(int i=0;i<lenOfData;i++){
            System.out.print(data[i]);
        }
        for(int i=0;i<lenOfDevice-1;i++)
            System.out.print(remainder[i]);

        reader.close();
    }
}
