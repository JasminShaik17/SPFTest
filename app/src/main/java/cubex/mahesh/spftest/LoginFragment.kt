package cubex.mahesh.spftest

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginFragment:Fragment()
{
    var email:EditText? = null
    var pass:EditText? = null
    var login:Button? = null
    var signup:Button? = null


    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?, savedInstanceState: Bundle?): View {
    var v = inflater?.inflate(R.layout.login_frag,
                                container,false)
        email = v?.findViewById(R.id.let1)
        pass = v?.findViewById(R.id.let2)
        login = v?.findViewById(R.id.login)
        signup = v?.findViewById(R.id.signup)
        
        signup?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                var fManager = fragmentManager
                var tx = fManager.beginTransaction()
                tx.replace(R.id.frame1,RegisterFragment())
                tx.commit()

            }
        })
        
        login?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                var spf = activity.getSharedPreferences("myprfs",
                        Context.MODE_PRIVATE)
              var spf_email =   spf.getString("email","no value")
              var spf_pass =   spf.getString("pass","no value")

                if(email?.text.toString().equals(spf_email) &&
                     pass?.text.toString().equals(spf_pass)){

                    var fManager = fragmentManager
                    var tx = fManager.beginTransaction()
                    tx.replace(R.id.frame1,
                            WelcomeFragment(email?.text.toString()))
                    tx.commit()

                }else{
                    Toast.makeText(activity,"Invalid User",
                            Toast.LENGTH_LONG).show()
                }
            }

        })

        return v!!
    }


}