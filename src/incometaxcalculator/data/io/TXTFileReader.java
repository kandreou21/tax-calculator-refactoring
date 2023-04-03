package incometaxcalculator.data.io;


public class TXTFileReader extends FileReader {
  
  public int isReceiptID(String[] values) {   
    if (values[0].equals("Receipt")) {
      if (values[1].equals("ID:")) {
        return 2;
      }
    }
    return -1;
  }
  
  public String getValue(String[] values) {
    values[1] = values[1].trim();
    return values[1];
  }
  
}