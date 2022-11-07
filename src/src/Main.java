/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ricardo Alves
 */
public class Main {

    public static String a = """
              1120211;Carro;LavaJato;Mobilidade;1;10.50
              1120222;safsdfas;sdfasdf;Variada;3;22.0
              1120223;fasfa;232;Fixa;#;32.0
              1120224;dsaas;sadsadas;Variada;1;22.0
              """;

    public static void main(String[] args) {
        getIfContains("2022").forEach(item -> {
            System.out.println(item);
        });

    }

    public static ArrayList<String> getIfContains(String search) {
        ArrayList<String> matches = new ArrayList<>();
        Pattern regex = Pattern.compile("^\\b(.*" + search + ".*)\\b", Pattern.MULTILINE);
        Matcher regexMatcher = regex.matcher(a.trim());
        while (regexMatcher.find()) {
            matches.add(regexMatcher.group());
        }
        return matches;
    }
}
