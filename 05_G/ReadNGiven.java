package zGoo;

public class ReadNGiven {

	
	public int read(char[] buf, int n) {
		int count = 0;
		char[] buf4 = new char[4];
	    for (int i = 0; i <= n/4; i++) {
	    	int len = read4(buf4);
	    	if (count + len < n) {
	    		System.arraycopy(buf4, 0, buf, count, len);
	    		count += len;
	    	} else {
	    		System.arraycopy(buf4, 0, buf, count, n-count);
	    		count = n;
	    	}
	    }
	    return count;
	}
	
	public int read(char[] buf, int n) {
		  boolean eof = false;      // end of file flag
		  int total = 0;            // total bytes have read
		  char[] tmp = new char[4]; // temp buffer
		  
		  while (!eof && total < n) {
		    int count = read4(tmp);
		    
		    // check if it's the end of the file
		    eof = count < 4;
		    
		    // get the actual count
		    count = Math.min(count, n - total);
		    
		    // copy from temp buffer to buf
		    for (int i = 0; i < count; i++) 
		      buf[total++] = tmp[i];
		  }
		  
		  return total;
		}

}

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        
        char[] buffer = new char[4];
        boolean endOfFile = false;
        int readBytes = 0;
        
        while (readBytes < n && !endOfFile) {
            int currReadBytes = read4(buffer);
            if (currReadBytes !=4) {
                endOfFile = true;
            }
            int length = Math.min(n - readBytes, currReadBytes);
            for (int i=0; i<length; i++) {
                buf[readBytes + i] = buffer[i];
            }
            readBytes += length;
        }
        return readBytes;
    }
}
