# String-Gzip-Utilities
Some simple Java String Wrappers for examples and a message converter that can be used to gzip and gunzip message contents.

##Pre-requisites
Java JDK 1.7


###Soasta Custom Scripting Module API
* cloudtest-plugin-api.jar 
* cloudtest-scripting-environment.jar 


```javascript
//String Functions Without Wrapper
var str = new java.lang.String("Hello World");
$context.result.postMessage($context.result.LEVEL_INFO, "str before: " + str);
str = str.replaceAll("l","LL");
$context.result.postMessage($context.result.LEVEL_INFO, "str after: " + str);
str = str.toLowerCase()
$context.result.postMessage($context.result.LEVEL_INFO, "str after: " + str);
```
Using a wrapper you can have more control over inputs and outputs and error handling within CloudTest.  In the example with the string the only reason you can do this is because the package is imported by default.

```javascript
//String Functions With Wrapper.  StringBuilder and String Types are both wrapped
importPackage(org.soasta.helper);

var StringBuilder = new StringBuilderHelper($context.createJavaEnvironment(),"Hello");

StringBuilder.Append(" World");
$context.result.postMessage($context.result.LEVEL_INFO, StringBuilder.ToString());

var length = StringBuilder.Length();
$context.result.postMessage($context.result.LEVEL_INFO, length);

var reverse = StringBuilder.Reverse();
$context.result.postMessage($context.result.LEVEL_INFO, reverse);

var StringHelper = new JavaStringHelper($context.createJavaEnvironment(),StringBuilder.Reverse());
var equalsString = StringHelper.EqualsIgnoreCase("DLROW OLLEH");
$context.result.postMessage($context.result.LEVEL_INFO, equalsString);

var matchesString = StringHelper.Matches("(?i:.*OLLEH.*)");
$context.result.postMessage($context.result.LEVEL_INFO, matchesString);

StringHelper.Replace("World", "SOASTA")
$context.result.postMessage($context.result.LEVEL_INFO, StringHelper.Value());

StringHelper.ToLowerCase();
$context.result.postMessage($context.result.LEVEL_INFO, StringHelper.Value());
```
For message conversion the class name "GzipConverter" would be entered as the module name for binary conversion for the target.  Then all messages for that target would have the compress and decompress methods invoked during processing.

```javascript
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
```
