package hungnt.com.adstir

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.ad_stir.interstitial.AdstirVideoAds
import com.ad_stir.videoreward.AdstirVideoReward
import com.ad_stir.videoreward.AdstirVideoRewardListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var adstirVideoReward: AdstirVideoReward
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowVideo.setOnClickListener {
            startActivity(Intent(this, VideoRewardActivity::class.java))
        }

        AdstirVideoAds.init(this, "YOUR_ID", 1)
        adstirVideoReward = AdstirVideoReward(this, "YOUR_ID", 1)

        btnLoadVideo.setOnClickListener {
            // Set mediaUserId
            AdstirVideoAds.setMediaUserID(description.text.toString())
            loading.visibility = View.VISIBLE
            adstirVideoReward.adstirVideoRewardListener = listener
            adstirVideoReward.load()
        }
    }

    private val listener = object : AdstirVideoRewardListener {

        override fun onLoad(spot_no: Int) {
            Toast.makeText(this@MainActivity, "onLoad()", Toast.LENGTH_SHORT).show()
            loading.visibility = View.GONE
        }

        override fun onFailed(spot_no: Int) {
            Toast.makeText(this@MainActivity, "onFailed()", Toast.LENGTH_SHORT).show()
        }

        override fun onStart(spot_no: Int) {
            Toast.makeText(this@MainActivity, "onStart()", Toast.LENGTH_SHORT).show()
        }

        override fun onStartFailed(spot_no: Int) {
            Toast.makeText(this@MainActivity, "onStartFailed()", Toast.LENGTH_SHORT).show()
        }

        override fun onFinished(spot_no: Int) {
            Toast.makeText(this@MainActivity, "onFinished()", Toast.LENGTH_SHORT).show()
        }

        override fun onReward(spot_no: Int) {
            Toast.makeText(this@MainActivity, "onReward()", Toast.LENGTH_SHORT).show()
        }

        override fun onRewardCanceled(spot_no: Int) {
            Toast.makeText(this@MainActivity, "onRewardCanceled()", Toast.LENGTH_SHORT).show()
        }

        override fun onClose(spot_no: Int) {
            Toast.makeText(this@MainActivity, "onClose()", Toast.LENGTH_SHORT).show()
        }
    }
}
