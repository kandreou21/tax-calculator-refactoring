package incometaxcalculator.data.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import incometaxcalculator.data.management.Receipt;
import incometaxcalculator.data.management.TaxpayerManager;

public abstract class InfoWriter implements FileWriter {
  
  private int taxpayerIndex = 0;
  private final String[] taxpayerConstants;
  
  
  public abstract String manipulateConstant(String constant);
  public abstract String printTaxpayerReceiptInfo(PrintWriter outputStream, Receipt receipt);

  
  public InfoWriter(String[] taxpayerConstants) {
    this.taxpayerConstants = taxpayerConstants;
  }
  
  public String getNextTaxpayerConstant() {
    return taxpayerConstants[taxpayerIndex++];
  }
  
  public void generateFile(int taxRegistrationNumber) throws IOException {

    TaxpayerManager manager = new TaxpayerManager();
    PrintWriter outputStream = new PrintWriter(
        new java.io.FileWriter(taxRegistrationNumber + getNextTaxpayerConstant()));
    outputStream.println(getNextTaxpayerConstant() + manager.getTaxpayerName(taxRegistrationNumber) + getNextTaxpayerConstant());
    outputStream.println(getNextTaxpayerConstant() + taxRegistrationNumber + getNextTaxpayerConstant());
    outputStream.println(getNextTaxpayerConstant() + manager.getTaxpayerStatus(taxRegistrationNumber) + getNextTaxpayerConstant());
    outputStream.println(getNextTaxpayerConstant() + manager.getTaxpayerIncome(taxRegistrationNumber) + getNextTaxpayerConstant() + "\n");
    outputStream.println(getNextTaxpayerConstant());
    outputStream.println();
    generateTaxpayerReceipts(taxRegistrationNumber, outputStream);
    outputStream.close();
  }
  
  private void generateTaxpayerReceipts(int taxRegistrationNumber, PrintWriter outputStream) {

    TaxpayerManager manager = new TaxpayerManager();
    HashMap<Integer, Receipt> receiptsHashMap = manager.getReceiptHashMap(taxRegistrationNumber);
    Iterator<HashMap.Entry<Integer, Receipt>> iterator = receiptsHashMap.entrySet().iterator();
    while (iterator.hasNext()) {
      HashMap.Entry<Integer, Receipt> entry = iterator.next();
      Receipt receipt = entry.getValue();
      printTaxpayerReceiptInfo(outputStream, receipt);
      outputStream.println();
    }
  }
  
  public int getReceiptId(Receipt receipt) {
    return receipt.getId();
  }

  public String getReceiptIssueDate(Receipt receipt) {
    return receipt.getIssueDate();
  }

  public String getReceiptKind(Receipt receipt) {
    return receipt.getKind();
  }

  public float getReceiptAmount(Receipt receipt) {
    return receipt.getAmount();
  }

  public String getCompanyName(Receipt receipt) {
    return receipt.getCompany().getName();
  }

  public String getCompanyCountry(Receipt receipt) {
    return receipt.getCompany().getCountry();
  }

  public String getCompanyCity(Receipt receipt) {
    return receipt.getCompany().getCity();
  }

  public String getCompanyStreet(Receipt receipt) {
    return receipt.getCompany().getStreet();
  }

  public int getCompanyNumber(Receipt receipt) {
    return receipt.getCompany().getNumber();
  }
}
