package cn.test.common;

public class isNumber {
    public static boolean isNum(String str){
        for (int i = str.length();--i>=0;){
            if(!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        if(isNum("aaa")){
            System.out.println("r");
        }else {
            System.out.println("f");
        }
    }
}
