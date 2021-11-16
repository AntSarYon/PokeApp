package pe.edu.ulima.pm.pokeapp.model

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class UserManager {
    companion object {
        lateinit var instance : UserManager
        private set
    }

    private val dbFirebase = Firebase.firestore

    fun saveUser(usuario : String,
                 callbackOK : (Long) -> Unit,
                 callbackError : (String) -> Unit){

        val data = hashMapOf<String, Any>(
            "usuario" to usuario
        )

        val userId = System.currentTimeMillis()
        dbFirebase.collection("usuarios").document(
            userId.toString()
        ).set(data)
            .addOnSuccessListener {
                callbackOK(userId)
            }
            .addOnFailureListener {
                callbackError(it.message!!)
            }
    }
}