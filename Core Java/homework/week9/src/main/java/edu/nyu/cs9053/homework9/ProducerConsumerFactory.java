package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;


public class ProducerConsumerFactory {

    public static Producer createProducer() {
	// TODO

        Producer producer = new ImplementProducer();
        return producer;
    }

    public static Consumer createConsumer() {
	// TODO

        Consumer consumer = new ImplementConsumer();
        return consumer;
    }

}
