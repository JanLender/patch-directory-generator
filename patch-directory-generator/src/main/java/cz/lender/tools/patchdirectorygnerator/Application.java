package cz.lender.tools.patchdirectorygnerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

public class Application {

    public static void main(String[] args) throws IOException {

        Collection<String> files = getListOfFiles();
        new Generator().generatePatch(files);

    }

    public static Collection<String> getListOfFiles() throws IOException {



        Collection<String> listOfFiles = new ArrayList<>();

        Path inputFilePath = Paths.get("/Users/jan/workspace/tools/patch-directory-generator/files.txt");

        return Files.readAllLines(inputFilePath);
    }
}
