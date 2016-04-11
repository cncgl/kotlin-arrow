package concigel.jp.arrow

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.reflect.KClass


class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val button = findViewById(R.id.btn_touch)
    button?.setOnClickListener {
      Log.v(TAG, "clicked")
      // val intent = Intent(applicationContext, javaClass<ArrowActivity>())
      startActivity(ArrowActivity::class)
    }
  }

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
