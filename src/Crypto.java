public class Crypto {
    public static String normallizeText(String txt){
        txt = txt.replaceAll("\\s+","");
        txt = txt.replaceAll("\\p{Punct}", "");
        txt = txt.toUpperCase();
        return txt;

    }
    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }
    public static String caesarify(String txt, int step){
        String new_txt = "";
        for (int i = 0; i < txt.length(); i++) {
            new_txt += charCaesarify(txt.charAt(i),step);
        }
        return new_txt;
    }

    public static char charCaesarify(char ch, int step) {
        String alphabet = shiftAlphabet(0);
        int curLocation = alphabet.indexOf(ch);
        String shifted = shiftAlphabet(step);
        return shifted.charAt(curLocation);
    }

    public static String groupify(String txt, int lengthOfEach){
        String new_txt = "";
        for (int i = 1; i <= txt.length(); i++) {
            if(i%lengthOfEach==0){
                new_txt += txt.substring(i-lengthOfEach,i);
                new_txt += " ";
            }
            if(i==txt.length() && i%lengthOfEach != 0){
                new_txt += txt.substring(i-i%lengthOfEach,i);
                int c = lengthOfEach-i%lengthOfEach;
                while(c>0){
                    new_txt += "x";
                    c--;
                }
            }
        }
        return new_txt;
    }
    public static String encryptString(String txt, int step, int length ){
        txt = normallizeText(txt);
        txt = caesarify(txt , step);
        txt = groupify(txt, length);
        return txt;
    }
    public static void main(String[] args) {
        System.out.println(encryptString("asdf@#$asdf#$%ASDF",4,5));
    }

}
