package org.soasta.convert;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import com.soasta.plugins.transport.v1.MessageConverter;

public final class GzipConverter implements MessageConverter {

	public static byte[] compress(String string) throws IOException {
	    ByteArrayOutputStream os = new ByteArrayOutputStream(string.length());
	    GZIPOutputStream gos = new GZIPOutputStream(os);
	    gos.write(string.getBytes());
	    gos.close();
	    byte[] compressed = os.toByteArray();
	    os.close();
	    return compressed;
	}

	public static String decompress(byte[] compressed) throws IOException {
	    final int BUFFER_SIZE = 32;
	    ByteArrayInputStream is = new ByteArrayInputStream(compressed);
	    GZIPInputStream gis = new GZIPInputStream(is, BUFFER_SIZE);
	    StringBuilder string = new StringBuilder();
	    byte[] data = new byte[BUFFER_SIZE];
	    int bytesRead;
	    while ((bytesRead = gis.read(data)) != -1) {
	        string.append(new String(data, 0, bytesRead));
	    }
	    gis.close();
	    is.close();
	    return string.toString();
	}
	
	@Override
	public String deserializeResponse(byte[] resp) throws Exception {
		return decompress(resp);
	}

	@Override
	public byte[] serializeRequest(String req) throws Exception {
		return compress(req);
	}

}

