package ru.billing.client;

import ru.billing.exceptions.CatalogLoadException;
import ru.billing.exceptions.ItemAlreadyExistsException;
import ru.billing.stocklist.FoodItem;
import ru.billing.stocklist.ItemCatalog;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class CatalogFileLoader implements CatalogLoader {
    
    private String fileName;
    
    public CatalogFileLoader(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public void load(ItemCatalog cat)
            throws CatalogLoadException {
        //File f = new File(fileName);
//        FileInputStream fis;
//        String line;
//        try {
//            fis = new FileInputStream(f);
//            Scanner s = new Scanner(fis);
//
//            while (s.hasNextLine()) {
//                line = s.nextLine();
//                if (line.length() == 0) {
//                    continue;
//                }
//                String[] item_fld = line.split(";");
//                String name = item_fld[0];
//                float price = Float.parseFloat(item_fld[1]);
//                short expires = Short.parseShort(item_fld[2]);
//                FoodItem item = new FoodItem(name, price, null, new Date(), expires);
//                cat.addItem(item);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            throw new CatalogLoadException(e);
//        } catch (ItemAlreadyExistsException e) {
//            e.printStackTrace();
//            throw new CatalogLoadException(e);
//        }
    }
    
    public void readFile() {
        File f = new File(fileName);
        FileInputStream fis;
        InputStreamReader isr;
        int intRead = 1;
        char chrRead;
        try {
            fis = new FileInputStream(f);
            //isr = new InputStreamReader(fis, "UTF-8");
            isr = new InputStreamReader(fis, "windows-1251");
            while ((intRead = isr.read()) != -1) {
                chrRead = (char) intRead;
                System.out.print(chrRead);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void readFile2() {
        File fRead = new File(fileName);
        FileInputStream fis;
        try {
            long lenFile = fRead.length();
            if (lenFile < Integer.MAX_VALUE) {
                fis = new FileInputStream(fRead);
                byte[] btRead = new byte[(int) lenFile];
                fis.read(btRead);
                String strOut = new String(btRead, "windows-1251");
                System.out.println(strOut);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
