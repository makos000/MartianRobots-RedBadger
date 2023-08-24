import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.martianrobots_codingchallenge.data.Robot
import com.example.martianrobots_codingchallenge.domain.parseGridSize
import com.example.martianrobots_codingchallenge.domain.parseOrientation
import com.example.martianrobots_codingchallenge.domain.parsePosition
import com.example.martianrobots_codingchallenge.domain.processInstructions
import com.example.martianrobots_codingchallenge.ui.*

@Composable
fun MainScreen() {
    var gridSizeX by remember { mutableStateOf("") }
    var gridSizeY by remember { mutableStateOf("") }
    var robotX by remember { mutableStateOf("") }
    var robotY by remember { mutableStateOf("") }
    var robotOrientation by remember { mutableStateOf("") }
    var robotInstructions by remember { mutableStateOf("") }
    val robots = remember { mutableStateListOf<Robot>() }

    //Submit button function that triggers the logic of the app
    val onBtnSubmit: () -> Unit = {
        if (robotX.isNotEmpty() && robotY.isNotEmpty() && robotX.toInt() < 51 && robotY.toInt() < 51 && robotInstructions.length < 101) {
            val grid = parseGridSize(gridSizeX, gridSizeY)
            val position = parsePosition(robotX, robotY)
            val orientation = parseOrientation(robotOrientation)
            robotInstructions.trim()

            if (grid != null && position != null && orientation != null && robotInstructions.isNotEmpty()) {
                val robot = Robot(position, orientation, position, orientation, false)
                //Robot's instructions are being triggered here
                processInstructions(robot, robotInstructions, grid)
                //Robot is added to the mutableStateList so it can be displayed in RobotList()
                robots.add(robot)
            }
        }

        //After Submit is clicked, robot's X and Y, Orientation and Instructions values are being deleted from TextFields.
        robotX = ""
        robotY = ""
        robotOrientation = ""
        robotInstructions = ""
    }

    //Screen UI layout
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Row {
                GridSizeX(gridSizeX = gridSizeX, modifier = Modifier.weight(1f)) { gridSizeX = it }
                Spacer(modifier = Modifier.width(16.dp))
                GridSizeY(gridSizeY = gridSizeY, modifier = Modifier.weight(1f)) { gridSizeY = it }
            }

            MovementInput(
                robotX = robotX,
                robotY = robotY,
                robotOrientation = robotOrientation,
                robotInstructions = robotInstructions,
                onBtnSubmit = onBtnSubmit,
                onXChanged = { robotX = it },
                onYChanged = { robotY = it },
                onOrientationChanged = { robotOrientation = it },
                onInstructionsChanged = { robotInstructions = it }
            )
            LazyRow() {
                item {
                    GridSizeOutput(gridSizeX = gridSizeX, gridSizeY = gridSizeY, robot = robots.lastOrNull())
                }
            }
            if (robots.isNotEmpty()) OutputWindow(robots = robots)
        }
    }
}








