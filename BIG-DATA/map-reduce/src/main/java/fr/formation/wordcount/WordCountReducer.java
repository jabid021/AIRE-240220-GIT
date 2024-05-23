package fr.formation.wordcount;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

// Clé d'entrée, Valeur d'entrée, Clé de sortie, Valeur de sortie
public class WordCountReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
    // dans : 1, 1, 1, 1
    // cette : 1, 1
    // phrase : 1, 1
    // ce : 1, 1
    // mot : 1, 1

    //

    // dans : 4
    // cette : 2
    // phrase : 2
    // ce : 2
    // mot : 2

    @Override
    public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
        int somme = 0;

        while (values.hasNext()) {
            // somme++;
            somme += values.next().get();
        }

        output.collect(key, new IntWritable(somme));
    }
}
