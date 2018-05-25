package cubex.mahesh.spftest

import android.annotation.SuppressLint
import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

@SuppressLint("ValidFragment")
class WelcomeFragment: Fragment
{
    var email:String? = null
        constructor(s:String)
        {
            email = s
        }
    var tview:TextView? = null

    override fun onCreateView(inflater: LayoutInflater?,
   container: ViewGroup?, savedInstanceState: Bundle?): View {
    var v = inflater?.inflate(R.layout.welcome_frag,
                                container,false)

        tview = v?.findViewById(R.id.tv1)

        tview?.setText("Welcome 2 NareshIT : "+email)

        return v!!
    }


}