package hungnt.com.adstir

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.ad_stir.videoreward.AdstirVideoRewardListener
import kotlinx.android.synthetic.main.activity_incentivized_video.*

class VideoRewardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_incentivized_video)

        val adstirVideoReward = MainActivity.adstirVideoReward
        MainActivity.adstirVideoReward.adstirVideoRewardListener = listener

        button_play.setOnClickListener {
            if (adstirVideoReward.canShow()) {
                Toast.makeText(this@VideoRewardActivity, "showRewardVideo", Toast.LENGTH_SHORT).show()
                adstirVideoReward.showRewardVideo()
            } else {
                adstirVideoReward.load()
            }
        }
    }

    private val listener = object : AdstirVideoRewardListener {

        override fun onLoad(spot_no: Int) {
            Toast.makeText(this@VideoRewardActivity, "onLoad()", Toast.LENGTH_SHORT).show()
        }

        override fun onFailed(spot_no: Int) {
            Toast.makeText(this@VideoRewardActivity, "onFailed()", Toast.LENGTH_SHORT).show()

        }

        override fun onStart(spot_no: Int) {
            Toast.makeText(this@VideoRewardActivity, "onStart()", Toast.LENGTH_SHORT).show()
        }

        override fun onStartFailed(spot_no: Int) {
            Toast.makeText(this@VideoRewardActivity, "onStartFailed()", Toast.LENGTH_SHORT).show()
        }

        override fun onFinished(spot_no: Int) {
            Toast.makeText(this@VideoRewardActivity, "onFinished()", Toast.LENGTH_SHORT).show()
        }

        override fun onReward(spot_no: Int) {
            Toast.makeText(this@VideoRewardActivity, "onReward()", Toast.LENGTH_SHORT).show()
        }

        override fun onRewardCanceled(spot_no: Int) {
            Toast.makeText(this@VideoRewardActivity, "onRewardCanceled()", Toast.LENGTH_SHORT).show()
        }

        override fun onClose(spot_no: Int) {
            Toast.makeText(this@VideoRewardActivity, "onClose()", Toast.LENGTH_SHORT).show()
        }
    }
}
