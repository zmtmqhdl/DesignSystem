package com.example.presentation.screen.main

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.example.core.designSystem.component.DSNavigationBar
import com.example.core.designSystem.component.DSScreen
import com.example.core.designSystem.component.DSSnackBarState
import com.example.core.designSystem.component.DSText
import com.example.core.designSystem.component.DSTextField
import com.example.core.designSystem.component.NavigationBarVariant
import com.example.core.designSystem.component.TextFieldVariant
import com.example.domain.model.domain.ProductDomain
import com.example.presentation.navigation.NavigationItems
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    backStack: NavBackStack<NavKey>
) {
    val snackBarHostState = remember { DSSnackBarState() }
    var isLoading by remember { mutableStateOf(true) }



    val viewModel: MainViewModel = hiltViewModel()

    val pagingItems = viewModel.products.collectAsLazyPagingItems()

    LaunchedEffect(Unit) {
        viewModel.test()
        delay(2000)
        isLoading = false
    }
    val isRefreshing = pagingItems.loadState.refresh is LoadState.Loading

    LaunchedEffect(pagingItems.loadState) {
        Log.d("PagingDebug", "Mediator Refresh: ${pagingItems.loadState.mediator?.refresh}")
        Log.d("PagingDebug", "Source Refresh: ${pagingItems.loadState.source.refresh}")
    }

    DSScreen(
        bottomBar = {
            DSNavigationBar(
                variant = NavigationBarVariant.ROUND,
                backStack = backStack,
                navigationItems = listOf(
                    NavigationItems.Main,
                    NavigationItems.First
                ),
            )
        },
        padding = true,
        snackBarState = snackBarHostState
    ) {

        val state = rememberTextFieldState()

        DSTextField(
            state = state,
            placeholder = "placeholder",
            onKeyboardActionClick = {},
            variant = TextFieldVariant.PASSWORD,
            isLoading = isLoading
        )

        DSText(
            text = "testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest",
            marquee = true
        )

        PullToRefreshBox(
            isRefreshing = isRefreshing,
            onRefresh = {
                // 🌟 당겼을 때 RemoteMediator의 REFRESH를 구동합니다.
                pagingItems.refresh()
            },
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                // 1. Paging 아이템 리스트
                items(
                    count = pagingItems.itemCount,
                    key = pagingItems.itemKey { it.id }
                ) { index ->
                    val product = pagingItems[index]
                    if (product != null) {
                        ProductItem(product = product)
                        HorizontalDivider()
                    }
                }


            }
        }

//        DSImage(
//            model = "https://images.unsplash.com/photo-1534528741775-53994a69daeb?w=500",
//            modifier = Modifier.fillMaxSize(),
//            onError = { Log.e("dd", "DDD") },
//            contentDescription = "",
//        )
    }

}


@Composable
private fun ProductItem(
    product: ProductDomain,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        DSText(text = "ID: ${product.id}")
        DSText(text = product.name)
        DSText(text = "${product.price}원")
    }
}
