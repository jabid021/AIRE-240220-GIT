package fr.formation.wordcount;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

// Types = Clé d'entrée, Valeur d'entrée, Clé de sortie, Valeur de sortie
public class WordCountMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
    // 0 : dans cette phrase dans ce mot.
    // 1 : dans cette phrase dans ce mot.
    // dans : 1
    // cette : 1
    // phrase : 1
    // dans : 1
    // ce : 1
    // mot : 1
    // dans : 1
    // cette : 1
    // phrase : 1
    // dans : 1
    // ce : 1
    // mot : 1

    //

    // dans : 1, 1, 1, 1
    // cette : 1, 1
    // phrase : 1, 1
    // ce : 1, 1
    // mot : 1, 1
    
    @Override
    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
        String line = value.toString();
        StringTokenizer tokenizer = new StringTokenizer(line);

        while (tokenizer.hasMoreTokens()) {
            String mot = tokenizer.nextToken();

            output.collect(new Text(mot), new IntWritable(1));
        }
    }
}
