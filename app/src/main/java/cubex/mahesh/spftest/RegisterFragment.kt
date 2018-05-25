package cubex.mahesh.spftest

import android.app.Fragment
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class RegisterFragment:Fragment()
{
    var email: EditText? = null
    var pass: EditText? = null
    var mno:EditText? = null
    var dob:EditText? = null
    var register: Button? = null

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?, savedInstanceState: Bundle?): View {
    var v = inflater?.inflate(R.layout.register_frag,
                                container,false)
        email = v?.findViewById(R.id.ret1)
        pass = v?.findViewById(R.id.ret2)
        mno = v?.findViewById(R.id.ret3)
        dob = v?.findViewById(R.id.ret4)
        register = v?.findViewById(R.id.register)

        register?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

        var spf = activity.getSharedPreferences("myprfs",
                Context.MODE_PRIVATE)
        var editor = spf.edit();
        editor.putString("email",email?.text.toString())
        editor.putString("pass",pass?.text.toString())
        editor.putString("mno",mno?.text.toString())
        editor.putString("dob",dob?.text.toString())
        editor.commit()

                var fManager = fragmentManager
                var tx = fManager.beginTransaction()
                tx.replace(R.id.frame1,LoginFragment())
                tx.commit()

            }
        })

        return v!!
    }


}