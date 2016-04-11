package concigel.jp.arrow

import android.app.Activity
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentTransaction
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import kotlin.reflect.KClass


class MainActivity : FragmentActivity(), ButtonFragment.OnFragmentInteractionListener, ArrowFragment.OnFragmentInteractionListener {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    var fragment = supportFragmentManager.findFragmentById(R.id.contents)

    if(fragment == null) {
      fragment = ButtonFragment()
      var fragmentTransaction: FragmentTransaction? = supportFragmentManager.beginTransaction()
      fragmentTransaction!!.add(R.id.contents, fragment)
      fragmentTransaction.commit()
    }
  }

  override fun onFragmentInteraction(uri : Uri) {}

  fun <T: Activity> Activity.startActivity(classRef: KClass<T>, bundle: Bundle? = null, finishFl: Boolean = false) {
    val intent = Intent(this, classRef.java).setAction(Intent.ACTION_VIEW)
    bundle?.let {
      intent.putExtra("args", bundle)
    }
    startActivity(intent)
    if (finishFl) {
      finish()
    }
  }

  companion object {
    private val TAG : String = "MainActivity"
  }
}
