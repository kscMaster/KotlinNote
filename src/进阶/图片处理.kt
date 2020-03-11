package 进阶

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

// 图片处理

fun main() {
    val w = 0..99
    val h = 0..99
    // 内存中建立一个100*100的RGB图片
    var image = BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB)
    image.setRGB(0, 0, 0xFF0000)
    image.apply {
        for (i in w) {
            for (j in h) {
                setRGB(i, j, 0xff0000)
            }
        }
    }
    ImageIO.write(image, "bmp", File("a.bmp"))
}