package com.example.martianrobots_codingchallenge.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.martianrobots_codingchallenge.R

@Composable
fun GridSizeY(gridSizeY: String, modifier: Modifier, onGridSizeChanged: (String) -> Unit) {
    val showError = (gridSizeY.toIntOrNull() ?: 0) > 50
    OutlinedTextField(
        modifier = modifier,
        value = gridSizeY,
        onValueChange = onGridSizeChanged,
        label = { Text(stringResource(R.string.grid_size_y_coordinate)) },
        placeholder = { Text(stringResource(R.string.grid_size_y)) },
        isError = gridSizeY.isBlank() || showError,
        trailingIcon = {
            if (gridSizeY.isBlank() || showError) Icon(
                Icons.Default.Warning,
                contentDescription = "Error"
            )
        },
        supportingText = {
            if (gridSizeY.isBlank()) Text(text = stringResource(R.string.grid_error))
            else if (showError) Text(text = stringResource(R.string.max_value_50))
        }
    )
}
