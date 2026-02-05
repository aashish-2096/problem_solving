package leetcode.hard.java;

public class ValidNumber {
    public boolean isNumber(String s) {
        boolean seenNumber = false;
        boolean seenExp = false;
        boolean seenDot = false;
            for(int i = 0 ;i<s.length();i++){
                char ch = s.charAt(i);
                if(Character.isDigit(ch)){
                    seenNumber = true;
                } else if(ch == 'e' || ch == 'E'){
                    if(seenExp || !seenNumber){
                        return false;
                    }
                    seenNumber = false;
                    seenExp = true;
                } else if(ch == '.'){
                    if(seenDot || seenExp){
                        return false;
                    }
                    seenDot = true;
                } else if(ch == '+' || ch == '-'){
                    if(i > 0 && s.charAt(i-1)!='E' && s.charAt(i-1) != 'e'){
                        return false;
                    }
                } else {
                    return false;
                }
            }
        
        return seenNumber;
        
    }
}
