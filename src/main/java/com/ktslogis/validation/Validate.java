package com.ktslogis.validation;

import java.util.regex.Pattern;

public class Validate {

    public static String validateContainerNo(String conNo) throws Exception{

        String containerNo = conNo.toUpperCase();
        String regex = "[A-Z]{3}U[0-9]{7}";
        boolean matches = Pattern.matches(regex, containerNo);

        if(true == matches)
            return containerNo;
        else
            throw new Exception("Container no entered is invalid");
    }

    public static String validateName(String name) throws Exception{

        StringBuffer sb = null;
        String patter = "^[a-zA-Z\\s.]*$";

        if(Pattern.matches(patter, name)) {

            sb = new StringBuffer(name.toUpperCase());

            sb.trimToSize();

            for (int i = 0; i < sb.length(); i++) {
                while(Character.isWhitespace(sb.charAt(i)) && Character.isWhitespace(sb.charAt(i+1)))
                {
                    sb.deleteCharAt(i);
                }
                System.out.println(sb.toString());
            }


            sb.trimToSize();

            for (int i = 0; i < sb.length(); i++) {
                while(sb.charAt(i)=='.' && Character.isWhitespace(sb.charAt(i+1)))
                {
                    sb.deleteCharAt(i+1);
                }
                System.out.println(sb.toString());
            }

        } else {
            throw new Exception("Invalid name. Only letters are allowerd in name.");
        }

        return sb.toString();
    }

}
