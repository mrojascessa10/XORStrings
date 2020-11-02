import java.nio.file.*;
public class Hex{
  public static void human(String key, String inp){
    String ans = "";
    if (key.length() == 1){
    for(int i = 0; i < inp.length(); i++){
      char temp = (char)((key.charAt(0)) ^ inp.charAt(i));
      ans += temp;
    }
  }
  else{
    for(int i = 0; i < inp.length(); i++){
      char temp = (char)((key.charAt(i % key.length())) ^ inp.charAt(i));
      ans += temp;
    }
  }
    System.out.println(ans);
  }
  public static void numOut(String key, String inp){
    String ans = "";
    for(int i = 0; i < inp.length(); i++){
      int temp = key.charAt(i %(key.length())) ^ inp.charAt(i);
      String temp2 = Integer.toHexString(temp);
      ans += temp2 + " ";
    }
    System.out.println(ans);
  }
  public static void main(String[]args){
    String mode = null;
    String keyfile = null;
    String inpfile = null;
    String key = null;
    String inp = null;
    boolean debug = false;
    try{
        mode = args[0];
        keyfile = args[1];
        inpfile = args[2];
        key = Files.readString(Path.of(keyfile));
        key = key.substring(0, key.length() - 1);
        inp = Files.readString(Path.of(inpfile));
        inp = inp.substring(0, inp.length() - 1);
        if(debug){
            System.out.println("mode:"+mode);
            System.out.println("key: "+key);
            System.out.println("inp: "+inp);
        }
        if(mode.equals("human")) human(key, inp);
        else numOut(key, inp);
    }catch(Exception e){
        e.printStackTrace();
        System.exit(1);
    }
  }
}
