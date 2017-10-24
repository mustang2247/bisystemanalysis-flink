package org.apache.flink.examples.java.wordcount;

import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.examples.java.wordcount.util.Word;

public class MyReduceFunction implements ReduceFunction<Word> {

//    new ReduceFunction<WordCountPojo.Word>() {
//        @Override
//        public WordCountPojo.Word reduce(WordCountPojo.Word value1, WordCountPojo.Word value2) throws Exception {
//            return new WordCountPojo.Word(value1.word, value1.frequency + value2.frequency);
//        }
//    }

    @Override
    public Word reduce(Word value1, Word value2) throws Exception {
        return new Word(value1.getWord(), value1.getFrequency() + value2.getFrequency());
    }
}
