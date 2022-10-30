package src.services;

import org.json.JSONObject;

import java.io.*;
import java.lang.reflect.Constructor;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataManager<T> {


    private String StringData = "";
    private final ArrayList<T> DataManagerList = new ArrayList<>();
    private String filePath = "";
    private String className = "";

    public DataManager(String className, String filePath) throws Exception {
        this.filePath = filePath;
        this.className = className;
        readFile();
    }

    public String getById(String id) {
        Pattern regex = Pattern.compile("^(" + id + ").*", Pattern.MULTILINE);
        Matcher regexMatcher = regex.matcher(getStringData());
        if (regexMatcher.find()) {
            return regexMatcher.group();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public <Y> Y getProperty(String name,String id) throws Exception {
        String dataString = getById(id);
        T fun = instantiate(dataString,className);
        JSONObject json = new JSONObject(((Modal) fun).toJson());
        return (Y) json.get(name);
    }

    public String getStringData() {
        return StringData;
    }

    public void setStringData(String stringData) {
        StringData = stringData;
    }

    public ArrayList<T> getDataManagerList() {
        return DataManagerList;
    }

    public T instantiate(String s, String childClass) throws Exception {
        Constructor<T> c = (Constructor<T>) Class.forName(childClass).getConstructor(String.class);
        c.setAccessible(true);
        return c.newInstance(s);
    }

    public T create(String line) throws Exception {
        T item = null;
        Path path = Paths.get(this.filePath);
        long lines = 0;
        lines = Files.lines(path).count();
        try {
            OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(this.filePath, true), StandardCharsets.UTF_8);
            Writer writer = new BufferedWriter(output);
            lines = lines + 1;
            String newLine = lines + ";" + line;
            writer.write("\n" + newLine);
            writer.close();
            item = instantiate(newLine, className);
            this.DataManagerList.add(item);
            System.out.println("Criado com sucesso!");
        } catch (FileNotFoundException e) {
            throw new Exception("Arquivo não encontrado");
        }
        return item;
    }

    public void delete(String id) throws Exception {
        String data = readFile();
        String user = getById(id);
        if (user == null) throw new Exception("Usuario não existe ou já foi deletado!");
        data = data.replace(user, "--" + user);
        try {
            new PrintWriter(this.filePath).close(); // Deleta o conteudo do arquivo
            OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(this.filePath, true), StandardCharsets.UTF_8);
            Writer writer = new BufferedWriter(output);
            writer.write(data);
            writer.close();
            output.close();
            System.out.println("Deletado com sucesso!");
        } catch (Exception e) {
            throw new Exception("Arquivo não encontrado");
        }

    }

    public String readFile() throws Exception {
        this.StringData = "";
        Scanner in;
        File data;
        try {
            data = new File(filePath);
            in = new Scanner(data);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Arquivo: \"" + filePath + "\". não foi encontrado");
        }

        while (in.hasNextLine()) {
            String line = in.nextLine();
            this.StringData += line + "\n";
            String[] cells = line.split(";");
            if (line != null) {
                if (line.charAt(0) != '-') {
                    T item = instantiate(line, className);
                    DataManagerList.add(item);
                }
            }

        }
        return this.StringData;
    }
}
