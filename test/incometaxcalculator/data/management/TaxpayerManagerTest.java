package incometaxcalculator.data.management;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import incometaxcalculator.exceptions.ReceiptAlreadyExistsException;
import incometaxcalculator.exceptions.WrongFileEndingException;
import incometaxcalculator.exceptions.WrongFileFormatException;
import incometaxcalculator.exceptions.WrongReceiptDateException;
import incometaxcalculator.exceptions.WrongReceiptKindException;
import incometaxcalculator.exceptions.WrongTaxpayerStatusException;


public class TaxpayerManagerTest {

   private static TaxpayerManager manager;
   
   @BeforeClass
   public static void setUpBeforeClass() throws Exception {  
     manager = new TaxpayerManager();
   }

   @Test
   public void testLoadTaxpayerHappyDay() throws NumberFormatException, IOException, WrongFileFormatException, WrongFileEndingException,
     WrongTaxpayerStatusException, WrongReceiptKindException, WrongReceiptDateException {
     
     manager.loadTaxpayer("123456789_INFO.txt"); 
     assertTrue(manager.containsTaxpayer());   //elegxo an fortothike taxpayer sto hashmap pou krata tous taxpayers
   }
   
   @Test(expected=WrongFileEndingException.class)
   public void testLoadTaxpayerException() throws NumberFormatException, IOException, WrongFileFormatException, WrongFileEndingException,
     WrongTaxpayerStatusException, WrongReceiptKindException, WrongReceiptDateException {
     
     manager.loadTaxpayer("123456789_INFO.doc"); 
   }
   
   @Test
   public void testAddReceiptHappyDay() throws IOException, WrongReceiptKindException, WrongReceiptDateException, ReceiptAlreadyExistsException, 
     NumberFormatException, WrongFileFormatException, WrongFileEndingException, WrongTaxpayerStatusException {
     
     manager.loadTaxpayer("123456789_INFO.txt");
     manager.addReceipt(100, "21/12/2020", 500, "Basic", "Coffee", "Greece", "Ioannina", "Nick", 1, 123456789);
     assertTrue(manager.containsReceipt(100)); 
   }
   
   @Test
   public void testRemoveReceiptHappyDay() throws IOException, WrongReceiptKindException, WrongReceiptDateException, ReceiptAlreadyExistsException, 
     NumberFormatException, WrongFileFormatException, WrongFileEndingException, WrongTaxpayerStatusException {
     
     manager.loadTaxpayer("123456789_INFO.txt");
     manager.removeReceipt(100);  //diagrafei thn receiptID 100 pou prostethike sto testAddReceipt
     assertFalse(manager.containsReceipt(100));
   }
   
  @Test
   public void testRemoveTaxpayerHappyDay() throws NumberFormatException, IOException, WrongFileFormatException, WrongFileEndingException, 
     WrongTaxpayerStatusException, WrongReceiptKindException, WrongReceiptDateException {
     
     manager.loadTaxpayer("123456789_INFO.txt");
     manager.removeTaxpayer(123456789);
     assertFalse(manager.containsTaxpayer());
   }
  
  @Test(expected=WrongFileFormatException.class) 
  public void testSaveLogFileWrongFileFormatException() throws IOException, WrongFileFormatException {
    
    manager.saveLogFile(123456789,"doc");  //only txt or xml
  }
   
}
