/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:OptIn(
    ExperimentalHorologistPaparazziApi::class,
    ExperimentalHorologistBaseUiApi::class,
    ExperimentalHorologistComposeToolsApi::class
)

package com.google.android.horologist.base.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.materialPath
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.dp
import com.google.android.horologist.base.ui.ExperimentalHorologistBaseUiApi
import com.google.android.horologist.base.ui.util.rememberVectorPainter
import com.google.android.horologist.compose.tools.ExperimentalHorologistComposeToolsApi
import com.google.android.horologist.compose.tools.coil.FakeImageLoader
import com.google.android.horologist.compose.tools.snapshotInABox
import com.google.android.horologist.paparazzi.ExperimentalHorologistPaparazziApi
import com.google.android.horologist.paparazzi.WearPaparazzi
import org.junit.Rule
import org.junit.Test

class PrimaryChipTest {

    @get:Rule
    val paparazzi = WearPaparazzi()

    @Test
    fun default() {
        paparazzi.snapshotInABox {
            StandardChip(
                label = "Primary label",
                onClick = { }
            )
        }
    }

    @Test
    fun withSecondaryLabel() {
        paparazzi.snapshotInABox {
            StandardChip(
                label = "Primary label",
                onClick = { },
                secondaryLabel = "Secondary label"
            )
        }
    }

    @Test
    fun withIcon() {
        paparazzi.snapshotInABox {
            StandardChip(
                label = "Primary label",
                onClick = { },
                icon = Icons.Default.Image
            )
        }
    }

    @Test
    fun withLargeIcon() {
        paparazzi.snapshotInABox {
            StandardChip(
                label = "Primary label",
                onClick = { },
                icon = Icon32dp,
                largeIcon = true
            )
        }
    }

    @Test
    fun withSecondaryLabelAndIcon() {
        paparazzi.snapshotInABox {
            StandardChip(
                label = "Primary label",
                onClick = { },
                secondaryLabel = "Secondary label",
                icon = Icons.Default.Image
            )
        }
    }

    @Test
    fun withSecondaryLabelAndLargeIcon() {
        paparazzi.snapshotInABox {
            StandardChip(
                label = "Primary label",
                onClick = { },
                secondaryLabel = "Secondary label",
                icon = Icon32dp,
                largeIcon = true
            )
        }
    }

    @Test
    fun disabled() {
        paparazzi.snapshotInABox {
            StandardChip(
                label = "Primary label",
                onClick = { },
                secondaryLabel = "Secondary label",
                icon = Icons.Default.Image,
                enabled = false
            )
        }
    }

    @Test
    fun withLongText() {
        paparazzi.snapshotInABox {
            StandardChip(
                label = "Primary label very very very very very very very very very very very very very very very very very long text",
                onClick = { }
            )
        }
    }

    @Test
    fun withSecondaryLabelAndLongText() {
        paparazzi.snapshotInABox {
            StandardChip(
                label = "Primary label very very very very very very very very long text",
                onClick = { },
                secondaryLabel = "Secondary label very very very very very very very very very long text",
                icon = Icons.Default.Image
            )
        }
    }

    @Test
    fun usingSmallIcon() {
        paparazzi.snapshotInABox {
            StandardChip(
                label = "Primary label",
                onClick = { },
                icon = Icon12dp
            )
        }
    }

    @Test
    fun withLargeIconUsingSmallIcon() {
        paparazzi.snapshotInABox {
            StandardChip(
                label = "Primary label",
                onClick = { },
                icon = Icon12dp,
                largeIcon = true
            )
        }
    }

    @Test
    fun usingExtraLargeIcon() {
        paparazzi.snapshotInABox {
            StandardChip(
                label = "Primary label",
                onClick = { },
                icon = Icon48dp
            )
        }
    }

    @Test
    fun withLargeIconUsingExtraLargeIcon() {
        paparazzi.snapshotInABox {
            StandardChip(
                label = "Primary label",
                onClick = { },
                icon = Icon48dp,
                largeIcon = true
            )
        }
    }

    @Test
    fun withPlaceholderIcon() {
        paparazzi.snapshotInABox {
            StandardChip(
                label = "Primary label",
                onClick = { },
                icon = Icons.Default.Image
            )
        }
    }

    @Test
    fun disabledWithIconPlaceholder() {
        paparazzi.snapshotInABox {
            FakeImageLoader.Never.override {
                // In inspection mode will jump to placeholder
                CompositionLocalProvider(LocalInspectionMode.provides(true)) {
                    StandardChip(
                        label = "Primary label",
                        onClick = { },
                        secondaryLabel = "Secondary label",
                        icon = "iconUri",
                        placeholder = rememberVectorPainter(
                            image = Icons.Default.Image,
                            tintColor = Color.Black
                        ),
                        enabled = false
                    )
                }
            }
        }
    }

    companion object {

        private val Icon12dp: ImageVector
            get() = ImageVector.Builder(
                name = "Icon Small",
                defaultWidth = 12f.dp,
                defaultHeight = 12f.dp,
                viewportWidth = 12f,
                viewportHeight = 12f
            )
                .materialPath {
                    horizontalLineToRelative(12.0f)
                    verticalLineToRelative(12.0f)
                    horizontalLineTo(0.0f)
                    close()
                }
                .build()

        private val Icon32dp: ImageVector
            get() = ImageVector.Builder(
                name = "Icon Large",
                defaultWidth = 32f.dp,
                defaultHeight = 32f.dp,
                viewportWidth = 32f,
                viewportHeight = 32f
            )
                .materialPath {
                    horizontalLineToRelative(32.0f)
                    verticalLineToRelative(32.0f)
                    horizontalLineTo(0.0f)
                    close()
                }
                .build()

        private val Icon48dp: ImageVector
            get() = ImageVector.Builder(
                name = "Icon Extra Large",
                defaultWidth = 48f.dp,
                defaultHeight = 48f.dp,
                viewportWidth = 48f,
                viewportHeight = 48f
            )
                .materialPath {
                    horizontalLineToRelative(48.0f)
                    verticalLineToRelative(48.0f)
                    horizontalLineTo(0.0f)
                    close()
                }
                .build()
    }
}
