package pe.edu.ulima.pm.pokeapp.model

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class UserManager {
    companion object {
         var instance : UserManager = UserManager()
        private set
    }

    private val dbFirebase = Firebase.firestore

    fun saveUser(usuario : String,
                 callbackOK : (Long) -> Unit,
                 callbackError : (String) -> Unit){

        val data = hashMapOf<String, Any>(
            "usuario" to usuario
        )

        var esta = false

        // COMPROBACION - ¿ESTA EN FIREBASE?

        dbFirebase.collection("usuarios")
            .get()
            .addOnSuccessListener { res ->
                for(document in res){
                    if(document.data["usuario"]!!.toString() == usuario){
                        esta = true
                        break
                    }
                }
            }
            .addOnFailureListener {
                callbackError(it.message!!)
            }

        // SI NO ESTA - SE CREA UN NUEVO USUARIO

        if(!esta) {
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
}