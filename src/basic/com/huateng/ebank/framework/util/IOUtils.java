package com.huateng.ebank.framework.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author YiSiliang
 * @date 2018/12/19 16:59
 */
public class IOUtils {

    public static void closeQuietly(final OutputStream output) {
        closeQuietly((Closeable) output);
    }


    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            // ignore
        }
    }

    public static void closeQuietly(final AutoCloseable autoCloseable) {
        try {
            if (autoCloseable != null) {
                autoCloseable.close();
            }
        } catch (final Exception ioe) {
            // ignore
        }
    }

}
