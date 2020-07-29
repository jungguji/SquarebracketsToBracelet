package com.ji.junggu.bracelet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String STRING = "string";
    private static final String CHAR = "char";

    private static final String SQUARE_BRACKETS_LEFT = "[";
    private static final String SQUARE_BRACKETS_RIGHT = "]";
    private static final String BRACELET_LEFT = "{";
    private static final String BRACELET_RIGHT = "}";

    private static final String SEPARATOR = "@";

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("자료형(int, String, char) 입력 : ");
            String type = br.readLine();

            System.out.print("괄호 치환 할 문자열 입력 : ");
            char[] array = br.readLine().toCharArray();
            int dimension = getDimension(array);

            String content = getQuoteInclude(type.toLowerCase(), array);

            StringBuilder sb = new StringBuilder();
            sb.append("new ");
            sb.append(getInstanceType(type));

            for (int i = 0; i < dimension; i++) {
                sb.append(SQUARE_BRACKETS_LEFT).append(SQUARE_BRACKETS_RIGHT);
            }

            sb.append(" ");

            for (int i = 0; i < dimension; i++) {
                sb.append(BRACELET_LEFT);
            }
            sb.append(content);
            for (int i = 0; i < dimension; i++) {
                sb.append(BRACELET_RIGHT);
            }

            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static int getDimension(char[] array) {
        int dimension = 0;
        for (char c : array) {
            if (c != '[') {
                break;
            }

            ++dimension;
        }

        return dimension;
    }

    private static String getQuoteInclude(String type, char[] array) {
        String quote = "";
        if (STRING.equals(type)) {
            quote = "\"";
        } else if (CHAR.equals(type)) {
            quote = "'";
        }

        String content = new String(array).replace("], [", ",@,").replace(SQUARE_BRACKETS_RIGHT, "").replace(SQUARE_BRACKETS_LEFT, "").trim();

        String[] strArray = content.split(",");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strArray.length; i++) {
            if (i != 0 && !SEPARATOR.equals(strArray[i]) && !SEPARATOR.equals(strArray[i-1])) {
                sb.append(", ");
            }

            sb.append(quote);
            sb.append(strArray[i].trim());
            sb.append(quote);
        }

        String target = quote + SEPARATOR + quote;
        return sb.toString().replace(target, "}, {");
    }

    private static String getInstanceType(String type) {
        String returnType;
        switch (type) {
            case STRING :
                returnType = "String";
                break;
            default:
                returnType = type;
                break;
        }

        return returnType;
    }
}
