package com.example.aplikasijogging.ui.screen.profile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.example.aplikasijogging.R
import com.example.aplikasijogging.ui.utils.component.RunningStatsItem



@Composable
fun ProfileScreen(
    bottomPadding: Dp = 0.dp
) {
    val context = LocalContext.current
    val viewModel: ProfileViewModel = hiltViewModel()
    val state by viewModel.profileScreenState.collectAsStateWithLifecycle()

    ProfileScreenContent(
        bottomPadding = bottomPadding,
        profileScreenState = state,
        profileEditActions = viewModel
    )

    LaunchedEffect(key1 = state.errorMsg) {
        if (state.errorMsg.isNullOrBlank().not())
            Toast.makeText(context, state.errorMsg.toString(), Toast.LENGTH_SHORT).show()
    }
}


@Composable
private fun ProfileScreenContent(
    bottomPadding: Dp = 0.dp,
    profileScreenState: ProfileScreenState,
    profileEditActions: ProfileEditActions
) {
    Column {
        TopBar(
            state = profileScreenState,
            profileEditActions = profileEditActions
        )
        Column(
            modifier = Modifier
                .padding(8.dp)
                .verticalScroll(rememberScrollState())
                .padding(top = 16.dp)
        ) {

            Spacer(modifier = Modifier.size(bottomPadding + 8.dp))
        }
    }
}


@Composable
private fun TopBar(
    modifier: Modifier = Modifier,
    state: ProfileScreenState,
    profileEditActions: ProfileEditActions
) {
    Box(
        modifier = modifier
            .height(IntrinsicSize.Min)
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .offset(y = (-24).dp)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp)
                )
        )
        Column(modifier = modifier.padding(horizontal = 24.dp)) {
            Spacer(modifier = Modifier.size(24.dp))
            TopBarProfile(
                modifier = Modifier.background(color = Color.Transparent),
                user = state.user,
                isEditMode = state.isEditMode,
                profileEditActions = profileEditActions
            )
            Spacer(modifier = Modifier.size(32.dp))
            TotalProgressCard(state = state)
        }
    }

}


@Composable
private fun TotalProgressCard(
    modifier: Modifier = Modifier,
    state: ProfileScreenState,
) {
    ElevatedCard(
        modifier = modifier,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = "Total Progress",
                style = MaterialTheme.typography.labelLarge.copy(
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier
                    .weight(1f)
            )

        }

        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp)
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                    shape = MaterialTheme.shapes.small
                )
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            RunningStatsItem(
                modifier = Modifier,
                painter = painterResource(id = R.drawable.running_boy),
                unit = "km",
                value = state.totalDistanceInKm.toString()
            )
            Box(
                modifier = Modifier
                    .width(1.dp)
                    .fillMaxHeight()
                    .padding(vertical = 8.dp)
                    .align(Alignment.CenterVertically)
                    .background(
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
                    )
            )
            RunningStatsItem(
                modifier = Modifier,
                painter = painterResource(id = R.drawable.stopwatch),
                unit = "hr",
                value = state.totalDurationInHr.toString()
            )
            Box(
                modifier = Modifier
                    .width(1.dp)
                    .fillMaxHeight()
                    .padding(vertical = 8.dp)
                    .align(Alignment.CenterVertically)
                    .background(
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
                    )
            )
            RunningStatsItem(
                modifier = Modifier,
                painter = painterResource(id = R.drawable.fire),
                unit = "kcal",
                value = state.totalCaloriesBurnt.toString()
            )
        }
    }
}


