package august;

import java.util.*;

/**
 * @author ：yl
 * @description：原子的数量
 * @date ：2020/8/23 21:29
 */
public class CountOfAtoms {
    public static  String  countOfAtoms3(String formula){
        int len = formula.length();
        Map<String,Integer> map = new TreeMap<>();
        Stack<Integer> numStack = new Stack<>();
        int tempNum = 1;
        for (int i = len - 1; i >= 0;) {
            String name = "";
            if (Character.isDigit(formula.charAt(i))){
                int start = i;
                while (Character.isDigit(formula.charAt(i))){
                    i--;
                }
                tempNum = Integer.valueOf(formula.substring(i+1,start+1));
            }
            if (formula.charAt(i) == ')'){
                if (numStack.empty()){
                    numStack.push(tempNum);
                }else {
                    numStack.push(tempNum * numStack.peek());
                }
                tempNum = 1;
            }
            if(formula.charAt(i) == '('){
                numStack.pop();
            }
            if (Character.isLowerCase(formula.charAt(i))){
                int start = i;
                while (Character.isLowerCase(formula.charAt(i))){
                    i--;
                }
                name = formula.substring(i,start+1);
                map.put(name,map.getOrDefault(name,0)+ tempNum * (numStack.empty() ? 1 :numStack.peek()));
                tempNum = 1;
            }
            if (i >= 0 && name== "" && Character.isUpperCase(formula.charAt(i))){
                name = name + formula.charAt(i);
                map.put(name,map.getOrDefault(name,0)+ tempNum * (numStack.empty() ? 1 :numStack.peek()));
                tempNum = 1;
            }
            i--;
        }
        StringBuilder ans = new StringBuilder();
        for (String atom : map.keySet()){
            ans.append(atom);
            int multiplicity = map.get(atom);
            if (multiplicity > 1){
                ans.append("" + multiplicity);
            }
        }
        return new String(ans);
    }
    public static void main(String[] args) {
        String formula = "K4(ON(SO3)2)2";
        System.out.println(countOfAtoms3(formula));
    }
    /**
     * @author: YL
     * @description: TODO
     * @date: 2020/8/23 21:44
     * @param formula
     * @return K4(ON(SO3)2)2
     */
    public static String countOfAtoms(String formula) {
        int N = formula.length();
        Stack<Map<String,Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());
        for (int i = 0; i < N;){
            if (formula.charAt(i) == '('){
                stack.push(new TreeMap<>());
                i++;
            }else if (formula.charAt(i) == ')'){
                Map<String,Integer>top = stack.pop();
                int iStart = ++i;
                int multiplicity = 1;
                while (i < N && Character.isDigit(formula.charAt(i))){
                    i++;
                }
                if (i > iStart){
                    multiplicity = Integer.parseInt(formula.substring(iStart,i));
                    for (String c : top.keySet()){
                        int v = top.get(c);
                        stack.peek().put(c,stack.peek().getOrDefault(c,0) + v * multiplicity);
                    }
                }
            }else {
                int iStart = i ++;
                while (i < N && Character.isLowerCase(formula.charAt(i))){
                    i++;
                }
                String name = formula.substring(iStart,i);
                iStart = i;
                while (i < N && Character.isDigit(formula.charAt(i))){
                    i++;
                }
                int multiplicity = i > iStart ? Integer.parseInt(formula.substring(iStart,i)) : 1;
                stack.peek().put(name,stack.peek().getOrDefault(name,0) +multiplicity);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (String name : stack.peek().keySet()){
            ans.append(name);
            int multiplicity = stack.peek().get(name);
            if (multiplicity > 1){
                ans.append("" + multiplicity);
            }
        }
        return new String(ans);
    }
    /**
     * @author: yl
     * @description:计算(SO3)2 返回 S2O6
     * @date: 2020/8/23 21:45
     * @param num 2
     * @param str SO
     * @return S2O6
     */
    public static String packageStr(int num,String str){
        //先计算相同原子的个数
        //判断是否是原子，放入数组中
        List arr = new ArrayList();
        String temp = "";
        int number = 0;
        String tempStr ="";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i)) && (i+1) < str.length() && Character.isUpperCase(str.charAt(i+1))){
                temp+=str.charAt(i);
                tempStr += temp;
                temp = "";
            }else if (Character.isDigit(str.charAt(i))){
                number += Integer.valueOf(String.valueOf(str.charAt(i)));
            }else if (number != 0 && !Character.isDigit(str.charAt(i))){
                while (number >= 0){
                    tempStr += temp;
                }
                number = 0;
                temp = "";
            }else {
                temp += str.charAt(i);
            }
        }
        while (number > 0){
            tempStr += temp;
            number--;
        }
        String ret = "" ;
        for (int i = 0; i < num ; i++) {
            ret += tempStr;
        }
        return ret;
    }


}
