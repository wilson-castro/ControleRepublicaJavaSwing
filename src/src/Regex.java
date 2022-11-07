/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ricardo Alves
 */
public class Regex {

    public Regex() {
    }

    public String getIfContains(String search, String text) {
        Pattern regex = Pattern.compile("^\\b(.*" + search + ".*)\\b", Pattern.MULTILINE);
        Matcher regexMatcher = regex.matcher(text.trim());
        if (regexMatcher.find()) {
            return regexMatcher.group();
        }
        return null;
    }
}
