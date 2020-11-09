package com.ji.junggu.bracelet;

import com.ji.junggu.bracelet.domain.convert.domain.Convert;
import com.ji.junggu.bracelet.global.util.PropertiesUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print(PropertiesUtil.getMessage("message.insert.data.type"));
            String type = br.readLine();

            System.out.print(PropertiesUtil.getMessage("message.insert.content"));
            String input = br.readLine();
            int dimension = getDimension(input);

            Convert converter = new Convert(type, dimension);

            String prefix = converter.prefix();
            String content = converter.convertContent(input);
            String suffix = converter.suffix();

            System.out.println(prefix + content + suffix);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getDimension(String input) {
        char[] array = input.toCharArray();

        int dimension = 0;
        for (char c : array) {
            if (c != '[') {
                break;
            }

            ++dimension;
        }

        return dimension;
    }
}
