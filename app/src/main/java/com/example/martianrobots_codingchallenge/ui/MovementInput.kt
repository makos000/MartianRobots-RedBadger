package com.example.martianrobots_codingchallenge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.martianrobots_codingchallenge.R

//Robot Initial Position and Instructions Section with warnings if values for position is over 50 and if Instructions string is over 100.
@Composable
fun MovementInput(
    robotX: String?,
    robotY: String?,
    robotOrientation: String,
    robotInstructions: String,
    onBtnSubmit: () -> Unit,
    onXChanged: (String) -> Unit,
    onYChanged: (String) -> Unit,
    onOrientationChanged: (String) -> Unit,
    onInstructionsChanged: (String) -> Unit
) {
    val maxXValue = 50
    val maxYValue = 50
    val maxInstructionsLength = 100

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            OutlinedTextField(
                value = robotX ?: "",
                onValueChange = onXChanged,
                label = { Text(stringResource(R.string.pos_x)) },
                placeholder = { Text(stringResource(R.string.pos_x_ex), fontSize = 12.sp) },
                modifier = Modifier.weight(1f),
                isError = robotX?.toIntOrNull() !in 0..maxXValue,
                trailingIcon = {
                    if (robotX?.toIntOrNull() != null && robotX.toInt() > maxXValue) Icon(
                        Icons.Default.Warning,
                        contentDescription = "Error"
                    )
                },
                supportingText = {
                    Text(text = stringResource(id = R.string.max_value_50))
                }
            )
            Spacer(modifier = Modifier.width(16.dp))
            OutlinedTextField(
                value = robotY ?: "",
                onValueChange = onYChanged,
                label = { Text(stringResource(R.string.pos_y)) },
                placeholder = { Text(stringResource(R.string.pos_y_ex), fontSize = 12.sp) },
                modifier = Modifier.weight(1f),
                isError = robotY?.toIntOrNull() !in 0..maxYValue,
                trailingIcon = {
                    if (robotY?.toIntOrNull() != null && robotY.toInt() > maxYValue) Icon(
                        Icons.Default.Warning,
                        contentDescription = "Error"
                    )
                },
                supportingText = {
                    Text(text = stringResource(id = R.string.max_value_50))
                }
            )
            Spacer(modifier = Modifier.width(16.dp))
            OutlinedTextField(
                value = robotOrientation,
                onValueChange = onOrientationChanged,
                label = { Text(stringResource(R.string.robot_orientation), fontSize = 12.sp) },
                placeholder = { Text(stringResource(R.string.robot_orientation_ex)) },
                modifier = Modifier.weight(1f)
            )
        }

        Row {
            OutlinedTextField(
                value = robotInstructions,
                onValueChange = onInstructionsChanged,
                label = { Text(stringResource(R.string.robot_instructions)) },
                placeholder = { Text(stringResource(R.string.robot_instructions_ex)) },
                modifier = Modifier.weight(1f),
                isError = robotInstructions.length > maxInstructionsLength,
                trailingIcon = {
                    if (robotInstructions.length > maxInstructionsLength) Icon(
                        Icons.Default.Warning,
                        contentDescription = "Error"
                    )
                }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onBtnSubmit
        ) {
            Text(stringResource(R.string.btn_submit))
        }
    }
}