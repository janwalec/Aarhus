package aarhus.mobileApp.FoodieFinder.ui.components.friends

import aarhus.mobileApp.FoodieFinder.integration.firebase.model.UserFB
import aarhus.mobileApp.FoodieFinder.integration.firebase.services.UserFBService
import aarhus.mobileApp.FoodieFinder.ui.components.Loader
import aarhus.mobileApp.FoodieFinder.ui.components.login.inputField
import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun SearchAndAddFriend(user: UserFB, back: () -> Unit) {
    val email :MutableState<String> = remember { mutableStateOf<String>("") }
    val service = remember {UserFBService()}
    val found = remember {mutableStateOf<UserFB?>(null)}
    var isLoading = remember { mutableStateOf(false) }
    var addingDone = remember { mutableStateOf(false) }
    val userService = remember { UserFBService() }
    var friends : MutableState<List<UserFB>> = remember { mutableStateOf<List<UserFB>>(emptyList()) }
    val scope = rememberCoroutineScope()

    val incorrectEmail = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        friends.value = userService.getFriendsOfAUser(user.id)
    }
    inputField("Enter your friends' email", true, email)

    Spacer(modifier = Modifier.padding(10.dp))
    Button(onClick = {
        isLoading.value = true
        if (!((listOf(friends.value)).contains<Any>(email.value))) {
            scope.launch {
                found.value = service.getUserByEmail(email.value)

                if(found.value == null){
                    incorrectEmail.value = true
                }
                found.value?.let { friendToAdd ->
                    service.addFriend(friendToAdd.id, user.email) // add to theirs friends list myself
                    service.addFriend(user.id, friendToAdd.email) // add to my friends list them
                }
                email.value = ""
            }
            addingDone.value = true
        }
        isLoading.value = false
    },  modifier = Modifier
        .clip(CutCornerShape(20.dp))
        .fillMaxWidth(0.75f)
        .height(40.dp)) {
        Text("Add!", fontSize = 20.sp)
    }
    if(isLoading.value){
        Loader()
    }
    else {
        Spacer(modifier = Modifier.padding(20.dp))
        if (addingDone.value) {
            if(found.value != null) {
                Text("You are friends with " + found.value?.name + "!", fontSize = 20.sp)
                back()
            }
            else if(incorrectEmail.value){
                Text("The user was not found", fontSize = 20.sp)
            }
        }

    }
}