package gutierrezmorquecho.luis.finaltoc

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import gutierrezmorquecho.luis.finaltoc.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_log_in.*


class Log_in : AppCompatActivity() {
    val RC_SIGN_IN = 123
    val COD_LOGOUT = 321
    lateinit var mGoogleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        btnIniciar_Google.setOnClickListener {
            val signInIntent = mGoogleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)

        }
        btnIniciar_Sesion.setOnClickListener {
            valida_ingreso()

        }

        txtRegistrarse.setOnClickListener {
            var intent: Intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }


    }

    private fun valida_ingreso(){
        var correo: String = txtCorreo.text.toString()
        var contra: String = txtContra.text.toString()

        if(!correo.isNullOrBlank() && !contra.isNullOrBlank()){
            Toast.makeText(this, "Se ingreso a la App correctamente!",
                Toast.LENGTH_SHORT).show()
            var intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            //ingresaFirebase(correo, contra)
        }else{
            Toast.makeText(this, "Ingresar datos",
                Toast.LENGTH_SHORT).show()
        }
    }
/*
    private fun ingresaFirebase(email: String, password: String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                    val user = auth.currentUser

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                }
            }
    }
*/
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }

        if(requestCode == COD_LOGOUT){
            signOut()
        }
    }

    override fun onStart() {
        super.onStart()

        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        val account = GoogleSignIn.getLastSignedInAccount(this)
        updateUI(account)
    }

    private fun signOut() {
        mGoogleSignInClient.signOut()
            .addOnCompleteListener(this) {
                Toast.makeText(this, "Sesión Terminada", Toast.LENGTH_SHORT).show()
            }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)

            // Signed in successfully, show authenticated UI.
            updateUI(account)
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            //Log.w(TAG, "signInResult:failed code=" + e.statusCode)
            updateUI(null)
        }
    }

    private fun updateUI(account: GoogleSignInAccount?) {

        if(account!=null){

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", account.displayName)
            intent.putExtra("email", account.email)
            startActivityForResult(intent, COD_LOGOUT)
        }
    }

    //Metodo en el que se supone que sirve para pasar datos de un Activity a un Fragmento
    fun newInstance(index: Int, account: GoogleSignInAccount?): HomeFragment? {
        val f = HomeFragment()
        // Supply index input as an argument.
        val args = Bundle()
        //args.putInt("index", index)
        if (account != null) {
            args.putString("name", account.displayName)
            args.putString("email", account.email)
            f.setArguments(args)
        }


        return f
    }
}