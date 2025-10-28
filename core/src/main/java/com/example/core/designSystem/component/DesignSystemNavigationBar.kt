package com.example.core.designSystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.core.designSystem.icon.Close
import com.example.core.designSystem.theme.DesignSystemTheme
//
//@Composable
//fun PrimaryNavigationBar(
//    route: List<NavigationItem>,
//    currentTab: Int,
//    onSelectedTab: (Int) -> Unit
//) {
//    NavigationBar {
//        route.forEachIndexed { index, value ->
//            NavigationBarItem(
//                selected = currentTab == index,
//                onClick = {
//                    onSelectedTab(index)
//                },
//                icon = {
//                    DesignSystemIcon(
//                        icon = if (currentTab == index) value.selectedIcon else value.unselectedIcon
//                    )
//                },
//                label = { value.label?.let { Text(it) } },
//            )
//        }
//    }
//}
//
//object DesignSystemNavigationBar {
//    @Composable
//    fun RoundedNavigationBar(
//        route: List<NavigationItem>,
//        currentTab: Int,
//        onSelectedTab: (Int) -> Unit
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(
//                    color = Color.Transparent,
//                    shape = RoundedCornerShape(
//                        topStart = DesignSystemTheme.space.space2,
//                        topEnd = DesignSystemTheme.space.space2,
//                    )
//                )
//                .border(
//                    width = DesignSystemTheme.space.space1,
//                    color = DesignSystemTheme.color.primary.outline,
//                    shape = RoundedCornerShape(
//                        topStart = DesignSystemTheme.space.space2,
//                        topEnd = DesignSystemTheme.space.space2,
//                    )
//                )
//        ) {
//            PrimaryNavigationBar(
//                route = route,
//                currentTab = currentTab,
//                onSelectedTab = onSelectedTab
//            )
//        }
//    }
//}
//
interface NavigationItem {
    val route: String
    val label: String?
    val selectedIcon: ImageVector
    val unselectedIcon: ImageVector
}
//
//private data class NavigationItemPreview(
//    override val route: String,
//    override val label: String? = null,
//    override val selectedIcon: ImageVector = Close,
//    override val unselectedIcon: ImageVector = Close
//) : NavigationItem
////
////@DesignSystemPreview
////@Composable
////private fun DesignSystemNavigationBar_RoundedNavigationBar_Preview() {
////    DesignSystemNavigationBar.RoundedNavigationBar(
////        route = listOf(
////            NavigationItemPreview(route = "first"),
////            NavigationItemPreview(route = "second"),
////        ),
////        currentTab = 0,
////        onSelectedTab = { index -> index }
////    )
////}