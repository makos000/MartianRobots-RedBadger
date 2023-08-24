package com.example.martianrobots_codingchallenge.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.martianrobots_codingchallenge.R

@Composable
fun GridSizeX(gridSizeX: String, modifier: Modifier, onGridSizeChanged: (String) -> Unit) {
    val showError = (gridSizeX.toIntOrNull() ?: 0) > 50
    OutlinedTextField(
        modifier = modifier,
        value = gridSizeX,
        onValueChange = onGridSizeChanged,
        label = { Text(stringResource(R.string.grid_size_x_coordinate)) },
        placeholder = { Text(stringResource(R.string.grid_size_x)) },
        isError = gridSizeX.isBlank() || showError,
        trailingIcon = {
            if (gridSizeX.isBlank() || showError) Icon(
                Icons.Default.Warning,
                contentDescription = "Error"
            )
        },
        supportingText = {
            if (gridSizeX.isBlank()) Text(text = stringResource(R.string.grid_error))
            else if (showError) Text(text = stringResource(R.string.max_value_50))
        }
    )
}
