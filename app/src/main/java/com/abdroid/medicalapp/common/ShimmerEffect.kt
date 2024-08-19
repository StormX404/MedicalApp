package com.abdroid.medicalapp.common

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdroid.medicalapp.R
import com.abdroid.medicalapp.presentation.home.components.IconItem
import com.abdroid.medicalapp.util.Dimens
import com.abdroid.medicalapp.util.Dimens.MediumPadding1

fun Modifier.shimmerEffect(cornerRadius: CornerRadius = CornerRadius(x = 12f, y = 12f)) = composed {
    val transition = rememberInfiniteTransition(label = "shimmer effect")
    val alpha = transition.animateFloat(
        initialValue = 0.2f, targetValue = 0.9f, animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000), repeatMode = RepeatMode.Reverse
        ), label = "transparency of the background color"
    ).value
    val color =  colorResource(id = R.color.shimmer).copy(alpha = alpha)
    drawBehind {
        drawRoundRect(
            color = color, cornerRadius = cornerRadius
        )
    }
}

@Composable
fun ShimmerEffect() {
    Column(
        Modifier
            .background(color = colorResource(id = R.color.background))
            .fillMaxSize()
            .statusBarsPadding()
            .systemBarsPadding()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.padding(top = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .height(80.dp)
                        .width(170.dp)
                        .shimmerEffect()

                )
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .shimmerEffect(),
                    )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .height(60.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(85.dp))
                        .shimmerEffect()

                )
            }
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconItemShimmer()
                    IconItemShimmer()
                    IconItemShimmer()
                    IconItemShimmer()
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(2f / 1f)
                        .shimmerEffect()
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Box(
                        modifier = Modifier
                            .height(18.dp)
                            .width(120.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .shimmerEffect()
                    )
                    Box(
                        modifier = Modifier
                            .height(18.dp)
                            .width(120.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .shimmerEffect()
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(130.dp)
                            .height(180.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .shimmerEffect()
                    )
                    Box(
                        modifier = Modifier
                            .width(130.dp)
                            .height(180.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .shimmerEffect()
                    )
                    Box(
                        modifier = Modifier
                            .width(130.dp)
                            .height(180.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .shimmerEffect()
                    )
                }
            }
        }
    }
}

@Composable
fun IconItemShimmer(){
    Column (
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)){
        Box(
            modifier = Modifier
                .size(55.dp)
                .clip(RoundedCornerShape(8.dp))
                .shimmerEffect()
        )
        Box(
            modifier = Modifier
                .width(55.dp)
                .height(10.dp)
                .clip(RoundedCornerShape(8.dp))
                .shimmerEffect()
        )
    }
}

@Composable
fun CardShimmerEffect(modifier: Modifier) {
    Row(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .size(Dimens.ArticleCardSize)
                .clip(MaterialTheme.shapes.medium)
                .shimmerEffect()
        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = Dimens.ExtraSmallPadding)
                .height(Dimens.ArticleCardSize)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .padding(horizontal = MediumPadding1)
                    .shimmerEffect()
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .padding(horizontal = MediumPadding1)
                        .height(30.dp)
                        .shimmerEffect()
                )

            }
        }
    }
}

@Composable
fun ShimmerEffectList(modifier: Modifier = Modifier.padding(horizontal = 20.dp)) {
    Column(
        Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        CardShimmerEffect(modifier)
        CardShimmerEffect(modifier)
        CardShimmerEffect(modifier)
        CardShimmerEffect(modifier)
    }
}

@Preview
@Composable
private fun ShimmerEffectPrev() {
    ShimmerEffect()
}

@Preview
@Composable
private fun CardShimmerEffectPrev() {
    ShimmerEffectList()
}