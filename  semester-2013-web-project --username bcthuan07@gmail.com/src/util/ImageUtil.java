/**
 * 
 */
package util;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * @author Thuan
 * 
 */
public class ImageUtil {

	/**
	 * Thay đổi kích thước ảnh
	 * @param origin: ảnh gốc
	 * @param width: chiều rộng
	 * @param height: chiều cao
	 * @param path: đường dẫn
	 * @return
	 */
	public static boolean resizeImage(
			final int width, final int height, String path) {
		try {
			BufferedImage origin = ImageIO.read(new File(path));
			int type = origin.getType()==0? BufferedImage.TYPE_INT_ARGB : origin.getType();
			BufferedImage resizedImage = new BufferedImage(width, height, type);
			Graphics2D g = resizedImage.createGraphics();
			g.drawImage(origin, 0, 0, width, height, null);
			g.dispose();
			g.setComposite(AlphaComposite.Src);

			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
					RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g.setRenderingHint(RenderingHints.KEY_RENDERING,
					RenderingHints.VALUE_RENDER_QUALITY);
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			ImageIO.write(resizedImage, "jpg", new File(path));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(ImageUtil.resizeImage(300, 300, "e:/4.png"));
	}
}
