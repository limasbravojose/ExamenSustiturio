package pe.idat.appa17144008.iu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import pe.idat.appa17144008.viewmodel.SetupViewModel

@Composable
fun ImageScreen(viewModel: SetupViewModel = hiltViewModel()) {
    val imagenes by viewModel.imagenes.observeAsState(initial = emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchImagenes()
    }

    LazyRow(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        items(imagenes) { imagen ->
            Column(modifier = Modifier.padding(end = 16.dp)) {
                Image(
                    painter = rememberAsyncImagePainter(model =  imagen.thumbnailUrl),
                    contentDescription = imagen.title,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(text = "Album ID: ${imagen.albumId}")
                Text(text = "ID: ${imagen.id}")
                Text(text = "Title: ${imagen.title}")
            }
        }
    }
}
