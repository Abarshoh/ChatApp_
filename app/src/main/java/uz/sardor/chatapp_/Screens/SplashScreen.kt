package uz.sardor.chatapp_.Screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import uz.sardor.chatapp_.Database.Main
import uz.sardor.chatapp_.R

@Composable
fun SplashScreen(navController: NavController) {
    val context = LocalContext.current
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue =6f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {

                    OvershootInterpolator(9f).getInterpolation(it)
                })
        )
        delay(2000)
        if (Main.getSavedUser(context) == "") navController.navigate("SignIn")
        else navController.navigate("Home")
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(R.drawable.img),
            contentDescription = "Splash",
        )
    }
}