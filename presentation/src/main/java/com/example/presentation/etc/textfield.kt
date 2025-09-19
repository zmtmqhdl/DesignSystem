package com.example.presentation.etc

//@Composable
//fun NewTextField(
//    modifier: Modifier = Modifier,
//    value: String,
//    height: Dp = 56.dp,
//    placeholder: String = "",
//    onValueChange: (String) -> Unit,
//    maxLength: Int? = null,
//    enabled: Boolean = true,
//    focusRequester: FocusRequester? = null,
//    singleLine: Boolean = true,
//    focusedContainerColor: Color = Theme.color.textFieldDefault,
//    unfocusedContainerColor: Color = Theme.color.textFieldDisabled,
//    focusedBorderColor: Color = Theme.color.primary100,
//    focusedTextColor: Color = Theme.color.textPrimary,
//    unfocusedBorderColor: Color = Theme.color.textFieldDisabled,
//    unfocusedTextColor: Color = Theme.color.textPrimary,
//    disabledTextColor: Color = Theme.color.textDisabled,
//    disabledBorderColor: Color = Theme.color.textFieldDisabled,
//    textFieldType: TextFieldType = TextFieldType.TEXT,
//    deleteIcon: Boolean = false,
//    onDeleteIconClick: () -> Unit = {},
//    imeAction: TextFieldImeAction = TextFieldImeAction.DONE,
//) {
//    OutlinedTextField(
//        value = value,
//        onValueChange = { input ->
//            var updated = input
//            if (textFieldType == TextFieldType.TEXT) {
//                updated = updated.replace(Regex("[^0-9a-zA-Zㄱ-ㅎ가-힣ㆍ ]"), "")
//            } else if (textFieldType == TextFieldType.NUMBER) {
//                updated = updated.replace(Regex("[^0-9]"), "")
//            }
//            maxLength?.let { len ->
//                if (updated.length > len) updated = updated.take(len)
//            }
//            onValueChange(updated.trim())
//        },
//        modifier = modifier
//            .then(
//                if (focusRequester != null) Modifier.focusRequester(focusRequester)
//                else Modifier
//            )
//            .fillMaxWidth()
//            .height(height),
//        enabled = enabled,
//        placeholder = {
//            if (value.isEmpty() && placeholder.isNotEmpty()) {
//                Text(
//                    text = placeholder,
//                    color = Theme.color.textInfo,
//                    style = Theme.typography.detailSmall
//                )
//            }
//        },
//        trailingIcon = {
//            if (deleteIcon && value.isNotEmpty()) {
//                IconBox(
//                    icon = Delete,
//                    boxWidth = 24.dp,
//                    boxHeight = 24.dp,
//                    iconWidth = 24.dp,
//                    iconHeight = 24.dp,
//                    color = Theme.color.iconSecondary,
//                    onClick = { onDeleteIconClick() }
//                )
//            }
//        },
//        singleLine = singleLine,
//        keyboardOptions = KeyboardOptions(
//            keyboardType = if (textFieldType == TextFieldType.NUMBER) {
//                KeyboardType.Number
//            } else if (textFieldType == TextFieldType.EMAIL) {
//                KeyboardType.Email
//            } else {
//                KeyboardType.Text
//            },
//            imeAction = when(imeAction) {
//                TextFieldImeAction.DONE -> ImeAction.Done
//                TextFieldImeAction.NEXT -> ImeAction.Next
//            }
//        ),
//        shape = RoundedCornerShape(8.dp),
//        textStyle = Theme.typography.detailSmall.copy(
//            color = Theme.color.textPrimary
//        ),
//        colors = OutlinedTextFieldDefaults.colors(
//            focusedBorderColor = focusedBorderColor,
//            focusedContainerColor = focusedContainerColor,
//            focusedTextColor = focusedTextColor,
//            unfocusedBorderColor = unfocusedBorderColor,
//            unfocusedContainerColor = unfocusedContainerColor,
//            unfocusedTextColor = unfocusedTextColor,
//            disabledTextColor = disabledTextColor,
//            disabledBorderColor = disabledBorderColor,
//            disabledContainerColor = unfocusedContainerColor
//        )
//    )
//}
//
//enum class TextFieldType {
//    TEXT, NUMBER, ALL, EMAIL
//}
//
//enum class TextFieldImeAction {
//    NEXT, DONE
//}