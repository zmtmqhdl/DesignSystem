import androidx.compose.runtime.Composable
import com.example.core.designSystem.DS

//
//fun SnackBar(
//    backgroundColor: Color?,
//    duration: SnackbarDuration = SnackbarDuration.Short,
//    icon: ImageVector?,
//    iconColor: Color?,
//    outlineColor: Color?,
//    snackBarHostState: SnackbarHostState,
//    text: String,
//) {
//    snackBarHostState.currentSnackbarData?.dismiss()
//
//    CoroutineScope(Dispatchers.Main).launch {
//        snackBarHostState.showSnackbar(
//            DesignSystemSnackBarVisuals(
//                backgroundColor = backgroundColor,
//                duration = duration,
//                icon = icon,
//                iconColor = iconColor,
//                message = text,
//                outlineColor = outlineColor
//            )
//        )
//    }
//}
//
//data class DesignSystemSnackBarVisuals(
//    override val actionLabel: String? = null,
//    val backgroundColor: Color? = null,
//    override val duration: SnackbarDuration = SnackbarDuration.Short,
//    val icon: ImageVector? = null,
//    val iconColor: Color? = null,
//    override val message: String,
//    val outlineColor: Color? = null,
//    override val withDismissAction: Boolean = false,
//) : SnackbarVisuals
//
//@Composable
//fun DesignSystemSnackBar(
//    snackBarHostState: SnackbarHostState,
//    icon: ImageVector? = null,
//    iconColor: Color = DesignSystemTheme.color.black,
//    containerColor: Color = DesignSystemTheme.color.white,
//    color: DesignSystemColorSet = DesignSystemTheme.color.primary
//) {
//    SnackbarHost(
//        hostState = snackBarHostState,
//        snackbar = { snackBarData ->
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .border(
//                        width = DesignSystemTheme.space.space0,
//                        color = color.outline,
//                        shape = DesignSystemTheme.shape.snackBar
//                    )
//                    .background(color = containerColor, shape = DesignSystemTheme.shape.snackBar)
//            ) {
//                Row(
//                    modifier = Modifier.padding(DesignSystemTheme.space.space4),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    icon?.let {
//                        DesignSystemIcon(
//                            icon = icon,
//                            color = iconColor,
//                        )
//                    }
//                    Text(
//                        text = snackBarData.visuals.message,
//                        color = color.fontColor,
//                        textAlign = TextAlign.Center,
//                        style = DesignSystemTheme.typography.s.medium
//                    )
//                }
//            }
//        }
//    )
//}
//
//@DesignSystemPreview
//@Composable
//fun DesignSystemSnackBarPreview() {
//
//    val snackBarHostState = remember { SnackbarHostState() }
//
//    LaunchedEffect(Unit) {
//        snackBarHostState.showSnackbar("message")
//    }
//
//    DesignSystemTheme {
//        DesignSystemSnackBar(
//            snackBarHostState = snackBarHostState,
//            icon = Person,
//            iconColor = DesignSystemTheme.color.primary.fontColor
//        )
//    }
//}


@Composable
fun DS.SSnackBar() {}