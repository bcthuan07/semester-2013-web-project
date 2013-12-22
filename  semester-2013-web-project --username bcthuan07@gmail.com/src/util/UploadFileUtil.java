/**
 * 
 */
package util;

import javax.servlet.http.Part;

/**
 * @author Thuan
 *
 */
public class UploadFileUtil {

	public static String getFileName(final Part part){
		final String partHeader = part.getHeader("content-disposition");
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
}
