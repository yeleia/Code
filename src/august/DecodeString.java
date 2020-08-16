package august;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author ：yl
 * @description：TODO
 * @date ：2020/8/16 20:17
 */
public class DecodeString {
    public static String packageStr(int num,String str){
        String tempStr = str;
        for (int i = 1; i < num; i++) {
            tempStr += str;
        }
          return tempStr;
    }
    public static String decode(String str){
        int i = 0;
        int j = 0;
        int left = i;
        int right = j;
        while ( j < str.length() && (str.charAt(j) != ']')){
            j++;
            right = j;
        }
         while (i < right){
            if (str.charAt(i) == '['){
                left = i;
            }
            i++;
        }
        if (left == 0){
            return str;
        }
        String tempNum = "";
        int numStart = 0;
        if (left > 0){
            for (int k = left - 1; k >= 0 ; k--) {
                if (Character.isDigit(str.charAt(k))){
                    tempNum += String.valueOf(str.charAt(k));
                    numStart = k;
                }else {
                    break;
                }
            }
        }
        String num =  tempNum != "" ? new StringBuilder(tempNum).reverse().toString() : "a";
        String leftStr = "";
        String midStr = "";
        String rightStr = right + 1  <= str.length() ? str.substring(right+1,str.length()) : "";
        if (num != "a"){
            leftStr = left - 2 >= 0 ? str.substring(0,numStart) : "";
            midStr = packageStr( Integer.parseInt(num),str.substring(left + 1,right));
        }else {
            leftStr = str.substring(0,left);
            midStr = packageStr(0,str.substring(left + 1,right));
        }
         return decode(leftStr + midStr + rightStr);
    }

    public static void main(String[] args) {
        String s = "10[a5[b]]";
        System.out.println(decode(s));
    }
    /**
     * @author: yl
     * @description: 官方题解，栈
     * @date: 2020/8/16 22:34
     * @param s
     * @return String
     */
    int ptr;
    public String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<String>();
        ptr = 0;

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母并进栈
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                // 左括号出栈
                stk.removeLast();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stk.addLast(t.toString());
            }
        }

        return getString(stk);
    }
    public String getDigits(String s){
        StringBuilder ret = new StringBuilder();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }
    public String getString(LinkedList<String> v){
        StringBuilder ret= new StringBuilder();
        for(String s :v){
            ret.append(s);
        }
        return ret.toString();
    }
}
