package net.jspiner.ask.ui.image

import android.graphics.*
import com.bumptech.glide.load.Key
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import java.security.MessageDigest
import kotlin.math.abs


class SquircleTransformer : BitmapTransformation() {
    private val ID = SquircleTransformer::class.simpleName!!
    private val ID_BYTES = ID.toByteArray(Key.CHARSET)

    override fun updateDiskCacheKey(messageDigest: MessageDigest) {
        messageDigest.update(ID_BYTES)
    }

    override fun transform(pool: BitmapPool, toTransform: Bitmap, outWidth: Int, outHeight: Int): Bitmap {
        val paint = Paint()

        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true

        val resultingImage = Bitmap.createBitmap(outWidth, outHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(resultingImage)
        canvas.drawPath(getSquirclePath(0f, 0f, outWidth / 2f), paint)

        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(toTransform, 0f, 0f, paint)
        return resultingImage
    }

    private fun getSquirclePath(left: Float, top: Float, radius: Float): Path {
        //Formula: (|x|)^3 + (|y|)^3 = radius^3
        val radiusToPow = radius * radius * radius.toDouble()
        val path = Path()
        path.moveTo(-radius, 0f)
        run {
            var x = -radius
            while (x <= radius) {
                path.lineTo(x, Math.cbrt(radiusToPow - abs(x * x * x)).toFloat())
                x++
            }
        }
        var x = radius
        while (x >= -radius) {
            path.lineTo(x, (-Math.cbrt(radiusToPow - abs(x * x * x))).toFloat())
            x--
        }
        path.close()
        val matrix = Matrix()
        matrix.postTranslate(left + radius, top + radius)
        path.transform(matrix)
        return path
    }

}