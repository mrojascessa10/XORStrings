public class XORStrings{
  public static void human(String keyfile, String textfile){
    String ans = "";
    int index = 0;
    for(int i = 0; i < textfile.length(); i++){
      ans += (char)(keyfile.charAt(index) ^ textfile.charAt(i));
      index = index % keyfile.length();
    }
    System.out.println(ans);
  }
  public static void numOut(String keyfile, String textfile){
    String ans = "";
    int index = 0;
    for(int i = 0; i < textfile.length(); i++){
      ans += Integer.toHexString((keyfile.charAt(index) ^ textfile.charAt(i))) + " ";
      index = index % keyfile.length();
    }
    System.out.println(ans);
  }
  public static void main(String [] args){
    String mode = args[0];
    String keyfile = args[1];
    String textfile = args[2];
    if(mode.charAt(0) == 'h') human(keyfile, textfile);
    else numOut(keyfile, textfile);
  }
}
