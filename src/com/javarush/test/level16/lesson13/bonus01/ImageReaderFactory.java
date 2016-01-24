package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Administator on 27.09.2015.
 */
public class ImageReaderFactory
{

    public static ImageReader getReader(ImageTypes type)
    {
        /*switch(type)
        {
            case BMP: return new BmpReader();
            case JPG: return new JpgReader();
            case PNG: return new PngReader();
            default: throw new IllegalArgumentException();
        }*/
        if (type == ImageTypes.BMP) return new BmpReader();
        if (type == ImageTypes.JPG) return new JpgReader();
        if (type == ImageTypes.PNG) return new PngReader();
        throw new IllegalArgumentException();
    }
}
