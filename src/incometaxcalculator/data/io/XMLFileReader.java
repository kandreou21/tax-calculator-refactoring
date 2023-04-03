package incometaxcalculator.data.io;


public class XMLFileReader extends FileReader {

  public int isReceiptID(String[] values) { 
    if (values[0].equals("<ReceiptID>")) {
      return 1;
    }
    return -1;
  }
  
  public String getValue(String[] values) {
    String valueReversed[] = new StringBuilder(values[1]).reverse().toString().trim().split(" ", 2);
    return new StringBuilder(valueReversed[1]).reverse().toString();
  }
  
}
