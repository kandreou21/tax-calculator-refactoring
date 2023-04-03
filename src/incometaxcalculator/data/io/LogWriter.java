package incometaxcalculator.data.io;

import java.io.IOException;
import java.io.PrintWriter;

import incometaxcalculator.data.management.TaxpayerManager;

public abstract class LogWriter implements FileWriter {
  
  private static final short ENTERTAINMENT = 0;
  private static final short BASIC = 1;
  private static final short TRAVEL = 2;
  private static final short HEALTH = 3;
  private static final short OTHER = 4;
  private double index = 0;
  private final String[] logConstants;
  
  
  public abstract String manipulateConstant(String constant);
  
  
  public LogWriter(String[] logConstants) {
    this.logConstants = logConstants;
  } 
  
  public double increaseIndex() {
    return index++;
  }
  
  public String getLogConstant() {
    return logConstants[(int)(index += 0.5)]; 
  }

  public void generateFile(int taxRegistrationNumber) throws IOException {
    TaxpayerManager manager = new TaxpayerManager();
    PrintWriter outputStream = new PrintWriter(
        new java.io.FileWriter(taxRegistrationNumber + getLogConstant()));
        
    outputStream.println(getLogConstant() + " " + manager.getTaxpayerName(taxRegistrationNumber) + " " + manipulateConstant(getLogConstant()));
    outputStream.println(getLogConstant() + " " + taxRegistrationNumber + " " + manipulateConstant(getLogConstant()));
    outputStream.println(getLogConstant() + " " + manager.getTaxpayerIncome(taxRegistrationNumber) + " " + manipulateConstant(getLogConstant()));
    outputStream
        .println(getLogConstant() + " " + manager.getTaxpayerBasicTax(taxRegistrationNumber) + " " + manipulateConstant(getLogConstant()));
    if (manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber) > 0) {
      outputStream.println(getLogConstant() 
          + " " + manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber) + " " + manipulateConstant(getLogConstant()));
      increaseIndex();
    } else {
      increaseIndex();
      outputStream.println(getLogConstant()
          + " " + manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber) + " " + manipulateConstant(getLogConstant()));
    }
    outputStream
        .println(getLogConstant() + " " + manager.getTaxpayerTotalTax(taxRegistrationNumber) + " " + manipulateConstant(getLogConstant()));
    outputStream.println(
        getLogConstant() + " " + manager.getTaxpayerTotalReceiptsGathered(taxRegistrationNumber) + " " + manipulateConstant(getLogConstant()));
    outputStream.println(
        getLogConstant() + " " + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, ENTERTAINMENT)
        + " " + manipulateConstant(getLogConstant()));
    outputStream.println(
        getLogConstant() + " " + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, BASIC) + " " + manipulateConstant(getLogConstant()));
    outputStream.println(
        getLogConstant() + " " + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, TRAVEL) + " " + manipulateConstant(getLogConstant()));
    outputStream.println(
        getLogConstant() + " " + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, HEALTH) + " " + manipulateConstant(getLogConstant()));
    outputStream.println(
        getLogConstant() + " " + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, OTHER) + " " + manipulateConstant(getLogConstant()));
    outputStream.close();
    
  }
  
  
}
