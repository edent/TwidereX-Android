package com.twidere.twiderex.scenes.settings

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.foundation.lazy.ExperimentalLazyDsl
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.twidere.twiderex.component.AppBar
import com.twidere.twiderex.component.AppBarNavigationButton
import com.twidere.twiderex.component.lazy.itemDivider
import com.twidere.twiderex.component.settings.radioItem
import com.twidere.twiderex.settings.AmbientTabPosition
import com.twidere.twiderex.settings.AmbientTheme
import com.twidere.twiderex.settings.primaryColorDialog

@OptIn(ExperimentalLazyDsl::class)
@Composable
fun AppearanceScene() {

    val tabPosition = AmbientTabPosition.current
    val theme = AmbientTheme.current
    var showPrimaryColorDialog by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            AppBar(
                navigationIcon = {
                    AppBarNavigationButton()
                },
                title = {
                    Text(text = "Appearance")
                },
            )
        }
    ) {
        if (showPrimaryColorDialog) {
            primaryColorDialog(
                onDismiss = {
                    showPrimaryColorDialog = false
                }
            )
        }
        LazyColumn {
            item {
                ListItem(
                    modifier = Modifier.clickable(
                        onClick = {
                            showPrimaryColorDialog = true
                        }
                    ),
                    text = {
                        Text(text = "Highlight color")
                    },
                    trailing = {
                        Box(
                            modifier = Modifier
                                .preferredHeight(24.dp)
                                .preferredWidth(32.dp)
                                .clip(MaterialTheme.shapes.small)
                                .aspectRatio(1F)
                                .background(MaterialTheme.colors.primary),
                        ) {
                        }
                    }
                )
            }
            itemDivider()
            radioItem(theme)
            itemDivider()
            radioItem(tabPosition)
        }
    }
}