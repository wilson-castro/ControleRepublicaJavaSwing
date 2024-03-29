package src.services;

import org.json.JSONObject;
import java.io.*;
import java.lang.reflect.Constructor;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import src.models.Modal;
import src.utils.Constantes;

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

    public DataManager(String className, String filePath, boolean mutipleFile, String filter) throws Exception {
        this.filePath = filePath;
        this.className = className;
        if (mutipleFile) {
            StringBuilder data = new StringBuilder();
            DataManager.this.getAllFilesFromFolder().forEach((String item) -> {
                try {
                    if (item.contains(filter)) {
                        data.append(readFile(this.filePath + item));
                    }
                } catch (Exception ex) {
                    Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            this.StringData = data.toString();
        }

    }

    public String getFilePath() {
        return filePath;
    }

    public String getById(String id) {
        Pattern regex = Pattern.compile("^(" + id + ").*", Pattern.MULTILINE);
        Matcher regexMatcher = regex.matcher(getStringData());
        if (regexMatcher.find()) {
            return regexMatcher.group();
        }
        return null;
    }

    public ArrayList<String> getIfContains(String search) {
        ArrayList<String> matches = new ArrayList<>();
        Pattern regex = Pattern.compile("^\\b(.*" + search + ".*)\\b", Pattern.MULTILINE);
        Matcher regexMatcher = regex.matcher(getStringData());
        while (regexMatcher.find()) {
            matches.add(regexMatcher.group());
        }
        return matches;
    }

    @SuppressWarnings("unchecked")
    public <Y> Y getProperty(String name, String id) throws Exception {
        String dataString = getById(id);
        T fun = instantiate(dataString);
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

    public T instantiate(String s) throws Exception {
        Constructor<T> c = (Constructor<T>) Class.forName(this.className).getConstructor(String.class);
        c.setAccessible(true);
        return c.newInstance(s);
    }

    public ArrayList<String> getAllFilesFromFolder(String folder) {
        ArrayList<String> array = new ArrayList<>();
        File dir = new File(folder);
        for (String fileName : dir.list()) {
            array.add(fileName);
        }
        return array;
    }

    public ArrayList<String> getAllFilesFromFolder() {
        ArrayList<String> array = new ArrayList<>();
        File dir = new File(filePath);
        for (String fileName : dir.list()) {
            array.add(fileName);
        }
        return array;
    }

    public T createSeparated(String line, String fileName, String... args) throws Exception {
        T item = null;
        long lines = 0;
        LocalDate today = LocalDate.now();
        String monthP = String.format("%02d", today.getMonthValue());
        String yearP = today.getYear() + "";
        if (args.length >= 1) {
            monthP = String.format("%02d", Integer.valueOf(args[0]));
        }
        if (args.length >= 2) {
            yearP = args[1];
        }
        String newFilePath = Constantes.DIRETORIO_FILE + fileName + "_" + monthP + "_" + yearP + ".txt";
        File file = new File(newFilePath);
        String idPrefix = monthP + yearP;
        if (file.exists()) {
            this.filePath = newFilePath;
            return create(line, idPrefix);
        }
        try {
            OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(newFilePath, true), StandardCharsets.UTF_8);
            this.filePath = newFilePath;

            Path path = Paths.get(this.filePath);
            lines = Files.lines(path).count();

            String newLine;
            try ( Writer writer = new BufferedWriter(output)) {
                lines = lines + 1;
                String id = idPrefix + lines;
                newLine = id + ";" + line;
                writer.write(newLine);
            }
            item = instantiate(newLine);
            this.DataManagerList.add(item);
            System.out.println("Criado arquivo com sucesso! Caminho:" + newFilePath);
        } catch (FileNotFoundException e) {
            throw new Exception("Arquivo não encontrado");
        }
        return item;
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
            writer.write("\n");
            writer.write(newLine);
            writer.close();
            item = instantiate(newLine);
            this.DataManagerList.add(item);
            System.out.println("Criado com sucesso!");
        } catch (FileNotFoundException e) {
            throw new Exception("Arquivo não encontrado");
        }
        return item;
    }

    public T create(String line, String idPrefix) throws Exception {
        T item = null;
        Path path = Paths.get(this.filePath);
        long lines = 0;
        lines = Files.lines(path).count();
        try {
            OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(this.filePath, true), StandardCharsets.UTF_8);
            String newLine;
            try ( Writer writer = new BufferedWriter(output)) {
                lines = lines + 1;
                String id = idPrefix + lines;
                newLine = id + ";" + line;
                writer.write("\n");
                writer.write(newLine);
            }
            item = instantiate(newLine);
            this.DataManagerList.add(item);
            System.out.println("Criado com sucesso!");
        } catch (FileNotFoundException e) {
            throw new Exception("Arquivo não encontrado");
        }
        return item;
    }

    public boolean deleteFromFile(String id, String file) throws Exception {
        String data = readFile(file);
        String user = getById(id);
        if (user == null) {
            throw new Exception("Registro não existe ou já foi deletado!");
        }
        data = data.replace(user, "--" + user);
        try {
            new PrintWriter(file).close(); // Deleta o conteudo do arquivo
            try ( OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(file, true), StandardCharsets.UTF_8);  Writer writer = new BufferedWriter(output)) {
                writer.write(data.trim());
                writer.close();
            }
            System.out.println("Deletado com sucesso!");
            return true;
        } catch (IOException e) {
            throw new Exception("Arquivo não encontrado");
        }
    }

    public boolean delete(String id) throws Exception {
        String data = readFile();
        String user = getById(id);
        if (user == null) {
            throw new Exception("Registro não existe ou já foi deletado!");
        }
        data = data.replace(user, "--" + user);
        try {
            new PrintWriter(this.filePath).close(); // Deleta o conteudo do arquivo
            try ( OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(this.filePath, true), StandardCharsets.UTF_8)) {
                Writer writer = new BufferedWriter(output);
                writer.write(data.trim());
                writer.close();
            }
            System.out.println("Deletado com sucesso!");
            return true;
        } catch (IOException e) {
            throw new Exception("Arquivo não encontrado");
        }
    }

    public final String readFile() throws Exception {
        this.StringData = "";
        deleteFromFileBlankOrEmptyLines(filePath);
        Scanner in;
        File data;
        try {
            data = new File(filePath);
            in = new Scanner(data);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Arquivo: \"" + filePath + "\". não foi encontrado");
        }

        while (in.hasNext()) {
            String line = in.nextLine();

            if (line.isBlank() || line.isEmpty()) {

                continue;
            }

            this.StringData += line + "\n";
            if (line.charAt(0) != '-') {
                T item = instantiate(line);
                DataManagerList.add(item);
            }

        }
        in.close();
        return this.StringData;
    }

    public final String readFile(String path) throws Exception {
        this.StringData = "";
        deleteFromFileBlankOrEmptyLines(path);
        Scanner in;
        File data;

        try {
            data = new File(path);
            in = new Scanner(data);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Arquivo: \"" + path + "\". não foi encontrado");
        }

        while (in.hasNext()) {
            String line = in.nextLine().trim();

            if (line.isBlank() || line.isEmpty()) {

                continue;
            }

            this.StringData += line + "\n";

            if (line.charAt(0) != '-') {
                T item = instantiate(line);
                DataManagerList.add(item);
            }
        }
        in.close();
        return this.StringData;
    }

    private String readFileWithBlankOrEmptyLine(String path) throws Exception {
        String stringData = "";
        Scanner in;
        File data;

        try {
            data = new File(path);
            in = new Scanner(data);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Arquivo: \"" + path + "\". não foi encontrado");
        }

        while (in.hasNext()) {
            String line = in.nextLine();
            stringData += line + "\n";

        }
        in.close();
        return stringData;
    }

    private boolean deleteFromFileBlankOrEmptyLines(String file) throws Exception {
        String data = readFileWithBlankOrEmptyLine(file);
        Pattern regex = Pattern.compile("^(?:[\\t ]*(?:\\r?\\n|\\r))+", Pattern.MULTILINE);
        data = regex.matcher(data).replaceAll("");
        try {
            new PrintWriter(file).close(); // Deleta o conteudo do arquivo
            try ( OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(file, true), StandardCharsets.UTF_8);  Writer writer = new BufferedWriter(output)) {
                writer.write(data.trim());
                writer.close();
            }
            return true;
        } catch (IOException e) {
            throw new Exception("Arquivo não encontrado");
        }
    }

    public boolean update(String id, String updatedLine) throws Exception {
        String data = readFile();
        String user = getById(id);
        if (user == null) {
            throw new Exception("Registro não existe!");
        }
        data = data.replace(user, id + ";" + updatedLine);
        try {
            new PrintWriter(this.filePath).close();
            try ( OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(this.filePath, true), StandardCharsets.UTF_8)) {
                Writer writer = new BufferedWriter(output);
                writer.write(data.trim());
                writer.close();
            }
            System.out.println("Atualizado com sucesso!");
            return true;
        } catch (IOException e) {
            throw new Exception("Arquivo não encontrado");
        }
    }

}
