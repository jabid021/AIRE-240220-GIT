package fr.formation;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.nio.charset.StandardCharsets;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class Application {
    private static final String HDFS_ENDPOINT = "hdfs://20.199.14.75:8020";

    public static void main(String[] args) throws Exception {
        Configuration config = new Configuration();

        // On se connect au serveur Hadoop HDFS
        try (FileSystem hdfs = FileSystem.get(new URI(HDFS_ENDPOINT), config)) {
            // Initialiser la création d'un fichier sur le HDFS
            Path file = new Path(HDFS_ENDPOINT + "/java/jeremy.txt");

            // Si le fichier existe ...
            if (hdfs.exists(file)) {
                // On le supprime !
                hdfs.delete(file, true);
            }

            // On crée le fichier
            OutputStream output = hdfs.create(file);

            // On écrit dans le fichier
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8))) {
                bw.append("Bonjour de Jérémy depuis JAVA !");
                bw.append("\n");
            }
        }
    }
}
