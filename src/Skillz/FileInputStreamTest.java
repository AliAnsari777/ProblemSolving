package Skillz;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Describe the conditions under which the use of this method can result in
 * reaching an operating system limit.  Fix the method as elegantly as
 * possible.
 */

public class FileInputStreamTest {
    public int readFirstByte(final File f) throws IOException {
        FileInputStream inStream = new FileInputStream(f);
        int bytes = inStream.read();
        inStream.close();
        return bytes;
    }
}
