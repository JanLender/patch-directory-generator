package cz.lender.tools.patchdirectorygnerator;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

public class Generator {

    private String targetDirectoryName = "/Users/jan/workspace/salinger-evidence/delivery/SED-950";

    private String contentRootDirectoryName = "/Users/jan/workspace/salinger-evidence";

    public void generatePatch(Collection<String> fileNames) {
        Path contentRootDirectoryPath = Paths.get(contentRootDirectoryName);
        Path targetDirectoryPath = Paths.get(targetDirectoryName);
        for (String fileName : fileNames) {
            Path sourcePath = contentRootDirectoryPath.resolve(fileName);
            Path targetPath = targetDirectoryPath.resolve(fileName);
            targetPath.getParent().toFile().mkdirs();
            System.out.println(sourcePath.toAbsolutePath());
            System.out.println(targetPath.toAbsolutePath());
            try {
                Files.copy(sourcePath, targetPath);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.format("Couldn't copy %s to %s. Exception: %s%n", sourcePath.toAbsolutePath(), targetPath.toAbsolutePath(), e.getMessage());
            }

        }

    }
}
