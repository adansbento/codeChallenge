import java.lang.Exception;

public class RomanNumber {

public static void main(String[] args){
	
   System.out.println(romanToInt(args[0]));
}

enum RomanEnum{
NOT_FOUND(0),
I(1),
V(5),            
X(10),
L(50),
C(100),
D(500),
M(1000);
 
 int integer;
  RomanEnum(int integer){
    this.integer = integer;
 }

 public int getValue(){
     return integer;
 }

 public static RomanEnum findBySymbol(String symbol){

     for(RomanEnum r: values()){
         if(r.toString().equals(symbol))
            return r;
     }
        return NOT_FOUND;

}
}

    public static int romanToInt(String s) {

        int sizeRoman = s.length();
        
        if(sizeRoman==1){
            return RomanEnum.findBySymbol(s).getValue();
        }

        int result=0;
        char[] romans = s.toCharArray();

        for(int i=0; i < sizeRoman;i++){
           
            int value = RomanEnum.findBySymbol(String.valueOf(romans[i])).getValue();
            int nextIndex = i+1;
            int maxIndexRoman = sizeRoman-1;

          if(nextIndex <= maxIndexRoman){
                int valueAfter = RomanEnum.findBySymbol(String.valueOf(romans[nextIndex])).getValue();
                if(value < valueAfter){
                    value = (valueAfter - value);
                    ++i;
                }
           }

            result += value;
        }

        return result;
    }


    
}