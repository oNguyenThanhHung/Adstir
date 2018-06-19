package hungnt.com.adstir

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
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

    fun initAdstir() {
        adstirVideoReward = AdstirVideoReward(this, "MEDIA-f5fa1e60", 3)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowVideo.setOnClickListener {
            startActivity(Intent(this, VideoRewardActivity::class.java))
        }

        AdstirVideoAds.init(this, "MEDIA-f5fa1e60", 3)
        btnLoadVideo.setOnClickListener {
            initAdstir()
            loading.visibility = View.VISIBLE
            AdstirVideoAds.setMediaUserID(description.text.toString())
            adstirVideoReward.adstirVideoRewardListener = listener
            adstirVideoReward.load()
        }
        btnLoadVideoWithoutUserId.setOnClickListener {
            initAdstir()
            loading.visibility = View.VISIBLE
            AdstirVideoAds.setMediaUserID(description.text.toString())
            adstirVideoReward.load()
            adstirVideoReward.adstirVideoRewardListener = object : AdstirVideoRewardListener {

                override fun onLoad(spot_no: Int) {
                    Toast.makeText(this@MainActivity, "onLoad()", Toast.LENGTH_SHORT).show()
                    Log.d("hung1234", "onLoad() returned: & destroy ")
                    loading.visibility = View.GONE
                    adstirVideoReward.destroy()
                    initAdstir()
                }

                override fun onFailed(spot_no: Int) {
                    Toast.makeText(this@MainActivity, "onFailed()", Toast.LENGTH_SHORT).show()
                    Log.d("hung1234", "onFailed() returned: ")

                }

                override fun onStart(spot_no: Int) {
                    Toast.makeText(this@MainActivity, "onStart()", Toast.LENGTH_SHORT).show()
                    Log.d("hung1234", "onStart() returned: ")
                }

                override fun onStartFailed(spot_no: Int) {
                    Toast.makeText(this@MainActivity, "onStartFailed()", Toast.LENGTH_SHORT).show()
                    Log.d("hung1234", "onStartFailed() returned: ")
                }

                override fun onFinished(spot_no: Int) {
                    Toast.makeText(this@MainActivity, "onFinished()", Toast.LENGTH_SHORT).show()

                    Log.d("hung1234", "onFinished() returned: ")
                }

                override fun onReward(spot_no: Int) {
                    Toast.makeText(this@MainActivity, "onReward()", Toast.LENGTH_SHORT).show()

                    Log.d("hung1234", "onReward() returned: ")
                }

                override fun onRewardCanceled(spot_no: Int) {
                    Toast.makeText(this@MainActivity, "onRewardCanceled()", Toast.LENGTH_SHORT).show()

                    Log.d("hung1234", "onRewardCanceled() returned: ")
                }

                override fun onClose(spot_no: Int) {
                    Toast.makeText(this@MainActivity, "onClose()", Toast.LENGTH_SHORT).show()

                    Log.d("hung1234", "onClose() returned: ")
                }
            }
        }
    }

    private val listener = object : AdstirVideoRewardListener {

        override fun onLoad(spot_no: Int) {
            Toast.makeText(this@MainActivity, "onLoad()", Toast.LENGTH_SHORT).show()
            Log.d("hung1234", "onLoad() returned: ")
            loading.visibility = View.GONE
        }

        override fun onFailed(spot_no: Int) {
            Toast.makeText(this@MainActivity, "onFailed()", Toast.LENGTH_SHORT).show()
            Log.d("hung1234", "onFailed() returned: ")

        }

        override fun onStart(spot_no: Int) {
            Toast.makeText(this@MainActivity, "onStart()", Toast.LENGTH_SHORT).show()
            Log.d("hung1234", "onStart() returned: ")
        }

        override fun onStartFailed(spot_no: Int) {
            Toast.makeText(this@MainActivity, "onStartFailed()", Toast.LENGTH_SHORT).show()
            Log.d("hung1234", "onStartFailed() returned: ")
        }

        override fun onFinished(spot_no: Int) {
            Toast.makeText(this@MainActivity, "onFinished()", Toast.LENGTH_SHORT).show()

            Log.d("hung1234", "onFinished() returned: ")
        }

        override fun onReward(spot_no: Int) {
            Toast.makeText(this@MainActivity, "onReward()", Toast.LENGTH_SHORT).show()

            Log.d("hung1234", "onReward() returned: ")
        }

        override fun onRewardCanceled(spot_no: Int) {
            Toast.makeText(this@MainActivity, "onRewardCanceled()", Toast.LENGTH_SHORT).show()

            Log.d("hung1234", "onRewardCanceled() returned: ")
        }

        override fun onClose(spot_no: Int) {
            Toast.makeText(this@MainActivity, "onClose()", Toast.LENGTH_SHORT).show()

            Log.d("hung1234", "onClose() returned: ")
        }
    }
}
