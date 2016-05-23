package model.utils;

import java.lang.instrument.Instrumentation;


/**
 * The Class ObjectSizeFetcher.
 */
public class ObjectSizeFetcher {
    
    /** The instrumentation. */
    private static Instrumentation instrumentation;

    /**
     * Premain.
     *
     * @param args the args
     * @param inst the Instrumentation
     */
    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
    }

    /**
     * Gets the object size.
     *
     * @param o the Object
     * @return the object size
     */
    public static long getObjectSize(Object o) {
        return instrumentation.getObjectSize(o);
    }
}