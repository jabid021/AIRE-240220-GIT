package fr.formation;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

import fr.formation.wordcount.WordCountMapper;
import fr.formation.wordcount.WordCountReducer;

public class Application {
    public static void main(String[] args) throws Exception {
        JobConf conf = new JobConf(Application.class);

        conf.setJobName("Comptage de mots");
        
        // Clés et valeurs de sortie
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);

        // Quelle classe Mapper et Reducer
        conf.setMapperClass(WordCountMapper.class);
        conf.setReducerClass(WordCountReducer.class);

        // Quel type de format de fichier en entrée, et en sortie
        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);

        // Le ou les fichier(s) en entrée, et le répertoire de sortie
        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));

        // Exécuter du job
        JobClient.runJob(conf);
    }
}
