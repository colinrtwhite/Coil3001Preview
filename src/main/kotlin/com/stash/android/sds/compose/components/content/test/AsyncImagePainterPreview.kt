package com.stash.android.sds.compose.components.content.test

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import coil3.ColorImage
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.AsyncImagePainter
import coil3.compose.AsyncImagePreviewHandler
import coil3.compose.LocalAsyncImagePreviewHandler
import coil3.compose.rememberAsyncImagePainter

@OptIn(ExperimentalCoilApi::class)
@Composable
internal fun CoilPreviewBug() {
    val previewHandler = AsyncImagePreviewHandler { ColorImage(Color.Red.toArgb()) }
    CompositionLocalProvider(
        LocalAsyncImagePreviewHandler provides previewHandler,
    ) {
        val painter = rememberAsyncImagePainter("https://example.com/image.jpg")
        val state by painter.state.collectAsState()

        when (state) {
            is AsyncImagePainter.State.Empty,
            is AsyncImagePainter.State.Loading -> {
                CircularProgressIndicator()
            }

            is AsyncImagePainter.State.Success -> {
                Image(
                    painter = painter,
                    contentDescription = null,
                )
            }

            is AsyncImagePainter.State.Error -> {
                // Show some error UI.
            }
        }
    }
}

@Composable
@Preview(name = "1 - Light Mode", device = Devices.PIXEL_4_XL)
@Preview(name = "2 - Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.PIXEL_4_XL)
@Preview(name = "3 - Light Mode - Large", device = Devices.PIXEL_4_XL, fontScale = 2.0f)
internal fun CoilPreviewBugPreview() {
    CoilPreviewBug()
}
