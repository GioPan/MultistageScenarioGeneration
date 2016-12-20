/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenariogeneration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author lct495
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        System.out.println("Scenario Generation");
        
        // Creates a Scanner, that is a utility which helps reading data files
        // I also set the US locale, so that it recognizes "." as decimal separator
        Scanner scanner = new Scanner(new File("data"+File.separator+"base_instance.txt")).useLocale(Locale.US);
        
        // The first number in the file is the number of assets
        int n_assets = scanner.nextInt();
        
        // For each asset reads the properties
        System.out.println("Targets :");
        for(int i = 1; i <= n_assets; i++){
            String asset_name = scanner.next();
            double expected_value = scanner.nextDouble();
            double standard_deviation = scanner.nextDouble();
            double skeweness = scanner.nextDouble();
            double kurtosis = scanner.nextDouble();
            double worst_case = scanner.nextDouble();
            
            System.out.println(asset_name+" : \n"+"Mean = "+expected_value+"\n SD = "
                    +standard_deviation+" \n skeweness = "+skeweness+"\n kurtosis = "
                    + kurtosis+"\n worst case = "+worst_case);
        }
        
    }    
}
