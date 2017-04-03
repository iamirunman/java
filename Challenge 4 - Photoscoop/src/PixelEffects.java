
/* A class to implement the various pixel effects.
 *
 * Todo: Put your netid (i.e. username) in the line below
 * 
 * @author pescar2
 */
public class PixelEffects
{

	/** Copies the source image to a new 2D integer image */
	public static int[][] copy(int[][] source)
	{
		// Create a NEW 2D integer array and copy the colors across
		// See redeye code below
		int width = source.length, height = source[0].length;
		int [][] sourceB = new int [width][height];
		
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++)
			{
				int rgb = source[i][j];
				int red = RGBUtilities.toRed(rgb);
				int green = RGBUtilities.toGreen(rgb);
				int blue = RGBUtilities.toBlue(rgb);
				
				sourceB[i][j] = RGBUtilities.toRGB(red, green, blue);
			}
		return sourceB; // Fix Me
	}
	/**
	 * Resize the array image to the new width and height
	 * You are going to need to figure out how to map between a pixel
	 * in the destination image to a pixel in the source image
	 * @param source
	 * @param newWidth
	 * @param newHeight
	 * @return
	 */
	public static int[][] resize(int[][] source, int newWidth, int newHeight)
	{
		int [][] resizedArray = new int [newWidth][newHeight];
		for(int i = 0; i <= newWidth-1; i++)
			for(int j = 0; j <= newHeight-1; j++) 
			{
				resizedArray [i][j] = source[(int)(((double)i/(double)newWidth)*source.length)]
											[(int)(((double)j/(double)newHeight)*source[0].length)];
			}
		return resizedArray; // Fix Me
		// Hints: Use two nested for loops between 0... newWidth-1 and 0.. newHeight-1 inclusive.
		// Hint: You can just use relative proportion to calculate the x (or y coordinate)  in the original image.
		// For example if you're setting a pixel halfway across the image, you should be reading half way across the original image too.
	}

	/**
	 * Half the size of the image. This method should be just one line! Just
	 * delegate the work to resize()!
	 */
	public static int[][] half(int[][] source)
	{
		return resize(source,source.length/2,source[0].length/2);// Fix Me
	}
	
	/**
	 * Create a new image array that is the same dimensions of the reference
	 * array. The array may be larger or smaller than the source. Hint -
	 * this methods should be just one line - delegate the work to resize()!
	 * 
	 * @param source
	 *            the source image
	 * @param reference
	 * @return the resized image
	 */
	public static int[][] resize(int[][] source, int[][] reference)
	{
		return resize(source,reference.length,reference[0].length); // Fix Me
	}

	/** Flip the image vertically */
	public static int[][] flip(int[][] source)
	{
		int sourceWidth = source.length;
		int sourceHeight = source[0].length;
		int newWidth = sourceWidth;
		int newHeight = sourceHeight;
		int[][] flippedImage = new int [newWidth][newHeight];
		for(int tgtX = 0;tgtX < newWidth ; tgtX++)
			for(int tgtY = 0;tgtY < newHeight ; tgtY++)
			{
				int srcY = (sourceHeight-1)-tgtY;
				int srcX = tgtX;
				flippedImage[tgtX][tgtY] = source[srcX][srcY];
			}
		return flippedImage;// Fix Me
	}

	/** Reverse the image horizontally */
	public static int[][] mirror(int[][] source)
	{
		int sourceWidth = source.length;
		int sourceHeight = source[0].length;
		int newWidth = sourceWidth;
		int newHeight = sourceHeight;
		int[][] mirroredImage = new int [newWidth][newHeight];
		for(int tgtX = 0;tgtX < newWidth ; tgtX++)
			for(int tgtY = 0;tgtY < newHeight ; tgtY++)
			{
				int srcY = tgtY;
				int srcX = (sourceWidth-1)-tgtX;
				mirroredImage[tgtX][tgtY] = source[srcX][srcY];
			}
		return mirroredImage;// Fix Me
	}

	/** Rotate the image */
	public static int[][] rotateLeft(int[][] source)
	{
		int sourceWidth = source[0].length;
		int sourceHeight = source.length;
		int targetWidth = sourceWidth;
		int targetHeight = sourceHeight;
		int[][] rotatedImage = new int [targetWidth][targetHeight];
		for(int tgtX = 0;tgtX < targetHeight ; tgtX++)
			for(int tgtY = 0;tgtY < targetWidth ; tgtY++)
			{
				rotatedImage[tgtY][targetHeight-tgtX-1] = source[tgtX][tgtY];
			}
		return rotatedImage;
	}

	/** Merge the red,blue,green components from two images */
	public static int[][] merge(int[][] sourceA, int[][] sourceB)
	{
		int [][] mergedImage = new int [sourceA.length][sourceA[0].length];
		for(int i = 0;i < sourceB.length; i++)
			for(int j = 0; j < sourceB[0].length; j++)
			{
				int SARed = RGBUtilities.toRed(sourceA[i][j]);//get components of source A
				int SAGreen = RGBUtilities.toGreen(sourceA[i][j]);
				int SABlue = RGBUtilities.toBlue(sourceA[i][j]);
				
				int SBRed = RGBUtilities.toRed(sourceB[i][j]);//get components of source B
				int SBGreen = RGBUtilities.toGreen(sourceB[i][j]);
				int SBBlue = RGBUtilities.toBlue(sourceB[i][j]);
				
				int newSRed = (int)(((SARed + SBRed)/2));//average of A & B to get merged component
				int newSGreen = (int)(((SAGreen + SBGreen)/2));
				int newSBlue = (int)(((SABlue + SBBlue)/2));
				
				mergedImage[i][j] = RGBUtilities.toRGB(newSRed,newSGreen,newSBlue);
			}
		// The output should be the same size as the input. Scale (x,y) values
		// when reading the background
		// (e.g. so the far right pixel of the source is merged with the
		// far-right pixel of the background).
		//return sourceA;
		return mergedImage;
	}

	/**
	 * Replace the green areas of the foreground image with parts of the back
	 * image
	 */
	public static int[][] chromaKey(int[][] foreImage, int[][] backImage)
	{
		if((foreImage.length != backImage.length) && (foreImage[0].length != backImage[0].length) )
		{
			resize(foreImage, backImage.length, backImage[0].length);
		}
		
		int width = foreImage.length, height = foreImage[0].length;
		int[][] result = new int[width][height];
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++)
			{
				int rgb = foreImage[i][j];
				int rgb2 = backImage [i][j];
				
				int red = RGBUtilities.toRed(rgb);//foreImage colors
				int green = RGBUtilities.toGreen(rgb);
				int blue = RGBUtilities.toBlue(rgb);
				
				int red2 = RGBUtilities.toRed(rgb2);//backImage colors
				int green2 = RGBUtilities.toGreen(rgb2);
				int blue2 = RGBUtilities.toBlue(rgb2);
				
				if (green > 4 * Math.max(red, blue) && green > 64)//checks forImage for green
				{
					green = green2;//changes foreImage color to backImage color
					red = red2;
					blue = blue2;
				}
				result[i][j] = RGBUtilities.toRGB(red, green, blue);
			}
		// If the image has a different size than the background use the
		// resize() method
		// create an image the same as the background size.
		return result;
	}

	/** Removes "redeye" caused by a camera flash. sourceB is not used */
	public static int[][] redeye(int[][] source, int[][] sourceB)
	{

		int width = source.length, height = source[0].length;
		int[][] result = new int[width][height];
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++)
			{
				int rgb = source[i][j];
				int red = RGBUtilities.toRed(rgb);
				int green = RGBUtilities.toGreen(rgb);
				int blue = RGBUtilities.toBlue(rgb);
				if (red > 4 * Math.max(green, blue) && red > 64)
					red = green = blue = 0;
				result[i][j] = RGBUtilities.toRGB(red, green, blue);
			}

		return result;
	}

	/* Upto you! do something fun to the image */
	/*shrink image*/
	public static int[][] funky(int[][] source, int[][] sourceB)
	{
		int srcWidth = source.length;
		int srcHeight = source[0].length;
		int tgtWidth = srcWidth;
		int tgtHeight = srcHeight;
		int [][] funkyImage = new int [tgtWidth][tgtHeight];
		for(int i = 0;i < srcWidth; i++)
			for(int j = 0;j < srcHeight; j++)
			{
				int srcY = (int)((j/(double)tgtHeight)*srcWidth);
				int srcX = (int)((i/(double)tgtWidth)*srcHeight);
				funkyImage [i][j] = source[srcX][srcY];
			}
		return funkyImage;
		// You need to invent your own image effect
		// Minimum boring requirements to pass autograder:
		// Does not ask for any user input and returns a new 2D array
		// Todo: remove this return null
	}
}
